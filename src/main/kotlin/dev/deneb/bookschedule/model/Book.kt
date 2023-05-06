package dev.deneb.bookschedule.model

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
class Book (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val isbn: Long = 0L,

    @Column
    val title: String,

    @Column
    val createdAt: LocalDateTime,

) {
    override fun toString(): String {
        return "Book(isbn=$isbn, title='$title', createdAt=$createdAt)"
    }
}