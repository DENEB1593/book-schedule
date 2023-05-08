package dev.deneb.bookschedule.service

import dev.deneb.bookschedule.model.Book
import dev.deneb.bookschedule.repository.BookRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class BookService(private val bookRepository: BookRepository) {

    val log: Logger = LoggerFactory.getLogger(BookService::class.java)

    @Transactional
    fun save(book: Book) {
        bookRepository.save(book)
    }

    @Transactional(readOnly = true)
    fun findById(isdn: Long): Book {
        return bookRepository.findById(isdn).orElseThrow { RuntimeException() }
    }

    @Transactional(readOnly = true)
    fun findAll(): List<Book> {
        return bookRepository.findAll()
    }



}