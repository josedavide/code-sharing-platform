package platform;

import org.springframework.stereotype.Service;

@Service
public class CodeService {

    public Snippet getCode() {
        return new Snippet("public static void main(String[] args) {\n    SpringApplication.run(CodeSharingPlatform.class, args);\n}");
    }
}
