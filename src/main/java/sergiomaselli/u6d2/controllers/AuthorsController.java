package sergiomaselli.u6d2.controllers;

import org.springframework.web.bind.annotation.*;
import sergiomaselli.u6d2.entities.Author;
import sergiomaselli.u6d2.payloads.NewAuthorPayload;
import sergiomaselli.u6d2.services.AuthorsService;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorsController {
    private final AuthorsService authorsService;

    public AuthorsController(AuthorsService authorsService) {
        this.authorsService = authorsService;
    }

    @GetMapping
    public List<Author> getAll() {
        return authorsService.findAll();
    }

    @GetMapping("/{id}")
    public Author getById(@PathVariable int id) {
        return authorsService.findById(id);
    }

    @PostMapping
    public Author create(@RequestBody NewAuthorPayload payload) {
        return authorsService.save(payload);
    }

    @PutMapping("/{id}")
    public Author update(@PathVariable int id, @RequestBody NewAuthorPayload payload) {
        return authorsService.update(id, payload);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        authorsService.delete(id);
    }
}
