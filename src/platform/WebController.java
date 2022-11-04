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
        //model.setViewName("view");
        return "code";
    }

    @GetMapping("/new")
    public String create() {
        return "create";
    }

    /*@GetMapping()
    public ModelAndView code(HttpServletResponse response) {
        response.addHeader("Content-Type", "text/html");
        Snippet snippet = codeService.getSnippedCode();
        ModelAndView model = new ModelAndView();
        model.addObject("title", "Code");
        model.addObject("body", bodyCode(snippet));
        model.setViewName("view");
        return model;
    }*/

   /* @GetMapping()
    public String code() {
        Snippet snippet = codeService.getSnippedCode();
        return webContent("Code", bodyCode(snippet));
    }*/

    /*@GetMapping("/new")
    public ModelAndView create(HttpServletResponse response) {
        ModelAndView model = new ModelAndView();
        model.setViewName("create");

        Snippet snippet = codeService.getSnippedCode();
        return model;//webContent("Create", bodyCreate());
    }*/

    private String webContent(String title, String code) {
        String webContent = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "    <title>" + title + "</title>\n" +
                "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\n" +
                "</head>\n" +
                "<body>\n" +
                "<script th:src=\"@{javascript.js}\"></script>" +
                code +
                "</body>\n" +
                "</html>\n";

        return webContent;
    }

    private String bodyCode(Snippet snippet) {
        return "<span id=\"load_date\">\n" + snippet.getDate() + "\n</span>\n" +
                "<pre id=\"code_snippet\">\n" + snippet.getCode() + "\n</pre>\n";

    }

    private String bodyCreate() {
        return "<textarea id=\"code_snippet\"> ... </textarea>" +
                "<button id=\"send_snippet\" type=\"submit\" onclick=\"send()\">Submit</button>";
    }

}