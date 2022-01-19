package service;

import model.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.BlogRepo;

import java.util.List;

@Service
public class BlogService implements IBlogService{
    @Autowired
    BlogRepo blogRepo;

    @Override
    public List<Blog> findAll() {
        return (List<Blog>) blogRepo.findAll();
    }

    @Override
    public void save(Blog blog) {
        blogRepo.save(blog);
    }

    @Override
    public void delete(int id) {
        blogRepo.deleteById(id);
    }

    @Override
    public Blog findById(int id) {
        return blogRepo.findById(id).get();
    }
}
