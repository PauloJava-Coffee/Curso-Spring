/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.paulojava_coffee.libraryapi.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import javax.sql.DataSource;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 *
 * @author max
 */
@Getter
@Setter
@Configuration
public class DatabaseConfiguration {
    
    @Value("${spring.datasource.url}")
    String url;
    
    @Value("${spring.datasource.username}")
    String userName;
    
    @Value("${spring.datasource.password}")
    String password;
    
    @Value("${spring.datasource.driver-class-name}")
    String driver;
    
    //@Bean
    public DataSource dataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        
        ds.setUrl(url);
        ds.setUsername(userName);
        ds.setPassword(password);
        ds.setDriverClassName(driver);
        
        return ds;
    }
    
    //@Bean
    public DataSource hikariDataSource() {
        HikariConfig config = new HikariConfig();
        
        config.setJdbcUrl(url);
        config.setUsername(userName);
        config.setPassword(password);
        config.setDriverClassName(driver);
        
        config.setMaximumPoolSize(10); // Máximo de conexões liberadas
        config.setMinimumIdle(1); // Tamanho inicial do pool
        config.setPoolName("library db pool");
        config.setMaxLifetime(600000); // 600 mil ms
        config.setConnectionTimeout(100000); // Time Out para conseguir uma conexão
        config.setConnectionTestQuery("select 1"); // Query de teste de conexão
        
        
        return new HikariDataSource(config);
    }
}
