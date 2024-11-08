package com.apirest.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class MailConfig {

    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);

        // esto no se si valdrá, para hacerlo se necesita la configuración en dos pasos y crear una contraseña de aplicación en google,
        // en el peor de los casos solo tendréis que crearla con un correo vuestro gmail y añadir el nombre de la cuenta y la contraseña
        mailSender.setUsername("nombreqaroniapellidosqaroni@gmail.com");
        mailSender.setPassword("xmik fyps blxm vunv");

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.ssl.trust", "*");
        props.put("mail.debug", "true");

        return mailSender;
    }
}
