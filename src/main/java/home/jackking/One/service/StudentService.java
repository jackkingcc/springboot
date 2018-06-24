package home.jackking.One.service;

import home.jackking.One.repository.Student;
import home.jackking.One.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;


    public Iterable<Student> all() {
        return studentRepository.findAll();
    }

    public void save(Student student) {
         studentRepository.save(student);
    }

    public Student getTop(){
        Iterable<Student> students = all();
        Iterator<Student> iterator=students.iterator();
        if(iterator.hasNext())
            return iterator.next();
        return null;
    }

}
