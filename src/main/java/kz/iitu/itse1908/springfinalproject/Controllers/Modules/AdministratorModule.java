package kz.iitu.itse1908.springfinalproject.Controllers.Modules;


import kz.iitu.itse1908.springfinalproject.Entities.User;
import kz.iitu.itse1908.springfinalproject.Repositories.GroupRepository;
import kz.iitu.itse1908.springfinalproject.Repositories.RoleRepository;
import kz.iitu.itse1908.springfinalproject.Repositories.UserRepository;
import kz.iitu.itse1908.springfinalproject.Services.GroupService;
import kz.iitu.itse1908.springfinalproject.Services.RoleService;
import kz.iitu.itse1908.springfinalproject.Services.UserService;
import kz.iitu.itse1908.springfinalproject.Utils.CsvUtils;
import kz.iitu.itse1908.springfinalproject.Utils.FileExtensionUtil;
import kz.iitu.itse1908.springfinalproject.Utils.GetCurrentDateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@EnableWebMvc
@RequestMapping(value = "/adminModule")
public class AdministratorModule {

    final
    GroupService groupService;

    final
    RoleService roleService;

    final
    UserService userService;

    final
    PasswordEncoder passwordEncoder;

    public AdministratorModule(GroupService groupService, RoleService roleService, UserService userService, PasswordEncoder passwordEncoder) {
        this.groupService = groupService;
        this.roleService = roleService;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/getNewStudentsTemplate")
    public void downloadCsv(HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; file=studentsTemplate.csv");
        CsvUtils.downloadCsv(response.getWriter()) ;
    }

    @Transactional
    @RequestMapping(value = "/uploadNewStudents", method = RequestMethod.POST)
    public String uploadNewStudents(@RequestParam("file") MultipartFile file, ModelMap modelMap) {
        String extension = FileExtensionUtil.getExtensionByStringHandling(file.getOriginalFilename()).get();
        if (!extension.equals("csv")){
            return "ONLY CSV FILES ARE ACCEPTED!";
        }
        String currentDate = GetCurrentDateUtil.getCurrentDateInStringFormat();
        try {
            file.transferTo( new File("temp/" + "students_import_for_"+currentDate+"."+extension));
        } catch (Exception e) {
            return e.getMessage();
        }
        List<String[]> userDetails = CsvUtils.readNewStudents("temp/" + "students_import_for_"+currentDate+"."+extension);
        List<User> newUsers = new ArrayList<User>();
        for (int i = 0;i<userDetails.size();i++){
            String[] currentUserInfo = userDetails.get(i);
            User newUser = new User();
            newUser.setFname(currentUserInfo[0]);
            newUser.setLname(currentUserInfo[1]);
            newUser.setEmail(currentUserInfo[2]);
            newUser.setPassword(passwordEncoder.encode(currentUserInfo[3]));
            newUser.setRoleid(roleService.getRoleById(Integer.valueOf(currentUserInfo[4])));
            newUser.setGroupid(groupService.findGroupById(Integer.valueOf(currentUserInfo[5])));
            newUsers.add(newUser);
        }
        userService.saveAll(newUsers);
        return "Users have been successfully added";
    }

}
