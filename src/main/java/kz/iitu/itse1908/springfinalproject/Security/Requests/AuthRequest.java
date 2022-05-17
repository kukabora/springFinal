package kz.iitu.itse1908.springfinalproject.Security.Requests;


import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class AuthRequest {

    @NotEmpty
    private String login;

    @NotEmpty
    private String password;
}
