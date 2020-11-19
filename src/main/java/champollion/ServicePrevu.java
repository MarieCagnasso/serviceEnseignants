package champollion;

public class ServicePrevu {
    private  int volumeCM;
    private  int volumeTD;
    private  int volumeTP;

    public ServicePrevu(int cm,int td, int tp){
        this.volumeCM = cm;
        this.volumeTD = td;
        this.volumeTP = tp;
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
}
