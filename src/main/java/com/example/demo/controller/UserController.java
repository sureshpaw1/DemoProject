
package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserServiceI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    Logger log = LoggerFactory.getLogger(User.class);
    //Logger -Log4j
//Sl4j
    // Data send from UI to Controller body send by using
// @Pathvariabl- pass sindle Data
// @Requestbody  -whole object &secure
//  @ Requestparam- when data pass  key value,start with ? ,and end with &
    //Http method
    //Status code

    @Autowired
    private UserServiceI userServiceI;

    //@RequestMapping(method = RequestMethod.POST,name="/users")

    @PostMapping("/users")
    public ResponseEntity<User> createuser(@RequestBody User user) {
        log.info("Entering the request for save user data");
        User saveuser = userServiceI.createUser(user);
        log.info("Completed the Dao call for the save user Data");
        return new ResponseEntity<>(saveuser, HttpStatus.CREATED);    //201
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllusers() {

        List<User> allUsers = userServiceI.getAllUsers();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }


    @GetMapping("/users{userId}")
    public ResponseEntity<User> getSingleUser(@PathVariable Long userId) throws Exception {
        log.info("Enterring the request for get  user data with user id{}",userId);
        User user = userServiceI.getSingleUser(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);

    }

    @PutMapping("/users{userid}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable Long userId) {
        User updatedUser = userServiceI.updateUser(user, userId);
        return new ResponseEntity<>(updatedUser, HttpStatus.CREATED);

    }

    @DeleteMapping("/users{userid}")
    public ResponseEntity deleteUser(@PathVariable Long userId) {
        userServiceI.deleteUser(userId);
        return new ResponseEntity<>("Resource delete successfully!!", HttpStatus.OK);

    }
}
