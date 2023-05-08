package dev.deneb.bookschedule.repository

import dev.deneb.bookschedule.model.Book
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import java.time.LocalDateTime

@DataJpaTest
class BookRepositoryTest {

    @Autowired
    lateinit var bookRepository: BookRepository

    @Test
    fun saveTest() {
        val book = Book(title = "title", createdAt = LocalDateTime.now())
        bookRepository.save(book)

        assertThat(book).isNotNull()
        assertThat(book.isbn).isNotNull()
        assertThat(book.title).isEqualTo("title")
    }

    @Test
    fun findByIsdnTest() {
        val book = Book(title = "test for find by isdn", createdAt = LocalDateTime.now())
        bookRepository.save(book)

        val result = bookRepository.findById(book.isbn).orElse(null)

        assertThat(result).isNotNull()
        assertThat(result.title).isEqualTo("test for find by isdn")
    }

    @Test
    fun findAllTest() {
        val books = bookRepository.findAll().orEmpty()

        assertThat(books).hasSize(0)
    }


}