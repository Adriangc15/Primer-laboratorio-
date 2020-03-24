/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

;
import Controlador.CarreraControlador;
import com.mobiles.backend.Entidades.Carrera;
import Main.Main;
import Modelo.CarreraModel;
import java.util.Observable;

/**
 *
 * @author Usuario1
 */
public class CarreraVista extends javax.swing.JInternalFrame implements java.util.Observer{

    /**
     * Creates new form CarreraView
     */
    public CarreraVista() {
        initComponents();
    }
    
    CarreraControlador controller;
    CarreraModel model;
    
     public CarreraControlador getController() {
        return controller;
    }
    public void setController(CarreraControlador controller){
        this.controller=controller;
    }
    public void setModel(CarreraModel model){
        this.model=model;
         model.addObserver(this);
    }

    public CarreraModel getModel() {
        return model;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        codigoFld = new javax.swing.JTextField();
        nombreFld = new javax.swing.JTextField();
        tituloFld = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setTitle("Carrera");

        jLabel1.setText("Código");

        jLabel2.setText("Nombre");

        jLabel3.setText("Título");

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/save.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(nombreFld, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                                    .addComponent(codigoFld)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(29, 29, 29)
                                .addComponent(tituloFld, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addComponent(btnGuardar)))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(codigoFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nombreFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tituloFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnGuardar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        this.controller.guardar();
    }//GEN-LAST:event_btnGuardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    public javax.swing.JTextField codigoFld;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    public javax.swing.JTextField nombreFld;
    public javax.swing.JTextField tituloFld;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object arg) {
       Carrera carreraCurrent = model.getCurrent();        
       
       codigoFld.setText(carreraCurrent.getCodigo());
       if (model.getErrores().get("CODIGO")!=null){
            codigoFld.setBorder(Main.BORDER_ERROR);
            codigoFld.setToolTipText(model.getErrores().get("CODIGO"));
        }
        else{
            codigoFld.setBorder(null);
            codigoFld.setToolTipText("");
        }
       
        nombreFld.setText(carreraCurrent.getNombre());
        if (model.getErrores().get("NOMBRE")!=null){
            nombreFld.setBorder(Main.BORDER_ERROR);
            nombreFld.setToolTipText(model.getErrores().get("NOMBRE"));
        }
        else{
           nombreFld.setBorder(null);
           nombreFld.setToolTipText("");
        }
        tituloFld.setText(carreraCurrent.getTitulo());
        if (model.getErrores().get("TITULO")!=null){
            tituloFld.setBorder(Main.BORDER_ERROR);
            tituloFld.setToolTipText(model.getErrores().get("TITULO"));
        }
        else{
           tituloFld.setBorder(null);
           tituloFld.setToolTipText("");
        }

        this.validate();
        if (!model.getMensaje().equals(""))
        {
            //JOptionPane.showMessageDialog(this, model.getMensaje(), "",JOptionPane.INFORMATION_MESSAGE,FrontEndDesktop.CARRERAS_VIEW.iconoload);
        }
    }
}