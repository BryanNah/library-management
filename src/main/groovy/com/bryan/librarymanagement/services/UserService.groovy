package com.bryan.librarymanagement.services

import com.bryan.librarymanagement.model.User
import com.bryan.librarymanagement.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService {

    @Autowired
    UserRepository userRepository

    List<User> findAll() {
        return userRepository.findAll()
    }

    User save(User user) {
        return userRepository.save(user)
    }
}
