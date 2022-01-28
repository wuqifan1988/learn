package com.example.learn.ddd.example.cargo.domain.infrastructure.repository;

import com.example.learn.ddd.example.cargo.domain.entity.Customer;

/**
 * @author xiuce
 * @version 1.0
 * @date 2022/1/10 2:02 下午
 */
public interface CustomerRepository {

    Customer findByCustomerId(String customerId);

    Customer findByName(String name);

    Customer findByCargoTracingId(String tracingId);
}
