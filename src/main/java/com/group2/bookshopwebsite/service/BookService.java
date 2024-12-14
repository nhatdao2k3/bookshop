package com.group2.bookshopwebsite.service;

import com.group2.bookshopwebsite.dto.BookSearchDTO;
import com.group2.bookshopwebsite.dto.UserSearchDTO;
import com.group2.bookshopwebsite.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Set;

public interface BookService {

    void addBook(Book book, MultipartFile coverImage);

    void editBook(Book book, MultipartFile coverImage);

    void deleteBook(Long id);

    Book getBookById(Long id);
    Book getBookByName(String name);

    Page<Book> searchBooks(BookSearchDTO search, Pageable pageable);
    Page<Book> searchBooksUser(UserSearchDTO search, Pageable pageable);

    Page<Book> getAllBooksForUsers(Pageable pageable);

    List<Book> getTop10BestSeller();
    List<Book> findAllOrderByCreatedDate();
    List<Book> getBooksByCategory(Long categoryId);

    Set<Book> getFavoriteBooksByUserId(Long id);
    Book getFavoriteBookByUserId(Long bookID, Long userID);

    Long countBook();
}
