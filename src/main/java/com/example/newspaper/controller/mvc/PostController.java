package com.example.newspaper.controller.mvc;

import com.example.newspaper.components.SectionsComponent;
import com.example.newspaper.model.Categoria;
import com.example.newspaper.model.Comentario;
import com.example.newspaper.model.Post;
import com.example.newspaper.model.Usuario;
import com.example.newspaper.service.*;
import com.example.newspaper.util.Pages;
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
@RequestMapping("/articulo")
public class PostController {

    @Autowired
    private SectionsComponent sectionsComponent;

    @Autowired
    private PostService postService;

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private ComentarioService comentarioService;

    @Autowired
    private HomeService homeService;


    @GetMapping(path = {"/{post}"})
    public ModelAndView getArticulo(@PathVariable(required = true, name ="post") int id) {
        ModelAndView modelAndView = new ModelAndView(Pages.IMAGE_POST);
        Post post = this.postService.getPostById(id);
        List<Comentario> comentariosList = comentarioService.findByPostId(id);
        List<Usuario> usuarios = usuarioService.findAll();
        modelAndView.addObject("post", post);
        modelAndView.addObject("comentario", new Comentario());
        modelAndView.addObject("comentariosList", comentariosList);
        modelAndView.addObject("usuarios", usuarios);
        modelAndView.addObject("categorias", this.categoriaService.findAll());
        modelAndView.addObject("loMasPopular", this.sectionsComponent.getLoMasPopular());
        modelAndView.addObject("noTeLoPierdas", this.sectionsComponent.getNoTeLoPierdas());
        return modelAndView;
    }

    @GetMapping("/nuevoArticulo")
    public ModelAndView newPost(){
        List<Categoria> categorias = categoriaService.findAll();
        List<Usuario> usuarios = usuarioService.findAll();
        return new ModelAndView("new-post.html").addObject("post", new Post())
                .addObject("categorias", categorias)
                .addObject("usuarios", usuarios);
    }

    @PostMapping("/addNuevoArticulo")
    public String addNewPost(Post post, Model model) {
        postService.saveNewPost(post);
        homeService.modelHome(model);
        return "redirect:/";
    }

    @PostMapping("/nuevoComentario")
    public String nuevoComentario(Comentario comentario, Model model) {
        comentarioService.save(comentario);
        homeService.modelHome(model);
        return "redirect:/";
    }

}
