package com.example.newspaper.controller.mvc;

import com.example.newspaper.components.PostComponent;
import com.example.newspaper.components.SectionsComponent;
import com.example.newspaper.configuration.Pages;
import com.example.newspaper.model.Post;
import com.example.newspaper.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private SectionsComponent sectionsComponent;

    @Autowired
    private PostComponent postComponent;

    @Autowired
    private PostService postService;

    @GetMapping(path = {"/"})
    public String saludar(Model model){
        model.addAttribute("ultimasNoticias", this.sectionsComponent.getUltimasNoticias());
        model.addAttribute("portadaPrincipal", this.sectionsComponent.getPortadaPrincipal());
        model.addAttribute("subPortadaTop", this.sectionsComponent.getSubPortadaTop());
        model.addAttribute("subPortadaBottom", this.sectionsComponent.getSubPortadaBottom());
        return "index.html";
    }

    @GetMapping(path = {"/articulo/{post}"})
    public ModelAndView getPostIndividual(@PathVariable(required = true, name ="post") int id) {
        ModelAndView modelAndView = new ModelAndView(Pages.IMAGE_POST);
        Post post = this.postComponent.getPostById(id);
        modelAndView.addObject("post", post);
        return modelAndView;
    }

    @GetMapping("/nuevoArticulo")
    public ModelAndView newPost(){
        return new ModelAndView("new-post.html").addObject("post", new Post());
    }

    @PostMapping("/addNuevoArticulo")
    public String addNewPost(Post post, Model model) {
        postService.saveNewPost(post);
        /*List<Post> posts = this.postComponent.getAllPosts();
        posts.add(post);
        model.addAttribute("posts", posts);*/
        return "index.html";
    }

}
