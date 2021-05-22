package principal;


import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;

/**
 * Fenêtre qui permet de visualiser les personnages du joueur actuel
 * @author Agustin Cartaya
 */
public class VisuPersonnagesDlg extends javax.swing.JDialog {


    /**
     * Initialisation de la fenêtre, composants et variables
     * @param parent compossant parent
     * @param modal type d'ouverture
     * @param joueur instance du joueur actuel
     * @see Joueur
     */
    public VisuPersonnagesDlg(java.awt.Frame parent, boolean modal, Joueur joueur) {
        super(parent, modal);
        initComponents();
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.joueur = joueur;
        initPanneau();
    }
    
    

    /**
     * crée les boutons avec les personnages du joueur actuel
     * montre également son pseudo et son score
     */
    private void initPanneau(){
        //verifie que le joueur actuel n'est pas null
        if( this.joueur != null){
            //obtenir les personnages du joueur actuel et calculer
            //les dimensions du tableau pour montrer les personnages
            LesPersonnages paquet = this.joueur.getPaquet();
            int n = (int)Math.sqrt(paquet.getNbPersonnages());
            
            if(n>0){
                panneau.setLayout(new GridLayout( ((n*n<paquet.getNbPersonnages())?n+1:n),n) );

                //créer les boutons avec les personnages et les ajoute à la fenêtre
                for(Personnage p: paquet.getPersos()){
                    JButton bt = new JButton();
                    Image img = p.getImage().getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
                    bt.setIcon(new ImageIcon(img));
                    panneau.add(bt);       
                }
                //affiche le nom et le score du joueur
                this.jlPseudo.setText("Cartes du joueur: " + this.joueur.getPseudo());
                this.jlScore.setText("Score: " + this.joueur.getScore() );
            }
        }
            
    } 
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jlPseudo = new javax.swing.JLabel();
        panneau = new javax.swing.JPanel();
        jlScore = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jlPseudo.setText("Cartes du joueur:");
        jPanel1.add(jlPseudo, java.awt.BorderLayout.NORTH);

        javax.swing.GroupLayout panneauLayout = new javax.swing.GroupLayout(panneau);
        panneau.setLayout(panneauLayout);
        panneauLayout.setHorizontalGroup(
            panneauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        panneauLayout.setVerticalGroup(
            panneauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 249, Short.MAX_VALUE)
        );

        jPanel1.add(panneau, java.awt.BorderLayout.CENTER);

        jlScore.setText("Score :");
        jPanel1.add(jlScore, java.awt.BorderLayout.SOUTH);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jButton1.setText(";)");
        getContentPane().add(jButton1, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    //contient la reference au joueur actuel
    private Joueur joueur;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jlPseudo;
    private javax.swing.JLabel jlScore;
    private javax.swing.JPanel panneau;
    // End of variables declaration//GEN-END:variables
}
