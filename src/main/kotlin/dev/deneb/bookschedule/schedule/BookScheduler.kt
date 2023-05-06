package dev.deneb.bookschedule.schedule

import dev.deneb.bookschedule.repository.BookRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class BookScheduler(val bookRepository: BookRepository) {

    val LOG: Logger = LoggerFactory.getLogger(BookScheduler::class.java)

    @Scheduled(fixedRate = 5000)
    fun countBook() {
        val count = bookRepository.count()

        LOG.info("book count : {}", count)

    }
}