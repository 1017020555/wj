package com.lc.wj.dao;

import com.lc.wj.pojo.Book;
import com.lc.wj.pojo.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BookDao extends JpaRepository<Book,Integer> {
    List<Book> findAllByCategory(Category category);
    List<Book> findAllByTitleLikeOrAuthorLike(String title,String author);
}
