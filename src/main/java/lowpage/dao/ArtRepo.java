package lowpage.dao;

import lowpage.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtRepo extends JpaRepository<Article,Long> {
}
