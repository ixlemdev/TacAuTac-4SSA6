package com.tacautac.seance.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

/** Séance d'entraînement oral sur un sujet de MS2. */
@Entity
@Table(name = "seance_entrainement")
public class SeanceEntrainement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String apprenantId;

    @Column(nullable = false)
    private Long sujetId;

    @Enumerated(EnumType.STRING)
    private Langue langue;

    @Enumerated(EnumType.STRING)
    private NiveauCecrl niveau;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ContexteSeance contexte = ContexteSeance.ENTRAINEMENT;

    private Long examenId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatutSeance statut = StatutSeance.EN_COURS;

    private LocalDateTime dateDebut;

    private LocalDateTime dateFin;

    protected SeanceEntrainement() {
    }

    public SeanceEntrainement(String apprenantId, Long sujetId, Langue langue, NiveauCecrl niveau,
                              StatutSeance statut, LocalDateTime dateDebut) {
        this.apprenantId = apprenantId;
        this.sujetId = sujetId;
        this.langue = langue;
        this.niveau = niveau;
        this.statut = statut;
        this.dateDebut = dateDebut;
    }

    public Long getId() { return id; }
    public String getApprenantId() { return apprenantId; }
    public Long getSujetId() { return sujetId; }
    public Langue getLangue() { return langue; }
    public NiveauCecrl getNiveau() { return niveau; }
    public ContexteSeance getContexte() { return contexte; }
    public Long getExamenId() { return examenId; }
    public StatutSeance getStatut() { return statut; }
    public LocalDateTime getDateDebut() { return dateDebut; }
    public LocalDateTime getDateFin() { return dateFin; }
}
