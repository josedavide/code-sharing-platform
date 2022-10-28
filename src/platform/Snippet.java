package platform;

import lombok.Data;

@Data
public class Snippet {
    private String code;

    public Snippet(String code) {
        this.code = code;
    }

}
