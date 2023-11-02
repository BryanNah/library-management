package com.bryan.librarymanagement.services

import com.bryan.librarymanagement.model.Book
import com.bryan.librarymanagement.model.User
import com.bryan.librarymanagement.repository.BookRepository
import com.bryan.librarymanagement.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class BookService {

    @Autowired
    BookRepository bookRepository

    @Autowired
    UserRepository userRepository

    List<Book> findAll() {
        return bookRepository.findAll()
    }

    Book findById(Long id) {
        return bookRepository.findById(id).orElse(null)
    }

    Book save(Book book) {
        return bookRepository.save(book)
    }

    void deleteById(Long id) {
        bookRepository.deleteById(id)
    }

    Book borrowBook(Long bookId, Long userId) {
        Book book = findById(bookId);
        User user = userRepository.findById(userId).orElse(null)

        if (book != null && !book.isBorrowed() && user != null) {
            book.setBorrowedBy(user)
            book.setBorrowed(true)
            return save(book)
        }
        // Handle errors (e.g., book not found, book already borrowed, user not found)
        return null
    }


    Book returnBook(Long bookId) {
        Book book = findById(bookId)
        if (book != null && book.isBorrowed()) {
            book.setBorrowedBy(null)
            book.setBorrowed(false)
            return save(book)
        }
        // Handle errors (e.g., book not found, book not borrowed)
        return null
    }
}
