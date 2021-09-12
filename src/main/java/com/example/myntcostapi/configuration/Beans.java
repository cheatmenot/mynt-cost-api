package com.example.myntcostapi.configuration;

import com.example.myntcostapi.engine.RulesEngine;
import com.example.myntcostapi.model.Rules;
import com.example.myntcostapi.rules.HeavyParcel;
import com.example.myntcostapi.rules.LargeParcel;
import com.example.myntcostapi.rules.MediumParcel;
import com.example.myntcostapi.rules.Reject;
import com.example.myntcostapi.rules.SmallParcel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Beans {

  @Bean
  public RulesEngine createRulesEngine(){
    Rules rules = new Rules();
    rules.addRule(new Reject());
    rules.addRule(new HeavyParcel());
    rules.addRule(new SmallParcel());
    rules.addRule(new MediumParcel());
    rules.addRule(new LargeParcel());
    return new RulesEngine(rules);
  }

}
