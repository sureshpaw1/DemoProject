package com.example.demo.service.Impl;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserServiceI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserServiceI {
    Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UserRepository userRepository;

    // IOC -  Inversion of control which manages Spring bean lifecyle

    // DI- Dependency Injection-Setter ,field & Constructor Dependency Injection


    @Override
    public User createUser(User user) {
        log.info("Initating the Dao call for the save user Data");
        User saveduser = userRepository.save(user);
        log.info("Completed the Dao call for the save user Data");
        return saveduser;
    }

    //4 th Suresh,  Aurangabad
    // Ramesh  pune
    @Override
    public User updateUser(User user, Long userId) {

        User user1 = userRepository.findById(userId).get();
        user1.setUserName(user.getUserName());
        user1.setUserAge(user.getUserAge());
        user1.setAbout(user1.getAbout());

        User updateUser = userRepository.save(user1);

        return updateUser;
    }

    // 1st Suresh 42 i am software Dev.
    @Override
    public User getSingleUser(Long userId) throws Exception {
        log.info("Initiating the Dao call for get Single user Data has userId{}",userId);
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("Resource not found on server"));
        log.info("completed the Dao call for get Single user Data has userId{}",userId);
        return user;


    }
     /*   Optional<User> User = userRepository.findById(userId);

        Optional<User> user= userRepository.findById(userId);
        if(user.isPresent()) {
            return user.get();
        }else{
            throw new Exception("Resource not found on server"+ userId);
        }

        return null;
    }*/


    @Override
    public List<User> getAllUsers() {

        List<User> allusers = userRepository.findAll();


        return allusers;
    }

@GetMapping("/usres")
    @Override
    public void deleteUser(Long userId) {

        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("Resource not found on server" + userId));

        userRepository.delete(user);
    }
}