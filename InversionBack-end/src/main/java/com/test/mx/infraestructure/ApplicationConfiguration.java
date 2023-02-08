package com.test.mx.infraestructure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.test.mx.application.service.MiServicio;
import com.test.mx.application.service.impl.MiServicioImpl;

@Configuration
public class ApplicationConfiguration {

  @Bean
  public MiServicio miServicio() {
    return new MiServicioImpl();
  }
}
