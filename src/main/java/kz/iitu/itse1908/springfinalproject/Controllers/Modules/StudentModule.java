package kz.iitu.itse1908.springfinalproject.Controllers.Modules;


import kz.iitu.itse1908.springfinalproject.Controllers.CutomResponses.RoutesMappingResponse;
import kz.iitu.itse1908.springfinalproject.Entities.User;
import kz.iitu.itse1908.springfinalproject.Entities.Usersgradedetail;
import kz.iitu.itse1908.springfinalproject.Security.CustomUserDetails;
import kz.iitu.itse1908.springfinalproject.Security.JwtProvider;
import kz.iitu.itse1908.springfinalproject.Services.AssessmentService;
import kz.iitu.itse1908.springfinalproject.Services.GroupService;
import kz.iitu.itse1908.springfinalproject.Services.UserGradesDetailsService;
import kz.iitu.itse1908.springfinalproject.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

import static kz.iitu.itse1908.springfinalproject.Security.JwtFilter.AUTHORIZATION;

@RestController
@EnableWebMvc
@RequestMapping(value = "/studentModule")
public class StudentModule {

    private final AssessmentService assessmentService;

    private final JwtProvider jwtProvider;

    private final UserService userService;

    private final GroupService groupService;

    private final UserGradesDetailsService userGradesDetailsService;

    public StudentModule(AssessmentService assessmentService, JwtProvider jwtProvider, UserService userService, GroupService groupService, UserGradesDetailsService userGradesDetailsService) {
        this.assessmentService = assessmentService;
        this.jwtProvider = jwtProvider;
        this.userService = userService;
        this.groupService = groupService;
        this.userGradesDetailsService = userGradesDetailsService;
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
        availableRoutes.put("Your assignments", baseUrl + "assignments");
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
}
