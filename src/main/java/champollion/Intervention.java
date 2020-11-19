package champollion;

import java.util.Date;

public class Intervention {
    private Salle salle;
    private UE ue;
    private Enseignant enseignant;
    private Date debut;
    private int duree;
    private boolean annulee;
    private TypeIntervention typeIntervention;

    public Intervention(Salle salle, UE ue, Enseignant enseignant, Date debut, int duree, TypeIntervention typeIntervention) {
        this.salle = salle;
        this.ue = ue;
        this.enseignant = enseignant;
        this.debut = debut;
        this.duree = duree;
        this.annulee = false;
        this.typeIntervention = typeIntervention;
    }

    public Salle getSalle() {
        return salle;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }

    public UE getUe() {
        return ue;
    }

    public void setUe(UE ue) {
        this.ue = ue;
    }

    public Enseignant getEnseignant() {
        return enseignant;
    }

    public void setEnseignant(Enseignant enseignant) {
        this.enseignant = enseignant;
    }

    public Date getDebut() {
        return debut;
    }

    public void setDebut(Date debut) {
        this.debut = debut;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public boolean isAnnulee() {
        return annulee;
    }

    public void setAnnulee(boolean annulee) {
        this.annulee = annulee;
    }

    public TypeIntervention getTypeIntervention() {
        return typeIntervention;
    }

    public void setTypeIntervention(TypeIntervention typeIntervention) {
        this.typeIntervention = typeIntervention;
    }
}
