
package com.tacautac.examen.entity;

import com.tacautac.examen.enums.NiveauCecrl;
import com.tacautac.examen.enums.StatutAttestation;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(
    name = "attestation",
    uniqueConstraints = {
        @UniqueConstraint(
            name = "uk_attestation_code",
            columnNames = "code_verification"
        )
    }
)
public class Attestation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code_verification", nullable = false, unique = true)
    private String codeVerification;

    @Enumerated(EnumType.STRING)
    private NiveauCecrl niveauAtteint;

    private LocalDateTime dateEmission;

    private String mentionIndicative;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatutAttestation statut = StatutAttestation.VALIDE;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
        name = "session_examen_id",
        nullable = false,
        unique = true
    )
    private SessionExamen sessionExamen;

    public Attestation() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodeVerification() {
        return codeVerification;
    }

    public void setCodeVerification(String codeVerification) {
        this.codeVerification = codeVerification;
    }

    public NiveauCecrl getNiveauAtteint() {
        return niveauAtteint;
    }

    public void setNiveauAtteint(NiveauCecrl niveauAtteint) {
        this.niveauAtteint = niveauAtteint;
    }

    public LocalDateTime getDateEmission() {
        return dateEmission;
    }

    public void setDateEmission(LocalDateTime dateEmission) {
        this.dateEmission = dateEmission;
    }

    public String getMentionIndicative() {
        return mentionIndicative;
    }

    public void setMentionIndicative(String mentionIndicative) {
        this.mentionIndicative = mentionIndicative;
    }

    public StatutAttestation getStatut() {
        return statut;
    }

    public void setStatut(StatutAttestation statut) {
        this.statut = statut;
    }

    public SessionExamen getSessionExamen() {
        return sessionExamen;
    }

    public void setSessionExamen(SessionExamen sessionExamen) {
        this.sessionExamen = sessionExamen;
    }
}
