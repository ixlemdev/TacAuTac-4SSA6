package com.tacautac.seance.repository;

import com.tacautac.seance.entity.Enregistrement;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnregistrementRepository extends JpaRepository<Enregistrement, Long> {

    List<Enregistrement> findBySeance_IdOrderByDateDepotAsc(Long seanceId);
}
