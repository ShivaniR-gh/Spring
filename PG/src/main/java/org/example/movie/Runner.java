package org.example.movie;

import org.example.movie.config.CoreConfigure;
import org.example.movie.dto.MovieDTO;
import org.example.movie.service.MovieService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {

    public static void main(String[] args) throws Exception {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(CoreConfigure.class);

        MovieDTO movieDTO = new MovieDTO(1, "xyz");

        System.out.println(movieDTO);
        MovieService movieService =
                context.getBean(MovieService.class);

        movieService.validateAndSave(movieDTO);
        System.out.println(movieService);
    }
}
