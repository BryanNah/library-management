package com.bryan.librarymanagement.repository

import com.bryan.librarymanagement.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository extends JpaRepository<User, Long> {

}