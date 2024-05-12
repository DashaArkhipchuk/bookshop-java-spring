package com.coursework.bookshop.user.service;

import com.coursework.bookshop.user.entity.Role;
import com.coursework.bookshop.user.entity.User;
import com.coursework.bookshop.user.persistence.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User getUser(String email) {
        return userRepository.findByEmail(email)
                .orElse(
                        User.builder()
                                .role(Role.UNKNOWN)
                                .build()
                );
    }


}