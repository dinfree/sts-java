package com.dinfree.java.basic;

public class Gun {
    private String model;       // model name of gun
    protected int bulletCount;    // total count of bullet

    public void fire() {
        System.out.println("=>");
        bulletCount -= 1;
    }

    public Gun() {
        bulletCount = 10;
    }

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getBulletCount() {
		return bulletCount;
	}

	public void setBulletCount(int bulletCount) {
		this.bulletCount = bulletCount;
	}
}
