package io.tmobaird.spring.jms.manager;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class QueueController {

    @GetMapping("/")
    public String index(Model m) {
        m.addAttribute("queue", new SimpleQueue());
        return "base/index";
    }

    @PostMapping("/queue")
    public ModelAndView create(@ModelAttribute SimpleQueue queue, Model m) {
        m.addAttribute("queue", queue);
        return new ModelAndView(String.format("redirect:/queue?name=%s", queue.getName()));
    }

    @GetMapping("/queue")
    public String show(@RequestParam(value = "name", defaultValue = "Test") String name, Model m) {
        m.addAttribute("name", name);
        return "base/show";
    }
}
