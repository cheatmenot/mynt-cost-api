package com.example.myntcostapi.interfaces;

import com.example.myntcostapi.model.Parcel;

public interface Rule {

  public boolean isTrue(Parcel parcel);

  public double calculateCost(Parcel parcel);

  public boolean isRejected();

}
