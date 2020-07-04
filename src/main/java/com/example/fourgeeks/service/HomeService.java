package com.example.fourgeeks.service;

import com.example.fourgeeks.components.SectionsComponent;
import com.example.fourgeeks.repository.CategoriaRep;
import com.example.fourgeeks.repository.UsuarioRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

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
        model.addAttribute("loMasPopular", this.sectionsComponent.getLoMasPopular());
        model.addAttribute("noTeLoPierdas", this.sectionsComponent.getNoTeLoPierdas());
        model.addAttribute("reportajes", this.sectionsComponent.getReportajes());
        model.addAttribute("opinion", this.sectionsComponent.getOpinion());
        model.addAttribute("categorias", this.categoriaRep.findAll());
        model.addAttribute("usuarios", this.usuarioRep.findAll());
        return model;
    }
}
