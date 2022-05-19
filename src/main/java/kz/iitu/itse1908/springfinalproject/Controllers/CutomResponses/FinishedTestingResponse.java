package kz.iitu.itse1908.springfinalproject.Controllers.CutomResponses;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;

@Data
@AllArgsConstructor
public class FinishedTestingResponse {

    private HashMap<String, String> data;

}
