package io.tmobaird.spring.jms.manager;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BaseController {

    @GetMapping("/")
    public String index(Model m) {
        m.addAttribute("queue", new SimpleQueue());
        return "base/index";
    }

    @PostMapping("/queue")
    public String show(@ModelAttribute SimpleQueue queue, Model m) {
        m.addAttribute("queue", queue);
        return "base/result";
    }
}
