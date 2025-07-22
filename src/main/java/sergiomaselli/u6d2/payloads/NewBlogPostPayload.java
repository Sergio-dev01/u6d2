package sergiomaselli.u6d2.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class NewBlogPostPayload {
    private String categoria;
    private String titolo;
    private String contenuto;
    private int tempoDiLettura;

    @Override
    public String toString() {
        return "NewBlogPostPayload{" +
                "categoria='" + categoria + '\'' +
                ", titolo='" + titolo + '\'' +
                ", contenuto='" + contenuto + '\'' +
                ", tempoDiLettura=" + tempoDiLettura +
                '}';
    }
}
