package home.jackking.One.schedule;

import home.jackking.One.repository.Student;
import home.jackking.One.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class StudentCountSchedule {

    private Logger logger = LoggerFactory.getLogger(StudentCountSchedule.class);

    @Autowired
    private StudentService studentService;

    @Scheduled(fixedRate = 5000)
    public void countStudent(){
        Student student=studentService.getTop();
        if(student!=null) {
            Long count = student.getCount()==null?1:student.getCount()+1;
            student.setCount(count);
            studentService.save(student);
        }else {
            logger.error("Can't find any student");
        }
    }
}
