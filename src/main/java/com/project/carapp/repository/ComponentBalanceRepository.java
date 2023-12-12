package com.project.carapp.repository;

import com.project.carapp.entity.ComponentBalance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Repository
@Transactional
public interface ComponentBalanceRepository extends JpaRepository<ComponentBalance, Long> {
    @Query(value = "select new map(cb.component.id as componentId, cb.count as count) from ComponentBalance cb where cb.component.id in :componentIds")
    List<Map<String, Long>> findComponentBalancesByComponentId(@Param("componentIds") Set<Long> componentIds);

   @Query(value = "select count from component_balance where component_id = ?1 for update", nativeQuery = true)
   Long findCountByComponentId(Long componentId);

    @Modifying
    @Query(value = "update component_balance set count = ?2 where component_id = ?1", nativeQuery = true)
    void updateCountByComponentId(@Param("componentId") Long componentId, @Param("newCount") Long newCount);
}

