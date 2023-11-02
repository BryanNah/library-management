package com.bryan.librarymanagement.controller

import com.bryan.librarymanagement.model.Book
import com.bryan.librarymanagement.services.BookService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/books")
class BookController {

    @Autowired
    BookService bookService

    @GetMapping
    List<Book> getAllBooks() {
        return bookService.findAll()
    }

    @GetMapping("/{id}")
    Book getBook(@PathVariable Long id) {
        return bookService.findById(id)
    }

    @PostMapping
    Book addBook(@RequestBody Book book) {
        return bookService.save(book)
    }

    @PutMapping("/{id}")
    Book updateBook(@PathVariable Long id, @RequestBody Book book) {
        // Additional logic to ensure you're updating the correct book
        return bookService.save(book)
    }

    @DeleteMapping("/{id}")
    void deleteBook(@PathVariable Long id) {
        bookService.deleteById(id)
    }

    @PostMapping("/{bookId}/borrow/{userId}")
    ResponseEntity<Book> borrowBook(@PathVariable Long bookId, @PathVariable Long userId) {
        Book borrowedBook = bookService.borrowBook(bookId, userId)
        if (borrowedBook != null) {
            return ResponseEntity.ok(borrowedBook)
        } else {
            return ResponseEntity.badRequest().build() // or a more descriptive error response
        }
    }

    @PostMapping("/{bookId}/return")
    ResponseEntity<Book> returnBook(@PathVariable Long bookId) {
        Book returnedBook = bookService.returnBook(bookId)
        if (returnedBook != null) {
            return ResponseEntity.ok(returnedBook)
        } else {
            return ResponseEntity.badRequest().build() // or a more descriptive error response
        }
    }
}
