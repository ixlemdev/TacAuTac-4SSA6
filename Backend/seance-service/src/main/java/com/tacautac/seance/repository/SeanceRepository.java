package com.tacautac.seance.repository;

import com.tacautac.seance.entity.SeanceEntrainement;
import com.tacautac.seance.entity.StatutSeance;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeanceRepository extends JpaRepository<SeanceEntrainement, Long> {

    List<SeanceEntrainement> findByApprenantIdOrderByDateDebutDesc(String apprenantId);

    List<SeanceEntrainement> findByApprenantIdAndStatutOrderByDateDebutDesc(String apprenantId, StatutSeance statut);
}
