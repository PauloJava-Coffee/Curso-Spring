package io.github.paulojava_coffee.arquiteturaspring;

import jdk.jfr.Enabled;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication
@EnableConfigurationProperties
public class ArquiteturaspringApplication {

    public static void main(String[] args) {
        //SpringApplication.run(ArquiteturaspringApplication.class, args);

        //Classe que desponibiliza o acesso às propriedades da aplicação
        SpringApplicationBuilder builder = new SpringApplicationBuilder(ArquiteturaspringApplication.class);

        //Retirando o banner do spring que aparec no console
        builder.bannerMode(Banner.Mode.OFF);

        //Definindo o perfil de configuração
        builder.profiles("teste");

        //Definindo o padrão para @Lazy
        builder.lazyInitialization(false);

        //Rodando a aplicação
        builder.run(args);

        //Obtendo o contexto da aplicação 
        ConfigurableApplicationContext applicationContext = builder.context();

        //Obtendo o Bean dentro do container 'ProdutoRepository' -->
        //  --> var produtoRepository =  applicationContext.getBean("ProdutoRepository"); <--
        //Definindo uma propriedade da aplicação
        builder.properties("spring.datasource.url=");

        //Objeto que permite o acesso às propriedades da aplicação
        ConfigurableEnvironment environment = applicationContext.getEnvironment();

        //Obtendo o nome da aplicação
        String applicationName = environment.getProperty("spring.application.name");

        System.out.println("Nome da aplicação: " + applicationName);

        //Recuperand  valor de uma variável das propriedades
        ExemploValue valor = applicationContext.getBean(ExemploValue.class);
        valor.imprimirVariavel();
        
        AppPorperties properties = applicationContext.getBean(AppPorperties.class);
        System.out.println(properties.getName());

    }

}
