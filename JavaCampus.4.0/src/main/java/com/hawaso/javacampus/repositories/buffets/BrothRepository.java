package com.hawaso.javacampus.repositories.buffets;

import com.hawaso.javacampus.models.buffets.Broth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrothRepository extends JpaRepository<Broth, Integer> {
}
