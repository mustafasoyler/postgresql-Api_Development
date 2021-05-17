package com.mustafa.service.concretes;

import com.mustafa.dao.AuthorRepository;
import com.mustafa.dao.BookRepository;
import com.mustafa.dto.AuthorDto;
import com.mustafa.entity.Author;
import com.mustafa.entity.Book;
import com.mustafa.service.abstracts.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorManager implements AuthorService {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    @Autowired
    public AuthorManager(AuthorRepository authorRepository,BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    @Transactional
    public AuthorDto save(AuthorDto authorDto) {

        Author author=new Author();
        author.setName(authorDto.getName());
        author.setSurname(authorDto.getSurname());
        final Author authorDb= (Author) authorRepository.save(author);

        List<Book> bookList=new ArrayList<>();

        authorDto.getBookList().forEach(item -> {
            Book book=new Book();
            book.setBookName(item);
            book.setBookType(Book.BookType.STORY);
            book.setPublishDate(Calendar.getInstance().getTime());
            book.setAuthor(authorDb);
            bookList.add(book);

        });
        bookRepository.saveAll(bookList);
        authorDto.setId(authorDb.getId());
        return authorDto;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<AuthorDto> getAll() {
        List<Author> authors =authorRepository.findAll();
        List<AuthorDto> authorDtos=new ArrayList<>();

        authors.forEach(it -> {
            AuthorDto authorDto= new AuthorDto();
            authorDto.setId(it.getId());
            authorDto.setName(it.getName());
            authorDto.setSurname(it.getSurname());
            authorDto.setBookList(it.getBookList().stream().map(Book::getBookName).collect(Collectors.toList()));
            authorDtos.add(authorDto);
        });
        return authorDtos;
    }


}
