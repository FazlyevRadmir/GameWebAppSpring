package com.fazlyev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.fazlyev.model.User;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsernameAndPassword(String username, String password);

    @Modifying
    @Query(value = "insert into users (email, first_name, password, phone_number, second_name, username) " +
            "VALUES (:email, :first_name, :password, :phone_number, :second_name, :username)", nativeQuery = true)
    void saveUser(@Param("email") String email, @Param("first_name") String firstName,
                  @Param("password") String password, @Param("phone_number") String phoneNumber,
                  @Param("second_name") String secondName, @Param("username") String username);

    User findByUsername(String username);
}