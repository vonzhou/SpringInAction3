package com.vonzhou.springinaction.springidol;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringIdolConfig {
  @Bean
  public Performer duke() {
    return new Juggler();
  }

  @Bean
  public Performer duke15() {
    return new Juggler(15);
  }


  @Bean
  public Performer poeticDuke() {
    return new PoeticJuggler(15, sonnet29());
  }

  @Bean
  private Poem sonnet29() {
    return new Sonnet29();
  }
}
