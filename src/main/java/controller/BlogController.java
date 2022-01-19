package controller;

import model.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import service.IBlogService;

@Controller
public class BlogController {
    @Autowired
    IBlogService blogService;

    @ModelAttribute("blog")
    public Blog blog(){
        return new Blog();
    }

    @GetMapping("/home")
    public ModelAndView homepage(){
        ModelAndView mav = new ModelAndView("homepage");
        mav.addObject("list",blogService.findAll());
        return mav;
    }

    @GetMapping("/create")
    public String createForm(){
        return "create";
    }

    @PostMapping("/create")
    public String create(Blog blog){
        blogService.save(blog);
        return "redirect:/home";
    }

    @GetMapping("/details/{id}")
    public ModelAndView details(@PathVariable int id){
        Blog blog = blogService.findById(id);
        ModelAndView mav = new ModelAndView("details");
        mav.addObject("blog",blog);
        return mav;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editForm(@PathVariable int id){
        Blog blog = blogService.findById(id);
        ModelAndView mav = new ModelAndView("edit");
        mav.addObject("blog",blog);
        return mav;
    }
}
