package com.vonzhou.springinaction.springidol;


/**
 * 会朗诵诗歌的杂技人
 */
public class PoeticJuggler extends Juggler {
    private Poem poem;

    public PoeticJuggler(Poem poem) {  //注入Poem
        super();
        this.poem = poem;
    }

    public PoeticJuggler(int beanBags, Poem poem) { // 注入扔豆子个数 和 Poem
        super(beanBags);
        this.poem = poem;
    }

    public void perform() throws PerformanceException {
        super.perform();
        System.out.println("While reciting...");
        poem.recite();
    }
}
