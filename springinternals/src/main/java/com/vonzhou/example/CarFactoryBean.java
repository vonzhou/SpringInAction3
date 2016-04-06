package com.vonzhou.example;

import org.springframework.beans.factory.FactoryBean;

/**
 * Created by vonzhou on 16/4/3.
 */
public class CarFactoryBean implements FactoryBean{
    private String carInfo = "BMW,500,300000";

    public Object getObject() throws Exception {
        Car car = new Car();
        String[] infos = carInfo.split(",");
        car.setBrand(infos[0]);
        car.setMaxSpeed(Integer.parseInt(infos[1]));
        car.setPrice(Double.valueOf(infos[2]));

        return car;
    }

    public Class<?> getObjectType() {
        return Car.class;
    }

    public boolean isSingleton() {
        return false;
    }

    public String getCarInfo() {
        return carInfo;
    }

    public void setCarInfo(String carInfo) {
        this.carInfo = carInfo;
    }
}
