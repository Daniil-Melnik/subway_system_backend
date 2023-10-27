package com.subway.system.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.subway.system.repository.UserRepository;
import com.subway.system.model.User;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userSevice;

    @MockBean
    private UserRepository userRepo;

    @Test
    public void activateUser() {
        List<User> userList = new ArrayList<>();

        User user = new User();

        user.setEmail("test@test.ru");
        user.setPsw("psw");
        user.setId(111);

        Mockito.doReturn(userList)
                .when(userRepo)
                .findAll();

        boolean isUserActivated = userSevice.activateUser("activate");

        User isUserAdded = userSevice.saveUser(user);

        System.out.println(isUserAdded);

        Assert.assertTrue(isUserActivated);
        Assert.assertNull(isUserAdded);
        Assert.assertNotNull(user.getEmail());

        Mockito.verify(userRepo, Mockito.times(1)).save(user);    
    }
}