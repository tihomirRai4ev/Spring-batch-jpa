package com.traychev.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author tihom
 *
 */
@Repository
public interface CrossingsRepository extends JpaRepository<Crossings, Long> {

	Page<Crossings> findById(Long id, Pageable pageable);

}
