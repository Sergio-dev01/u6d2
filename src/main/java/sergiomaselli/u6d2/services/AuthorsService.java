package sergiomaselli.u6d2.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sergiomaselli.u6d2.entities.Author;
import sergiomaselli.u6d2.exceptions.NotFoundException;
import sergiomaselli.u6d2.payloads.NewAuthorPayload;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class AuthorsService {
    private List<Author> authorsDB = new ArrayList<>();

    public List<Author> findAll() {
        return authorsDB;
    }

    public Author save(NewAuthorPayload payload) {
        Author newAuthor = new Author(payload.getNome(), payload.getCognome(), payload.getEmail(), payload.getDataDiNascita());
        authorsDB.add(newAuthor);
        log.info("Autore salvato: " + newAuthor);
        return newAuthor;
    }

    public Author findById(int id) {
        return authorsDB.stream()
                .filter(a -> a.getId() == id)
                .findFirst()
                .orElseThrow(() -> new NotFoundException(id));
    }

    public Author update(int id, NewAuthorPayload payload) {
        Author found = findById(id);
        found.setNome(payload.getNome());
        found.setCognome(payload.getCognome());
        found.setEmail(payload.getEmail());
        found.setDataDiNascita(payload.getDataDiNascita());
        return found;
    }

    public void delete(int id) {
        Author found = findById(id);
        authorsDB.remove(found);
    }
}