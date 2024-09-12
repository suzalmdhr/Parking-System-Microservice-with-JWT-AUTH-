package com.slot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.slot.entity.Slot;

public interface SlotDao extends JpaRepository<Slot,Integer> {

}
