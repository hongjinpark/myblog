package com.example.myblog.service;


import com.example.myblog.domain.user.User;
import com.example.myblog.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public Long save(User user) {
        return userRepository.save(user).getId();
    }
}
