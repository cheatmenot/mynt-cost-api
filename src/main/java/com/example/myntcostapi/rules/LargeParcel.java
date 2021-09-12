package com.example.myntcostapi.rules;

import com.example.myntcostapi.interfaces.Rule;
import com.example.myntcostapi.model.Parcel;
import com.example.myntcostapi.utils.ParcelUtils;

public class LargeParcel implements Rule {

  @Override
  public boolean isTrue(Parcel parcel) {
    return true;
  }

  @Override
  public double calculateCost(Parcel parcel) {
    double volume = ParcelUtils.getVolume(parcel);
    return volume * 0.05;
  }

  @Override
  public boolean isRejected() {
    return false;
  }
}
