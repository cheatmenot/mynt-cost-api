package com.example.myntcostapi.model;

import com.example.myntcostapi.interfaces.Rule;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

public class Rules {

  public Rules(){
    rulesMap = new HashMap<>();
    count = 0;
  }

  private Integer count;
  private Map<Integer, Rule> rulesMap;

  public Map<Integer, Rule> getRulesMap() {
    return rulesMap;
  }

  public void addRule(Rule rule){
    this.count = this.count + 1;
    this.rulesMap.put(this.count, rule);
  }

}
