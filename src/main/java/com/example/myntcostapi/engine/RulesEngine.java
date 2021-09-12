package com.example.myntcostapi.engine;

import com.example.myntcostapi.interfaces.Rule;
import com.example.myntcostapi.model.Parcel;
import com.example.myntcostapi.model.Rules;

public class RulesEngine {

  private final Rules rules;

  public RulesEngine(Rules rules){
    this.rules = rules;
  }

  public Double calculateCost(Parcel parcel){
    for (int i = 1; i <= rules.getRulesMap().size(); i++){
      Rule rule = rules.getRulesMap().get(i);
      if(rule.isTrue(parcel)){
        if(rule.isRejected()){
          throw new RuntimeException("Rejected - Parcel exceed 50kgs");
        }
        else {
          System.out.println("Rule Matched: " + rule.getClass().getName());
          return rule.calculateCost(parcel);
        }
      }
    }
    throw new RuntimeException("No rules matched");
  }

}
