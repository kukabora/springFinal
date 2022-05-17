

package kz.iitu.itse1908.springfinalproject.Security.Requests;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class RegistrationRequest {

    @NotEmpty
    private String login;

    @NotEmpty
    private String password;

    @NotEmpty
    private String fname;

    @NotEmpty
    private String lname;
}