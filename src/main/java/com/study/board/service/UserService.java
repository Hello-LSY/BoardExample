package com.study.board.service;

import com.study.board.entity.User;
import com.study.board.repository.UserRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    //회원가입
    public void insertUser(@NotNull User user){

        user.setUsername(user.getUsername());
        user.setPassword(user.getPassword());
        user.setNickname(user.getNickname());

        userRepository.save(user);
    }


    public User findUserByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }
}
