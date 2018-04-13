package spring.homework9;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import spring.homework9.server.Server;
import spring.homework9.server.interfacer.ServerRepository;

@Configuration
@ComponentScan("spring.homework9")
@PropertySource("classpath:source.properties")
public class SpringMain {
    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    private static final Logger logger = LoggerFactory.getLogger(SpringMain.class);

    public static void main(String[] args) {
        logger.info("Start the context Spring  ");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(SpringMain.class);
        context.getEnvironment().setActiveProfiles("prod");
        context.refresh();
        ServerRepository repository = context.getBean(ServerRepository.class);
        repository.start();
        context.registerShutdownHook();
    }
}
