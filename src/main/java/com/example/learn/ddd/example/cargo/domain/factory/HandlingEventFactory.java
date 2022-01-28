package com.example.learn.ddd.example.cargo.domain.factory;

import com.example.learn.ddd.example.cargo.domain.entity.Cargo;
import com.example.learn.ddd.example.cargo.domain.entity.CarrierMovement;
import com.example.learn.ddd.example.cargo.domain.entity.HandlingEvent;
import com.example.learn.ddd.example.cargo.domain.enums.HandlingEventTypeEnum;

import java.util.Date;

/**
 * @author xiuce
 * @version 1.0
 * @date 2022/1/4 2:56 下午
 */
public class HandlingEventFactory {

    public static HandlingEvent newLoading(Cargo cargo, CarrierMovement loadedOnto, Date arrivalTime){
        HandlingEvent result = new HandlingEvent(cargo,arrivalTime, HandlingEventTypeEnum.LOADING_EVENT);
        result.setCarrierMovement(loadedOnto);
        return result;
    }

}
