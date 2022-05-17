package kz.iitu.itse1908.springfinalproject.Controllers.CutomResponses;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;

@Data
@AllArgsConstructor
public class RoutesMappingResponse {

    private String welcomeMessage;

    private HashMap<String, String> urlMappings;

}
