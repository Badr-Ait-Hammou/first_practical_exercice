package com.example.first_practical_ex.ws;

import com.example.first_practical_ex.dao.FiliereRepository;
import com.example.first_practical_ex.entity.Filiere;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/filiere")
public class FiliereController {


    @Autowired
    private FiliereRepository filiereRepository;
    @Autowired
    StudentController studentController;

    @Transactional
    @DeleteMapping("/id/{id}")
    public int deleteById(@PathVariable int id) {
        if(studentController.findByFiliereId(id)!=null && filiereRepository.findById(id)!=null) {
            studentController.deleteByFiliereId(id);
            filiereRepository.deleteById(id);
            return 1;
        }else
            return -1;
    }
    @GetMapping("/")
    public List<Filiere> findAll() {
        return filiereRepository.findAll();
    }
    @PostMapping("/save")
    public int  save(@RequestBody Filiere filiere) {
        if(findById(filiere.getId())!=null){
            return -1;
        }else
            filiereRepository.save(filiere);
        return 1;
    }

    @GetMapping("/id/{id}")
    public Filiere findById(@PathVariable int id) {
        return filiereRepository.findById(id);
    }
  /*  @GetMapping("/studentByF")
    @Query("select * from filiere")
    public Collection<?> findStudentsByFiliere() {
        return filiereRepository.findStudentsByFiliere();
    }
*/


}
