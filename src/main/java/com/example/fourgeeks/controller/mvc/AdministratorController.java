package com.example.fourgeeks.controller.mvc;

import com.example.fourgeeks.components.SectionsComponent;
import com.example.fourgeeks.model.Categoria;
import com.example.fourgeeks.model.Post;
import com.example.fourgeeks.model.Seccion;
import com.example.fourgeeks.model.Usuario;
import com.example.fourgeeks.service.*;
import com.example.fourgeeks.util.Pages;
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
@RequestMapping("/admin")
public class AdministratorController {

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private PostService postService;

    @Autowired
    private PostSeccionService postSeccionService;

    @Autowired
    private HomeService homeService;

    @Autowired
    private SectionsComponent sectionsComponent;


    @GetMapping("/")
    public ModelAndView getHome(){
        return new ModelAndView("administrator/admin");
    }


    @GetMapping(path = {"/posts"})
    public ModelAndView getPostList() {
        ModelAndView modelAndView = new ModelAndView(Pages.POST_LIST);
        modelAndView.addObject("posts", this.postService.findAll());
        modelAndView.addObject("categorias", this.categoriaService.findAll());
        return modelAndView;
    }

    @GetMapping("/eliminarPost")
    public String deletePost(Post post) {
        postService.deleteByPostId((int) post.getIdPost());
        return "redirect:/admin/posts";
    }

    @GetMapping("/modificar/{post}")
    public ModelAndView updatePost(@PathVariable(required = true, name ="post") int id){
        List<Categoria> categorias = categoriaService.findAll();
        List<Usuario> usuarios = usuarioService.findAll();
        Post post = this.postService.getPostById(id);
        return new ModelAndView("update-post.html").addObject("post", post)
                .addObject("categorias", categorias)
                .addObject("usuarios", usuarios);
    }

    @PostMapping("/modificarArticulo")
    public String updatePost(Post post, Model model) {
        postService.update(post);
        homeService.modelHome(model);
        return "redirect:/admin/posts";
    }

    @GetMapping(path = {"/secciones"})
    public ModelAndView getSeccionesList() {
        ModelAndView modelAndView = new ModelAndView(Pages.SECCIONES_LIST);
        modelAndView.addObject("secciones", this.sectionsComponent.getSecciones());
        modelAndView.addObject("postSeccionList", this.postSeccionService.findAll());
        modelAndView.addObject("postsSinSeccion", this.postService.postsSinSeccion());
        modelAndView.addObject("posts", this.postService.findAll());
        modelAndView.addObject("categorias", this.categoriaService.findAll());
        return modelAndView;
    }

    @GetMapping("/modificarSeccion")
    public String updateSeccion(Post post, Seccion seccion) {
        postSeccionService.updatePostSeccion(post, seccion);
        return "redirect:/admin/secciones";
    }


}
