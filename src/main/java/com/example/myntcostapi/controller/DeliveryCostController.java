package com.example.myntcostapi.controller;

import com.example.myntcostapi.model.Parcel;
import com.example.myntcostapi.response.CostResponse;
import com.example.myntcostapi.services.DeliveryCostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.ValidationException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/deliveryCost")
public class DeliveryCostController {

  private final DeliveryCostService deliveryCostService;

  @Autowired
  public DeliveryCostController(DeliveryCostService deliveryCostService){
    this.deliveryCostService = deliveryCostService;
  }

  @PostMapping
  public ResponseEntity<CostResponse> post(
      @Valid @RequestBody Parcel parcel,
      BindingResult result
  ){
    if (result.hasErrors()){
      HashMap<String, String> hashMap = (HashMap<String, String>)result.getFieldErrors()
          .stream()
          .collect(Collectors.toMap(FieldError::getField, DefaultMessageSourceResolvable::getDefaultMessage));
      throw new ValidationException(getFieldErrorsAsString(hashMap));
    }
    CostResponse response = deliveryCostService.calculateCost(parcel);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  private String getFieldErrorsAsString(HashMap<String, String> map) {
    return (String)map.entrySet().stream().map((x) -> {
      return ((String)x.getKey()).concat(" ").concat((String)x.getValue());
    }).collect(Collectors.joining("; ", "[", "]"));
  }

}
