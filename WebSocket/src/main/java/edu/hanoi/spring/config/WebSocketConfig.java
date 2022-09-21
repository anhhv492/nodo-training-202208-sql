package edu.hanoi.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Properties;

@Configuration
@EnableWebSocketMessageBroker
@PropertySource("classpath:/application.properties")
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {
    @Autowired
    private Environment env;

    @Bean
    public DataSource dataSource() throws SQLException {
        String url = env.getProperty("spring.datasource.url");
        DriverManagerDataSource dataSource = new DriverManagerDataSource(url);
        dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
        dataSource.setUsername(env.getProperty("spring.datasource.username"));
        dataSource.setPassword(env.getProperty("spring.datasource.password"));
        return dataSource;
    }
    @Bean
    public LocalSessionFactoryBean sessionFactoryBean() throws SQLException {
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource());
        sessionFactoryBean.setPackagesToScan(new String[]{"edu/hanoi/spring/model"});
        sessionFactoryBean.setHibernateProperties(hibernateProperties());
        return sessionFactoryBean;
    }
    private Properties hibernateProperties(){
        return new Properties(){
            {
                setProperty("spring.jpa.show-sql",env.getProperty("spring.jpa.show-sql"));
                setProperty("spring.jpa.properties.hibernate.dialect",env.getProperty("spring.jpa.properties.hibernate.dialect"));
            }
        };
    }
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic");
        config.setApplicationDestinationPrefixes("/app");
    }
    public void registerStompEndpoints(StompEndpointRegistry registry){
//        registry.addEndpoint("/message").withSockJS();
        registry.addEndpoint("/user").withSockJS();
    }
}

