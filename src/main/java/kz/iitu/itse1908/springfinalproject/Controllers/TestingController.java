package kz.iitu.itse1908.springfinalproject.Controllers;


import kz.iitu.itse1908.springfinalproject.Entities.Notification;
import kz.iitu.itse1908.springfinalproject.Entities.User;
import kz.iitu.itse1908.springfinalproject.Security.JwtProvider;
import kz.iitu.itse1908.springfinalproject.Security.Requests.AuthRequest;
import kz.iitu.itse1908.springfinalproject.Security.Responses.AuthResponse;
import kz.iitu.itse1908.springfinalproject.Security.UserAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/testingController")
public class TestingController {

    @Autowired
    UserAuthenticationService userService;

    @Autowired
    JwtProvider jwtProvider;

    @RequestMapping(value = "/testHttpRequest", method = RequestMethod.OPTIONS)
    public ResponseEntity options(HttpServletResponse response) {
        response.setHeader("Allow", "POST,GET,PUT,DELETE");
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/getHttpHeader", method = RequestMethod.HEAD)
    public ResponseEntity getHeader(HttpServletRequest request, HttpServletResponse response, @RequestBody AuthRequest authRequest){
        User user = userService.findByLoginAndPassword(authRequest.getLogin(), authRequest.getPassword());
        String token = jwtProvider.generateToken(user.getEmail());
        response.setHeader("Authorization", "Bearer " + token);
        return new ResponseEntity(HttpStatus.OK);
    }

}
