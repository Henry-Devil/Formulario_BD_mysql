/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formulario;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import com.sun.jdi.connect.spi.Connection;
import java.net.URI;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author retor
 */
public class frmPrincipal extends javax.swing.JFrame {
    
    DefaultTableModel model;
    private String sql;

    public frmPrincipal() {
        initComponents();
        this.setLocationRelativeTo(null);
        //this.setResizable(false);        
        
        limpiar();
        bloquear();
        cargar("");
        
    }
    
    void cargar(String valor){
        
            String [] titulos ={"Nombre" ,"Apellido", "Documento" , "Nivel Academico", "Direccion" , "Telefono"};
            String [] registros = new String [6];
            
            String sql = "SELECT * FROM estudiantes where CONCAT (nombre,' ',apellido) LIKE '%"+valor+"%'";
            
            model = new DefaultTableModel(null, titulos);
            conectar cc = new conectar ();
            java.sql.Connection cn = cc.conexion();
            
        try {    
                java.sql.Statement st = cn.createStatement();
                java.sql.ResultSet rs = st.executeQuery(sql);
                
                while (rs.next()){
                    registros [0] =rs.getString("nombre");
                    registros [1] =rs.getString("apellido");
                    registros [2] =rs.getString("documento");
                    registros [3] =rs.getString("nivel_educativo");
                    registros [4] =rs.getString("telefono");
                    registros [5] =rs.getString("dirección");
                    model.addRow(registros);
                    
                }
                tblDatos.setModel(model);
                
              
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
    }
    void limpiar(){
        txtnombre.setText("");
        txtapellido.setText("");
        txtdocumento.setText("");
        txtnivelacademico.setText("");
        txttelefono.setText("");
        txtdireccion.setText("");      
        txttelefono.setText(" ");
        txtbuscar.setText("");
       
  }
    void bloquear (){
        txtnombre.setEditable(false);
        txtapellido.setEditable(false);
        txtdocumento.setEditable(false);
        txtnivelacademico.setEditable(false);
        txttelefono.setEditable(false);
        txtdireccion.setEditable(false);   
        txtbuscar.setEditable(false);

        btnnuevo.setEnabled(true);
        btncancel.setEnabled(true);
        btnguardar.setEnabled(true);
    }
    
    void desbloquear (){
        txtnombre.setEditable(true);
        txtapellido.setEditable(true);
        txtdocumento.setEditable(true);
        txtnivelacademico.setEditable(true);
        txttelefono.setEditable(true);
        txtdireccion.setEditable(true);   
        txtbuscar.setEditable(true);

        btnnuevo.setEnabled(false);
        btncancel.setEnabled(true);
        btnguardar.setEnabled(true);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtdireccion = new javax.swing.JTextField();
        txtbuscar = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtapellido = new javax.swing.JTextField();
        txtdocumento = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtnivelacademico = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txttelefono = new javax.swing.JTextField();
        btnbuscar = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();
        btnguardar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        btnnuevo = new javax.swing.JButton();
        btncancel = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDatos = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        jLabel10.setText("jLabel10");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(800, 700));
        setMinimumSize(new java.awt.Dimension(800, 600));
        getContentPane().setLayout(null);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logo_cul_2015.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(40, 30, 230, 100);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("Apellido:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(400, 150, 90, 20);

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel3.setText("INGRESAR DATOS DEL ESTUDIANTE");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(370, 30, 440, 32);

        txtdireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdireccionActionPerformed(evt);
            }
        });
        getContentPane().add(txtdireccion);
        txtdireccion.setBounds(570, 350, 120, 30);

        txtbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbuscarActionPerformed(evt);
            }
        });
        txtbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbuscarKeyReleased(evt);
            }
        });
        getContentPane().add(txtbuscar);
        txtbuscar.setBounds(260, 450, 181, 24);

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setText("Buscar:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(150, 450, 70, 20);

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setText("Direccion:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(400, 350, 100, 24);

        txtapellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtapellidoActionPerformed(evt);
            }
        });
        getContentPane().add(txtapellido);
        txtapellido.setBounds(570, 150, 181, 24);

        txtdocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdocumentoActionPerformed(evt);
            }
        });
        getContentPane().add(txtdocumento);
        txtdocumento.setBounds(570, 200, 181, 24);

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel6.setText("Documento:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(400, 200, 110, 24);

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel7.setText("Nivel academico:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(400, 250, 152, 24);

        txtnivelacademico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnivelacademicoActionPerformed(evt);
            }
        });
        getContentPane().add(txtnivelacademico);
        txtnivelacademico.setBounds(570, 250, 181, 24);

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel8.setText("Telefeno:");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(400, 300, 90, 24);

        txttelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttelefonoActionPerformed(evt);
            }
        });
        getContentPane().add(txttelefono);
        txttelefono.setBounds(570, 300, 181, 30);

        btnbuscar.setText("Buscar");
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnbuscar);
        btnbuscar.setBounds(720, 350, 77, 32);

        btnsalir.setText("Salir");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnsalir);
        btnsalir.setBounds(180, 340, 70, 40);

        btnguardar.setText("Guardar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });
        getContentPane().add(btnguardar);
        btnguardar.setBounds(60, 340, 90, 40);

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel9.setText("Presiona nuevo para ingresar datos");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(20, 160, 320, 30);

        btnnuevo.setText("Nuevo");
        btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoActionPerformed(evt);
            }
        });
        getContentPane().add(btnnuevo);
        btnnuevo.setBounds(70, 200, 70, 40);

        btncancel.setText("Cancelar");
        btncancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelActionPerformed(evt);
            }
        });
        getContentPane().add(btncancel);
        btncancel.setBounds(190, 200, 90, 40);

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel11.setText("¿Deseas guardar tus datos?");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(40, 290, 250, 30);

        tblDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblDatos);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(110, 520, 500, 230);

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel12.setText("Nombre:");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(400, 100, 90, 30);

        txtnombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombreActionPerformed(evt);
            }
        });
        getContentPane().add(txtnombre);
        txtnombre.setBounds(570, 100, 181, 24);

        jButton1.setText("Mostrar todo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(470, 440, 110, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
        // TODO add your handling code here:
      try{
          String direccionMapa= URLEncoder.encode(btnbuscar.getText(), "UTF-8");
          java.awt.Desktop.getDesktop().browse(new URI ("https://wwww.google.com/maps/place/"));
      }catch (Exception e){
          System.err.println("errro :" + e.getMessage());
          
    }  
    }//GEN-LAST:event_btnbuscarActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        // TODO add your handling code here:
        conectar cc = new conectar();
        java.sql.Connection cn = cc.conexion();
        String nom, ape, doc, niv, dir, tel,bus;
        String sql = " ";
        nom = txtnombre.getText();
        ape = txtapellido.getText();
        doc = txtdocumento.getText();
        niv = txtnivelacademico.getText();
        dir = txtdireccion.getText();
        tel = txttelefono.getText();
        bus = txtbuscar.getText();

        
       sql="INSERT INTO estudiantes(nombre, apellido, documento, nivel_educativo, telefono, dirección ) VALUES (?,?,?,?,?,?)";
        try {
            java.sql.PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, nom);
            pst.setString(2, ape);
            pst.setString(3, doc);
            pst.setString(4, niv);
            pst.setString(5, dir);
            pst.setString(6, tel);
            
            int n=pst.executeUpdate();
            if (n>0){
                JOptionPane.showMessageDialog(null, "Registro guardado");
                bloquear();
                cargar("");
            }
                
        } catch (SQLException ex) {
            Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }//GEN-LAST:event_btnguardarActionPerformed

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnsalirActionPerformed

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
        // TODO add your handling code here:
        desbloquear();
        txtnombre.requestFocus();
        
    }//GEN-LAST:event_btnnuevoActionPerformed

    private void btncancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelActionPerformed
        // TODO add your handling code here:
        bloquear();
        
    }//GEN-LAST:event_btncancelActionPerformed

    private void txtbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbuscarActionPerformed
txtnombre.transferFocus();        // TODO add your handling code here:
    }//GEN-LAST:event_txtbuscarActionPerformed

    private void txtapellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtapellidoActionPerformed
txtapellido.transferFocus();           // TODO add your handling code here:
    }//GEN-LAST:event_txtapellidoActionPerformed

    private void txtdocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdocumentoActionPerformed
txtdocumento.transferFocus();           // TODO add your handling code here:
    }//GEN-LAST:event_txtdocumentoActionPerformed

    private void txtnivelacademicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnivelacademicoActionPerformed
txtnivelacademico.transferFocus();           // TODO add your handling code here:
    }//GEN-LAST:event_txtnivelacademicoActionPerformed

    private void txttelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttelefonoActionPerformed
txttelefono.transferFocus();           // TODO add your handling code here:
    }//GEN-LAST:event_txttelefonoActionPerformed

    private void txtdireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdireccionActionPerformed
txtdireccion.transferFocus();           // TODO add your handling code here:
    }//GEN-LAST:event_txtdireccionActionPerformed

    private void txtnombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombreActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtbuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyReleased
        // TODO add your handling code here:
        cargar(txtbuscar.getText());
        
    }//GEN-LAST:event_txtbuscarKeyReleased


    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        new frmPrincipal().setVisible(true);
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
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            
            public void run() {
                new frmPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btncancel;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JButton btnsalir;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDatos;
    private javax.swing.JTextField txtapellido;
    private javax.swing.JTextField txtbuscar;
    private javax.swing.JTextField txtdireccion;
    private javax.swing.JTextField txtdocumento;
    private javax.swing.JTextField txtnivelacademico;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txttelefono;
    // End of variables declaration//GEN-END:variables
}
