package com.demo.springrestsql;

import com.demo.springrestsql.model.User;
import com.demo.springrestsql.repository.UserRepository;
import com.demo.springrestsql.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.UUID;

@SpringBootTest
@AutoConfigureDataJpa
class UserServiceTests {

    @InjectMocks
    private UserService userService;
    @Mock
    private UserRepository userRepository;

    @Test
    public void AddUser() throws Exception {

        Mockito.when(userRepository.save(Mockito.any(User.class))).thenReturn(new User(UUID.randomUUID(), "Spock", "Spock"));

        userService.saveUser(new User(UUID.randomUUID(), "James", "Kirk"));

        Mockito.verify(userRepository, Mockito.times(1)).save(Mockito.any(User.class));

        User test = userRepository.save(new User(UUID.randomUUID(), "James", "Kirk"));

//		TODO: No users in Mock, unsure why.
        List users = userService.listAllUser();

//        Assertions.assertEquals(test, users.indexOf(0));
    }
}
