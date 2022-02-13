package com.meli.mutans.util;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import java.util.HashMap;

/**
 * Clase encargada de inyectar
 * las propiedades del archivo properties
 * mutans.properties
 *
 *@author eduardo guerere
 */
@Configuration
@ComponentScan(basePackages = "com.meli.mutans")
@PropertySource("classpath:mutans.properties")
public class PropertiesMutans {
        @Value("${number.of.words}")
        public String cantWords;
        @Value("${number.of.occurrences}")
        public String cantOccurrences;
        @Value("${supported.letters}")
        public String supportedLetters;

    @Bean
    public static PropertySourcesPlaceholderConfigurer getPropertySourcePlaceholderConfig() {
        PropertySourcesPlaceholderConfigurer ret = new PropertySourcesPlaceholderConfigurer();
        return ret;
    }

    @Bean
    public HashMap<String, String> getProperties() {
        HashMap<String,String> properties = new HashMap<String, String>();
        properties.put("number.of.words",cantWords);
        properties.put("cantOccurrences",cantOccurrences);
        properties.put("supported.letters",supportedLetters);
        return properties;
    }

}
