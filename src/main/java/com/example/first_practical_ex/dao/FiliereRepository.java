package com.example.first_practical_ex.dao;


import com.example.first_practical_ex.entity.Filiere;
import com.example.first_practical_ex.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface FiliereRepository extends JpaRepository<Filiere,Integer> {
    Filiere findById(int id);


}
