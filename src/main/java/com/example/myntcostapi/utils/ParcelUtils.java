package com.example.myntcostapi.utils;

import com.example.myntcostapi.model.Parcel;

public class ParcelUtils {

  public static Double getVolume(Parcel parcel){
    return parcel.getHeight() * parcel.getWidth() * parcel.getLength();
  }

}
