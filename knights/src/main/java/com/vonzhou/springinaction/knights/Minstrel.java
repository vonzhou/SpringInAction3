package com.vonzhou.springinaction.knights;

/**
 * Minstrel 吟游诗人 作为骑士的一个切面
 */
public class Minstrel {
    public void singBeforeQuest() {
        System.out.println("Fa la la; The knight is so brave!");
    }

    public void singAfterQuest() {
        System.out.println("Tee hee he; The brave knight did embark on a quest!");
    }
}
