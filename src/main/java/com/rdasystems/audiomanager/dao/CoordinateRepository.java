package com.rdasystems.audiomanager.dao;

import com.rdasystems.audiomanager.model.Coordinate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoordinateRepository extends JpaRepository<Coordinate,Long> {
}
