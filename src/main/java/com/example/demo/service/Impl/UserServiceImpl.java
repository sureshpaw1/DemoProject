package com.example.demo.service.Impl;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserServiceI {

    @Autowired
    private UserRepository userRepository;

    // IOC -  Inversion of control which manages Spring bean lifecyle

    // DI- Dependency Injection-Setter ,field & Constructor Dependency Injection


    @Override
    public User createUser(User user) {
        User saveduser = userRepository.save(user);
        return saveduser;
    }

    @Override
    public User updateUser(User user, Long userId) {

        User user1 = userRepository.findById(userId).get();
        user1.setUserName(user.getUserName());
        user1.setUserAge(user.getUserAge());
        user1.setAbout(user1.getAbout());

        User updateUser = userRepository.save(user1);

        return updateUser;
    }

    // 1st Suresh
    @Override
    public User getSingleUser(Long userId) throws Exception {

        userRepository.findById(userId).orElseThrow(() -> new RuntimeException("Resource not found on server"));
        return null;


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


    @Override
    public void deleteUser(Long userId) {

        User user = userRepository.findById(userId).orElseThrow(()-> new RuntimeException("Resource not found on server" + userId));

        userRepository.delete(user);
    }
}