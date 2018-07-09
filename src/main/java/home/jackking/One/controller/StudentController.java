package home.jackking.One.controller;

import home.jackking.One.repository.Student;
import home.jackking.One.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentController implements WebMvcConfigurer {

    @Autowired
    private StudentService studentService;

    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/student-results").setViewName("student-results");
    }

    @RequestMapping("/listStudent")
    @ResponseBody
    public List<Student> list(){
        List<Student> res=new ArrayList<>();

        res.add(new Student("John",2));
        res.add(new Student("One",2));
        return res;
    }

    @RequestMapping("/allStudent")
    @ResponseBody
    public Iterable<Student> all(){
        return  studentService.all();
    }

    @GetMapping("/addStudent")
    @ResponseBody
    public String saveStudent(@RequestParam String  name,@RequestParam int sex){
        Student student = new Student(name,sex);
        studentService.save(student);
        return "saved";
    }

    @GetMapping("/login-student")
    public String loginStudentForm(Student student){
        return "student";
    }
    @PostMapping("/login-student")
    public String checkStudentInfo(@Valid Student student,BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "student";
        }
        return "redirect:/student-results";
    }
}
