package com.example.learn.ddd.example.cargo.domain.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiuce
 * @version 1.0
 * @date 2022/1/4 2:45 下午
 */
public class DeliveryHistory {

    private Cargo cargo;

    private List<HandlingEvent> eventList;

    public DeliveryHistory(Cargo cargo) {
        this.cargo = cargo;
        eventList = new ArrayList<>();
    }

    public void addEvent(HandlingEvent event) {
        eventList.add(event);
    }

    public List<HandlingEvent> getEventList(){
        return eventList;
    }
}
