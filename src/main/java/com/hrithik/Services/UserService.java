package com.hrithik.Services;

import com.hrithik.DataObjects.UserDO;
import com.hrithik.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Optional<UserDO> user = userRepository.findById(id);
        if(user.isPresent())
        {
            UserDO deleteUser = user.get();
            userRepository.deleteById(id);
            return id + " is deleted Successfully";
        }

        return id + " is not Present";
    }

    public UserDO updateUser(UserDO userDO, Long userId) {
        Optional<UserDO> user = userRepository.findById(userId);
        if(user.isPresent())
        {
            UserDO userUpdate = userDO;
            userUpdate.setId(userId);
            userUpdate.setFullName(userDO.getFullName());
            userUpdate.setGender(userDO.getGender());
            userUpdate.setEmail(userDO.getEmail());
            userUpdate.setMobileNo(userDO.getMobileNo());
            userRepository.save(userUpdate);
            return userUpdate;
        }
        return (UserDO) userDO;
    }

    public UserDO getUserById(Long userId) {
        Optional<UserDO> fetchUser = userRepository.findById(userId);
       if(fetchUser.isPresent())
       {
           return (UserDO) fetchUser.get();
       }
       return null;
    }
}
