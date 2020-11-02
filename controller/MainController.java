package com.example.demomvc.controller;

import com.example.demomvc.entity.TapEntity;
import com.example.demomvc.entity.UserEntity;
import com.example.demomvc.service.OrganizeService;
import com.example.demomvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.Console;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

@Controller
public class MainController {
    @Autowired
    private  UserService  userService;
    @Autowired
    private OrganizeService organizeService;


    private static String UPLOADED_FOLDER = "D://temp//";
    private TapEntity person = new TapEntity();


    @GetMapping("/")
    public String Main(){
        return "index";
    }

    @RequestMapping(value = "/test")
    public String Main(
            @RequestParam("fname") String fname,
            @RequestParam("lname") String lname,
            ModelMap model){
        person.setFirstName(fname);
        person.setLastName(lname);
        String hello = "Hello";
        model.addAttribute("hello",hello);
        model.addAttribute("person",person);
        return "index2";
    }
    @RequestMapping("/upload") // //new annotation since 4.3
    public String singleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {

        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:uploadStatus";
        }

        try {

            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);

            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + file.getOriginalFilename() + "'");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/uploadStatus";
    }

    @GetMapping("/uploadStatus")
    public String uploadStatus() {
        return "uploadStatus";
    }

    @RequestMapping(value ="/registerUser")
    public String registerUser(ModelMap model) {
        model.addAttribute("org",this.organizeService.findAll());
        return "AddUser";
    }


    @RequestMapping(value = "/tableAllUser")
    public String tableAllUser(ModelMap model) {
        List<UserEntity> dataUser = userService.getAllUser();
        model.addAttribute("dataUser",dataUser);
        return "tableAllUser";
    }


    @RequestMapping(value = "/addUser",method= RequestMethod.POST)
    public String addUser(HttpServletRequest request ) {
        UserEntity user = new UserEntity();
        long millis=System.currentTimeMillis();
        java.sql.Date date=new java.sql.Date(millis);
        Timestamp ts=new Timestamp(date.getTime());
        user.setCreateDate(ts);
        user.setEmail(request.getParameter("email"));
        user.setName(request.getParameter("name"));
        user.setLastName(request.getParameter("lastName"));
        user.setTel(request.getParameter("tel"));
        user.setOrgId(Integer.parseInt(request.getParameter("orgId")));
        userService.addUserNew(user);
        return "redirect:/tableAllUser";
    }

    @RequestMapping(value = "/delete/{id}")
    public String delete(@PathVariable int id) {
        userService.deleteUser(id);
        return "redirect:/tableAllUser";
    }


    @RequestMapping(value = "/edit/{id}")
    public String editUser(ModelMap model,@PathVariable int id) {
        UserEntity user = userService.getOne(id);
        model.addAttribute("user",user);
        model.addAttribute("org",organizeService.findAll());
        return "Edit";
    }

    @RequestMapping(value = "/edit/update",method= RequestMethod.POST)
    public String update(HttpServletRequest request,@RequestParam(value ="userId") int userId) {
        UserEntity user = new UserEntity();
        user.setEmail(request.getParameter("email"));
        user.setName(request.getParameter("name"));
        user.setLastName(request.getParameter("lastName"));
        user.setTel(request.getParameter("tel"));
        user.setUserId(Integer.parseInt(request.getParameter("userId")));
        user.setOrgId(Integer.parseInt(request.getParameter("orgId")));
        userService.updateUser(user);
        return "redirect:/tableAllUser";
    }

    @RequestMapping(value = "/getAllUser")
    public String dataTable() {

        return "DataTableUser/allUser";
    }


}
