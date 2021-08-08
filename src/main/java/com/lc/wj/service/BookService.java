package com.lc.wj.service;

import com.lc.wj.dao.BookDao;
import com.lc.wj.dao.CatrgoryDao;
import com.lc.wj.pojo.Book;
import com.lc.wj.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookDao bookDao;
    @Autowired
    private CategoryService categoryService;

    public List<Book> list(){
        return bookDao.findAll(Sort.by(Sort.Direction.DESC,"id"));
    }
    public Book findById(Integer id){
        return bookDao.findById(id).orElse(null);
    }
    public void addOrUpdate(Book book){
        bookDao.save(book);
    }

    public void deleteById(Integer id){
        bookDao.deleteById(id);
    }

    public List<Book> listByCategory(Integer  cid){
        Category category = categoryService.get(cid);
        return bookDao.findAllByCategory(category);
    }
}
