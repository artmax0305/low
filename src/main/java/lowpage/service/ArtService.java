package lowpage.service;

import lowpage.dao.ArtRepo;
import lowpage.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ArtService {

    @Autowired
    private ArtRepo artRepo;

    public void save(Article article){
        artRepo.save(article);
    }

    public List<Article> getAll(){
        List<Article> articles =artRepo.findAll();
        Collections.reverse(articles);
        return articles;
    }
}
