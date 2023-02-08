package com.test.mx.application.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.test.mx.application.dto.InitialInvestmentDto;
import com.test.mx.application.dto.InvestmentYieldDto;


public interface MiServicio {
  
  List<InvestmentYieldDto> createRevenueGrid(InitialInvestmentDto initialInvestment);
  
  boolean validateInput(InitialInvestmentDto input);

}
