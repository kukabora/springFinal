package kz.iitu.itse1908.springfinalproject.Controllers.Modules;


import kz.iitu.itse1908.springfinalproject.Utils.FileExtensionUtil;
import kz.iitu.itse1908.springfinalproject.Utils.GetCurrentDateUtil;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@EnableWebMvc
@RequestMapping(value = "/adminModule")
public class AdministratorModule {


    @Autowired
    private FileStorageService fileStorageService;
    @GetMapping("/downloadFile/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
        Resource resource = fileStorageService.loadFileAsResource(fileName);

        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            logger.info("Could not determine file type.");
        }
        if(contentType == null) {
            contentType = "application/octet-stream";
        }
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }


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
        return "Users have been successfully added";
    }

}
