package com.example.springtext.service;

import com.example.springtext.model.User;
import com.example.springtext.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional(rollbackFor = Exception.class)
    public void addUser(User user) {
        int affectedRows = userRepository.insert(user);

        if (affectedRows != 1) {
            throw new IllegalStateException("新增用户失败，事务回滚");
        }
    }
}
