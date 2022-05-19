package kz.iitu.itse1908.springfinalproject.Controllers.Modules;


import kz.iitu.itse1908.springfinalproject.Controllers.CustomRequests.TestingRequest;
import kz.iitu.itse1908.springfinalproject.Controllers.CutomResponses.CustomTestingResponse;
import kz.iitu.itse1908.springfinalproject.Controllers.CutomResponses.RoutesMappingResponse;
import kz.iitu.itse1908.springfinalproject.Controllers.CutomResponses.TrimmedTestQuestion;
import kz.iitu.itse1908.springfinalproject.Entities.*;
import kz.iitu.itse1908.springfinalproject.Security.CustomUserDetails;
import kz.iitu.itse1908.springfinalproject.Services.*;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@EnableWebMvc
@RequestMapping(value = "/studentModule")
public class StudentModule {

    private final AssessmentService assessmentService;


    private final UserService userService;

    private final GroupService groupService;

    private final UserGradesDetailsService userGradesDetailsService;

    private final TaskService taskService;

    private final TaskGroupService taskGroupService;

    private final TestService testService;

    private final TestQuestionService testQuestionService;

    public StudentModule(AssessmentService assessmentService, UserService userService, GroupService groupService, UserGradesDetailsService userGradesDetailsService, TaskService taskService, TaskGroupService taskGroupService, TestService testService, TestQuestionService testQuestionService) {
        this.assessmentService = assessmentService;
        this.userService = userService;
        this.groupService = groupService;
        this.userGradesDetailsService = userGradesDetailsService;
        this.taskService = taskService;
        this.taskGroupService = taskGroupService;
        this.testService = testService;
        this.testQuestionService = testQuestionService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @Transactional
    RoutesMappingResponse home(HttpServletRequest request) {
        String baseUrl =
                ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString() + request.getServletPath();
        CustomUserDetails principal = (CustomUserDetails) SecurityContextHolder.
                getContext().
                getAuthentication().
                getPrincipal();
        User user = userService.findUserByEmail(principal.getUsername());
        String message = "Welcome, " +user.getFname() + " " + user.getLname() + "!";
        HashMap<String, String> availableRoutes = new HashMap<String, String>();
        availableRoutes.put("Your grades details", baseUrl + "myGrades");
        availableRoutes.put("Your assessments", baseUrl + "assessments");
        availableRoutes.put("Tasks for your group", baseUrl + "tasks");
        availableRoutes.put("Your unfinished tasks", baseUrl + "unfinishedTasks");
        availableRoutes.put("Pass test", baseUrl + "passTest");
        availableRoutes.put("Upload assessment", baseUrl + "uploadAssessment");
        RoutesMappingResponse mappingResponse = new RoutesMappingResponse(message, availableRoutes);
        return mappingResponse;
    }

    @RequestMapping(value = "/myGrades", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @Transactional
    Usersgradedetail myGrades(HttpServletRequest request) {
        CustomUserDetails principal = (CustomUserDetails) SecurityContextHolder.
                getContext().
                getAuthentication().
                getPrincipal();
        User user = userService.findUserByEmail(principal.getUsername());
        Usersgradedetail currentUsersGrades = userGradesDetailsService.getUserGradesByUserId(user);
        return currentUsersGrades;
    }

    @RequestMapping(value = "/tasks", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @Transactional
    Iterable<Task> tasks(HttpServletRequest request) {
        CustomUserDetails principal = (CustomUserDetails) SecurityContextHolder.
                getContext().
                getAuthentication().
                getPrincipal();
        User user = userService.findUserByEmail(principal.getUsername());
        Group group = user.getGroupid();
        Iterable<TaskGroup> taskGroups = taskGroupService.findTaskGroupByGroupid(group);
        List<Integer> taskIds = new ArrayList<Integer>();
        taskGroups.forEach(taskGroup -> {
            taskIds.add(taskGroup.getTaskid());
        });
        Iterable<Task> tasks = taskService.findAllById(taskIds);
        return tasks;
    }

    @RequestMapping(value = "/assessments", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @Transactional
    Iterable<Assesment> assessments(HttpServletRequest request) {
        CustomUserDetails principal = (CustomUserDetails) SecurityContextHolder.
                getContext().
                getAuthentication().
                getPrincipal();
        User user = userService.findUserByEmail(principal.getUsername());
        Iterable<Assesment> assesments = assessmentService.findAllByAssessorId(user);
        return assesments;
    }

    @RequestMapping(value = "/passTest/{testId}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @Transactional
    CustomTestingResponse passTest(HttpServletRequest request, @PathVariable Integer testId) {
        CustomUserDetails principal = (CustomUserDetails) SecurityContextHolder.
                getContext().
                getAuthentication().
                getPrincipal();
        User user = userService.findUserByEmail(principal.getUsername());
        Group group = user.getGroupid();
        if (testService.existsById(testId)){
            Test test = testService.findById(testId);

            Task currentTask = taskService.findByTestId(test);

            if (assessmentService.checkIfAlreadyAssessed(user, currentTask))
                return null;
            CustomTestingResponse customTestingResponse = new CustomTestingResponse();
            TestingRequest testingRequest = new TestingRequest();
            HashMap<Integer, String> exampleRequestBody = new HashMap<>();
            exampleRequestBody.put(1, "ANSWER ON THE QUESTION #1");
            exampleRequestBody.put(2, "ANSWER ON THE QUESTION #2");
            exampleRequestBody.put(3, "ANSWER ON THE QUESTION #3");
            testingRequest.setAnswers(exampleRequestBody);
            Iterable<Testquestion> testquestions = testQuestionService.findAllByTestId(test);
            HashMap<Integer, TrimmedTestQuestion> questions = new HashMap<Integer, TrimmedTestQuestion>();
            testquestions.forEach(testquestion -> {
                TrimmedTestQuestion trimmedTestQuestion = new TrimmedTestQuestion();
                trimmedTestQuestion.setQuestionText(testquestion.getQuestiontext());
                trimmedTestQuestion.setAnswer1(testquestion.getAnswer1());
                trimmedTestQuestion.setAnswer2(testquestion.getAnswer2());
                trimmedTestQuestion.setAnswer3(testquestion.getAnswer3());
                questions.put(testquestion.getId(), trimmedTestQuestion);
            });
            customTestingResponse.setQuestions(questions);
            customTestingResponse.setTestingRequestExample(testingRequest);
            return customTestingResponse;

        }

        return null;
    }

    @RequestMapping(value = "/unfinishedTasks", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @Transactional
    Iterable<Task> unfinishedTasks(HttpServletRequest request) {
        CustomUserDetails principal = (CustomUserDetails) SecurityContextHolder.
                getContext().
                getAuthentication().
                getPrincipal();
        User user = userService.findUserByEmail(principal.getUsername());
        Group group = user.getGroupid();
        Iterable<TaskGroup> taskGroups = taskGroupService.findTaskGroupByGroupid(group);
        List<Integer> taskIds = new ArrayList<Integer>();
        taskGroups.forEach(taskGroup -> {
            taskIds.add(taskGroup.getTaskid());
        });
        List<Task> tasks = (List<Task>) taskService.findAllById(taskIds);
        for (int i = 0;i<tasks.size();i++){
            if (assessmentService.checkIfAlreadyAssessed(user, tasks.get(i))){
                tasks.remove(i);
            }
        }
        return tasks;
    }


    @RequestMapping(value = "/passTest/{testId}", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @Transactional
    String passTestPost(HttpServletRequest request, @PathVariable Integer testId, @RequestBody TestingRequest testingRequest) {
        CustomUserDetails principal = (CustomUserDetails) SecurityContextHolder.
                getContext().
                getAuthentication().
                getPrincipal();
        User user = userService.findUserByEmail(principal.getUsername());
        Group group = user.getGroupid();
        if (testService.existsById(testId)){
            Test test = testService.findById(testId);
            Task currentTask = taskService.findByTestId(test);

            if (assessmentService.checkIfAlreadyAssessed(user, currentTask))
                return "YOU HAVE ALREADY PASSED THIS TEST";

            AtomicInteger rightAnswered = new AtomicInteger();
            AtomicInteger totalQuestions = new AtomicInteger();
            HashMap<Integer, String> userAnswers = testingRequest.getAnswers();
            Iterable<Testquestion> testquestions = testQuestionService.findAllByTestId(test);
            testquestions.forEach(testquestion -> {
                String currentAnswer = userAnswers.getOrDefault(testquestion.getId(), "");
                totalQuestions.getAndIncrement();
                if (currentAnswer.equals(testquestion.getCorrectanswer())) {
                    rightAnswered.getAndIncrement();
                }
            });
            Assesment newAssesment = new Assesment();
            newAssesment.setAssesmentgrade(Float.valueOf(rightAnswered.get() * 100 / totalQuestions.get()));
            newAssesment.setAssessorid(user);
            newAssesment.setGraded(true);
            newAssesment.setTaskid(currentTask);
            newAssesment.setTestresult(rightAnswered.get());
            assessmentService.insertNewAssesment(newAssesment);
            return "YOU HAVE GOT " + rightAnswered.get() + "/" + totalQuestions.get() + " ANSWERS RIGHT!";

        }
        return "THERE IS NO TEST WITH SUCH AN ID";
    }
}
