package com.example.rest_user_store.User;


import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public String findUserById(Integer id){
        return userRepository.findById(id).toString();
    }

    public void createUser(UserRequest userRequest){

//        boolean userExists = userRepository.existsById()
        UserEntity user = new UserEntity(

                userRequest.getFirstname(),
                userRequest.getLastname(),
                userRequest.getPassword(),
                userRequest.getPhone()
        );
        userRepository.save(user);
    }
}
