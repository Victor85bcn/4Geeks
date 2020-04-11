package com.example.newspaper.controller.mvc;

import com.example.newspaper.model.Usuario;
import com.example.newspaper.service.HomeService;
import com.example.newspaper.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private HomeService homeService;


    @GetMapping(path = {"/"})
    public String home(Model model){
        homeService.modelHome(model);
        return "index.html";
    }

    @GetMapping(path = {"/login"})
    public String login(){
        return "login";
    }

    @GetMapping("/registro")
    public ModelAndView newUsuario(){
        return new ModelAndView("registro.html").addObject("usuario", new Usuario());
    }

    @PostMapping("/registro")
    public String addNewUser(Usuario usuario) {
        usuarioService.saveNewUsuario(usuario);
        return "redirect:/";
    }


}
