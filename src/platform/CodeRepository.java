package platform;

import lombok.Getter;
import org.springframework.stereotype.Repository;

@Repository
public class CodeRepository {
    @Getter
    private Snippet snippet;

    public CodeRepository() {
        this.snippet = new Snippet();
    }

    public void updateSnippetCode(String code) {
        snippet.setCode(code);
    }

}
