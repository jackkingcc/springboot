package home.jackking.One.controller;

import home.jackking.One.repository.Student;
import home.jackking.One.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/listStudent")
    public List<Student> list(){
        List<Student> res=new ArrayList<>();

        res.add(new Student("John",2));
        res.add(new Student("One",2));
        return res;
    }

    @RequestMapping("/allStudent")
    public Iterable<Student> all(){
        return  studentService.all();
    }

    @GetMapping("/addStudent")
    public String saveStudent(@RequestParam String  name,@RequestParam int sex){
        Student student = new Student(name,sex);
        studentService.save(student);
        return "saved";

    }
}
