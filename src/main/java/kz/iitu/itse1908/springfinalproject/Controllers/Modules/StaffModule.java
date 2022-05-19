package kz.iitu.itse1908.springfinalproject.Controllers.Modules;


import kz.iitu.itse1908.springfinalproject.Controllers.CustomRequests.FillingTestWithQuestionsRequest;
import kz.iitu.itse1908.springfinalproject.Controllers.CustomRequests.GetAssesmentRequest;
import kz.iitu.itse1908.springfinalproject.Controllers.CustomRequests.TaskAssigningRequest;
import kz.iitu.itse1908.springfinalproject.Controllers.CutomResponses.RoutesMappingResponse;
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
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@EnableWebMvc
@RequestMapping(value = "/staffModule")
public class StaffModule {


    final UserService userService;

    private final AssessmentService assessmentService;

    private final GroupService groupService;

    private final UserGradesDetailsService userGradesDetailsService;

    private final TaskService taskService;

    private final TaskGroupService taskGroupService;

    private final TestService testService;

    private final TestQuestionService testQuestionService;

    public StaffModule(UserService userService, AssessmentService assessmentService, GroupService groupService, UserGradesDetailsService userGradesDetailsService, TaskService taskService, TaskGroupService taskGroupService, TestService testService, TestQuestionService testQuestionService) {
        this.userService = userService;
        this.assessmentService = assessmentService;
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
        availableRoutes.put("Ungraded assessments", baseUrl + "gradeAssesments");
        availableRoutes.put("Create new task", baseUrl + "createNewTask");
        availableRoutes.put("Assign task to groups", baseUrl + "assignTask");
        availableRoutes.put("Create new test", baseUrl + "createNewTest");
        availableRoutes.put("Fill test with questions", baseUrl + "fillTestWithQuestions");
        availableRoutes.put("Download student's assignment", baseUrl + "getAssessment");
        RoutesMappingResponse mappingResponse = new RoutesMappingResponse(message, availableRoutes);
        return mappingResponse;
    }

    @RequestMapping(value = "/createNewTask", method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @Transactional
    String createNewTask(@RequestBody Task task) {
        taskService.insert(task);
        return "Task succesfully created!";
    }

    @RequestMapping(value = "/assignTask", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @Transactional
    String create(@RequestBody TaskAssigningRequest taskAssigningRequest) {
        Task task = taskService.findById(taskAssigningRequest.getTaskId());
        List<Integer> groupIds = taskAssigningRequest.getGroupIds();
        Group group;
        for (int i = 0;i<groupIds.size();i++){
            TaskGroup taskGroup = new TaskGroup();
            taskGroup.setTaskid(task);
            group = groupService.findGroupById(groupIds.get(i));
            taskGroup.setGroupid(group);
            taskGroupService.insert(taskGroup);
        }
        return "You have successfully assigned task to groups!";
    }

    @RequestMapping(value = "/gradeAssessments", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @Transactional
    List<Assesment> getUngradedAssessments() {
        CustomUserDetails principal = (CustomUserDetails) SecurityContextHolder.
                getContext().
                getAuthentication().
                getPrincipal();
        User user = userService.findUserByEmail(principal.getUsername());
        Iterable<Assesment> allAssessments = assessmentService.getAll();
        List<Assesment> choosenAssessments = new ArrayList<Assesment>();
        allAssessments.forEach(assesment -> {
            Task task = taskService.findById(assesment.getTaskid().getId());
            Integer graderId = task.getGraderid();
            if (graderId == user.getId() && !assesment.getGraded())
                choosenAssessments.add(assesment);
        });
        return choosenAssessments;
    }

    @RequestMapping(value = "/getAssesment", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void getFile(
            @RequestBody GetAssesmentRequest request,
            HttpServletResponse response) {
        try {
            String fileName = request.getPath();
            File initialFile = new File("temp/assessments/" + fileName);
            InputStream is = new FileInputStream(initialFile);
            org.apache.commons.io.IOUtils.copy(is, response.getOutputStream());
            response.flushBuffer();
        } catch (IOException ex) {
            throw new RuntimeException("IOError writing file to output stream");
        }
    }

    @RequestMapping(value = "/fillTestWithQuestions", method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @Transactional
    String fillTestWithQuestions(@RequestBody FillingTestWithQuestionsRequest request) {
        List<Testquestion> questions = request.getQuestions();
        for (int i = 0;i<questions.size();i++){
            questions.get(i).setTestid(testService.findById(request.getTestId()));
        }
        testQuestionService.saveAll(questions);
        return "You have successfully added questions to a test!";
    }

    @RequestMapping(value = "/createNewTest", method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @Transactional
    String createNewTest(@RequestBody Test test) {
        testService.insert(test);
        return "Test succesfully created!";
    }

}
