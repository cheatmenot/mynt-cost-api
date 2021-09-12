package com.example.myntcostapi.client;

import com.example.myntcostapi.model.VoucherDetails;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Component
public class VoucherClient {

  private static RestTemplate restTemplate = new RestTemplate();

  public VoucherDetails getVoucherDetails(String voucher) {
    try {
      HttpHeaders headers = new HttpHeaders();
      headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
      HttpEntity<String> entity = new HttpEntity<>(headers);

      System.out.println("https://mynt-exam.mocklab.io/voucher/" + voucher + "?key=apikey");
      ResponseEntity<VoucherDetails> result = restTemplate.exchange("https://mynt-exam.mocklab.io/voucher/" + voucher + "?key=apikey",
          HttpMethod.GET, entity, VoucherDetails.class);

      System.out.println(result);
      return result.getBody();
    } catch (Exception e) {
      throw new RuntimeException("Error on getting voucher details: " + e.getMessage());
    }
  }
}
