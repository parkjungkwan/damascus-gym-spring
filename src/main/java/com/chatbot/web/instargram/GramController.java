package com.chatbot.web.instargram;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;


@CrossOrigin("*")
@RestController
@RequestMapping("/gram")
@Transactional
public class GramController {
    private final MemberRepository memberRepository;
    private final RoomRepository roomRepository;
    private final EnterRepository enterRepository;
    public GramController(MemberRepository memberRepository, RoomRepository roomRepository,
                          EnterRepository enterRepository) {
        this.memberRepository = memberRepository;
        this.roomRepository = roomRepository;
        this.enterRepository = enterRepository;
    }
    /********************************************
     * MemberController
     *
     ********************************************/
    private static String UPLOADED_FOLDER = "C:\\Users\\user\\Desktop\\tardygram\\frontend\\public\\image\\member\\";
    // 회원가입
    @PostMapping("/join")
    public ResponseEntity<GramMember> insertMember(@RequestBody GramMember joinFd) {
        joinFd.setProfileimage("/image/member/user.jpg");
        joinFd.setTardystate("-");
        return new ResponseEntity<GramMember>(memberRepository.save(joinFd), HttpStatus.OK);
    }

    // 회원탈퇴
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteMember() {
        // Member m = new Member();
        // m.setMemberid("memberid");
        memberRepository.deleteById("c");
        return new ResponseEntity<String>("되어주세요", HttpStatus.OK);
    }

    // 로그인
    @PostMapping("/select")
    public ResponseEntity<HashMap<String,String>> selectone(@RequestBody GramMember loginFd) {
        HashMap<String,String> map =new HashMap<>();
        try{
            GramMember repoData = memberRepository.findById(loginFd.getMemberid()).get();
            memberRepository.findById(loginFd.getMemberid());
            System.out.println("아이디 통과");
            if (loginFd.getPwd().equals(repoData.getPwd())) {
                System.out.println("비번 통과");
                map.put("status","sucess");
                map.put("dataid",loginFd.getMemberid());
                return new ResponseEntity<HashMap<String,String>>(map, HttpStatus.OK);
            } else {
                System.out.println("비번 실패");
                map.put("status","fail");
                map.put("msg","비밀번호가 틀렸습니다");
                return new ResponseEntity<HashMap<String,String>>(map, HttpStatus.OK);
            }
        } catch(Exception e) {
            System.out.println("실패");
            map.put("status","fail");
            map.put("msg","아이디 또는 비밀번호가 틀렸습니다");
            return new ResponseEntity<HashMap<String,String>>(map, HttpStatus.OK);
        }

    }

    // 마이페이지 정보 보여주기
    @GetMapping("/mypage/{id}")
    public ResponseEntity<HashMap<String, Object>> mypage(@PathVariable String id) {
        System.out.println("mypage 컨트롤러");
        System.out.println("프론트에서 오는 id : " + id);
        HashMap<String, Object> map = new HashMap<>();
        // c가왔을때
        // 1. 그냥회원내용
        System.out.println("1번 hostProgressEx: " + memberRepository.findById(id).get());
        GramMember m1 = memberRepository.findById(id).get();
        map.put("uInfo", m1);

        // 2. 방장, 진행O
        List<GramRoom> m2 = roomRepository.hostProgressEx(id);
        map.put("hostProgressEx", m2);
        System.out.println("2번 hostProgressEx: " + roomRepository.hostProgressEx(id));

        // 3. 방장, 진행X
        //System.out.println("3번 hostNotProgressEx: " + roomrepo.hostNotProgressEx(id));
        //List<Room> m3 = roomrepo.hostNotProgressEx(id);
        //map.put("hostNotProgressEx", m3);

        // 4. 방원, 진행O
        System.out.println("4번 MemberProgressEx: " + roomRepository.MemberProgressEx(id));
        List<GramRoom> m4 = roomRepository.MemberProgressEx(id);
        map.put("MemberProgressEx", m4);

        // //5. 방원, 진행X
        //ystem.out.println("5번 MemberNotProgressEx: " + roomrepo.MemberNotProgressEx(id));
        //List<Room> m5 = roomrepo.MemberNotProgressEx(id);
        //map.put("MemberNotProgressEx", m5);

        int hostCount = roomRepository.HostCount(id);
        int memberCount = roomRepository.MemberCount(id);
        map.put("hostCount", hostCount);
        map.put("memberCount", memberCount);

        return new ResponseEntity<HashMap<String, Object>>(map, HttpStatus.OK);

    }


    //프로필 이미지 파일업로드
    @PostMapping(path="/upload/{id}",consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public String imgUpload(@RequestParam("file") MultipartFile file, @PathVariable String id){

        System.out.println("파일업로드 컨트롤러");
        System.out.println("건너온 data : " + file);
        System.out.println("로그인한id : " + id);
        System.out.println("파일이름 : " + file.getOriginalFilename());

        try{
            String DbPath = "/image/member/" + file.getOriginalFilename();
            System.out.println("Dbpath : " + DbPath);
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);
            System.out.println("path : " + path);
            System.out.println(id);
            memberRepository.profileUpdate(DbPath, id);
            return DbPath;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "No Img";
    }


    //메인페이지에 남은시간
    @GetMapping("/mainchk/{id}")
    public ResponseEntity<String> mainchk(@PathVariable String id) {
        System.out.println("mainchk 컨트롤러");
        System.out.println("프론트에서 오는 id : " + id);

        String roomdate = memberRepository.mainchk(id);

        return new ResponseEntity<String>(roomdate, HttpStatus.OK);

    }
    /********************************************
     * RoomController
     *
     ********************************************/
    private static String UPLOADED_ROOM_FOLDER = "C:\\Users\\user\\Desktop\\tardygram\\frontend\\public\\image\\room\\";

//    @GetMapping("/sucess")
//    public String add() {
//         System.out.println("성공시 컨트롤러");
//         return "localhost:3000";
//     }



    //모임방 이미지 업로드
    @PostMapping(path="/upload/{roomno}",consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public String roomUpload(@RequestParam("file") MultipartFile file, @PathVariable String roomno){
        System.out.println("모임방 이미지 업로드 컨트롤러 ");
        // System.out.println("파일업로드 컨트롤러");
        System.out.println("건너온 data : " + file);
        System.out.println("roomno : " + roomno);
        System.out.println("파일이름 : " + file.getOriginalFilename());

        try{
            String DbPath = "/image/room/" + file.getOriginalFilename();
            System.out.println("Dbpath : " + DbPath);
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);
            System.out.println("path : " + path);
            roomRepository.roomphotoUpdate(DbPath, roomno);
            return DbPath;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "No Img";
    }



    //방장이 모임방 개설
    @PostMapping(path="/create")
    public ResponseEntity<HashMap<String, Object>> insertRoom(@RequestBody GramRoom data) {
        System.out.println("컨트롤러 도착");
        System.out.println("room : " + data);


        data.setRoomprogress(1);
        data.setRoomphoto("/image/room/kakaofriends.jpg");
        GramMember member = memberRepository.findById(data.getRoomhostid()).get();
        System.out.println("member : " + member);
        member.setTardystate("-");
        HashMap<String,Object> map =new HashMap<>();


        if(member.getMoney() >= data.getRoomcharge()){
            int tardycashe = member.getMoney()-data.getRoomcharge();
            member.addRoom(data);

            Long roomno = roomRepository.save(data).getRoomno();
            memberRepository.roomTardy(data.getRoomhostid(), tardycashe);
            roomRepository.insertPenaltyall(data.getRoomno(), data.getRoomcharge());
            map.put("status", "00");
            map.put("msg", "방이 생성되었습니다.");
            map.put("roomno",roomno);
        } else{
            map.put("status", "11");
            map.put("msg", "tardy캐시를 충전하고 다시 방을 만들어주세요.");
        }


        return new ResponseEntity<HashMap<String, Object>>(map, HttpStatus.OK);
    }

    //    List<Object []> selectuser = roomrepo.selectuser(roomno);
    //모임방에 방원이 될 사람이 참여하기 버튼클릭시
    @PostMapping("/enter/{id}/{roomno}/{roomcharge}")
    public ResponseEntity<HashMap<String, Object>> enter(@PathVariable String id, @PathVariable int roomno, @PathVariable int roomcharge){
        System.out.println("enter컨트롤러 도착");
        System.out.println("id : " + id);
        System.out.println("roomno : " + roomno);
        System.out.println("roomcharge : " + roomcharge);
        HashMap<String,Object> map =new HashMap<>();

        int tardycashe = memberRepository.tardyCash(id);
        if(tardycashe >= roomcharge){
            GramMember m = new GramMember();
            m.setMemberid(id);
            m.setTardystate("-");  //waiting
            enterRepository.enter(m, roomno);
            int money = tardycashe - roomcharge;
            memberRepository.roomTardy(id, money);
            roomRepository.insertPenaltyall(Long.parseLong(Integer.toString(roomno)), roomcharge);
            //return "방에 참여하셨습니다.";
            GramMember m2 = memberRepository.findById(id).get();
            System.out.println("m2 : " + m2);
            map.put("status", "00");
            map.put("msg", "성공했습니다");
            map.put("m2", m2);
            return new ResponseEntity<HashMap<String, Object>>(map, HttpStatus.OK);
        }else {
            //return "tardy캐시를 확인하세요";
            map.put("status", "11");
            map.put("msg", "타디캐시가 없습니다");
            return new ResponseEntity<HashMap<String, Object>>(map, HttpStatus.OK);
        }
    }


    //연관테이블 레코드 삭제후 room테이블 레코드 삭제, 각인원들에게 돈다시 줘야함
    // @DeleteMapping("/delete")
    // public void deleteroom(){
    //         roomrepo.deleteRoom((long)1);
    //         // roomrepo.deleteById((long)3);
    // }


    //모임방 전체출력
    @GetMapping("/selectall")
    public  ResponseEntity<HashMap<String, Object>> selectall(){
        System.out.println("모임방전체출력 컨트롤러 ");
        List<GramRoom> mList = roomRepository.selectall();
        System.out.println("mList : " + mList);
        HashMap <String, Object> map = new HashMap<>();
        map.put("mList", mList);

        return new ResponseEntity<HashMap<String, Object>>(map, HttpStatus.OK);
    }


    //모임방 디테일
    @GetMapping("/selectone/{roomno}")
    public ResponseEntity<HashMap<String, Object>> selectone(@PathVariable Long roomno){
// public void selectone(@PathVariable int roomno){
        System.out.println("selectone 컨트롤러 도착");
        System.out.println("roomno : " + roomno);
        GramRoom selecthost = roomRepository.selecthost(roomno);
        List<Object []> selectuser = roomRepository.selectuser(roomno);
        List memberList = new ArrayList<>();

        selectuser.forEach(arr -> {
            HashMap<String,Object> memlist =new HashMap<>();
            String memberid = arr[0].toString();
            String tardystate = arr[2].toString();

            memlist.put("memberid", memberid);
            //    System.out.println(arr[0].toString()); ID
            //    System.out.println(arr[1].toString()); Image
            //    System.out.println(arr[2].toString()); tardyState

            try{
                String profileimage = arr[1].toString();
                memlist.put("profileimage", profileimage);
                memlist.put("tardystate", tardystate);

            }catch(Exception e){
                memlist.put("profileimage", "null");
                memlist.put("tardyState", "null");
            }
            memberList.add(memlist);
        });

        System.out.println("selectuser : " + selectuser);
        HashMap<String,Object> map =new HashMap<>();
        map.put("selecthost", selecthost);
        map.put("selectuser", memberList);
        // System.out.println(map);
        return new ResponseEntity<HashMap<String, Object>>(map, HttpStatus.OK);
    }


    //룸디테일에서 확인버튼 누르면 tardystate변경
    @PutMapping("/checkroom/{memberid}")
    public ResponseEntity<String> checkroom(@PathVariable String memberid){
        System.out.println("체크룸컨트롤러도착");
        System.out.println("memberid : " + memberid);
        roomRepository.changeState(memberid);
        return new ResponseEntity<String>("arrived", HttpStatus.OK);
    }


    @DeleteMapping("/closeroom/{roomno}/{roompenaltyall}")
    public ResponseEntity<String> closeroom(@PathVariable String roomno, @PathVariable String roompenaltyall){
        System.out.println("클로즈룸컨트롤러도착");
        System.out.println("roomno :" + roomno);
        System.out.println("roompenaltyall : " + roompenaltyall);
        int arrivedcount = roomRepository.arrivedcount(roomno);
        //System.out.println("총벌금/도착인원 : " + Integer.parseInt(roompenaltyall)/arrivedcount);
        try{
            int deviceCharge =  Integer.parseInt(roompenaltyall)/arrivedcount;
            String[] arrivedMember =roomRepository.arrivedMember(roomno);
            System.out.println("arrivedMember[0] : " + arrivedMember[0]);
            for(int i=0; i<arrivedMember.length; i++){
                System.out.println(arrivedMember[i]);
                roomRepository.turnTardycashe(deviceCharge, arrivedMember[i]);

                String[] memberidArray = roomRepository.memberidArray(roomno);
                for(int j=0; j<memberidArray.length; j++){
                    roomRepository.tardystateChange(memberidArray[j]);
                }
            }
        }catch(ArithmeticException e){

        }

        roomRepository.deleteRoom(roomno);
        roomRepository.deleteFinalRoom(roomno);

        return new ResponseEntity<String>("성공", HttpStatus.OK);
    }


    //차트데이터 넣기
    @GetMapping("/chart")
    public ResponseEntity<HashMap<String,Object>> chartData(){
        System.out.println("차트 컨트롤러");
        int totalMember = memberRepository.totalMember();
        int totalRoom = roomRepository.totalRoom();

        HashMap <String,Object> map = new HashMap<>();
        map.put("totalMember", totalMember);
        map.put("totalRoom", totalRoom);

        int roomTotalCharge = 0;
        try{
            int[] roomChage = roomRepository.roomCharge();
            for(int i=0; i<roomChage.length; i++){
                roomTotalCharge = roomTotalCharge + roomChage[i];
            }
            System.out.println("roomTotalCharge : " + roomTotalCharge);
            double avg = roomTotalCharge/totalRoom;
            System.out.println("avg : " + avg);
            map.put("avg", avg);
        }catch(ArithmeticException e){

        }


        return new ResponseEntity<HashMap<String,Object>>(map, HttpStatus.OK);
    }

    /********************************************
     * KakaoController
     *
     ********************************************/
    // document.getElementsByClassName("link_gnb")[1].click()
    // document.getElementById("userPhone").value="01031753215";
    // document.getElementById("userBirth").value="880821"
    // document.getElementsByClassName("btn_payask")[0].click();

    private String amount;
    private String memberId;
    public String getAmount(){return this.amount;}
    public String getMemberId(){return this.memberId;}
    private KakaoPay kakaoPay;

    @GetMapping("/kakaoPay")
    public void kakaoPayGet() {

    }

    @PostMapping("/kakaoPay")
    public String kakaoPay(@RequestBody HashMap<String, String> data) {
        // System.out.println("kakaopay 컨트롤러 매핑");
        // System.out.println("data : " + data);
        // System.out.println("amount : " + data.get("amount"));
        // System.out.println("memberid : " + data.get("memberid"));

        amount = data.get("amount");
        memberId = data.get("memberId");
        System.out.println(amount);
        System.out.println("여기1");
        return kakaoPay.kakaoPayReady(data);
    }

    @GetMapping("/kakaoPaySuccess")
    public RedirectView  kakaoPaySuccess(@RequestParam("pg_token") String pg_token) {
        System.out.println("성공시 컨트롤러");
        //log.info("kakaoPaySuccess pg_token : " + pg_token);
        System.out.println("전역에있는 amount : " + this.getAmount());

        kakaoPay.kakaoPayInfo(pg_token, this.getAmount(), this.getMemberId());

        int money = memberRepository.tardyCash(this.getMemberId());
        GramMember m = memberRepository.findById(this.getMemberId()).get();
        m.setMoney(money + Integer.parseInt(this.getAmount()));
        memberRepository.save(m);


        return new RedirectView("http://localhost:3000/admin/user-profile");

    }


}
