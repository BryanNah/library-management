package com.bryan.librarymanagement.repository

import com.bryan.librarymanagement.model.Book
import org.springframework.data.jpa.repository.JpaRepository

interface BookRepository extends JpaRepository<Book, Long> {

}