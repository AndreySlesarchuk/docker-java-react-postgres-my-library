package by.atmm.mylibraryapp.repository;

import by.atmm.mylibraryapp.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
