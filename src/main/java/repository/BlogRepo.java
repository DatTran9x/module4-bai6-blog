package repository;

import model.Blog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepo extends CrudRepository<Blog,Integer> {
}
