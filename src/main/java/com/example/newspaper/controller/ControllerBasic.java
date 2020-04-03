package com.example.newspaper.controller;

import com.example.newspaper.components.PostComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class ControllerBasic {


    @Autowired
    private PostComponent _postComponent;

/*
    @GetMapping(path = {"/posts","/"})
    public String saludar(Model model){
        model.addAttribute("ultimasNoticias", this._postComponent.getPosts());
        return "index.html";
    }

    @GetMapping(path = "/public")
    public ModelAndView post(){
        ModelAndView modelAndView = new ModelAndView(Pages.POST);
        modelAndView.addObject("ultimasNoticias", this._postComponent.getPosts());
        return modelAndView;
    }

    @GetMapping(path = {"/post", "/post/p/{post}"})
    public ModelAndView getPostIndividual(
            @PathVariable(required = true, name ="post") int id) {
        ModelAndView modelAndView = new ModelAndView(Pages.POST);

        List<Post> postFiltrado = this._postComponent.getPosts().stream()
                .filter( (p) -> {
                     return p.getIdPost() == id;
                }).collect(Collectors.toList());

        modelAndView.addObject("post", postFiltrado.get(0));
        return modelAndView;
    }

    @GetMapping("/newPost")
    public ModelAndView newPost(){
        return new ModelAndView("new-post").addObject("post", new Post());
    }

    @PostMapping("/addNewPost")
    public String addNewPost(Post post, Model model) {
        List<Post> posts = this._postComponent.getPosts();
        posts.add(post);
        model.addAttribute("posts", posts);
        return "index";
    }

 */
}
