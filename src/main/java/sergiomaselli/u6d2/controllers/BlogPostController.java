package sergiomaselli.u6d2.controllers;

import org.springframework.web.bind.annotation.*;
import sergiomaselli.u6d2.entities.BlogPost;
import sergiomaselli.u6d2.payloads.NewBlogPostPayload;
import sergiomaselli.u6d2.services.BlogPostService;

import java.util.List;

@RestController
@RequestMapping("/blogPosts")
public class BlogPostController {

    private final BlogPostService blogPostService;

    public BlogPostController(BlogPostService blogPostService) {
        this.blogPostService = blogPostService;
    }

    @GetMapping
    public List<BlogPost> getAll() {
        return blogPostService.findAll();
    }

    @GetMapping("/{id}")
    public BlogPost getById(@PathVariable int id) {
        return blogPostService.findById(id);
    }

    @PostMapping
    public BlogPost create(@RequestBody NewBlogPostPayload payload) {
        return blogPostService.save(payload);
    }

    @PutMapping("/{id}")
    public BlogPost update(@PathVariable int id, @RequestBody NewBlogPostPayload payload) {
        return blogPostService.update(id, payload);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        blogPostService.delete(id);
    }
}