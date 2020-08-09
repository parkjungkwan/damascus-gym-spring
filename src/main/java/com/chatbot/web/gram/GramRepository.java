package com.chatbot.web.gram;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

interface MemberRepository extends JpaRepository<Member, String> {
    /*  @Query(
        value = "SELECT * FROM member WHERE memberid= :memberid",
        nativeQuery = true
    )
    public Iterable<Member> findByMemberid(@Param("memberid") String memberid);

    //테이블 join해서 2개의 테이블 리스트 출력
    @Query(
        value = "SELECT * FROM MEMBER JOIN MEETINGPprofileUpdateEOPLE ON MEMBER.memberid = MEETINGPEOPLE.memberid2",
        nativeQuery = true
    )
    public List<Object[]> joinlist(); */



    //프로필 이미지 업데이트 메소드
    @Query(
            value = "update tbl_members set profileimage = :path where memberid=:id"
            , nativeQuery = true
    )
    public Member profileUpdate(String path, String id);

    @Query(
            value = "select money from tbl_members where memberid=:id"
            , nativeQuery = true
    )
    public int tardyCash(String id);

    //방장이 방을만들면 타디캐시-시켜줌
    @Query(
            value = "update tbl_members set money = :money where memberid=:id ",
            nativeQuery = true
    )
    public void roomTardy(String id, int money);


    //메인페이지에 뿌릴 시간
    @Query(
            value = "select roomdate from tbl_members_rooms mr JOIN tbl_room r ON mr.rooms_roomno=r.roomno where mr.members_memberid=:id",
            nativeQuery = true
    )
    public String mainchk(String id);

    //총 회원의 수
    @Query(
            value = "select count(*) from tbl_members", nativeQuery = true
    )
    public int totalMember();
}
interface RoomRepository extends JpaRepository<Room, Long> {
    @Query(
            value = "select * from tbl_room m where m.roomprogress=1 and m.roomhostid=:roomhostid "
            , nativeQuery = true
    )
    public List<Room> hostProgressEx(String roomhostid);


    @Query(
            value = "select * from tbl_room mt JOIN tbl_members_rooms mm ON mt.roomno=mm.rooms_roomno where mt.roomprogress=0 and mt.roomhostid= mm.members_memberid and mm.members_memberid=:memberid"
            , nativeQuery = true
    )
    public List<Room> hostNotProgressEx(String memberid);


    @Query(
            value = "select * from tbl_room mt JOIN tbl_members_rooms mm ON mt.roomno=mm.rooms_roomno where mt.roomprogress=1 and mt.roomhostid!= mm.members_memberid and mm.members_memberid=:memberid"
            , nativeQuery = true
    )
    public List<Room> MemberProgressEx(String memberid);


    @Query(
            value = "select * from tbl_room mt JOIN tbl_members_rooms mm ON mt.roomno=mm.rooms_roomno where mt.roomprogress=0 and mt.roomhostid!= mm.members_memberid and mm.members_memberid=:memberid"
            , nativeQuery = true
    )
    public List<Room> MemberNotProgressEx(String memberid);

    //모임테이블 전체 조회
    @Query(
            value = "select * from tbl_room where roomprogress=1"
            , nativeQuery = true
    )
    public List<Room> selectall();
    //내가 개설한 현재진행중인 방의 count
    @Query(
            value = "select count(*) from tbl_room where roomhostid=:id and roomprogress=1"
            , nativeQuery = true
    )
    public int HostCount(String id);

    //내가 참여중인 현재진행중인 방의 count
    @Query(
            value = "select count(*) from tbl_room mt JOIN tbl_members_rooms mm ON mt.roomno=mm.rooms_roomno where mt.roomhostid != mm.members_memberid and mm.members_memberid=:id and mt.roomprogress=1"
            , nativeQuery = true
    )
    public int MemberCount(String id);


    //프로필 이미지 업데이트 메소드
    @Query(
            value = "update tbl_room set roomphoto = :path where roomhostid=:id"
            , nativeQuery = true
    )
    public Room roomUpdate(String path, String id);


    //1번방에 대한 방장정보
    @Query(
            value = "select * from tbl_room r JOIN tbl_members_rooms mr JOIN tbl_members mb ON r.roomno=mr.rooms_roomno and mb.memberid=mr.members_memberid where r.roomno=:roomno and r.roomhostid=mr.members_memberid"
            , nativeQuery = true
    )
    public Room selecthost(Long roomno);


    //1번방에 대한 유저정보
    // @Query(
    //     value = "select mb.memberid, mb.profileimage from tbl_room r JOIN tbl_members_rooms mr JOIN tbl_members mb ON r.roomno=mr.rooms_roomno and mb.memberid=mr.members_memberid where r.roomno=:roomno and r.roomhostid!=mr.members_memberid",
    //     nativeQuery = true
    // )
    // public List<Member> selectuser(Long roomno);

    @Query(
            value = "select memberid,profileimage,tardystate from tbl_members mb JOIN tbl_members_rooms mr ON mb.memberid=mr.members_memberid where mr.rooms_roomno=:roomno",
            nativeQuery = true
    )
    public List<Object[]> selectuser(Long roomno);

    //총벌금 합산
    @Query(
            value = "update tbl_room set roompenaltyall = roompenaltyall+(:roomcharge) where roomno=:roomno",
            nativeQuery = true
    )
    public void insertPenaltyall(Long roomno, int roomcharge);


    //위치 시간 검사 통과한 사람의 tardystate를 arrived로 변환
    @Query(
            value = "update tbl_members set tardystate='arrived' where memberid=:memberid",
            nativeQuery = true
    )
    public void changeState(String memberid);


    //룸 이미지 업데이트 메소드
    @Query(
            value = "update tbl_room set roomphoto = :path where roomno=:roomno"
            , nativeQuery = true
    )
    public Room roomphotoUpdate(String path, String roomno);


    //방디테일에서 마감버튼 누를시 방원들의 상태가 arrived가 된 갯수
    @Query(
            value = "select count(*) from tbl_members mb JOIN tbl_members_rooms mr ON mb.memberid = mr.members_memberid where mb.tardystate='arrived' and mr.rooms_roomno=:roomno",
            nativeQuery = true
    )
    public int arrivedcount(String roomno);


    //상태가 arrived가 된 id 출력 (roomno조건)
    @Query(
            value = "select memberid from tbl_members mb JOIN tbl_members_rooms mr ON mb.memberid = mr.members_memberid where mb.tardystate='arrived' and mr.rooms_roomno=:roomno"
            , nativeQuery = true
    )
    public String[] arrivedMember(String roomno);


    //상태가 arrived인 유저에게 벌금을 다시 돌려줌
    @Query(
            value = "update tbl_members set money=money+(:deviceCharge) where memberid=:memberid",
            nativeQuery = true
    )
    public void turnTardycashe(int deviceCharge, String memberid);

    //연관테이블 삭제
    @Query(
            value = "delete from tbl_members_rooms where rooms_roomno = :roomno"
            , nativeQuery = true
    )
    public void deleteRoom(String roomno);

    //룸테이블 삭제
    @Query(
            value = "delete from tbl_room where roomno=:roomno"
            , nativeQuery = true
    )
    public void deleteFinalRoom(String roomno);

    //방의 전체 갯수
    @Query(
            value = "select count(*) from tbl_room", nativeQuery = true
    )
    public int totalRoom();

    //방들의 벌금 배열로 나열
    @Query(
            value = "select roomcharge from tbl_room ", nativeQuery = true
    )
    public int[] roomCharge();


    //tardystate -로 변경
    @Query(
            value = "update tbl_members set tardystate='-' where memberid=:id", nativeQuery = true
    )
    public void tardystateChange(String id);

    //string[]로 방에 참여한 멤버들 아이디 출력
    @Query(
            value = "select mr.members_memberid from tbl_room tr JOIN tbl_members_rooms mr ON tr.roomno=mr.rooms_roomno where tr.roomno=:roomno ", nativeQuery = true
    )
    public String[] memberidArray(String roomno);
}
interface EnterRepository extends JpaRepository<Member, Integer>{
    @Query(
            value = "insert into tbl_members_rooms (members_memberid, rooms_roomno) values(:memberid, :roomno)",
            nativeQuery = true
    )
    public void enter(Member memberid, int roomno);

}
