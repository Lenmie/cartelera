package ttps.cartelera.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.orm.jpa.support.PersistenceAnnotationBeanPostProcessor;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "ttps.cartelera")
public class AppConfig implements WebMvcConfigurer{

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters){
        converters.add(new MappingJackson2HttpMessageConverter());
    }
/*
    @Bean
    PersistenceAnnotationBeanPostProcessor persistenceAnnotationBeanPostProcessor(){
        PersistenceAnnotationBeanPostProcessor processor = new PersistenceAnnotationBeanPostProcessor();
        return processor;
    }
    */
}
