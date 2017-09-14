package com.codexa.data.coapserver.data;


import java.io.Serializable;
import java.util.UUID;

/**
 * Created by peter on 26.7.2017.
 */
public class SensorDataEntity implements Comparable, Serializable {

    private static final long serialVersionUID = 308933809830675395L;

    private String id;

    private String deviceId;

    private String timestamp;

    private String type;

    private String value;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof SensorDataEntity) {
            return this.id.compareTo(((SensorDataEntity)o).getId());
        } else {
            return 0;
        }
    }
}