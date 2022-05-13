package kz.iitu.itse1908.springfinalproject.Controllers;

import kz.iitu.itse1908.springfinalproject.Entities.User;
import kz.iitu.itse1908.springfinalproject.Repositories.GroupRepository;
import kz.iitu.itse1908.springfinalproject.Repositories.RoleRepository;
import kz.iitu.itse1908.springfinalproject.Security.JwtProvider;
import kz.iitu.itse1908.springfinalproject.Security.Requests.AuthRequest;
import kz.iitu.itse1908.springfinalproject.Security.Requests.RegistrationRequest;
import kz.iitu.itse1908.springfinalproject.Security.Responses.AuthResponse;
import kz.iitu.itse1908.springfinalproject.Security.UserAuthenticationService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    private UserAuthenticationService userService;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private JwtProvider jwtProvider;

    @PostMapping("/register")
    public String registerUser(@RequestBody @Valid RegistrationRequest registrationRequest) {
        User u = new User();
        u.setPassword(registrationRequest.getPassword());
        u.setEmail(registrationRequest.getLogin());
        u.setRoleid(roleRepository.findRoleByName("USER"));
        u.setGroupid(groupRepository.findGroupByName("UNSORTED"));
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
}