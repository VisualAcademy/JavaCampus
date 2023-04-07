package com.hawaso.javacampus.repositories.buffets;

import com.hawaso.javacampus.models.buffets.Garnish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GarnishRepository extends JpaRepository<Garnish, Integer> {
}
