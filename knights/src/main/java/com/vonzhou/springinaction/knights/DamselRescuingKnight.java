package com.vonzhou.springinaction.knights;


/**
 * damsel : 少女
 */
public class DamselRescuingKnight implements Knight {
  private RescueDamselQuest quest;
  
  public DamselRescuingKnight() {
    // 与RescueDamselQuest耦合紧密
    quest = new RescueDamselQuest(); //<co id="co_coupledToQuest"/>
  }
  
  public void embarkOnQuest() throws QuestException {
    quest.embark();
  }
}
