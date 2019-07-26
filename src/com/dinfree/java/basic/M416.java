package com.dinfree.java.basic;

public class M416 extends Gun {
    public void fire() {
        System.out.println("=> => => => =>");
        bulletCount -= 5;
    }

    public M416() {
        bulletCount = 40;
    }	
}
