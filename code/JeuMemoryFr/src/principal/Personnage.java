package principal;

import java.awt.Image;
import java.util.Objects;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * Une implémentation de cette classe crée un objet de type
 * Personnage lesquels sont les pièces principales du Jeu Memory
* chaque personnage contient une image, un nom, une famille et sa valeur
 * @author Agustin Cartaya
 */
public class Personnage {
    
    private ImageIcon image;
    private String nom;
    private String famille;
    private int valeur;

    /**
     * Crée un personnage appartenant à la famille
     * spécifié, et dont le nom et la valeur sont également spécifiés,
     * une image par défaut à chaque personnage est donnee
     * @param famille famille à laquelle appartient le personnage
     * @param nom nom du personnage
     * @param valeur valeur du personnage
     */
    public Personnage( String famille,String nom, int valeur) {
        setNom(nom);
        setFamille(famille);
        setValeur(valeur);
        setImage(new ImageIcon("src/img/anonyme.png"));

    }
    
    /**
     * Crée un personnage perteneciente à la famille "anonyme"
     * cuyo nom es "anonyme" y cuyo valeur es cero
     */
    public Personnage() {
        this("anonyme", "anonyme",0);
    }


    /**
     * établit la image du personage al boton pasado por parametro,
     * utilizando algunos calculos para redimencionar apropiadamente
     * la image dependiendo les dimensiones du boton
     * @param jb JButton al cual se le établitra la image du personnage
     * @see JeuMemoryUtil#imageScale(javax.swing.ImageIcon, int) 
     */
    public void setImgBouton(JButton jb) {
        int max = (jb.getHeight()>jb.getWidth())? jb.getWidth() : jb.getHeight();
        jb.setIcon(JeuMemoryUtil.imageScale(this.image, max));
    }
    
    
   /**
    * Renvoie l'image du personage
    * @return ImageIcon avec la image du personage
    */
    public ImageIcon getImage() {
        return image;
    }

    /**
     * établit l'image du personnage
     * @param image image du personnage
     */
    public void setImage(ImageIcon image) {
        this.image = image;
    }

    /**
     * Renvoie le nom du personnage
     * @return String avec le nom du personnage
     */
    public String getNom() {
        return nom;
    }

    /**
     * établit le nom du personnage
     * @param nom String qui contioent le nom 
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Renvoie la famille du personnage
     * @return String avec la famille du personnage
     */
    public String getFamille() {
        return famille;
    }

    /**
     * établit la famille du personnage
     * @param famille String qui contient la famille à établir
     */
    public void setFamille(String famille) {
        this.famille = famille;
    }

    /**
     * Renvoie le valeur du personnage
     * @return int avec la valeur du personnage
     */
    public int getValeur() {
        return valeur;
    }

    /**
     * établit le valeur du personnage
     * @param valeur int avec la valeur du personnage
     */
    public void setValeur(int valeur) {
        this.valeur = valeur;
    }

    
    /**
     * Renvoie la description du personnage contenat
     * son nom, sa famille, y sa valeur
     * @return String avec la description du personnage
     */
    @Override
    public String toString() {
        return "Personnage{" + "nom=" + nom + ", famille=" + famille + ", valeur=" + valeur + '}';
    }

    /**
     * Renvoie le hashCode du personnage
     * basé sur le hashcode de son nom, sa famille et sa valeur
     * @return int avec le hashCode du joueur
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.nom);
        hash = 59 * hash + Objects.hashCode(this.famille);
        hash = 59 * hash + this.valeur;
        return hash;
    }

  /**
     * Renvoie true les deux personnage sont les mêmes
     * c-a-d si son nom et sa famille sont les mêmes
     * @param obj object de type personnage a comparer
     * @return true se le deux personnages sont egaux
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
        final Personnage other = (Personnage) obj;
        if (this.valeur != other.valeur) {
            return false;
        }
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (!Objects.equals(this.famille, other.famille)) {
            return false;
        }
        return true;
    }

 
}
