package com.example.learn.ddd.example.cargo.domain.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xiuce
 * @version 1.0
 * @date 2022/1/4 2:44 下午
 */
public class Cargo {

    private String tracingId;
    private DeliveryHistory deliveryHistory;
    private Map customerRoles;

    public Cargo(String tracingId) {
        this.tracingId = tracingId;
        this.deliveryHistory = new DeliveryHistory(this);
        customerRoles = new HashMap();
    }

    public Cargo copyPrototype(String newTracingId) {
        return new Cargo(newTracingId);
    }
}
