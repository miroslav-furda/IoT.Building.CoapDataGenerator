package com.codexa.data.coapserver.data;


/**
 * Created by peter on 28.7.2017.
 */
public class Data {

    public static SensorDataEntity getSensorMessage(String type, String value, String deviceId) {

        SensorDataEntity sensorDataEntity = new SensorDataEntity();
        sensorDataEntity.setId(String.valueOf(System.currentTimeMillis()));
        sensorDataEntity.setTimestamp(String.format("%s", System.currentTimeMillis()));
        sensorDataEntity.setType(type);
        sensorDataEntity.setValue(value);
        sensorDataEntity.setDeviceId(deviceId);
        return sensorDataEntity;
    }
}