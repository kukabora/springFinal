package kz.iitu.itse1908.springfinalproject.Controllers;

import kz.iitu.itse1908.springfinalproject.Entities.User;
import kz.iitu.itse1908.springfinalproject.Security.CustomUserDetails;
import kz.iitu.itse1908.springfinalproject.Security.JwtProvider;
import kz.iitu.itse1908.springfinalproject.Security.Requests.AuthRequest;
import kz.iitu.itse1908.springfinalproject.Security.Requests.RegistrationRequest;
import kz.iitu.itse1908.springfinalproject.Security.Responses.AuthResponse;
import kz.iitu.itse1908.springfinalproject.Security.UserAuthenticationService;
import kz.iitu.itse1908.springfinalproject.Services.GroupService;
import kz.iitu.itse1908.springfinalproject.Services.RoleService;
import lombok.SneakyThrows;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import static kz.iitu.itse1908.springfinalproject.Security.JwtFilter.AUTHORIZATION;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    private final UserAuthenticationService userService;

    private final RoleService roleService;

    private final GroupService groupService;

    private final JwtProvider jwtProvider;

    public AuthenticationController(UserAuthenticationService userService, RoleService roleService, GroupService groupService, JwtProvider jwtProvider) {
        this.userService = userService;
        this.roleService = roleService;
        this.groupService = groupService;
        this.jwtProvider = jwtProvider;
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody @Valid RegistrationRequest registrationRequest) {
        User u = new User();
        u.setPassword(registrationRequest.getPassword());
        u.setEmail(registrationRequest.getLogin());
        u.setRoleid(roleService.getRoleByName("USER"));
        u.setGroupid(groupService.findGroupByName("UNSORTED"));
        u.setFname(registrationRequest.getFname());
        u.setLname(registrationRequest.getLname());
        userService.saveUser(u);
        return "OK";
    }

    @SneakyThrows
    @PostMapping("/login")
    public AuthResponse auth(@RequestBody AuthRequest request) {
        User user = userService.findByLoginAndPassword(request.getLogin(), request.getPassword());
        String token = jwtProvider.generateToken(user.getEmail());
        return new AuthResponse(token);
    }

    @GetMapping("/checkUser")
    @Cacheable(value="customUserCache", key="#userRequest.getHeader(\"Authorization\")")
    public String checkUserInformation(HttpServletRequest userRequest) {
        CustomUserDetails principal = (CustomUserDetails) SecurityContextHolder.
                getContext().
                getAuthentication().
                getPrincipal();
        User user = userService.findByLogin(principal.getUsername());
        return "You are successfully logged in! Your id is " + user.getId();
    }
}