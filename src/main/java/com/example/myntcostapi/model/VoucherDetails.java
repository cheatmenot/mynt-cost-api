package com.example.myntcostapi.model;

import java.time.LocalDate;

public class VoucherDetails {

  private String code;
  private Double discount;
  private LocalDate expiry;

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public Double getDiscount() {
    return discount;
  }

  public void setDiscount(Double discount) {
    this.discount = discount;
  }

  public LocalDate getExpiry() {
    return expiry;
  }

  public void setExpiry(LocalDate expiry) {
    this.expiry = expiry;
  }

  @Override
  public String toString() {
    return "VoucherDetails{" +
        "code='" + code + '\'' +
        ", discount=" + discount +
        ", expiry=" + expiry +
        '}';
  }
}
