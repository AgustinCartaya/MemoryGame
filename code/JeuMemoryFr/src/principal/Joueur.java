package principal;


import java.util.Objects;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * Une implémentation de cette classe crée un objet de type
 * Joueur qui modélise les joueurs du jeu,
 * ces joueurs ont un pseudo, une famille de personnages
 * favoris, une photo et une liste de personnages
 * @author Agustin Cartaya
 */
public class Joueur {
    
    private String pseudo;
    
    private String famillePref;
    
    private ImageIcon photo;
    
    private LesPersonnages paquet;

    /**
     * Crée un joueur avec un pseudo et une famille de personnages préférés,
     * initialise également la liste des personnages (vide par défaut)
     * @param pseudo String avec le pseudo du joueur
     * @param famillePref String avec la famille de personnages préférés,
     * @see LesPersonnages
     */
    public Joueur(String pseudo, String famillePref) {
        setPseudo(pseudo);
        setFamillePref(famillePref);
        this.paquet = new LesPersonnages();
    }

    /**
     * Crée un joueur avec le psudo et famille préférés null
     * pas du sens???
     * @deprecated
     */
    public Joueur() {
         this(null,null);
    }
    
    /**
     * Renvoi le score du joueur
     * @return int avec le score du joueur
     * @see LesPersonnages#getScore() 
     */
    public int getScore(){
        return this.paquet.getScore();
    }
    
    /**
     * Ajoute un personnage à la liste des joueurs
     * @param p personnge à ajouter
     * @see LesPersonnages#ajoutePerso(principal.Personnage) 
     */
    public void ajoutePersoPaquet(Personnage p) {
        this.paquet.ajoutePerso(p);
    }
    
    /**
     * Méthode pour faires des tests,
     * ajouter 3 personnages à la liste des joueurs
     */
    public void initPaquetTest(){
        ajoutePersoPaquet(new Personnage("communs", "assault-trooper", 10));
        ajoutePersoPaquet(new Personnage("communs", "commando", 20));
        ajoutePersoPaquet(new Personnage("rares", "absolute-zero", 10));
    }
    
    /**
     * établit l'image du joueur sur le bouton passé par paramètre,
     * en utilisant certains calculs pour redimensionner correctement
     * @param jb JButton sur lequel l'image du personnage sera établie
     * @see JeuMemoryUtil#imageScale(javax.swing.ImageIcon, int) 
     */
    public void setImgBouton(JButton jb) {
        int max = (jb.getHeight()>jb.getWidth())? jb.getWidth() : jb.getHeight();
        jb.setIcon(JeuMemoryUtil.imageScale(this.photo, max));
    }
    

    
    /**
     * Renvoie le pseudo du joueur
     * @return String avec le pseudo du joueur
     */
    public String getPseudo() {
        return pseudo;
    }

    /**
     * établit les psudo du joueur
     * @param pseudo String avec le pseudo du joueur
     */
    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    /**
     * Renvoie la famille préférée du joueur
     * @return String avec la famille préférée du joueur
     */
    public String getFamillePref() {
        return famillePref;
    }

    /**
     * établit la famille préférée du joueur
     * @param famillePref String avec la famille préférée du joueur
     */
    public void setFamillePref(String famillePref) {
        this.famillePref = famillePref;
    }

    /**
     * Renvoie la photo du joueur
     * @return ImageIcon avec la photo du joueur
     */
    public ImageIcon getPhoto() {
        return photo;
    }

    /**
     * établit la photo du joueur
     * @param photo ImageIcon avec la photo du joueur
     */
    public void setPhoto(ImageIcon photo) {
        this.photo = photo;
    }
    
    /**
     * Renvoie la liste de personnages du joueur
     * @return liste de personnages du joueur
     * @see LesPersonnages
     */
    public LesPersonnages getPaquet() {
        return paquet;
    }


    /**
     * Renvoie une description du joueur. contient
     * sont pseudonyme, sa famille préférée, la liste des personnages
*    * gagnés et son score 
     * @return String avec la description du joueur
     */
    @Override
    public String toString() {
        return "Joueur: " +  pseudo + 
               "\nFamille Preferee=" + famillePref +
               "\nEn possession des personnages: " +  getPaquet().toString() +
               "\nScore: " +  getScore();
    }

    /**
     * Renvoie le hashCode du joueur
     * basé sur le hashcode de son pseudonyme et de sa famille préférée
     * @return int avec le hashCode du joueur
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.pseudo);
        hash = 83 * hash + Objects.hashCode(this.famillePref);
        return hash;
    }
    
    /**
     * Renvoie true les deux joueurs sont les mêmes
     * c-a-d si son pseudo et sa famille prefere sont les mêmes
     * @param obj object de type joueur a comparer
     * @return true se le deux joueur sont egaux
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Joueur other = (Joueur) obj;
        if (!Objects.equals(this.pseudo, other.pseudo)) {
            return false;
        }
        if (!Objects.equals(this.famillePref, other.famillePref)) {
            return false;
        }
        return true;
    }
    
    
    
 
}
