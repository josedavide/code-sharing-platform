package platform;

import lombok.Getter;

import java.time.LocalDateTime;


@Getter
public class Snippet {
    private String code;
    private LocalDateTime date;

    public Snippet() { }
    public Snippet(String code) {
        this.setCode(code);
    }

    public void setCode(String code) {
        this.code = code;
        this.date = LocalDateTime.now();
    }

}
