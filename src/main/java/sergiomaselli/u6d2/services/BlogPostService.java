package sergiomaselli.u6d2.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sergiomaselli.u6d2.entities.BlogPost;
import sergiomaselli.u6d2.exceptions.NotFoundException;
import sergiomaselli.u6d2.payloads.NewBlogPostPayload;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class BlogPostService {
    private List<BlogPost> blogPostsDB = new ArrayList<>();

    public List<BlogPost> findAll() {
        return blogPostsDB;
    }

    public BlogPost save(NewBlogPostPayload payload) {
        BlogPost newPost = new BlogPost(
                payload.getCategoria(),
                payload.getTitolo(),
                payload.getContenuto(),
                payload.getTempoDiLettura()
        );
        blogPostsDB.add(newPost);
        log.info("Post salvato: " + newPost);
        return newPost;
    }

    public BlogPost findById(int id) {
        return blogPostsDB.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElseThrow(() -> new NotFoundException(id));
    }

    public BlogPost update(int id, NewBlogPostPayload payload) {
        BlogPost found = findById(id);
        found.setCategoria(payload.getCategoria());
        found.setTitolo(payload.getTitolo());
        found.setContenuto(payload.getContenuto());
        found.setTempoDiLettura(payload.getTempoDiLettura());
        return found;
    }

    public void delete(int id) {
        BlogPost found = findById(id);
        blogPostsDB.remove(found);
    }
}