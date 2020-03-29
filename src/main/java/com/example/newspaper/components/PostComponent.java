package com.example.newspaper.components;

import com.example.newspaper.model.Post;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("postComponent")
public class PostComponent {

    public List<Post> getPosts(){
        ArrayList<Post> postsList = new ArrayList<>();
//        postsList.add(new Post(1L,"Titulo test", "Extracto test", "Contenido test", 1L, 1L, "https://i11d.3djuegos.com/juegos/9515/playstation_network/fotos/noticias/playstation_network-5118579.jpg", "POST"));
//        postsList.add(new Post(2L,"Titulo test", "Extracto test", "Contenido test", 3L, 2L, "https://i11c.3djuegos.com/juegos/17090/captain_tsubasa_rise_of_new_champions/fotos/noticias/captain_tsubasa_rise_of_new_champions-5118262.jpg", "POST"));
//        postsList.add(new Post(3L,"Titulo test", "Extracto test", "Contenido test", 2L, 4L, "https://i11d.3djuegos.com/juegos/9280/mount__blade_ii_bannerlord/fotos/noticias/mount__blade_ii_bannerlord-5118243.jpg", "POST"));
//        postsList.add(new Post(4L,"Titulo test", "Extracto test", "Contenido test", 1L, 1L, "https://i11d.3djuegos.com/juegos/17188/call_of_duty_warzone/fotos/noticias/call_of_duty_warzone-5117987.jpg", "POST"));
        return postsList;
    }

}
