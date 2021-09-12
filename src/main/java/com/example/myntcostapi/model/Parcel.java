package com.example.myntcostapi.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Parcel {

  @NotNull
  private Double weight;

  @NotNull
  private Double height;

  @NotNull
  private Double width;

  @NotNull
  private Double length;

  private String voucherCode;

  public Double getWeight() {
    return weight;
  }

  public void setWeight(Double weight) {
    this.weight = weight;
  }

  public Double getHeight() {
    return height;
  }

  public void setHeight(Double height) {
    this.height = height;
  }

  public Double getWidth() {
    return width;
  }

  public void setWidth(Double width) {
    this.width = width;
  }

  public Double getLength() {
    return length;
  }

  public void setLength(Double length) {
    this.length = length;
  }

  public String getVoucherCode() {
    return voucherCode;
  }

  public void setVoucherCode(String voucherCode) {
    this.voucherCode = voucherCode;
  }

  @Override
  public String toString() {
    return "Parcel{" +
        "weight=" + weight +
        ", height=" + height +
        ", width=" + width +
        ", length=" + length +
        ", voucherCode= " + voucherCode +
        '}';
  }
}
