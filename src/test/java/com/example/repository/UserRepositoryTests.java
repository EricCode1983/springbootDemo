package com.example.repository;

import java.text.DateFormat;
import java.util.Date;
import com.example.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void test() throws Exception {
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
        String formattedDate = dateFormat.format(date);

        userRepository.save(new User("aa1", "aa", "aa@126.com", "aa123456",formattedDate,"emailAddress"));
        userRepository.save(new User("bb2", "bb", "bb@126.com", "bb123456",formattedDate,"emailAddress"));
        userRepository.save(new User("cc3", "cc", "cc@126.com", "cc123456",formattedDate,"emailAddress"));

        Assert.assertEquals(3, userRepository.findAll().size());
        Assert.assertEquals("bb123456", userRepository.findByUserNameOrEmail("bb2", "bb@126.com").getNickName());
        userRepository.delete(userRepository.findByUserName("aa1"));
        userRepository.delete(userRepository.findByUserName("bb2"));
        userRepository.delete(userRepository.findByUserName("cc3"));
    }

}
