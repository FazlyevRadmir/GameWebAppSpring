package com.fazlyev.repository;

import com.fazlyev.model.Games;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameShopRepository extends JpaRepository<Games, Long> {
}
