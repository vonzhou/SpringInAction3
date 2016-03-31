package com.vonzhou.springinaction.springidolaop;

import java.util.Map;


public class OneManBand2 implements Performer {
    public OneManBand2() {
    }

    public void perform() throws PerformanceException {
        for (String key : instruments.keySet()) {
            System.out.print(key + " : ");
            Instrument instrument = instruments.get(key);
            instrument.play();
        }
    }

    private Map<String, Instrument> instruments;

    public void setInstruments(Map<String, Instrument> instruments) {
        this.instruments = instruments; //<co id="co_injectInstrumentMap"/>
    }
}
