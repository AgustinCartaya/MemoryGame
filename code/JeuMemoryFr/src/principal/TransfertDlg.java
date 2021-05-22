/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;

/**
 *
 * @author agust
 */
public class TransfertDlg extends javax.swing.JDialog {

    /**
     * Creates new form TransfertDlg
     */
    public TransfertDlg(java.awt.Frame parent, boolean modal, LesJoueurs lj, int indj) {
        super(parent, modal);
        initComponents();
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.lj = lj;
        this.indj = indj ;
        // this.tc=null;
        this.ok=false;
        this.fs=null;
        initCombo(); // méthode pour remplir la liste déroulante
        indjs = 0;
        message.setText("Le joueur "+lj.getJoueur(indj).getPseudo()+" a obtenu une famille complète");
        infos.setText("Personnages de "+lj.getJoueur(indj).getPseudo()+" : \n"+lj.getJoueur(indj).getPaquet());

    }
    
    private void initCombo(){
        if( this.lj!= null)
            for(Joueur j: this.lj.getJoueurs())
                this.comboJoueurs.addItem(j.getPseudo());
    }
    
    
    public boolean isOk() {
        return ok;
    }
    
    private void initPanneau(){
        panneauG.removeAll();
        this.repaint();
        LesPersonnages lcs = this.lj.getJoueur(this.indjs).getPaquet();
        int t = lcs.getNbPersonnages();
        int n = 1+(t-1)/4;
        panneauG.setLayout(new java.awt.GridLayout(4, n));

        for(Personnage p: lcs.getPersos()){
            JButton bt = new JButton();
            bt.setName(p.getFamille());
            bt.addActionListener(new ActionListener(){
                
                @Override
                public void actionPerformed(ActionEvent e) {
                    boutonActionPerformed(e);
                }
            });
            
            Image img = p.getImage().getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
            bt.setIcon(new ImageIcon(img));
            
            panneauG.add(bt);
        }
        this.pack();
    }
    
    /**
     * por el momento este metodo esta en desuso,
     * posiblemente se podre usar luego si hay la necesidad
     * lo que deveria hecer este metodo esta en el metodo initPanneau
     * @see TransfertDlg#initPanneau()
     * @deprecated 
     */
    private void affichePanneau(){
//        pass
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panneauG = new javax.swing.JPanel();
        panneauC = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        message = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        comboJoueurs = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        infos = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        btTransfert = new javax.swing.JButton();
        btFermer = new javax.swing.JButton();
        panneauD = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(700, 500));
        setSize(new java.awt.Dimension(700, 500));
        getContentPane().setLayout(new java.awt.GridLayout(1, 3));

        panneauG.setLayout(new java.awt.GridLayout(1, 1));
        getContentPane().add(panneauG);

        panneauC.setLayout(new java.awt.BorderLayout());

        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel4.setLayout(new java.awt.GridLayout(2, 1));
        jPanel4.add(message);

        jLabel1.setText("sélectionner un autre joueur à l’aide de liste déroulante");
        jPanel4.add(jLabel1);

        jPanel2.add(jPanel4, java.awt.BorderLayout.NORTH);

        comboJoueurs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboJoueursActionPerformed(evt);
            }
        });
        jPanel2.add(comboJoueurs, java.awt.BorderLayout.CENTER);

        panneauC.add(jPanel2, java.awt.BorderLayout.NORTH);

        jPanel1.setLayout(new java.awt.BorderLayout());

        infos.setColumns(20);
        infos.setRows(5);
        jScrollPane1.setViewportView(infos);

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel3.setLayout(new java.awt.GridLayout(1, 2));

        btTransfert.setText("Transfert");
        jPanel3.add(btTransfert);

        btFermer.setText("Fermer");
        jPanel3.add(btFermer);

        jPanel1.add(jPanel3, java.awt.BorderLayout.SOUTH);

        panneauC.add(jPanel1, java.awt.BorderLayout.CENTER);

        getContentPane().add(panneauC);

        javax.swing.GroupLayout panneauDLayout = new javax.swing.GroupLayout(panneauD);
        panneauD.setLayout(panneauDLayout);
        panneauDLayout.setHorizontalGroup(
            panneauDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1056, Short.MAX_VALUE)
        );
        panneauDLayout.setVerticalGroup(
            panneauDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        getContentPane().add(panneauD);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboJoueursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboJoueursActionPerformed
        this.indjs = comboJoueurs.getSelectedIndex();
        if (indjs != -1){
            if (this.indjs == this.indj) {
                infos.setText("Sélectionnez un joueur différent du joueur courant !");
                panneauG.removeAll();
                panneauG.repaint();
            }
            else {
                infos.setText("\nJoueur sélectionné: "+lj.getJoueur(indjs).toString());
                initPanneau();
                affichePanneau();
            }
        }
    }//GEN-LAST:event_comboJoueursActionPerformed

    private void boutonActionPerformed(ActionEvent e){
        LesPersonnages lp = lj.getJoueur(indjs).getPaquet();
        int t = lp.getNbPersonnages();
        JButton bt=(JButton) e.getSource();
        fs = bt.getName(); // la proprité Name, contient ici le nom du personnage affiché sur le bouton
        
        for(int i = 0; i < t; i++) {
            JButton b = (JButton)(panneauG.getComponent(i));
            if (b.getName().equals(fs))
            b.setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, new java.awt.Color(255, 0, 0)));
            else
            b.setBorder(null);
        }
        
        LesPersonnages lps = lp.getPersosFamille(fs);
        infos.setText("Vous pouvez récupérer "+lps.getNbPersonnages()+" personnages : \n"+lps);
    }
    
    
    private LesJoueurs lj;
    private int indj; //indice joueur courant
 // private Transfert tc; // cette classe sera étudiée ultérieurement – laisser l’attribut en commentaire
    private boolean ok; // indicateur pour savoir le transfert a bien été effectué.
    private int indjs; //indice du joueur sélectionné dans la liste déroulante
    private String fs; //famille du personnage sélectionné en cliquant sur un des personnages du joueur sélectionné

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btFermer;
    private javax.swing.JButton btTransfert;
    private javax.swing.JComboBox<String> comboJoueurs;
    private javax.swing.JTextArea infos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel message;
    private javax.swing.JPanel panneauC;
    private javax.swing.JPanel panneauD;
    private javax.swing.JPanel panneauG;
    // End of variables declaration//GEN-END:variables
}
