package com.chc.tanda.concepthubclassessbackend;

import com.chc.tanda.concepthubclassessbackend.customRepo.CustomCRUDRepositoryImpl;
import com.chc.tanda.concepthubclassessbackend.services.FileStorageProperties;
import net.kaczmarzyk.spring.data.jpa.web.SpecificationArgumentResolver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@EnableConfigurationProperties({
        FileStorageProperties.class
})
@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = CustomCRUDRepositoryImpl.class)

public class ConcepthubclassessbackendApplication implements WebMvcConfigurer {

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(new SpecificationArgumentResolver());
        argumentResolvers.add(new PageableHandlerMethodArgumentResolver());
    }


    public static void main(String[] args) {
        SpringApplication.run(ConcepthubclassessbackendApplication.class, args);
    }

}
