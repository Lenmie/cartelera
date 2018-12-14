package ttps.cartelera.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class SpringWebApp implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext container) throws ServletException {
        //crear el root del spring app context
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(AppConfig.class);

        //agregar listener para administrar el ciclo de vida del root app context
        container.addListener(new ContextLoaderListener(rootContext));

        //Registrar y mapear el Dispatcher Servlet
        ServletRegistration.Dynamic dispatcher = container.addServlet("DispatcherServlet", new DispatcherServlet(rootContext));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
    }
}
