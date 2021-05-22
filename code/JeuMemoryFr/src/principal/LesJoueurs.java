package principal;


import java.util.ArrayList;

/**
 * Une implémentation de cette classe crée une liste de joueurs
 * @author Agustin Cartaya
 * @see Joueur
 */
public class LesJoueurs {
    
    private ArrayList<Joueur> lstJ;

    
    
    /**
     * Crée la liste de joueurs vide
     */
    public LesJoueurs() {
        lstJ = new ArrayList<Joueur>();
    }
    


    /**
     * Ajoute un joueur à la liste
     * @param j joueur à ajouter
     */
    public void ajouteJoueur(Joueur j){
        this.lstJ.add(j);
    }
    
        
    /**
     * Ajoute un groupe de joueurs à la liste
     * @param js groupe de joueurs à ajouter
     */
    public void ajouteJoueurs(LesJoueurs js){
        for(Joueur j: js.getJoueurs())
            ajouteJoueur(j);
    }
    
    /**
     * Renvoie le joueurs de la position i de la liste
     * s'il existe cette position dans la liste
     * @param i int avec la position du joueur dans la liste
     * @return renvoie le joueur si la position existe nulle sinon
     * @see Joueur
     */
    public Joueur getJoueur(int i){
        if (i>=0 && i<getNbJoueurs())
             return this.lstJ.get(i);
        else return null;
    }
    
    /**
     * Renvoie le joueur avec pseudo cherché
     * s'il existe dans la liste
     * @param psuedo pseudo du joueur
     * @return joueur cherché
     * @see Joueur
     */
    public Joueur getJoueur(String psuedo){
        Joueur j = null;
        int c = 0;
        while (j==null || c<getNbJoueurs()){
            if(getJoueur(c).getPseudo().equals(psuedo))
                j = getJoueur(c);
            c++;
        }
        return j;
    }
    
    /**
     * Renvoie la position dans la liste du joueur j
     * @param j joueur cherché
     * @return int avec la position du joueur
     */
    public int getIndiceJoueur(Joueur j){
        return this.lstJ.indexOf(j);
    } 
    
    /**
     * Renvoie la quantité de joueurs dans la liste
     * @return int avec la quantité de joueurs
     */
    public int getNbJoueurs(){
        return this.lstJ.size();
    }
    
    /**
     * Suprime un joueur de la liste an passant son pseudo,
     * si il y a plusieurs joueurs avec le meme pseudo retira la première accurence est suprime
     * @param pseudo String avec le pseudo du joueur à retirer
     */
    public void supprimeJoueur(String pseudo){
        boolean suprime = false;
        int c = 0;
        while(!suprime || c<getNbJoueurs()){
            if(getJoueur(c).getPseudo().equals(pseudo)){
                this.lstJ.remove(c);
                suprime = true;
            }
            c++;
        }
        
    }
    
    /**
     * Renvoie une liste avec les joueurs gagnants de la liste
     * @return liste de joueurs avec la mailleure ponctuation
     * @see LesJoueurs
     */
    public LesJoueurs getGagnants(){
        
        int max=getJoueur(0).getScore();
        
        for(int i=1; i<getNbJoueurs();i++)
            if (getJoueur(i).getScore()>max)
                max=this.getJoueur(i).getScore();
        
            LesJoueurs lst=new LesJoueurs();
            
            for(int i=0; i<getNbJoueurs();i++)
                
            if (getJoueur(i).getScore()==max)
                lst.ajouteJoueur(getJoueur(i));
            
            return lst;
    }
    
    
    
    /**
     * Renvoie la liste de joueurs
     * @return la liste avec les joueurs 
     */
    public ArrayList<Joueur> getJoueurs() {
        return lstJ;
    }
    

    /**
     * Renvoie la description de tous les joueurs
     * @return String avec la description de tous les joueurs
     * @see Joueur#toString() 
     */
    @Override
    public String toString() {
        return "LesJoueurs{" + "lstJ=" + lstJ + '}';
    }
    
    
}
