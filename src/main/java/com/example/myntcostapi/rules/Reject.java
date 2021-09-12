package com.example.myntcostapi.rules;

import com.example.myntcostapi.interfaces.Rule;
import com.example.myntcostapi.model.Parcel;

public class Reject implements Rule {

  @Override
  public boolean isTrue(Parcel parcel) {
    return parcel.getWeight() > 50d;
  }

  @Override
  public double calculateCost(Parcel parcel) {
    return 0;
  }

  @Override
  public boolean isRejected() {
    return true;
  }

}
