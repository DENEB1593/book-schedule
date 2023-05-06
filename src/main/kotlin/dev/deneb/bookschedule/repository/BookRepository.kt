package dev.deneb.bookschedule.repository

import dev.deneb.bookschedule.model.Book
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BookRepository: JpaRepository<Book, Long>{
}
