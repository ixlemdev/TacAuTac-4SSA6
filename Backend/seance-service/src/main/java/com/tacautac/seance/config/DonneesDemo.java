package com.tacautac.seance.config;

import com.tacautac.seance.entity.Enregistrement;
import com.tacautac.seance.entity.FormatAudio;
import com.tacautac.seance.entity.Langue;
import com.tacautac.seance.entity.NiveauCecrl;
import com.tacautac.seance.entity.SeanceEntrainement;
import com.tacautac.seance.entity.StatutAnalyse;
import com.tacautac.seance.entity.StatutSeance;
import com.tacautac.seance.repository.EnregistrementRepository;
import com.tacautac.seance.repository.SeanceRepository;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/** Données de démonstration, insérées au premier démarrage (base vide). */
@Configuration
public class DonneesDemo {

    @Bean
    CommandLineRunner chargerSeances(SeanceRepository seances, EnregistrementRepository enregistrements) {
        return args -> {
            if (seances.count() > 0) {
                return;
            }
            LocalDateTime maintenant = LocalDateTime.now();
            SeanceEntrainement s1 = seances.save(new SeanceEntrainement(Ids.APPRENANT_1, 1L, Langue.FR, NiveauCecrl.B2,
                    StatutSeance.ANALYSEE, maintenant.minusDays(2)));
            SeanceEntrainement s2 = seances.save(new SeanceEntrainement(Ids.APPRENANT_1, 2L, Langue.FR, NiveauCecrl.B2,
                    StatutSeance.EN_ANALYSE, maintenant.minusMinutes(5)));
            SeanceEntrainement s3 = seances.save(new SeanceEntrainement(Ids.APPRENANT_2, 4L, Langue.EN, NiveauCecrl.C1,
                    StatutSeance.ANALYSEE, maintenant.minusDays(1)));
            enregistrements.saveAll(List.of(
                    new Enregistrement(s1, "a1b2c3d4-0001/1.webm", FormatAudio.WEBM, 58, 940_000L,
                            maintenant.minusDays(2), StatutAnalyse.TERMINEE, "demo-analyse-1", 68.5),
                    new Enregistrement(s2, "a1b2c3d4-0001/2.webm", FormatAudio.WEBM, 47, 760_000L,
                            maintenant.minusMinutes(4), StatutAnalyse.EN_ATTENTE, null, null),
                    new Enregistrement(s3, "a1b2c3d4-0002/1.webm", FormatAudio.WEBM, 60, 980_000L,
                            maintenant.minusDays(1), StatutAnalyse.TERMINEE, "demo-analyse-2", 74.0)));
        };
    }
}
