package com.example.first_practical_ex.ws;

import com.example.first_practical_ex.dao.FiliereRepository;
import com.example.first_practical_ex.entity.Filiere;
import com.example.first_practical_ex.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/filiere")
public class FiliereController {


    @Autowired
    private FiliereRepository filiereRepository;

    @DeleteMapping("/id/{id}")
    public void deleteById(@PathVariable int id) {
        filiereRepository.deleteById(id);
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
