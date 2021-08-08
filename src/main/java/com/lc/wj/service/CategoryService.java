package com.lc.wj.service;

import com.lc.wj.dao.CatrgoryDao;
import com.lc.wj.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CatrgoryDao catrgoryDao;

    public List<Category> list(){
        Sort sort= Sort.by(Sort.Direction.DESC,"id");
        return catrgoryDao.findAll(sort);
    }
    public Category get(int id){
        Category category= catrgoryDao.findById(id).orElse(null);
        return category;
    }
}
