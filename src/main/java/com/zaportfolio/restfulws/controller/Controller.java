package com.zaportfolio.restfulws.controller;

import com.zaportfolio.restfulws.model.Book;
import jakarta.annotation.PostConstruct;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller {

    private List<Book> theBooks;
    //define attribute, a list called thebooks contain an object called book
    @PostConstruct
    public void init(){
        theBooks = new ArrayList<>();
        theBooks.add(new Book(1,"Quran","Allah"));
    }

//
//    @GetMapping("/status")
//    @ResponseStatus
//    public String getstatus (){
//        return "HttpStatus.OK";
//    }

    @GetMapping("/books")
    public List<Book> getAllBooks
            (@RequestParam ( value = "page", defaultValue = "1") int page,
            @RequestParam ( value = "sort", defaultValue = "by id", required = false) String sort) {

        return theBooks;
    }
    @GetMapping( value = "/books/{bookId}",
            produces = {MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE})
    public Book getBook (@PathVariable int bookId) {
        return theBooks.get(bookId);
    }

//    @PostMapping("/createuser")
//    public String createUser() {
//        return "Hello, createUser was called!";
//    }
//
//    @PutMapping ("/updateuser")
//    public String updateUser() {
//        return "Hello, updateUser was called!";
//    }
//
//    @DeleteMapping ("/deleteuser")
//    public String deleteUser() {
//        return "Hello, deleteUser was called!";
//    }

}
