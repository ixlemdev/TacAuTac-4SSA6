package com.tacautac.seance.controller;

import com.tacautac.seance.entity.Enregistrement;
import com.tacautac.seance.entity.SeanceEntrainement;
import com.tacautac.seance.entity.StatutSeance;
import com.tacautac.seance.repository.EnregistrementRepository;
import com.tacautac.seance.repository.SeanceRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api")
@Tag(name = "Séances", description = "MS3 : séances d'entraînement et enregistrements audio")
public class SeanceController {

    private final SeanceRepository seances;
    private final EnregistrementRepository enregistrements;

    public SeanceController(SeanceRepository seances, EnregistrementRepository enregistrements) {
        this.seances = seances;
        this.enregistrements = enregistrements;
    }

    @GetMapping("/seances")
    @Operation(summary = "Historique des séances d'un apprenant, avec un filtre facultatif par statut")
    public List<SeanceEntrainement> historique(@RequestParam(required = false) String apprenantId,
                                               @RequestParam(required = false) StatutSeance statut) {
        if (apprenantId == null) {
            return seances.findAll();
        }
        return statut == null
                ? seances.findByApprenantIdOrderByDateDebutDesc(apprenantId)
                : seances.findByApprenantIdAndStatutOrderByDateDebutDesc(apprenantId, statut);
    }

    @GetMapping("/seances/{id}")
    @Operation(summary = "État d'une séance")
    public SeanceEntrainement consulter(@PathVariable Long id) {
        return seances.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Séance introuvable : " + id));
    }

    @GetMapping("/seances/{id}/enregistrements")
    @Transactional(readOnly = true)
    @Operation(summary = "Enregistrements d'une séance et leur statut d'analyse")
    public List<Enregistrement> enregistrementsDeLaSeance(@PathVariable Long id) {
        if (!seances.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Séance introuvable : " + id);
        }
        return enregistrements.findBySeance_IdOrderByDateDepotAsc(id);
    }

    @GetMapping("/enregistrements/{id}")
    @Transactional(readOnly = true)
    @Operation(summary = "Métadonnées d'un enregistrement (durée, format, statut d'analyse, score)")
    public Enregistrement enregistrement(@PathVariable Long id) {
        return enregistrements.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Enregistrement introuvable : " + id));
    }
}
