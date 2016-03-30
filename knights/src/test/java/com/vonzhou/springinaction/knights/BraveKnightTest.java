package com.vonzhou.springinaction.knights;

import static org.mockito.Mockito.*;

import org.junit.Test;

public class BraveKnightTest {
    @Test
    public void knightShouldEmbarkOnQuest() throws QuestException {
        // mock一个Quest
        Quest mockQuest = mock(Quest.class);


        BraveKnight knight = new BraveKnight(mockQuest); //注入这个quest
        knight.embarkOnQuest();

        verify(mockQuest, times(1)).embark();
    }
}
