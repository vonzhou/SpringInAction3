package com.vonzhou.springinaction.springidol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("eddie")
@Qualifier("guitar")
public class Instrumentalist implements Performer {
  // ...
  public void perform() throws PerformanceException {
    instrument.play();
  }

  @Autowired
  private Instrument instrument;


  public Instrument getInstrument() {
    return instrument;
  }

  public void setInstrument(Instrument instrument) {
    this.instrument = instrument;
  }
}
