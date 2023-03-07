package com.example.first_practical_ex.ws;

import com.example.first_practical_ex.dao.StudentRepository;
import com.example.first_practical_ex.entity.Filiere;
import com.example.first_practical_ex.entity.Student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/studenttest")
public class StudentController {



    @Autowired
    private FiliereController filiereController;
    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("/save")
    public int save(@RequestBody Student student){
        if(findById(student.getId())!=null){
            return -1;
        }
       Filiere filiere= filiereController.findById(student.getFiliere().getId());
        student.setFiliere(filiere);
        if(filiere==null){
            return -2;
        } else
            studentRepository.save(student);
        return 1;
    }


    /*
    @PostMapping("/save")
    public void save(@RequestBody Student student) {
        studentRepository.save(student);
    }
*/

    @GetMapping("/count")
    public long countStudent() {
        return studentRepository.count();
    }

  /*  @DeleteMapping("/id/{id}")
    public void delete(@PathVariable(required = true) String id){
        Student s = studentRepository.findById(Integer.parseInt(id));
        studentRepository.delete(s);
    }*/
    @DeleteMapping("id/{id}")
    public void deleteById(@PathVariable int id) {
        studentRepository.deleteById(id);
    }

    @GetMapping("/")
    public List<Student> findAll() {
        return studentRepository.findAll();
    }
    @GetMapping("/findbyid/id/{id}")
    public Student findById(@PathVariable int id) {
        return studentRepository.findById(id);
    }

    @GetMapping(value = "/byYear")
    public Collection<?> findByYear() {
        return studentRepository.findNbrStudentByYear();
    }

    @GetMapping("/findstudentsbyfiliere/id/{id}")
    public List<Student> findByFiliereId(@PathVariable int id) {
        return studentRepository.findByFiliereId(id);
    }
    @Transactional
    @DeleteMapping("/deletestudentsbyfiliere/id/{id}")
    public int deleteByFiliereId(@PathVariable int id) {
           return studentRepository.deleteByFiliereId(id);
    }

}
