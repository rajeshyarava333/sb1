package com.example.sb1;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class BookService {
    Map<String,Book> bookMap=new HashMap<>();

    public Collection<Book> getBooks(){
        return bookMap.values();
    }
    public Book getBooksById(String id) {
        return bookMap.get(id);
    }
    public void addBooks(Book book){
        bookMap.put(book.getId(),book);
    }
    public void updateBooks(String id,Book book){
        bookMap.remove(id);
        bookMap.put(book.getId(), book);
    }
    public void deleteBooks(String id){
        bookMap.remove(id);
    }
}
