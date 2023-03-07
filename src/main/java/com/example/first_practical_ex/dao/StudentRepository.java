package com.example.first_practical_ex.dao;

import com.example.first_practical_ex.entity.Filiere;
import com.example.first_practical_ex.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
    Student findById(int id);
    //Filiere findStudentFiliere(int id);
    @Query("select year(s.dateNaissance) as annee, count(*) as nbr from Student s group by year(s.dateNaissance) order by year(s.dateNaissance)")
    Collection<?> findNbrStudentByYear();
    List<Student> findByFiliereId(int id);
    int deleteByFiliereId(int id);

}
