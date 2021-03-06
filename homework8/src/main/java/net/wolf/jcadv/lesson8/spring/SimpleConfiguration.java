/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.wolf.jcadv.lesson8.spring;

import net.wolf.jcadv.lesson8.spring.homework.example.*;
import net.wolf.jcadv.lesson8.spring.service.DefaultMessageSender;
import net.wolf.jcadv.lesson8.spring.service.DefaultWelcomeService;
import net.wolf.jcadv.lesson8.spring.service.MessageSender;
import net.wolf.jcadv.lesson8.spring.service.WelcomeService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Конфигурационный класс Spring IoC контейнера
 * 
 * @author Andrey
 */
@Configuration
public class SimpleConfiguration {
    @Bean
    public Liberty liberty(){
        return new LibertyMan();
    }
    @Bean
    public RubberQuality rubberQuality(){
        return new Rubber();
    }
    @Bean WheelSize wheelSize(Rubber rubber){
        return new Wheel(rubber);
    }
    @Bean
    public CarRepository carRepository(Wheel wheel){
        return new MyCar(wheel);
    }
    @Bean
    public MessageSender messageSender() {
        return new DefaultMessageSender();
    }
    
    @Bean
    public WelcomeService welcomeService(DefaultMessageSender messageSender) {
        return new DefaultWelcomeService(messageSender);
    }
    
}
