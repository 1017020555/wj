package com.lc.wj.controller;

import com.lc.wj.pojo.Book;
import com.lc.wj.service.BookService;
import com.lc.wj.utils.UploadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@RestController
public class LibraryController {
    @Autowired
    private BookService bookService;

    @CrossOrigin
    @GetMapping("/api/books")
    public List<Book> list() throws Exception {
        return bookService.list();
    }

    @CrossOrigin
    @PostMapping("/api/books")
    public Book addOrUpdate(@RequestBody Book book) throws Exception {
        bookService.addOrUpdate(book);
        return book;
    }

    @CrossOrigin
    @RequestMapping("/api/findById/{id}")
    public Book findById(@PathVariable Integer id){
        return bookService.findById(id);
    }

    @PostMapping("/api/delete")
    public void delete(@RequestBody Book book) throws Exception {
        bookService.deleteById(book.getId());
    }

    @CrossOrigin
    @GetMapping("/api/categories/{cid}/books")
    public List<Book> listByCategory(@PathVariable("cid") int cid) throws Exception {
        if (0 != cid) {
            return bookService.listByCategory(cid);
        } else {
            return list();
        }
    }

    @CrossOrigin
    @GetMapping("/api/search")
    public List<Book> search(@Param("keywords") String keywords){
        if ("".equals(keywords)){
            return bookService.list();
        }else {
            return bookService.search(keywords);
        }
    }

    @CrossOrigin
    @PostMapping("api/covers")
    public String upload(MultipartFile file){
        try {
            String folder = "D:/workspace/wj/img/";
            File file1=new File(folder);
            if (!file1.exists()) {
                file1.mkdir();
            }
            file.transferTo(new File(folder,file.getOriginalFilename()));
            String imgURL = "http://localhost:8843/api/file/" + file.getOriginalFilename();
            return imgURL;
        }catch (Exception e){
            e.getMessage();
            return "";
        }

    }
}
