package kz.iitu.itse1908.springfinalproject.Controllers.Modules;


import kz.iitu.itse1908.springfinalproject.Controllers.CutomResponses.CustomTestingResponse;
import kz.iitu.itse1908.springfinalproject.Controllers.CutomResponses.RoutesMappingResponse;
import kz.iitu.itse1908.springfinalproject.Entities.User;
import kz.iitu.itse1908.springfinalproject.Security.CustomUserDetails;
import kz.iitu.itse1908.springfinalproject.Services.*;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

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

    public StaffModule(UserService userService, AssessmentService assessmentService, GroupService groupService, UserGradesDetailsService userGradesDetailsService, TaskService taskService, TaskGroupService taskGroupService) {
        this.userService = userService;
        this.assessmentService = assessmentService;
        this.groupService = groupService;
        this.userGradesDetailsService = userGradesDetailsService;
        this.taskService = taskService;
        this.taskGroupService = taskGroupService;
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
        RoutesMappingResponse mappingResponse = new RoutesMappingResponse(message, availableRoutes);
        return mappingResponse;
    }

}
