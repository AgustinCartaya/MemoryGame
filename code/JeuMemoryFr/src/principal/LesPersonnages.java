package principal;


import java.util.ArrayList;

/**
 * Une implémentation de cette classe crée une liste de Personnages
 * @author Agustin Cartaya
 * @see Personnage
 */
public class LesPersonnages {
    
    private ArrayList<Personnage> persos;


    
    /**
     * Crée la liste de personnages avec une quantité de personnages nc
     * @param nc quantité de personnages valeurs acceptés (4,10,18,32)
     * toute autre valeur laisse la liste vide
     */
    public LesPersonnages(int nc) {
        this.persos = new ArrayList<Personnage>();
        if (nc >= 4){ // 2 familles
            ajoutePerso(new Personnage("communs", "assault-trooper", 10));
            ajoutePerso(new Personnage("communs", "commando", 20));
            ajoutePerso(new Personnage("rares", "absolute-zero", 10));
            ajoutePerso(new Personnage("rares", "arctice-assassin", 20));
        }
        if (nc >= 10){ // 4 familles
            ajoutePerso(new Personnage("communs", "devestrator", 30));
            ajoutePerso(new Personnage("rares", "brawler", 30));
            ajoutePerso(new Personnage("alpins-femmes", "mogul-master", 10));
            ajoutePerso(new Personnage("alpins-femmes", "mogul-master-can", 20));
            ajoutePerso(new Personnage("as-des-pistes", "alpine-ace", 10));
            ajoutePerso(new Personnage("as-des-pistes", "alpine-ace-can", 20));
        }
        if (nc >= 18){ // 6 familles

            ajoutePerso(new Personnage("alpins-femmes", "mogul-master-chn", 30));
            ajoutePerso(new Personnage("as-des-pistes", "alpine-ace-chn", 30));
            ajoutePerso(new Personnage("legendaires", "power-chord", 10));
            ajoutePerso(new Personnage("legendaires", "raptor", 20));
            ajoutePerso(new Personnage("legendaires", "raven", 30));
            ajoutePerso(new Personnage("epiques", "burnout", 10));
            ajoutePerso(new Personnage("epiques", "funk-ops", 20));
            ajoutePerso(new Personnage("epiques", "rex", 30));
        }
        if (nc == 32){ // 6 familles
            ajoutePerso(new Personnage("communs", "dominator", 40));
            ajoutePerso(new Personnage("communs", "highrise-assault-trooper", 50));
            ajoutePerso(new Personnage("communs", "jungle-scout", 60));
            ajoutePerso(new Personnage("communs", "pathfinder", 70));
            ajoutePerso(new Personnage("rares", "brilliant-striker", 40));
            ajoutePerso(new Personnage("rares", "brite-bomber", 50));
            ajoutePerso(new Personnage("rares", "circuit-breaker", 60));
            ajoutePerso(new Personnage("rares", "dazzle", 70));
            ajoutePerso(new Personnage("alpins-femmes", "mogul-master-fra", 40));
            ajoutePerso(new Personnage("alpins-femmes", "mogul-master-gbr", 50));
            ajoutePerso(new Personnage("as-des-pistes", "alpine-ace-fra", 40));
            ajoutePerso(new Personnage("as-des-pistes", "alpine-ace-gbr", 50));
            ajoutePerso(new Personnage("legendaires", "red-knight", 40));
            ajoutePerso(new Personnage("epiques", "shadow-ops", 40));
        }
    }
    
    /**
     * Crée la liste sans aucun personnage
     */
    public LesPersonnages() {
      this(0);
     }
    
    
    /**
     * Ajoute Un personnage dans la liste
     * @param p personnage à Ajouter
     */
    public void ajoutePerso (Personnage p){
         persos.add(p);
     }
    
    /**
     * Ajoute un groupe de personnages dans la liste
     * @param persos groupe de personnages à ajouter
     */
    public void ajoutePersos(LesPersonnages persos){
        for(int i=0; i<persos.getNbPersonnages(); i++){
            ajoutePerso(persos.getPerso(i));
        }
    }
    
    /**
     * Renvoie le personnage dans la position
     * i de la liste, si cette position appartien à telle liste
     * @param i position ou se trouve le personnage dans la liste
     * @return personnage cherché
     * @see Personnage
     */
    public Personnage getPerso(int i){
        if (i>=0 && i<this.persos.size())
             return this.persos.get(i);
        else return null;
    }
    
    /**
     * Renvoie tous les personnages d'une famille déterminée
     * @param f String avec famille cherché
     * @return liste avec tous les personnages apartenant à la famillecherché
     */
    public LesPersonnages getPersosFamille(String f)
    {   LesPersonnages lp = new LesPersonnages();
        for(int i=0; i<getNbPersonnages(); i++)
            if(getPerso(i).getFamille().equals(f))
                lp.ajoutePerso(getPerso(i));
        return lp;
    }
    
    /**
     * Renvoie la quantité de personnages dans la liste
     * @return int avec la quantité de personnages
     */
    public int getNbPersonnages() { 
         return this.persos.size(); 
     }
    
    /**
     * Supprime un personnage de la liste par son psuedo,
     * s'il y a plusieurs personnages avec le meme psuedo Supprime la premiere coincidence
     * @param nom String avec le psuedo du personnage à Supprimer
     */
    public void retirePerso(String nom)
    { 
        int i=0; 
        boolean trouve = false;
        while(i<getNbPersonnages() && !trouve){
          if (getPerso(i).getNom().equals(nom)){
              this.persos.remove(i);  
              trouve = true;
          }
          else i++;
        }      
    }
     
    /**
     * Supprime les premiers n personnages de la liste et les Renvoie
     * @param n int avec la quantité de personnages à Supprimer
     * @return les personnages Supprimes
     */
   public LesPersonnages retirePersos(int n)
    { LesPersonnages lcr = new LesPersonnages();
        for (int i=0; i<=n; i++)
        {
            lcr.ajoutePerso(getPerso(i));
            this.persos.remove(i);  
        }
        return lcr;
    } 
    
   /**
    * Supprime tous les personnages d'une famille déterminée
    * @param f String avec la famille à Supprimer
    * @return les personnager Supprimes
    */
    public LesPersonnages retirePersosFamille(String f)
    { 
        LesPersonnages lcr = new LesPersonnages();
        int i = 0;
        while(i<getNbPersonnages()){
            if (getPerso(i).getFamille().equals(f)) {
                lcr.ajoutePerso(getPerso(i));
                this.persos.remove(i);  
            }
            else i++;
        }
        return lcr;
    }
    
    /**
     * Renvoie toutes les familles de la liste
     * @return liste avec les differents familles
     */
    public ArrayList<String> getFamilles(){
        ArrayList<String> lst = new ArrayList<String>();
        for (int j=0; j<this.persos.size(); j++){
            Personnage p = this.persos.get(j);
            boolean trouve = false;
            for (int i=0; i< lst.size(); i++)
                if (lst.get(i).equals(p.getFamille()))
                    trouve = true;
            
            if (!trouve)
                lst.add(p.getFamille());
        }
        return lst;
    }
     
    /**
     * Suprime tous les personnages de la liste
     */ 
    public void retireCartes(){ 
           persos.clear();
    }
     
    /**
     * Renvoie la somme des valeurs
     * de chaqe personnage dans la liste
     * @return int avec la somme de tous les valeurs
     */
    public int getScore(){   
        int sc = 0;
        for(int i=0; i<getNbPersonnages(); i++)
           sc+=getPerso(i).getValeur();
        return sc;
    }
    
    
    /**
     * Renvoie la liste de personnages
     * @return la liste avec les personnages 
     */
    public ArrayList<Personnage> getPersos() {
        return persos;
    }
    
    
    
    /**
     * Renvoie la description de tous les personnages
     * @return String avec la description de tous les personnages
     * @see Personnage#toString() 
     */
    @Override
    public String toString() {
        String s = "";
        for(int i=0; i<getNbPersonnages(); i++)
            s+=i+"- "+getPerso(i).toString();
       return s;
    }
	
    
}