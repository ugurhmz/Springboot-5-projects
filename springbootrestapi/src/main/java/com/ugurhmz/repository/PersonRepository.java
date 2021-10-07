package com.ugurhmz.repository;


import com.ugurhmz.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface PersonRepository extends JpaRepository<Person,Long> {


}
