package com.example.learn.ddd.example.cargo.domain.factory;

import com.example.learn.ddd.example.cargo.domain.entity.Cargo;

import java.util.UUID;

/**
 * @author xiuce
 * @version 1.0
 * @date 2022/1/4 2:49 下午
 */
public class CargoFactory {


    public Cargo newCargo(Cargo prototype) {
        return new Cargo(UUID.randomUUID().toString());
    }
}
