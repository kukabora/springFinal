package kz.iitu.itse1908.springfinalproject.Controllers.CustomRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestingRequest {

    private HashMap<Integer, String> answers;

}
