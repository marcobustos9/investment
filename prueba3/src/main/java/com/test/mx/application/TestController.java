package com.test.mx.application;

import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.test.mx.application.dto.InitialInvestmentDto;
import com.test.mx.application.dto.InvestmentYieldDto;
import com.test.mx.application.service.MiServicio;


@RestController
public class TestController {
  
  @Value("${testApplication.token:317d559c}")
  private String token;
  
  private MiServicio service;
  
  public TestController(MiServicio service) {
    this.service = service;
  }

   
    
  @PostMapping(value = "/api/v1/investmentFinal", 
      consumes = "application/json", 
      produces = "application/json")
  public ResponseEntity<List<InvestmentYieldDto>> postInvestmentFinal (
         @RequestBody InitialInvestmentDto investment) {
       
             
    boolean valida = true;
    
    
    if(investment!=null) {
    
    valida= service.validateInput(investment);
    
    }else {
      valida = false;
    }
    
    if(!valida) {
      throw new AuthorizationException("No es posible procesar su solicitud con los datos proporcionados");
     
     }
    
        
    return new ResponseEntity<>(service.createRevenueGrid(investment), HttpStatus.OK);
  }
  
 
   
    
}
