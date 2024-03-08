package com.hrithik.Controllers;

import com.hrithik.DataObjects.UserDO;
import com.hrithik.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("save")
    public UserDO saveUser(@RequestBody UserDO userDO)
    {
        return userService.saveUser(userDO);
    }

    @GetMapping("getUsers")
    public List<UserDO> getAllUser()
    {
        return  userService.getAlluser();
    }

    @PostMapping("delete/{id}")
    public String deleteUser(@PathVariable Long id)
    {
        return  userService.deleteUser(id);
    }

}
