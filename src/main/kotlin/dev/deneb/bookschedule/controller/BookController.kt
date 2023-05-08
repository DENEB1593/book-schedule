package dev.deneb.bookschedule.controller

import dev.deneb.bookschedule.model.Book
import dev.deneb.bookschedule.model.BookDto
import dev.deneb.bookschedule.repository.BookRepository
import dev.deneb.bookschedule.service.BookService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime

@RestController
@RequestMapping("api/books")
class BookController(
    private val bookService: BookService) {

    val log: Logger = LoggerFactory.getLogger(BookController::class.java)

    @PostMapping
    fun save(@RequestBody bookDto: BookDto): ResponseEntity<Book> {
        log.info("book save request: {}", bookDto)

        val book = Book(title = bookDto.title, createdAt = LocalDateTime.now())

        bookService.save(book)

        return ResponseEntity.ok(book)
    }

    @GetMapping("/{isdn}")
    fun findByIsdn(@PathVariable isdn: Long): ResponseEntity<Book> {
        log.info("request isdn: {}", isdn)

        return ResponseEntity.ok(
                bookService.findById(isdn))
    }

    @GetMapping
    fun findAll(): ResponseEntity<List<Book>> {

        return ResponseEntity.ok(
                bookService.findAll().orEmpty()
        );
    }


}