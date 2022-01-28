package com.example.learn.ddd.example.cargo.domain.infrastructure.repository;

import com.example.learn.ddd.example.cargo.domain.entity.HandlingEvent;

import java.util.Date;
import java.util.List;

/**
 * @author xiuce
 * @version 1.0
 * @date 2022/1/4 3:26 下午
 */
public interface HandlingEventRepository {

    HandlingEvent findByCargoIdTimeType(String id, Date date, String type);

    List<HandlingEvent> findByTraceId(String traceId);

    HandlingEvent findByScheduleId(String scheduleId);

    String findMostRecentCargoIdByType(String type);
}
