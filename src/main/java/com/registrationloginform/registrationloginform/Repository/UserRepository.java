package com.registrationloginform.registrationloginform.Repository;


import com.registrationloginform.registrationloginform.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long>{

        public String emailDetails = "SELECT u FROM User u Where u.email = ?1";
        @Query(emailDetails)
        User findByEmail(String email);
        }
