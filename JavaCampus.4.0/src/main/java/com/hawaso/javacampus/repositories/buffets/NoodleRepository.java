package com.hawaso.javacampus.repositories.buffets;

import com.hawaso.javacampus.models.buffets.Noodle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoodleRepository extends JpaRepository<Noodle, Integer> {
}
