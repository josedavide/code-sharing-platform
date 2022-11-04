package platform;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(path = "/code")
public class WebController {
    private final CodeService codeService;

    @Autowired
    public WebController(CodeService codeService) {
        this.codeService = codeService;
    }

    @ModelAttribute
    public void setResponseHeader(HttpServletResponse response) {
        response.setHeader("Content-Type", "text/html");
    }

    @GetMapping()
    public String code(Model model) {
        Snippet snippet = codeService.getSnippedCode();
        model.addAttribute("code", snippet.getCode());
        model.addAttribute("datetime", snippet.getDate());
        return "code";
    }

    @GetMapping("/new")
    public String create() {
        return "create";
    }
}