package kz.iitu.itse1908.springfinalproject.Controllers.CustomRequests;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskAssigningRequest {

    private Integer taskId;

    private List<Integer> groupIds;

}
