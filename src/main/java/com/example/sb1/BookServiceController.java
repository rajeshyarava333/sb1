package com.example.sb1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookServiceController {

    @Autowired
    private BookService bookService;

    @GetMapping(value="/books")
    public ResponseEntity<Object>getBook(){
        return new ResponseEntity<>(bookService.getBooks(), HttpStatus.OK);
    }
    @GetMapping(value="/books/{id}")
    public ResponseEntity<Object>getBookById(@PathVariable("id")String id){
        return new ResponseEntity<>(bookService.getBooksById(id),HttpStatus.OK);
    }
    @PostMapping(value ="/books")
    public ResponseEntity<Object>createProduct(@RequestBody Book book) {
        bookService.addBooks(book);
        return new ResponseEntity<>("Book is created successfully", HttpStatus.CREATED);
    }

    @PutMapping(value ="/books/{id}")
    public ResponseEntity<Object>updateProduct(@PathVariable("id") String a, @RequestBody Book book){
        bookService.updateBooks( a,book);
        return new ResponseEntity<>("Book is updated successfully", HttpStatus.OK);
    }
    @DeleteMapping(value ="/books/{id}")
    public ResponseEntity<Object>deleteProduct(@PathVariable("id") String id) {
        bookService.deleteBooks(id);
        return new ResponseEntity<>("Book is deleted successfully", HttpStatus.OK);
    }
}
