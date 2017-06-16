package com.konulgurbanli;

import com.konulgurbanli.Controller.WordController;
import com.konulgurbanli.Dao.WordDao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Created by Konul Gurbanli on 5/31/2017.
 */
@SpringBootApplication
//@ComponentScan(basePackageClasses=WordController.class)
public class Main extends SpringBootServletInitializer {

    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(WordController.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Main.class, args);
//        WordDao dao =  new WordDao();
//        System.out.println(dao.countWords());
    }

//    @Bean
//    public ViewResolver getViewResolver(){
//        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//        resolver.setPrefix("/resources/templates/");
//        resolver.setSuffix(".jsp");
////        resolver.setViewClass(JstlView.class);
//        return resolver;
//    }
}
