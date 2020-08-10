package com.chatbot.web.health;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.*;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import org.apache.commons.io.FilenameUtils;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 * FileUploadController
 */

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/coach")
public class CoachController {
// ChallengeController
    private final ChallengeRepository challengeRepository;
    private final CoachRepository coachRepository;
    private final DiaryRepository diaryRepository;
    private final ExerciseRepository exerciseRepository;
    private final FoodRepository foodRepository;
    private final GymRepository gymRepository;
    private final MealRepository mealRepository;
    private final MemberRepository memberRepository;
    private final MyChallengeRepository myChallengeRepository;
    private final MyExerciseRepository myExerciseRepository;
    private final ReportRepository reportRepository;
    @PersistenceContext
    EntityManager entity;


    public CoachController(ChallengeRepository challengeRepository, CoachRepository coachRepository,
                           DiaryRepository diaryRepository, MyChallengeRepository myChallengeRepository,
                           ExerciseRepository exerciseRepository, FoodRepository foodRepository,
                           GymRepository gymRepository, MealRepository mealRepository,
                           MyExerciseRepository myExerciseRepository,ReportRepository reportRepository,
                           MemberRepository memberRepository, MyExerciseRepository repo) {
        this.challengeRepository = challengeRepository;
        this.coachRepository = coachRepository;
        this.diaryRepository = diaryRepository;
        this.exerciseRepository = exerciseRepository;
        this.foodRepository = foodRepository;
        this.gymRepository = gymRepository;
        this.mealRepository = mealRepository;
        this.memberRepository = memberRepository;
        this.myChallengeRepository = myChallengeRepository;
        this.reportRepository = reportRepository;
        this.myExerciseRepository = myExerciseRepository;
    }
    /********************************************
     * ChallengeController
     *
     ********************************************/
    //챌린지 이름 내용 넣기
    @PostMapping("/insert")
    public HashMap<String ,String > insertChallenge(@RequestBody Challenge challenge){
        HashMap <String ,String > map = new HashMap<>();
        challengeRepository.save(challenge);
        map.put("result" ,"Challenge inputSuccess");
        return map;
    }

    @GetMapping("/findAll")
    public List<Challenge> findAllChallenges(){
        return challengeRepository.findAll();
    }

    @GetMapping("/find/{id}")
    public Optional<Challenge> findById2(@PathVariable Long id){
        return challengeRepository.findById(id);
    }
    @GetMapping("/test")
    public String test() {
        return "성공";
    }


    /********************************************
     * CoachController
     *
     ********************************************/
    @PostMapping("/insert/{gymMemberId}/{gymId}")
    public Coach insertForm(@RequestBody Coach coach, @PathVariable GymMember gymMemberId, @PathVariable Gym gymId) {
        coach.setGymMemberId(gymMemberId);
        coach.setGymId(gymId);
        return coachRepository.save(coach);
    }

    @GetMapping("/exists/{gymMemberId}")
    public Boolean existsByMemberId(@PathVariable GymMember gymMemberId) {
        return coachRepository.existsByMemberId(gymMemberId);
    }

    @GetMapping("/existscoachid/{coachId}")
    public Boolean existsByMemberId(@PathVariable Coach coachId) {
        return coachRepository.existsByCoachId(coachId);
    }

    @GetMapping("/find/{gymMemberId}")
    public Coach findByMemberId(@PathVariable GymMember gymMemberId) {
        return coachRepository.findByMemberId(gymMemberId);
    }

    @GetMapping("/find")
    public List<Coach> list(Sort sort) {
      /*  sort = sort.and(new Sort(Sort.Direction.DESC, "coachId"));
        List<Coach> list = coachRepository.findAll(sort);
        return list;*/
        return null;
    }

    // R(1)
    @GetMapping("/findbycoachid/{coachId}")
    public Coach findByCoachesId(@PathVariable Long coachId) {
        Coach coach = coachRepository.findById(coachId).orElseThrow(javax.persistence.EntityNotFoundException::new);

        return coach;
    }

    // U
    @PutMapping("/update/{id}")
    public HashMap<String, String> update(@PathVariable Long id, @RequestBody Coach coach) {
        HashMap<String, String> map = new HashMap<>();
        Coach oldCoaches = coachRepository.findById(id).get();
        oldCoaches.setCoachInfo(coach.getCoachInfo());
        oldCoaches.setCoachLink(coach.getCoachLink());
        oldCoaches.setCoachLoc(coach.getCoachLoc());
        oldCoaches.setCoachName(coach.getCoachName());
        oldCoaches.setCoachPhoto1(coach.getCoachPhoto1());
        oldCoaches.setCoachPhoto2(coach.getCoachPhoto2());
        oldCoaches.setCoachResume1(coach.getCoachResume1());
        oldCoaches.setCoachResume2(coach.getCoachResume2());
        oldCoaches.setCoachResume3(coach.getCoachResume3());
        oldCoaches.setCoachResume4(coach.getCoachResume4());
        oldCoaches.setCoachResume5(coach.getCoachResume5());
        coachRepository.save(oldCoaches);
        map.put("result", "update sucess");
        return map;
    }
    /********************************************
     * DiaryController
     *
     ********************************************/


    @PostMapping("/{gymMemberId}")
    public HashMap<String, String> postDiary(@RequestBody Diary diaries, @PathVariable GymMember gymMemberId){
        HashMap<String, String> map = new HashMap<>();
        diaries.setGymMemberId(gymMemberId);
        diaryRepository.save(diaries);
        map.put("RESULT", "다이어리 등록 성공");
        return map;
    }

    @GetMapping("/exists/{gymMemberId}/{diaryDate}")
    public Boolean existsByMemberIdAndDiaryDate(@PathVariable GymMember gymMemberId, @PathVariable String diaryDate){
        return diaryRepository.existsByMemberIdAndDiaryDate(gymMemberId, diaryDate);
    }

    @GetMapping("/list/{gymMemberId}")
    public List<Diary> findByMemberId2(@PathVariable GymMember gymMemberId){
        return diaryRepository.findByMemberId(gymMemberId);
    }

    @GetMapping("/find/{diaryDate}/{gymMemberId}")
    public Diary findByDiaryDateAndMemberId(@PathVariable String diaryDate, @PathVariable GymMember gymMemberId){
        return diaryRepository.findByDiaryDateAndMemberId(diaryDate, gymMemberId);
    }

    @PutMapping("/update/{diaryDate}/{gymMemberId}")
    public HashMap<String, String> updateDiary(@PathVariable String diaryDate, @PathVariable GymMember gymMemberId, @RequestBody Diary diary){
        HashMap<String, String> map = new HashMap<>();
        Diary tempDiary = diaryRepository.findByDiaryDateAndMemberId(diaryDate, gymMemberId);
        tempDiary.setDiaryDays(diary.getDiaryDays());
        tempDiary.setDiaryGoal(diary.getDiaryGoal());
        tempDiary.setDiaryMuscle(diary.getDiaryMuscle());
        tempDiary.setDiaryFat(diary.getDiaryFat());
        tempDiary.setDiaryWater(diary.getDiaryWater());
        tempDiary.setDiarySkeletal(diary.getDiarySkeletal());
        tempDiary.setDiaryComment(diary.getDiaryComment());
        tempDiary.setDiaryPhoto(diary.getDiaryPhoto());
        diaryRepository.save(tempDiary);
        map.put("RESULT", "다이어리 수정 성공");
        return map;
    }

    @DeleteMapping("/delete/{diaryId}")
    public HashMap<String, String> deleteByDiaryId(@PathVariable String diaryId){
        HashMap<String, String> map = new HashMap<>();
        diaryRepository.deleteById(Long.parseLong(diaryId));
        map.put("RESULT", "다이어리 삭제 성공");
        return map;
    }

    /********************************************
     * ExerciseController
     *
     ********************************************/
    // 운동 루틴 데이터 입력
    @PostMapping("/insert")
    public HashMap<String, String> insertExercise(@RequestBody Exercise exercise,
                                                  @RequestParam("challengeId") Challenge challengeId) {
        HashMap<String, String> map = new HashMap<>();
        exercise.setChallengeId(challengeId);
        exerciseRepository.save(exercise);
        map.put("result", "Exercise Success");
        return map;
    }
    // 운동 포함 다 출력
    @GetMapping("/findAll")
    public List<Exercise> findAllExercise() {
        return exerciseRepository.findAll();
    }
    // challengeId에 따른 운동 출력
    @GetMapping("/findByChallengeId/{challengeId}")
    public List<Exercise> findByChallengeId(@PathVariable ("challengeId") Challenge challengeId){
        return exerciseRepository.findByChallengeId(challengeId);
    }
    // exerciseName 중복 제거
    @GetMapping(value="/findGroupByExerciseName")
    public List<Exercise> findGroupByExerciseName() {
        return exerciseRepository.findGroupByExerciseName();
    }

    /********************************************
     * FoodController
     *
     ********************************************/
    @PostMapping("")
    public HashMap<String, String> postFood(@RequestBody Food foods) {
        HashMap<String, String> map = new HashMap<>();
        foodRepository.save(foods);
        map.put("RESULT", "푸드 등록 성공");
        return map;
    }

    @GetMapping("/find/all")
    public Iterable<Food> findAllFoods() {
        return foodRepository.findAll();
    }

    @GetMapping("/find/{foodId}")
    public Optional<Food> findByFoodId(@PathVariable String foodId) {
        return foodRepository.findById(Long.parseLong(foodId));
    }

    @PutMapping("/update/{foodId}")
    public HashMap<String, String> updateFood(@PathVariable String foodId, @RequestBody Food foods){
        HashMap<String, String> map = new HashMap<>();
        Food tempFood = new Food();
        Optional<Food> optFood = foodRepository.findById(Long.parseLong(foodId));
        if(optFood.isPresent()){
            tempFood = optFood.get();
        }
        tempFood.setFoodName(foods.getFoodName());
        tempFood.setFoodCal(foods.getFoodCal());
        foodRepository.save(tempFood);
        map.put("RESULT", "푸드 수정 성공");
        return map;
    }

    @DeleteMapping("/delete/{foodId}")
    public HashMap<String, String> deleteFood(@PathVariable String foodId){
        HashMap<String, String> map = new HashMap<>();
        foodRepository.deleteById(Long.parseLong(foodId));
        map.put("RESULT", "푸드 삭제 성공");
        return map;
    }

    /********************************************
     * GymController
     *
     ********************************************/

    @PostMapping("/insert")
    public Gym insertForm(@RequestBody Gym gyms) {
        return gymRepository.save(gyms);
    }

    @GetMapping("/find/{gymId}")
    public Gym findByGymsId(@PathVariable Long gymId) {
        return gymRepository.findById(gymId).orElseThrow(EntityNotFoundException::new);
    }

    @GetMapping("/find")
    public List<Gym> findAll() {
        return gymRepository.findAll();
    }

    @PutMapping("update/{id}")
    public HashMap<String, String> update(@PathVariable Long id, @RequestBody Gym gyms) {
        HashMap<String, String> map = new HashMap<>();
        Gym oldGyms = gymRepository.findById(id).get();
        oldGyms.setGymName(gyms.getGymName());
        oldGyms.setGymInfo(gyms.getGymInfo());
        oldGyms.setGymInfo1(gyms.getGymInfo1());
        oldGyms.setGymInfo2(gyms.getGymInfo2());
        oldGyms.setGymInfo3(gyms.getGymInfo3());
        oldGyms.setGymPrice(gyms.getGymPrice());
        oldGyms.setGymTime(gyms.getGymTime());
        oldGyms.setGymLoc(gyms.getGymLoc());
        oldGyms.setGymPhoto(gyms.getGymPhoto());
        gymRepository.save(oldGyms);
        map.put("result", "update sucess");
        return map;
    }

    @DeleteMapping("/{gymId}")
    public void deleteById(@PathVariable Long gymId) {
        gymRepository.deleteById(gymId);
    }

    // querydsl: searching(exception)
    @GetMapping("/search/{keyword}")
    public List<Gym> search(@PathVariable String keyword) {

        System.out.println(keyword);
/*
        QGym gym = QGym.gyms;

        BooleanBuilder builder = new BooleanBuilder();
        JPAQueryFactory query = new JPAQueryFactory(entity);
        List<Gym> list = new ArrayList<>();
        // 동적
        // builder.and(gyms.gymId.eq(1L).and(gyms.gymLoc.eq("keyword")));
        // builder.and(gyms.gymLoc.like("%"+ keyword+"%"));
        // builder.and(gyms.gymId.eq(0L).and(gyms.gymLoc.like("%"+ keyword+"%")));
        builder.and(gym.gymId.gt(0L).and(gym.gymLoc.like("%" + keyword + "%")));
        query.from(gym).where(builder).fetch().forEach(obj -> list.add((Gym) obj));
        System.out.println(list.toString());
        return list;
        */
        return null;
        // // 정적
        // query.from(gyms)
        // .where(gyms.gymId.eq(5L).and(gyms.gymName.eq("asdf")))
        // .fetch()
        // .forEach(arr -> list.add(arr));
    }

    /********************************************
     * MealController
     *
     ********************************************/
    @PostMapping("")
    public HashMap<String, String> postMeal(@RequestBody Meal meal) {
        HashMap<String, String> map = new HashMap<>();
        mealRepository.save(meal);
        map.put("RESULT", "식사 등록 성공");
        return map;
    }

    @GetMapping("/find/{mealDate}")
    public Iterable<Meal> findByMealDate2(@PathVariable String mealDate){
        return mealRepository.findByMealDate(mealDate);
    }

    @PutMapping("/update/{mealId}")
    public HashMap<String, String> updateMeal(@PathVariable String mealId, @RequestBody Meal meals){
        HashMap<String, String> map = new HashMap<>();
        Meal tempMeal = new Meal();
        Optional<Meal> optMeal = mealRepository.findById(Long.parseLong(mealId));
        if(optMeal.isPresent()){
            tempMeal = optMeal.get();
        }
        tempMeal.setMealDate(meals.getMealDate());
        tempMeal.setMealTime(meals.getMealTime());
        tempMeal.setMealCal(meals.getMealCal());
        mealRepository.save(tempMeal);
        map.put("RESULT", "식사 수정 성공");
        return map;
    }

    @DeleteMapping("/delete/{mealId}")
    public HashMap<String, String> deleteMeal2(@PathVariable String mealId){
        HashMap<String, String> map = new HashMap<>();
        mealRepository.deleteById(Long.parseLong(mealId));
        map.put("RESULT", "식사 삭제 성공");
        return map;
    }


    @PostMapping("")
    public HashMap<String, String> postMeal2(@RequestBody Meal meals) {
        HashMap<String, String> map = new HashMap<>();
        mealRepository.save(meals);
        map.put("RESULT", "식사 등록 성공");
        return map;
    }

    @GetMapping("/find/{mealDate}")
    public Iterable<Meal> findByMealDate(@PathVariable String mealDate){
        return mealRepository.findByMealDate(mealDate);
    }

    @PutMapping("/update/{mealId}")
    public HashMap<String, String> updateMeal2(@PathVariable String mealId, @RequestBody Meal meals){
        HashMap<String, String> map = new HashMap<>();
        Meal tempMeal = new Meal();
        Optional<Meal> optMeal = mealRepository.findById(Long.parseLong(mealId));
        if(optMeal.isPresent()){
            tempMeal = optMeal.get();
        }
        tempMeal.setMealDate(meals.getMealDate());
        tempMeal.setMealTime(meals.getMealTime());
        tempMeal.setMealCal(meals.getMealCal());
        mealRepository.save(tempMeal);
        map.put("RESULT", "식사 수정 성공");
        return map;
    }

    @DeleteMapping("/delete/{mealId}")
    public HashMap<String, String> deleteMeal(@PathVariable String mealId){
        HashMap<String, String> map = new HashMap<>();
        mealRepository.deleteById(Long.parseLong(mealId));
        map.put("RESULT", "식사 삭제 성공");
        return map;
    }

    /********************************************
     * MemberController
     *
     ********************************************/
    //member회원가입 local
    @PostMapping("/join")
    public HashMap<String, String> join(@RequestBody GymMember members){
        HashMap<String ,String> map = new HashMap<>();
        System.out.println("조인 접근");
        System.out.println("members : " + members);
        memberRepository.save(members);
        map.put("result","회원가입 성공");
        return map;
    }

    //로그인 하기
    @PostMapping("/login")
    public Optional<GymMember> login(@RequestBody GymMember members){
        System.out.println("로그인 컨트롤러 : " + members.getMemberEmail() + members.getMemberPw());

        System.out.println("members.getMemberPw() : "+members.getMemberPw());
        Optional<GymMember> result = memberRepository.findByMemberEmailAndMemberPw(members.getMemberEmail(), members.getMemberPw());

        if(result.isPresent()){
            System.out.println(result + "111");
            return result;
        }else{
            System.out.println(result + "222");
            return null;
        }
    }

    //회원에 id 따른 정보 가져오기
    @GetMapping("/find/{id}")
    public GymMember findById(@PathVariable Long id){
        System.out.println("findById " + id);

        GymMember members = memberRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        System.out.println("id 회원정보 : "+ members);
        return members;
    }

    // 회원 정보 수정
    @PutMapping("/update/{id}")
    @Transactional
    public HashMap<String, String> update(@PathVariable Long id, @RequestBody GymMember members) {
        HashMap<String ,String> map = new HashMap<>();

        // 아이디 찾고 --> 해당 정보 수정
        GymMember oldMembers = memberRepository.findById((id)).get();
        oldMembers.setMemberName(members.getMemberName());
        oldMembers.setMemberPw(members.getMemberPw());
        oldMembers.setMemberHeight(members.getMemberHeight());
        oldMembers.setMemberPhoto(members.getMemberPhoto());
        //not null값은 입력해야됨
        oldMembers.setMemberType(members.getMemberType());
        oldMembers.setMemberWeight(members.getMemberWeight());
        oldMembers.setMemberText(members.getMemberText());

        memberRepository.save(oldMembers);

        map.put("result", "update success");
        return map;
    }

    // 회원 정보 삭제
    @DeleteMapping("/delete/{id}")
    public HashMap<String, String> deleteMember(@PathVariable Long id){
        HashMap<String ,String > map = new HashMap<>();

        memberRepository.deleteById(id);

        map.put("result", "member delete success");
        return map;
    }
    /********************************************
     * MyChallengeController
     *
     ********************************************/



    // 커스터마이징한 챌린지 값 넣기
    @PostMapping("/insert/{gymMemberId}")
    public HashMap<String, String> insertMyChallenge(@RequestBody MyChallenge myChallenge,
                                                      @PathVariable GymMember gymMemberId) {
        HashMap<String, String> map = new HashMap<>();

        myChallenge.setGymMemberId(gymMemberId);

        myChallengeRepository.save(myChallenge);

        map.put("result", "success");
        return map;
    }

    // memberId 별로 가져오기
    @GetMapping("/findbymemberid/{gymMemberId}")
    public List<MyChallenge> findByMemberId3(@PathVariable GymMember gymMemberId){

        return myChallengeRepository.findByMemberId(gymMemberId);
    }

    // findFirstByOrderByIdDesc
    @GetMapping("/findFirstByOrderByMyChallengeIdDesc")
    public MyChallenge findFirstByOrderByMyChallengeIdDesc(){
        return myChallengeRepository.findFirstByOrderByMyChallengeIdDesc();
    }
    /********************************************
     * MyExerciseController
     *
     ********************************************/

    @PostMapping("")
    public HashMap<String, String> postMyExercise(@RequestBody MyExercise myExercise){
        HashMap<String, String> map = new HashMap<>();
        myExerciseRepository.save(myExercise);
        map.put("RESULT", "멤버 운동 등록 성공");
        return map;
    }

    @GetMapping("/find/{myExerciseDate}")
    public Iterable<MyExercise> findByMyExerciseDate(@PathVariable String myExerciseDate){
        return myExerciseRepository.findByMyExerciseDate(myExerciseDate);
    }

    @PutMapping("/update/{myExerciseId}")
    public HashMap<String, String> updateMyExercise(@PathVariable String myExerciseId, @RequestBody MyExercise myExercise){
        HashMap<String, String> map = new HashMap<>();
        MyExercise tempMem = new MyExercise();
        Optional<MyExercise> optMem = myExerciseRepository.findById(Long.parseLong(myExerciseId));
        if(optMem.isPresent()){
            tempMem = optMem.get();
        }
        tempMem.setExerciseId(myExercise.getExerciseId());
        tempMem.setMyExerciseSet(myExercise.getMyExerciseSet());
        tempMem.setMyExerciseCount(myExercise.getMyExerciseCount());
        tempMem.setMyExerciseTime(myExercise.getMyExerciseTime());
        tempMem.setMyExerciseCal(myExercise.getMyExerciseCal());
        tempMem.setMyExerciseComplete(myExercise.getMyExerciseComplete());
        myExerciseRepository.save(tempMem);
        map.put("RESULT", "멤버 운동 수정 성공");
        return map;
    }

    @PutMapping("/update2/{myExerciseId}")
    public HashMap<String, String> updateMyExercise2(@PathVariable String myExerciseId, @RequestBody MyExercise myExercise){
        HashMap<String, String> map = new HashMap<>();
        MyExercise tempMem = new MyExercise();
        Optional<MyExercise> optMem = myExerciseRepository.findById(Long.parseLong(myExerciseId));
        if(optMem.isPresent()){
            tempMem = optMem.get();
        }
        // tempMem.setExerciseId(myExercise.getExerciseId());
        tempMem.setMyExerciseSet(myExercise.getMyExerciseSet());
        tempMem.setMyExerciseCount(myExercise.getMyExerciseCount());
        tempMem.setMyExerciseTime(myExercise.getMyExerciseTime());
        tempMem.setMyExerciseCal(myExercise.getMyExerciseCal());
        tempMem.setMyExerciseComplete(myExercise.getMyExerciseComplete());
        tempMem.setMyExerciseDate(myExercise.getMyExerciseDate());

        myExerciseRepository.save(tempMem);
        map.put("RESULT", "멤버 운동 수정 성공");
        return map;
    }

    @DeleteMapping("/delete/{myExerciseId}")
    public HashMap<String, String> deleteMyExercise(@PathVariable String myExerciseId){
        HashMap<String, String> map = new HashMap<>();
        myExerciseRepository.deleteById(Long.parseLong(myExerciseId));
        map.put("RESULT", "멤버 운동 삭제 성공");
        return map;
    }

    // 커스터마이징 운동 루틴 저장
    // @PostMapping("/insert")
    // public HashMap<String,String> insertMemEx(@RequestBody MyExercises myExercises,
    //                                          @RequestParam("memberId")Members memberId,
    //                                          @RequestParam("exerciseId") Exercises exerciseId){
    //     HashMap<String,String> map = new HashMap<>();

    //     myExercises.setMemberId(memberId);
    //     myExercises.setExerciseId(exerciseId);
    //     myExerciseRepository.save(myExercises);

    //     map.put("result","memEx insert success");
    //     return map;
    // }

    // PathVariable 로 값 저장하기
    @PostMapping("/insert/{gymMemberId}/{exerciseId}/{myChallengeId}")
    public HashMap<String,String> insertMemEx(@RequestBody MyExercise myExercises,
                                              @PathVariable GymMember gymMemberId,
                                              @PathVariable Exercise exerciseId,
                                              @PathVariable MyChallenge myChallengeId){
        HashMap<String,String> map = new HashMap<>();

        myExercises.setMyChallengeId(myChallengeId);
        myExercises.setGymMemberId(gymMemberId);
        myExercises.setExerciseId(exerciseId);
        myExerciseRepository.save(myExercises);

        map.put("result","memEx insert success");
        return map;
    }

    // PathVariable 로 값 저장하기
    @PostMapping("/insert2/{gymMemberId}/{exerciseId}")
    public HashMap<String,String> insertMemEx2(@RequestBody MyExercise myExercises,
                                               @PathVariable GymMember gymMemberId,
                                               @PathVariable Exercise exerciseId){

        HashMap<String,String> map = new HashMap<>();

        myExercises.setGymMemberId(gymMemberId);
        myExercises.setExerciseId(exerciseId);
        myExerciseRepository.save(myExercises);

        map.put("result","memEx insert success");
        return map;
    }

    // findByMyChallengeId
    @GetMapping("/findbymychallengeid/{myChallengeId}")
    public List<MyExercise> findByMyChallengeId(@PathVariable MyChallenge myChallengeId){
        return myExerciseRepository.findByMyChallengeId(myChallengeId);
    }

    /********************************************
     * ReportController
     *
     ********************************************/
    @PostMapping("")
    public HashMap<String, String> postReport(@RequestBody Report reports) {
        HashMap<String, String> map = new HashMap<>();
        reportRepository.save(reports);
        map.put("RESULT", "리포트 등록 성공");
        return map;
    }

    @GetMapping("/find/{reportDate}")
    public Report findByReportDate(@PathVariable String reportDate){
        return reportRepository.findByReportDate(reportDate);
    }

    @PutMapping("/update/{reportDate}")
    public HashMap<String, String> updateReport(@PathVariable String reportDate, @RequestBody Report report){
        HashMap<String, String> map = new HashMap<>();
        Report tempReports = reportRepository.findByReportDate(reportDate);
        tempReports.setReportCalIn(report.getReportCalIn());
        tempReports.setReportCalOut(report.getReportCalOut());
        reportRepository.save(tempReports);
        map.put("RESULT", "리포트 수정 성공");
        return map;
    }

    @DeleteMapping("/delete/{reportId}")
    public HashMap<String, String> deleteReport(@PathVariable String reportId){
        HashMap<String, String> map = new HashMap<>();
        reportRepository.deleteById(Long.parseLong(reportId));
        map.put("RESULT", "리포트 삭제 성공");
        return map;
    }

    // //D
    // @DeleteMapping("/{id}")
    // public void deleteById(@PathVariable Long id){
    // Coaches coaches = repo.findById(id);
    // repo.deleteById(coaches.getCoachId());
    // }


    /********************************************
     * FileUploadController
     *
     ********************************************/
   @PostMapping("")
    public String handleUpload(@RequestParam("file") MultipartFile uploadFile) throws Exception {
        String newFileName = "";
        if(uploadFile != null) {
            String filePath = "C:/Users/YONG/newdeal/project/team_Project/frontend/public/user-image";
            File fileDir = new File(filePath);
           if(fileDir.exists() == false) {
                fileDir.mkdirs();
            }

           SimpleDateFormat stampFormat = new SimpleDateFormat("yyyyMMdd-HHmmssSSSS");
            String timeStamp = stampFormat.format(new Date());
           String fileExtension = "";
            int extensionIndex = uploadFile.getOriginalFilename().lastIndexOf(".");
            if(extensionIndex != -1) {
                fileExtension = uploadFile.getOriginalFilename().substring(extensionIndex);
            }
            String uuid = UUID.randomUUID().toString().replace("-", "");
            newFileName = timeStamp + "-" + uuid + fileExtension;

            uploadFile.transferTo(new File(filePath + "/" + newFileName));
        }
        return newFileName;
    }

//	s3에서 사진 올리기
//	 s3 관련

    private static final String BUCKET_NAME = "urcoach.fileupload.com";
    private static final String ACCESS_KEY = "AKIA3KNYQRDBWQWSKA7Q";
    private static final String SECRET_KEY = "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";
    private static final String clientRegion = "ap-northeast-2";
    private AmazonS3 s3;
    private static final String cloudfront = "http://urcoach.fileupload.com.s3-website.ap-northeast-2.amazonaws.com";

    @PostMapping("")
    public String handleUploadS3(@RequestParam("file") MultipartFile uploadfile) throws Exception{
        String newFileName = "";

        String datePath = new SimpleDateFormat("/yyyy/MM/dd/HH").format(new Date());
        AWSCredentials awsCredentials = new BasicAWSCredentials(ACCESS_KEY, SECRET_KEY);
        s3=AmazonS3ClientBuilder.standard().withRegion(clientRegion).withCredentials(new AWSStaticCredentialsProvider(awsCredentials)).build();

        if (uploadfile != null) {
            // 파일명 중복 방지
            String uName = UUID.randomUUID().toString();
            String ext = FilenameUtils.getExtension(uploadfile.getOriginalFilename());
            String convName = uName + "." + ext;
            // s3 업로드를 위해 multipart -> File convert
            File convfile = new File(convName);
            convfile.createNewFile();
            FileOutputStream fos = new FileOutputStream(convfile);
            fos.write(uploadfile.getBytes());
            fos.close();

            if (s3 != null) {
                try {
                    PutObjectRequest putObjectRequest = new PutObjectRequest(BUCKET_NAME + datePath, convName,
                            convfile);
                    putObjectRequest.setCannedAcl(CannedAccessControlList.PublicRead); // file permission
                    s3.putObject(putObjectRequest);
                } catch (Exception e) {
                    // TODO: handle exception
                } finally {
                    s3 = null;
                }
            }

            return newFileName = uploadfile.getOriginalFilename() ;
        }
        return newFileName = uploadfile.getOriginalFilename() ;
    }
}
