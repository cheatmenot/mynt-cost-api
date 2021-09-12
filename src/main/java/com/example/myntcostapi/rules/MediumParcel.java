package com.example.myntcostapi.rules;

import com.example.myntcostapi.interfaces.Rule;
import com.example.myntcostapi.model.Parcel;
import com.example.myntcostapi.utils.ParcelUtils;

public class MediumParcel implements Rule {

  @Override
  public boolean isTrue(Parcel parcel) {
    double volume = ParcelUtils.getVolume(parcel);
    return volume < 2500;
  }

  @Override
  public double calculateCost(Parcel parcel) {
    double volume = ParcelUtils.getVolume(parcel);
    return volume * 0.04;
  }

  @Override
  public boolean isRejected() {
    return false;
  }
}
