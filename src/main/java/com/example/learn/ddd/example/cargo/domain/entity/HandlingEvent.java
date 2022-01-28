package com.example.learn.ddd.example.cargo.domain.entity;

import com.example.learn.ddd.example.cargo.domain.enums.HandlingEventTypeEnum;

import java.util.Date;
import java.util.List;

/**
 * @author xiuce
 * @version 1.0
 * @date 2022/1/4 2:44 下午
 */
public class HandlingEvent {

    private Cargo cargo;
    private Date arrivalTime;
    private HandlingEventTypeEnum eventType;

    private CarrierMovement carrierMovement;


    public HandlingEvent(Cargo cargo, Date arrivalTime, HandlingEventTypeEnum eventType) {
        this.cargo = cargo;
        this.arrivalTime = arrivalTime;
        this.eventType = eventType;
    }

    public void setCarrierMovement(CarrierMovement carrierMovement){
        this.carrierMovement = carrierMovement;
    }

}
