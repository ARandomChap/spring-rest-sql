package com.demo.springrestsql;

import com.demo.springrestsql.controller.UserController;
import com.demo.springrestsql.model.User;
import com.demo.springrestsql.repository.UserRepository;
import com.demo.springrestsql.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class SpringRestSqlApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private UserController userController;

    @Mock
    private UserService userService;

    @Mock
    private UserRepository userRepository;


    @Test
    public void ReturnUsers() throws Exception {

        List<User> users = new ArrayList<>();
        users.add(new User(UUID.randomUUID(), "James", "Kirk"));
        users.add(new User(UUID.randomUUID(), "Spock", "Spock"));

        Mockito.when(userController.list()).thenReturn(users);

        List resp = userController.list();
        Mockito.verify(userController, Mockito.times(1)).list();

        Assertions.assertEquals(users, resp);

//		this.mockMvc.perform(get("/users")
//						.param("firstName", "Jack")
//						.param("lastName", "Chapman"))
//				.andDo(print()).andExpect(status().isOk())
//				.andExpect(jsonPath("[*].firstName").value("Jack"))
//				.andExpect(jsonPath("[*].lastName").value("Chapman"));
    }

    @Test
    public void ReturnUser() throws Exception {

        User user = new User(UUID.randomUUID(), "James", "Kirk");

        Mockito.when(userController.get(Mockito.any(UUID.class))).thenReturn(new ResponseEntity<>(user, HttpStatus.OK));

        ResponseEntity<User> resp = userController.get(user.getId());
        Mockito.verify(userController, Mockito.times(1)).get(user.getId());

        this.userRepository.save(user);

        Assertions.assertEquals(user, resp.getBody());

//        this.mockMvc.perform(get("/users/" + user.getId()))
//                .andDo(print()).andExpect(status().isOk());
    }

}
