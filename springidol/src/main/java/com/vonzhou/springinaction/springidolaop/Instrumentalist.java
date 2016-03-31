package com.vonzhou.springinaction.springidolaop;

/**
 * 音乐演奏家, 演示setter注入
 */
public class Instrumentalist implements Performer {
  public Instrumentalist() {
  }

  public void perform() throws PerformanceException {
    System.out.print("Playing " + song + " : ");
    instrument.play();
  }

  private String song;

  public void setSong(String song) { //注入song
    this.song = song;
  }

  public String getSong() {
    return song;
  }

  public String screamSong() {
    return song;
  }

  private Instrument instrument;

  public void setInstrument(Instrument instrument) { // 注入 instrument
    this.instrument = instrument;
  }
}
