package com.example.rest_user_store.User;


import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public UserEntity findUserById(Integer id){

        return userRepository.findById(id).get();
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

    public List<UserEntity> getUsers(String[] tags){
        List<UserEntity> usersByTags = userRepository.findByTags(tags);

        Iterator<UserEntity> it = usersByTags.iterator();
        while(it.hasNext()) {
            UserEntity u = it.next();
            String[] t = u.getTags();
            Integer e = u.getExpiry();
            if (!t.equals(tags) && (LocalDateTime.now().toInstant(ZoneOffset.UTC).toEpochMilli()-e.intValue())){ // to check for expiry
                usersByTags.remove(u);
            }
            System.out.println(it.next());
        }

        return usersByTags;
    }


    public void updateUser(Integer id, String[][] updates){
        Optional<UserEntity> u = userRepository.findById(id);

        u.get().setTags(updates[0]);
        u.get().setExpiry(Integer.parseInt(String.valueOf(updates[1])));
    }
}
