package com.pinktarr.Main;

public enum LightSpeedProjectileGameruleValues {
	OFF(1/1.4),
	SLOW(0.9),
	NORMAL(1.0),
	FAST(1.5);
	
	
	private final double value;

	LightSpeedProjectileGameruleValues(double value) {
        this.value = value;
    }
	
	public double getValue() {
        return value;
    }
}
