package kz.iitu.itse1908.springfinalproject;

import kz.iitu.itse1908.springfinalproject.Entities.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
public class UserInfoResponse {

    private User mainUserInfo;

    private Group userGroupInfo;

    private Role userRoleInfo;

    private Set<Task> createdTasks;

    private Set<Test> createdTests;

    private Usersgradedetail usersgradedetails;

    private Set<Notification> createdNotifications;

    private Set<Notification> recievedNotifications;
}