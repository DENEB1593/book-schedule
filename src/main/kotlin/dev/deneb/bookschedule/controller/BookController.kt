package dev.deneb.bookschedule.controller

import dev.deneb.bookschedule.model.Book
import dev.deneb.bookschedule.model.BookDto
import dev.deneb.bookschedule.repository.BookRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime

@RestController
@RequestMapping("api/books")
class BookController(
    private val bookRepository: BookRepository) {

    val log: Logger = LoggerFactory.getLogger(BookController::class.java)

    @PostMapping
    fun save(@RequestBody bookDto: BookDto): ResponseEntity<Book> {
        log.info("book save request: {}", bookDto)

        val book = Book(title = bookDto.title, createdAt = LocalDateTime.now())

        bookRepository.save(book)

        return ResponseEntity.ok(book)
    }

    @GetMapping("/{isdn}")
    fun findByIsdn(@PathVariable isdn: Long): ResponseEntity<Book> {
        log.info("request isdn: {}", isdn)

        val book = bookRepository.findById(isdn).orElseThrow { RuntimeException() }

        return ResponseEntity.ok(book)
    }


}