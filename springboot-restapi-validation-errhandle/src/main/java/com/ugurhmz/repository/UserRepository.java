package com.ugurhmz.repository;

import com.ugurhmz.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    boolean existsUserByUserName(String userName);


}
