package home.jackking.controller;

import home.jackking.entity.Student;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {


    @RequestMapping("/list")
    public List<Student> list(){
        List<Student> res=new ArrayList<>();

        res.add(new Student(604847,"John",3));
        res.add(new Student(111111,"One",2));
        return res;
    }
}
