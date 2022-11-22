package com.rdasystems.audiomanager.dao;

import com.rdasystems.audiomanager.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Integer> {
}
