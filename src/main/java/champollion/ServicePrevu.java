package champollion;

public class ServicePrevu {
    private  int volumeCM;
    private  int volumeTD;
    private  int volumeTP;
    private final Enseignant enseignant;
    private final UE ue;

    public ServicePrevu(int cm, int td, int tp, Enseignant enseignant, UE ue){
        this.volumeCM = cm;
        this.volumeTD = td;
        this.volumeTP = tp;
        this.enseignant = enseignant;
        this.ue = ue;
    }

    public int getVolumeCM() {
        return volumeCM;
    }

    public void setVolumeCM(int volumeCM) {
        this.volumeCM = volumeCM;
    }

    public int getVolumeTD() {
        return volumeTD;
    }

    public void setVolumeTD(int volumeTD) {
        this.volumeTD = volumeTD;
    }

    public int getVolumeTP() {
        return volumeTP;
    }

    public void setVolumeTP(int volumeTP) {
        this.volumeTP = volumeTP;
    }

    public Enseignant getEnseignant() {
        return enseignant;
    }

    public UE getUe() {
        return ue;
    }
}
