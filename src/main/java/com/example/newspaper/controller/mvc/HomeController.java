package com.example.newspaper.controller.mvc;

import com.example.newspaper.components.PostComponent;
import com.example.newspaper.components.SectionsComponent;
import com.example.newspaper.configuration.Pages;
import com.example.newspaper.model.Categoria;
import com.example.newspaper.model.Comentario;
import com.example.newspaper.model.Post;
import com.example.newspaper.model.Usuario;
import com.example.newspaper.repository.*;
import com.example.newspaper.security.UserPrincipal;
import com.example.newspaper.security.UserPrincipalDetailsService;
import com.example.newspaper.service.HomeService;
import com.example.newspaper.service.PostService;
import com.example.newspaper.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private SectionsComponent sectionsComponent;

    @Autowired
    private PostComponent postComponent;

    @Autowired
    private PostService postService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private CategoriaRep categoriaRep;

    @Autowired
    private UsuarioRep usuarioRep;

    @Autowired
    private ComentarioRep comentarioRep;

    @Autowired
    private PostRep postRep;

    @Autowired
    private HomeService homeService;


    @GetMapping(path = {"/"})
    public String home(Model model){
        homeService.modelHome(model);
        return "index.html";
    }

    @GetMapping(path = {"/login"})
    public String login(Model model){
//        homeService.modelHome(model);
        return "login";
    }

    @GetMapping(path = {"/articulo/{post}"})
    public ModelAndView getPostIndividual(@PathVariable(required = true, name ="post") int id) {
        ModelAndView modelAndView = new ModelAndView(Pages.IMAGE_POST);
        Post post = this.postComponent.getPostById(id);
        List<Comentario> comentariosList = comentarioRep.findByPostId(id);
        List<Usuario> usuarios = usuarioRep.findAll();
        modelAndView.addObject("post", post);
        modelAndView.addObject("comentario", new Comentario());
        modelAndView.addObject("comentariosList", comentariosList);
        modelAndView.addObject("usuarios", usuarios);
        modelAndView.addObject("categorias", this.categoriaRep.findAll());
        modelAndView.addObject("loMasPopular", this.sectionsComponent.getLoMasPopular());
        modelAndView.addObject("noTeLoPierdas", this.sectionsComponent.getNoTeLoPierdas());
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
        homeService.modelHome(model);
        return "index.html";
    }

    @GetMapping("/nuevoUsuario")
    public ModelAndView newUsuario(){
        return new ModelAndView("registro.html").addObject("usuario", new Usuario());
    }

    @PostMapping("/registro")
    public String addNewUser(Usuario usuario, Model model) {
        usuarioService.saveNewUsuario(usuario);
        homeService.modelHome(model);
        return "index.html";
    }


    @PostMapping("/addNuevoComentario")
    public String addNewComentario(Comentario comentario, Model model) {
        comentarioRep.save(comentario);
        homeService.modelHome(model);
        return "index.html";
    }

    @GetMapping(path = {"/categoria/{categoria}"})
    public ModelAndView getCategoria(@PathVariable(required = true, name ="categoria") String categoria) {
        ModelAndView modelAndView = new ModelAndView(Pages.CATEGORIA);
        List<Usuario> usuarios = usuarioRep.findAll();
        modelAndView.addObject("usuarios", usuarios);
        modelAndView.addObject("categorias", this.categoriaRep.findAll());
        modelAndView.addObject("loMasPopular", this.sectionsComponent.getLoMasPopular());
        modelAndView.addObject("noTeLoPierdas", this.sectionsComponent.getNoTeLoPierdas());
        modelAndView.addObject("portadaPrincipal", this.sectionsComponent.getPortadaPrincipal());
        modelAndView.addObject("subPortadaTop", this.sectionsComponent.getSubPortadaTop());
        modelAndView.addObject("subPortadaBottom", this.sectionsComponent.getSubPortadaBottom());
        modelAndView.addObject("postsByCategoria", this.postRep.getPostsByCategoria(categoria));
        return modelAndView;
    }


    @GetMapping(path = {"/admin/posts"})
    public ModelAndView getPostList() {
        ModelAndView modelAndView = new ModelAndView(Pages.POST_LIST);
        modelAndView.addObject("posts", this.postRep.findAll());
        modelAndView.addObject("categorias", this.categoriaRep.findAll());
        return modelAndView;
    }

    @GetMapping("/eliminarPost")
    public String deletePost(Post post, Model model) {
        postRep.deleteByPostId((int) post.getIdPost());
        homeService.modelHome(model);
        return "redirect:/admin/posts";
    }

    @GetMapping("/modificar/{post}")
    public ModelAndView updatePost(@PathVariable(required = true, name ="post") int id){
        List<Categoria> categorias = categoriaRep.findAll();
        List<Usuario> usuarios = usuarioRep.findAll();
        Post post = this.postComponent.getPostById(id);
        return new ModelAndView("update-post.html").addObject("post", post)
                .addObject("categorias", categorias)
                .addObject("usuarios", usuarios);
    }

    @PostMapping("/modificarArticulo")
    public String updatePost(Post post, Model model) {
        postRep.update(post);
        homeService.modelHome(model);
        return "redirect:/admin/posts";
    }


}
