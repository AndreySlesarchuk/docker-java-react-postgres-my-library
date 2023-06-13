package by.atmm.mylibraryapp.service.impl;

import by.atmm.mylibraryapp.models.Book;
import by.atmm.mylibraryapp.repository.BookRepository;
import by.atmm.mylibraryapp.service.BookService;
import by.atmm.mylibraryapp.service.convertor.BookMapper;
import by.atmm.mylibraryapp.service.dto.BookDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Override
    public List<BookDto> findAll() {
        return bookMapper.toListDto(bookRepository.findAll());
    }

    @Override
    public BookDto findById(Long id) {
        return Optional.of(getById(id)).map(bookMapper::modelToDto).get();
    }

    @Override
    @Transactional
    public BookDto save(BookDto book) {
        return bookMapper.modelToDto(bookRepository.save(
                bookMapper.dtoToModel(book)));
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        var book = getById(id);
        bookRepository.delete(book);
    }

    private Book getById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "Book with id: " + id + " not found"));
    }
}
