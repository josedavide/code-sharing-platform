package platform;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(path = "/api/code")
public class ApiController {
    private final CodeService codeService;

    @Autowired
    public ApiController(CodeService codeService) {
        this.codeService = codeService;
    }

    @ModelAttribute
    public void setResponseHeader(HttpServletResponse response) {
        response.setHeader("Content-Type", "application/json");
    }

    @GetMapping()
    public Snippet getCode() {
        return codeService.getSnippedCode();
    }

    @PostMapping("/new")
    public ResponseEntity postCode(@RequestBody Snippet snippet) {
        codeService.updateSnippetCode(snippet.getCode());
        return new ResponseEntity("{}", HttpStatus.OK);
    }




}
