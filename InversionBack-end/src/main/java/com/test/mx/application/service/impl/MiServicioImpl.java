package com.test.mx.application.service.impl;

import java.util.ArrayList;
import java.util.List;
import com.test.mx.application.service.MiServicio;
import com.test.mx.application.dto.InvestmentYieldDto;
import com.test.mx.application.dto.InitialInvestmentDto;



public class MiServicioImpl implements MiServicio {
  
  @Override
  public List createRevenueGrid(InitialInvestmentDto initialInvestmentDto) {
    
    List <InvestmentYieldDto> investmentYieldDtoList = new ArrayList <InvestmentYieldDto>();

    InvestmentYieldDto investmentYieldDto = null;
    Float saldoInicial = 0.0f;
    Float saldoFinal = 0.0f;
    Float aportacion = 0.0f;
    Float rendimiento = 0f;

    for (int i = 0; i<initialInvestmentDto.getInvestmentYears (); i++) {

      investmentYieldDto=new InvestmentYieldDto();

    if (i==0) {
    saldoInicial=(float) initialInvestmentDto.getInitialInvestment()+saldoFinal;
    aportacion=(float) initialInvestmentDto.getYearlyInput();
    }else{
      saldoInicial= (float) saldoFinal;
      aportacion= (float) (aportacion*(1.0+(1.0/100.0f)));
    }

    
    rendimiento=  (float) ((saldoInicial+aportacion)*(initialInvestmentDto.getInvestmentYield()/100f));
     saldoFinal = (float) saldoInicial+aportacion+rendimiento;
  

    investmentYieldDto.setInvestmentYear(i+1);
    investmentYieldDto.setInitialInvestment(saldoInicial);
    investmentYieldDto.setYearlyInput(aportacion);
    investmentYieldDto.setInvestmentYield(rendimiento);
    investmentYieldDto.setFinalBalance(saldoFinal);
    investmentYieldDtoList.add(investmentYieldDto);
    
    }
    return investmentYieldDtoList;
  }

  @Override
  public boolean validateInput(InitialInvestmentDto input) {
    
    boolean regla = true;

    if(input.getInitialInvestment()==null||(String.valueOf(input.getInitialInvestment())==""||input.getInitialInvestment()<1000)
        
    ||(input.getYearlyInput()==null||input.getYearlyInput().equals("")||input.getYearlyInput()<0)

    ||(input.getYearlyInputIncrement()==null||input.getYearlyInputIncrement().equals("")||input.getYearlyInputIncrement()<0)

    ||(input.getInvestmentYears()==null||input.getInvestmentYears().equals("")||input.getInvestmentYears()<0)
    
    ||(input.getInvestmentYield()==null||input.getInvestmentYield().equals("")||input.getInvestmentYield()<0)){

    regla = false;

    }
    return regla;


  }

}
