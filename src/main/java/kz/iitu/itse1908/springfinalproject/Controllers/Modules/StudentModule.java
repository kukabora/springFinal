package kz.iitu.itse1908.springfinalproject.Controllers.Modules;


import kz.iitu.itse1908.springfinalproject.Controllers.CutomResponses.RoutesMappingResponse;
import kz.iitu.itse1908.springfinalproject.Entities.*;
import kz.iitu.itse1908.springfinalproject.Security.CustomUserDetails;
import kz.iitu.itse1908.springfinalproject.Security.JwtProvider;
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

@RestController
@EnableWebMvc
@RequestMapping(value = "/studentModule")
public class StudentModule {

    private final AssessmentService assessmentService;

    private final JwtProvider jwtProvider;

    private final UserService userService;

    private final GroupService groupService;

    private final UserGradesDetailsService userGradesDetailsService;

    private final TaskService taskService;

    private final TaskGroupService taskGroupService;

    public StudentModule(AssessmentService assessmentService, JwtProvider jwtProvider, UserService userService, GroupService groupService, UserGradesDetailsService userGradesDetailsService, TaskService taskService, TaskGroupService taskGroupService) {
        this.assessmentService = assessmentService;
        this.jwtProvider = jwtProvider;
        this.userService = userService;
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
        availableRoutes.put("Your grades details", baseUrl + "myGrades");
        availableRoutes.put("Your assessments", baseUrl + "assignments");
        availableRoutes.put("Tasks for your group", baseUrl + "tasks");
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
}
