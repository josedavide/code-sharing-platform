package platform;

import org.springframework.stereotype.Service;

@Service
public class CodeService {
    public final String CODE = "public static void main(String[] args) {\n    SpringApplication.run(CodeSharingPlatform.class, args);\n}";
    public final CodeRepository codeRepository;

    public CodeService(CodeRepository codeRepository) {
        this.codeRepository = codeRepository;
        codeRepository.updateSnippetCode(CODE);
    }

    public Snippet getSnippedCode() {
        return codeRepository.getSnippet();
    }

    public void updateSnippetCode(String code) {
        codeRepository.updateSnippetCode(code);
    }
}
