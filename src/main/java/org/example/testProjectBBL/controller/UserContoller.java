package org.example.testProjectBBL.controller;
import org.example.testProjectBBL.Business.UserBusiness;
import org.example.testProjectBBL.model.entity.User;
import org.example.testProjectBBL.model.request.UserRequest;
import org.example.testProjectBBL.model.response.ApiResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserContoller {


    private final UserBusiness userBusiness;

    public UserContoller(UserBusiness userBusiness) {
        this.userBusiness = userBusiness;
    }



    @DeleteMapping("/{id}")
    public ApiResponse deleteUser(@PathVariable("id") Long id) throws Exception {

        this.userBusiness.deleteUserById(id);
        return new ApiResponse("200", "Delete User Success");
    }

    @PostMapping()
    public User createUser(@RequestBody UserRequest userRequest){
        return userBusiness.createUser(userRequest);
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable("id") Long id) throws Exception {
        return userBusiness.getIfUserExist(id);

    }


    @GetMapping("")
    public List<User> getAllUser()  {
        return userBusiness.getAllUser();

    }






}
