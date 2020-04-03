package com.example.newspaper.controller.mvc;

import com.example.newspaper.components.PostComponent;
import com.example.newspaper.components.SectionsComponent;
import com.example.newspaper.configuration.Pages;
import com.example.newspaper.model.Categoria;
import com.example.newspaper.model.Comentario;
import com.example.newspaper.model.Post;
import com.example.newspaper.model.Usuario;
import com.example.newspaper.repository.CategoriaRep;
import com.example.newspaper.repository.ComentarioRep;
import com.example.newspaper.repository.UsuarioRep;
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

@Controller
@RequestMapping("/articulo/{post}")
public class PostController {

    @Autowired
    private SectionsComponent sectionsComponent;

    @Autowired
    private PostComponent postComponent;

    @Autowired
    private PostService postService;

    @Autowired
    private CategoriaRep categoriaRep;

    @Autowired
    private UsuarioRep usuarioRep;

    @Autowired
    private ComentarioRep comentarioRep;


    @GetMapping(path = {"/"})
    public String saludar(Model model){
        model.addAttribute("ultimasNoticias", this.sectionsComponent.getUltimasNoticias());
        model.addAttribute("portadaPrincipal", this.sectionsComponent.getPortadaPrincipal());
        model.addAttribute("subPortadaTop", this.sectionsComponent.getSubPortadaTop());
        model.addAttribute("subPortadaBottom", this.sectionsComponent.getSubPortadaBottom());
        model.addAttribute("categorias", this.categoriaRep.findAll());
        model.addAttribute("usuarios", this.usuarioRep.findAll());
        return "gallery-post.html";
    }

    @GetMapping(path = {"/articulo/{post}"})
    public ModelAndView getPostIndividual(@PathVariable(required = true, name ="post") int id) {
        ModelAndView modelAndView = new ModelAndView(Pages.IMAGE_POST);
        Post post = this.postComponent.getPostById(id);
        modelAndView.addObject("post", post);
        modelAndView.addObject("comentario", new Comentario());
        return modelAndView;
    }

    @GetMapping("/nuevoArticulo")
    public ModelAndView newPost(){
        List<Categoria> categorias = categoriaRep.findAll();
        List<Usuario> usuarios = usuarioRep.findAll();
        return new ModelAndView("new-post.html").addObject("post", new Post())
                .addObject("categorias", categorias)
                .addObject("usuarios", usuarios);
    }

    @PostMapping("/addNuevoArticulo")
    public String addNewPost(Post post, Model model) {
        postService.saveNewPost(post);
        return "gallery-post.html";
    }

    @PostMapping("/addNuevoComentario")
    public String addNewComentario(Comentario comentario) {
        comentarioRep.save(comentario);
        return "gallery-post.html";
    }

}
