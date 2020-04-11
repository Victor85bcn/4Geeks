package com.example.fourgeeks.controller.mvc;

import com.example.fourgeeks.components.SectionsComponent;
import com.example.fourgeeks.model.Usuario;
import com.example.fourgeeks.repository.CategoriaRep;
import com.example.fourgeeks.repository.PostRep;
import com.example.fourgeeks.repository.UsuarioRep;
import com.example.fourgeeks.util.Pages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private SectionsComponent sectionsComponent;

    @Autowired
    private CategoriaRep categoriaRep;

    @Autowired
    private UsuarioRep usuarioRep;

    @Autowired
    private PostRep postRep;


    @GetMapping(path = {"/{categoria}"})
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

}
