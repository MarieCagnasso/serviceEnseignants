package champollion;

import java.util.LinkedList;
import java.util.List;

public class Enseignant extends Personne {

    private final List<ServicePrevu> servicePrevu = new LinkedList<>();
    private final List<Intervention> interventions = new LinkedList<>();

    public Enseignant(String nom, String email) { super(nom, email); }

    /**
     * Calcule le nombre total d'heures prévues pour cet enseignant en "heures équivalent TD" Pour le calcul : 1 heure
     * de cours magistral vaut 1,5 h "équivalent TD" 1 heure de TD vaut 1h "équivalent TD" 1 heure de TP vaut 0,75h
     * "équivalent TD"
     *
     * @return le nombre total d'heures "équivalent TD" prévues pour cet enseignant, arrondi à l'entier le plus proche
     *
     */
    public int heuresPrevues() {
        int res = 0;
        for (int i = 0; i<servicePrevu.size();i++){
            res += servicePrevu.get(i).getVolumeCM()*1.5 + servicePrevu.get(i).getVolumeTD() + servicePrevu.get(i).getVolumeTP()*0.75;
        }
       return res;
    }

    /**
     * Calcule le nombre total d'heures prévues pour cet enseignant dans l'UE spécifiée en "heures équivalent TD" Pour
     * le calcul : 1 heure de cours magistral vaut 1,5 h "équivalent TD" 1 heure de TD vaut 1h "équivalent TD" 1 heure
     * de TP vaut 0,75h "équivalent TD"
     *
     * @param ue l'UE concernée
     * @return le nombre total d'heures "équivalent TD" prévues pour cet enseignant, arrondi à l'entier le plus proche
     *
     */
    public int heuresPrevuesPourUE(UE ue) {
        int res = 0;
        for (int i = 0; i<servicePrevu.size();i++){
            if (servicePrevu.get(i).getUe() == ue){
                res +=  servicePrevu.get(i).getVolumeCM()*1.5 + servicePrevu.get(i).getVolumeTD() + servicePrevu.get(i).getVolumeTP()*0.75;
                break;
            }
        }
        return res;
    }

    /**
     * Ajoute un enseignement au service prévu pour cet enseignant
     *
     * @param ue l'UE concernée
     * @param volumeCM le volume d'heures de cours magitral
     * @param volumeTD le volume d'heures de TD
     * @param volumeTP le volume d'heures de TP
     */
    public void ajouteEnseignement(UE ue, int volumeCM, int volumeTD, int volumeTP) {
        boolean done = false;
        for (ServicePrevu s : servicePrevu){
            if (s.getUe() == ue){
                s.setVolumeCM(s.getVolumeCM()+volumeCM);
                s.setVolumeTD(s.getVolumeTD()+volumeTD);
                s.setVolumeTP(s.getVolumeTP()+volumeTP);
            }
        }
        if(!done){ servicePrevu.add(new ServicePrevu(volumeCM,volumeTD,volumeTP,this,ue));}
    }

    public boolean enSousService(){
        return heuresPrevues()<192;
    }

    /**
     * Ajoute une intervention au intervention prévu pour cet enseignant
     * @param e Intervention
     */
    public void ajouterIntervention (Intervention e){
        interventions.add(e);
    }

    /**
     * Calcule le nombre d'heures total plannifié (equivalent TD) pour cette enseignant
     * @return int heures planifier
     */
    public int heuresPlanifiées(){
      int res = 0;
      for (int i = 0; i<interventions.size(); i++){
          switch (interventions.get(i).getTypeIntervention()){
              case CM: res+= interventions.get(i).getDuree()*1.5;
                      break;
              case TD: res+= interventions.get(i).getDuree();
                  break;
              case TP: res+= interventions.get(i).getDuree()*0.75;
                  break;
          }
      }
      return res;
    }

}
