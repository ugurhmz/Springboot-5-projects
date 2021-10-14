package com.ugurhmz.repository;


import com.ugurhmz.enums.Role;
import com.ugurhmz.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;




@Repository
public interface UserRepository extends JpaRepository<User,Long> {


    // findBy + (F)ieldname
    Optional<User> findByUsername(String username);

    @Modifying
    @Query("Update User set role = :role where username = :username")
    void updateUserRole(@Param("username") String username,@Param("role") Role role);





}
