/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pr3.Vistas;

/**
 *
 * @author godof
 */
public class Partida extends javax.swing.JFrame {

    /**
     * Creates new form Partida
     */
    public Partida() {
        super("HUMANOS VS ZOMBIES VS CAZAVAMPIROS VS VAMPIROS");
        initComponents();
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nuevoEntorno = new javax.swing.JButton();
        pasarDia = new javax.swing.JButton();
        mostrarDetalles = new javax.swing.JButton();
        avanzar10dias = new javax.swing.JButton();
        invasion = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        cglobal = new javax.swing.JButton();
        eglobal = new javax.swing.JButton();
        salir = new javax.swing.JButton();
        acontecimientos = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 600));
        setResizable(false);
        setSize(new java.awt.Dimension(800, 620));
        getContentPane().setLayout(null);

        nuevoEntorno.setFont(new java.awt.Font("GodOfWar", 0, 24)); // NOI18N
        nuevoEntorno.setText("Crear nuevo entorno");
        getContentPane().add(nuevoEntorno);
        nuevoEntorno.setBounds(21, 43, 308, 41);

        pasarDia.setFont(new java.awt.Font("GodOfWar", 0, 24)); // NOI18N
        pasarDia.setText("Transcurrir un dia");
        getContentPane().add(pasarDia);
        pasarDia.setBounds(21, 96, 279, 41);

        mostrarDetalles.setFont(new java.awt.Font("GodOfWar", 0, 24)); // NOI18N
        mostrarDetalles.setText("Mostrar detalles");
        mostrarDetalles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarDetallesActionPerformed(evt);
            }
        });
        getContentPane().add(mostrarDetalles);
        mostrarDetalles.setBounds(21, 149, 262, 41);

        avanzar10dias.setFont(new java.awt.Font("GodOfWar", 0, 24)); // NOI18N
        avanzar10dias.setText("Avanzar 10 dias");
        getContentPane().add(avanzar10dias);
        avanzar10dias.setBounds(21, 202, 237, 41);

        invasion.setFont(new java.awt.Font("GodOfWar", 0, 24)); // NOI18N
        invasion.setText("Invasion zombie");
        getContentPane().add(invasion);
        invasion.setBounds(21, 414, 239, 41);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(374, 350, 410, 232);

        cglobal.setFont(new java.awt.Font("GodOfWar", 0, 24)); // NOI18N
        cglobal.setText(" Calentamiento global");
        getContentPane().add(cglobal);
        cglobal.setBounds(21, 308, 330, 41);

        eglobal.setFont(new java.awt.Font("GodOfWar", 0, 24)); // NOI18N
        eglobal.setText("Enfriamiento global");
        getContentPane().add(eglobal);
        eglobal.setBounds(21, 361, 304, 41);

        salir.setFont(new java.awt.Font("GodOfWar", 1, 24)); // NOI18N
        salir.setText("Salir");
        getContentPane().add(salir);
        salir.setBounds(21, 473, 104, 41);

        acontecimientos.setFont(new java.awt.Font("GodOfWar", 1, 24)); // NOI18N
        acontecimientos.setText("Acontecimientos: ");
        getContentPane().add(acontecimientos);
        acontecimientos.setBounds(21, 271, 324, 25);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondo ep2.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 800, 600);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mostrarDetallesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrarDetallesActionPerformed
        MostrarDetalles md = new MostrarDetalles();
        md.setVisible(true);
    }//GEN-LAST:event_mostrarDetallesActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Partida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Partida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Partida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Partida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Partida().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel acontecimientos;
    private javax.swing.JButton avanzar10dias;
    private javax.swing.JButton cglobal;
    private javax.swing.JButton eglobal;
    private javax.swing.JButton invasion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton mostrarDetalles;
    private javax.swing.JButton nuevoEntorno;
    private javax.swing.JButton pasarDia;
    private javax.swing.JButton salir;
    // End of variables declaration//GEN-END:variables
}
