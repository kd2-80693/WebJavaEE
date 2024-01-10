package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration //equivalent to bean config xml 
@ComponentScan(basePackages = {"dependent","dependency"})
public class AppConfiguration {

}
