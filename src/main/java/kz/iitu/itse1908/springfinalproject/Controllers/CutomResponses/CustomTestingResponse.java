package kz.iitu.itse1908.springfinalproject.Controllers.CutomResponses;

import kz.iitu.itse1908.springfinalproject.Controllers.CustomRequests.TestingRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomTestingResponse {

    private HashMap<Integer, TrimmedTestQuestion> questions;

    private TestingRequest testingRequestExample;

}
