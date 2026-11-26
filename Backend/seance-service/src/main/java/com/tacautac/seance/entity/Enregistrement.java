package com.tacautac.seance.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

/** Enregistrement audio déposé dans une séance ; le fichier est sur disque, la base garde ses métadonnées. */
@Entity
@Table(name = "enregistrement")
public class Enregistrement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "seance_id", nullable = false)
    private SeanceEntrainement seance;

    private String cheminFichier;

    @Enumerated(EnumType.STRING)
    private FormatAudio format;

    private Integer dureeSec;

    private Long tailleOctets;

    private LocalDateTime dateDepot;

    @Enumerated(EnumType.STRING)
    private StatutAnalyse statutAnalyse = StatutAnalyse.EN_ATTENTE;

    private String analyseId;

    private Double scoreGlobal;

    protected Enregistrement() {
    }

    public Enregistrement(SeanceEntrainement seance, String cheminFichier, FormatAudio format, Integer dureeSec,
                          Long tailleOctets, LocalDateTime dateDepot, StatutAnalyse statutAnalyse,
                          String analyseId, Double scoreGlobal) {
        this.seance = seance;
        this.cheminFichier = cheminFichier;
        this.format = format;
        this.dureeSec = dureeSec;
        this.tailleOctets = tailleOctets;
        this.dateDepot = dateDepot;
        this.statutAnalyse = statutAnalyse;
        this.analyseId = analyseId;
        this.scoreGlobal = scoreGlobal;
    }

    public Long getId() { return id; }
    public Long getSeanceId() { return seance.getId(); }
    public String getCheminFichier() { return cheminFichier; }
    public FormatAudio getFormat() { return format; }
    public Integer getDureeSec() { return dureeSec; }
    public Long getTailleOctets() { return tailleOctets; }
    public LocalDateTime getDateDepot() { return dateDepot; }
    public StatutAnalyse getStatutAnalyse() { return statutAnalyse; }
    public String getAnalyseId() { return analyseId; }
    public Double getScoreGlobal() { return scoreGlobal; }
}
