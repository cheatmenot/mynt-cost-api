package com.example.myntcostapi.services;

import com.example.myntcostapi.client.VoucherClient;
import com.example.myntcostapi.engine.RulesEngine;
import com.example.myntcostapi.model.Parcel;
import com.example.myntcostapi.model.VoucherDetails;
import com.example.myntcostapi.response.CostResponse;
import com.example.myntcostapi.utils.ParcelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

@Component
public class DeliveryCostService {

  private final RulesEngine rulesEngine;

  private final VoucherClient voucherClient;

  @Autowired
  public DeliveryCostService(RulesEngine rulesEngine, VoucherClient voucherClient){
    this.rulesEngine = rulesEngine;
    this.voucherClient = voucherClient;
  }

  public CostResponse calculateCost(Parcel parcel){
    CostResponse response = new CostResponse();
    Double cost = rulesEngine.calculateCost(parcel);
    response.setCost(cost);
    response.setVolume(ParcelUtils.getVolume(parcel));
    response.setWeight(parcel.getWeight());
    if (ObjectUtils.isEmpty(parcel.getVoucherCode())){
      return response;
    }
    else {
      VoucherDetails voucherDetails = voucherClient.getVoucherDetails(parcel.getVoucherCode());
      System.out.println(voucherDetails);
      response.setDiscounted(true);
      response.setOriginalCost(cost);
      response.setDiscount(voucherDetails.getDiscount());
      response.setCost(cost - voucherDetails.getDiscount());
      return response;
    }

  }

}
