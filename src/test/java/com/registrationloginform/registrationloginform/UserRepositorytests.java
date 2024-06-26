package com.registrationloginform.registrationloginform;

import com.registrationloginform.registrationloginform.Model.User;
import com.registrationloginform.registrationloginform.Repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepositorytests {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testCreateUser()
    {
        User user = new User();

        user.setEmail("Jakkulasai@gmail.com");
        user.setPassword("MyMomnd");
        user.setFirstName("SaiNa");
        user.setLastName("Jakku");

        User savedUser = userRepository.save(user);

       User existUser =  entityManager.find(User.class, savedUser.getId());

       assertThat(existUser.getEmail()).isEqualTo(user.getEmail());
    }

    @Test
    public void testFindUserByEmail(){
        String email = "Jakkulasai@gmail.com";

        User user = userRepository.findByEmail(email);

        assertThat(user).isNotNull();
    }
}
