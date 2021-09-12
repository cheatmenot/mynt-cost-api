package com.example.myntcostapi.rules;

import com.example.myntcostapi.interfaces.Rule;
import com.example.myntcostapi.model.Parcel;

public class HeavyParcel implements Rule {

  @Override
  public boolean isTrue(Parcel parcel) {
    return parcel.getWeight() > 10d;
  }

  @Override
  public double calculateCost(Parcel parcel) {
    return parcel.getWeight() * 20;
  }

  @Override
  public boolean isRejected() {
    return false;
  }

}
