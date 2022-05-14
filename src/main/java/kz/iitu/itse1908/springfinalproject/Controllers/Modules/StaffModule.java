package kz.iitu.itse1908.springfinalproject.Controllers.Modules;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@RestController
@EnableWebMvc
@RequestMapping(value = "/staffModule")
public class StaffModule {

//    @Autowired
//    private AssesmentRepository repository;

//    @RequestMapping(value = "/all", method = RequestMethod.GET,
//            produces = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseBody
//    @Transactional
//    List<Assesment> home() {
//        return (List<Assesment>) repository.findAll();
//    }

}
