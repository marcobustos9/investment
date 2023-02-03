package com.test.mx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class ApplicationStarter {

  public static void main(String[] args) {
    SpringApplication.run(ApplicationStarter.class, args);
  }

}
