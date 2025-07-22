package sergiomaselli.u6d2.entities;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Random;

@Getter
@Setter
@ToString
public class BlogPost {
    @Setter(AccessLevel.NONE)
    private int id;
    private String categoria;
    private String titolo;
    private String contenuto;
    private int tempoDiLettura;
    private String cover;

    public BlogPost(String categoria, String titolo, String contenuto, int tempoDiLettura) {
        this.id = new Random().nextInt(1, 10000);
        this.categoria = categoria;
        this.titolo = titolo;
        this.contenuto = contenuto;
        this.tempoDiLettura = tempoDiLettura;
        this.cover = "https://picsum.photos/200/300";
    }
}