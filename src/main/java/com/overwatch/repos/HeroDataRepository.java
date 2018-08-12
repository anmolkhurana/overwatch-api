package com.overwatch.repos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.overwatch.domain.HeroData;

public interface HeroDataRepository extends JpaRepository<HeroData, Long> {
		Page<HeroData> findByHeroId(Long heroId, Pageable pageable);
}
