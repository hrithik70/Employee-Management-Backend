package com.hrithik.Services;

import com.hrithik.DataObjects.UserDO;
import com.hrithik.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    public UserDO saveUser(UserDO userDO) {
        return userRepository.save(userDO);

    }

    public List<UserDO> getAlluser() {
        List<UserDO> userList = (List<UserDO>) userRepository.findAll();
        return userList;
    }

    public String deleteUser(Long id) {
        List<UserDO> userList = (List<UserDO>) userRepository.findAll();
        for (int i = 0; i < userList.size(); i++) {
            UserDO user = userList.get(i);
            if(user.getId() == id)
            {
                userRepository.deleteById(id);
                return "Delete "+ id + " is Successfully..";
            }

        }
        return id + " is not Present";
    }
}
