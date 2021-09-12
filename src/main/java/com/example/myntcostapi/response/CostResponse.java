package com.example.myntcostapi.response;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CostResponse {

  private Double weight;

  private Double volume;

  private Double cost;

  private Double originalCost;

  private Boolean isDiscounted;

  private Double discount;

  public Double getWeight() {
    return weight;
  }

  public void setWeight(Double weight) {
    this.weight = weight;
  }

  public Double getVolume() {
    return volume;
  }

  public void setVolume(Double volume) {
    this.volume = volume;
  }

  public Double getCost() {
    return cost;
  }

  public void setCost(Double cost) {
    this.cost = cost;
  }

  public Double getOriginalCost() {
    return originalCost;
  }

  public void setOriginalCost(Double originalCost) {
    this.originalCost = originalCost;
  }

  public Boolean getDiscounted() {
    return isDiscounted;
  }

  public void setDiscounted(Boolean discounted) {
    isDiscounted = discounted;
  }

  public Double getDiscount() {
    return discount;
  }

  public void setDiscount(Double discount) {
    this.discount = discount;
  }

  @Override
  public String toString() {
    return "CostResponse{" +
        "weight=" + weight +
        ", volume=" + volume +
        ", cost=" + cost +
        ", originalCost=" + originalCost +
        ", isDiscounted=" + isDiscounted +
        ", discount=" + discount +
        '}';
  }
}
