package com.example.newspaper.service;

import com.example.newspaper.components.PostComponent;
import com.example.newspaper.components.SectionsComponent;
import com.example.newspaper.repository.CategoriaRep;
import com.example.newspaper.repository.ComentarioRep;
import com.example.newspaper.repository.UsuarioRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

@Service
public class HomeService {

    @Autowired
    private SectionsComponent sectionsComponent;

    @Autowired
    private CategoriaRep categoriaRep;

    @Autowired
    private UsuarioRep usuarioRep;


    public Model modelHome(Model model){
        model.addAttribute("ultimasNoticias", this.sectionsComponent.getUltimasNoticias());
        model.addAttribute("portadaPrincipal", this.sectionsComponent.getPortadaPrincipal());
        model.addAttribute("subPortadaTop", this.sectionsComponent.getSubPortadaTop());
        model.addAttribute("subPortadaBottom", this.sectionsComponent.getSubPortadaBottom());
        model.addAttribute("categorias", this.categoriaRep.findAll());
        model.addAttribute("usuarios", this.usuarioRep.findAll());
        return model;
    }
}
