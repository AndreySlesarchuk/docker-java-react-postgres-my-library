package by.atmm.mylibraryapp.service.convertor;


import by.atmm.mylibraryapp.models.Book;
import by.atmm.mylibraryapp.service.dto.BookDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {
    Book dtoToModel(BookDto bookDto);

    BookDto modelToDto(Book book);

    List<BookDto> toListDto(List<Book> books);
}
