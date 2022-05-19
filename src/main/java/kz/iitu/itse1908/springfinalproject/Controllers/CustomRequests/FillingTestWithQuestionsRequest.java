package kz.iitu.itse1908.springfinalproject.Controllers.CustomRequests;


import kz.iitu.itse1908.springfinalproject.Entities.Testquestion;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FillingTestWithQuestionsRequest {

    private Integer testId;

    private List<Testquestion> questions;

}
