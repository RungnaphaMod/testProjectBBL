package org.example.testProjectBBL.Business;

import org.example.testProjectBBL.model.entity.User;
import org.example.testProjectBBL.model.request.UserRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class UserBusiness {
    private final List<User> userList = new ArrayList<>();

    public Optional<User> getIfUserExist(Long id) throws Exception {
        Optional<User> user = userList.stream().filter(u -> u.id.equals(id)).findFirst();
        if (user.isPresent()){
            return user;
        }
        else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
    }


    public void deleteUserById(Long id) throws Exception {
        Optional<User> user = getIfUserExist(id);
        if (user.isPresent()){
            userList.remove(user);
        }
    }



    public List<User> getAllUser()  {
        return userList;
    }




    public User createUser(UserRequest userRequest) {
        int count = userList.size();
        User user = new User();
        user.id = (long) (count+1);
        user.setName(userRequest.getName());
        user.setUsername(userRequest.getUsername());
        user.setEmail(userRequest.getEmail());
        user.setPhone(userRequest.getPhone());
        user.setWebsite(userRequest.getWebsite());
        userList.add(user);
        return user;
    }
}
