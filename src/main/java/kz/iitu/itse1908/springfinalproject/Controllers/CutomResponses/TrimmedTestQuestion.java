package kz.iitu.itse1908.springfinalproject.Controllers.CutomResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrimmedTestQuestion {

    private String questionText;

    private String answer1;

    private String answer2;

    private String answer3;
}
