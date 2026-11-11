
package com.tacautac.examen.entity;

import com.tacautac.examen.enums.StatutExamen;
import jakarta.persistence.*;
import com.tacautac.examen.enums.Langue;
import com.tacautac.examen.enums.NiveauCecrl;

import java.time.LocalDateTime;

@Entity
@Table(name = "session_examen")
public class SessionExamen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String apprenantId;

    @Column(nullable = false)
    private String certification;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Langue langue;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private NiveauCecrl niveauVise;

    private Long sujetId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatutExamen statut = StatutExamen.PREPARATION;

    private LocalDateTime debutPreparation;

    private LocalDateTime debutPassage;

    private LocalDateTime dateFin;

    private Double noteEstimee;

    @Enumerated(EnumType.STRING)
    private NiveauCecrl niveauAtteint;

    public SessionExamen() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getApprenantId() {
        return apprenantId;
    }

    public void setApprenantId(String apprenantId) {
        this.apprenantId = apprenantId;
    }

    public String getCertification() {
        return certification;
    }

    public void setCertification(String certification) {
        this.certification = certification;
    }

    public Langue getLangue() {
        return langue;
    }

    public void setLangue(Langue langue) {
        this.langue = langue;
    }

    public NiveauCecrl getNiveauVise() {
        return niveauVise;
    }

    public void setNiveauVise(NiveauCecrl niveauVise) {
        this.niveauVise = niveauVise;
    }

    public Long getSujetId() {
        return sujetId;
    }

    public void setSujetId(Long sujetId) {
        this.sujetId = sujetId;
    }

    public StatutExamen getStatut() {
        return statut;
    }

    public void setStatut(StatutExamen statut) {
        this.statut = statut;
    }

    public LocalDateTime getDebutPreparation() {
        return debutPreparation;
    }

    public void setDebutPreparation(LocalDateTime debutPreparation) {
        this.debutPreparation = debutPreparation;
    }

    public LocalDateTime getDebutPassage() {
        return debutPassage;
    }

    public void setDebutPassage(LocalDateTime debutPassage) {
        this.debutPassage = debutPassage;
    }

    public LocalDateTime getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDateTime dateFin) {
        this.dateFin = dateFin;
    }

    public Double getNoteEstimee() {
        return noteEstimee;
    }

    public void setNoteEstimee(Double noteEstimee) {
        this.noteEstimee = noteEstimee;
    }

    public NiveauCecrl getNiveauAtteint() {
        return niveauAtteint;
    }

    public void setNiveauAtteint(NiveauCecrl niveauAtteint) {
        this.niveauAtteint = niveauAtteint;
    }
}
