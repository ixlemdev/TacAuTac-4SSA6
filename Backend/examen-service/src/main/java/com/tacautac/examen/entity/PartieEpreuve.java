
package com.tacautac.examen.entity;

import com.tacautac.examen.enums.TypePartie;
import jakarta.persistence.*;

@Entity
@Table(name = "partie_epreuve")
public class PartieEpreuve {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TypePartie type;

    @Column(nullable = false)
    private Integer ordre;

    private Long enregistrementId;

    private Long analyseId;

    private Double score;

    private Boolean scoreValide = false;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "session_examen_id", nullable = false)
    private SessionExamen sessionExamen;

    public PartieEpreuve() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TypePartie getType() {
        return type;
    }

    public void setType(TypePartie type) {
        this.type = type;
    }

    public Integer getOrdre() {
        return ordre;
    }

    public void setOrdre(Integer ordre) {
        this.ordre = ordre;
    }

    public Long getEnregistrementId() {
        return enregistrementId;
    }

    public void setEnregistrementId(Long enregistrementId) {
        this.enregistrementId = enregistrementId;
    }

    public Long getAnalyseId() {
        return analyseId;
    }

    public void setAnalyseId(Long analyseId) {
        this.analyseId = analyseId;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Boolean getScoreValide() {
        return scoreValide;
    }

    public void setScoreValide(Boolean scoreValide) {
        this.scoreValide = scoreValide;
    }

    public SessionExamen getSessionExamen() {
        return sessionExamen;
    }

    public void setSessionExamen(SessionExamen sessionExamen) {
        this.sessionExamen = sessionExamen;
    }
}
