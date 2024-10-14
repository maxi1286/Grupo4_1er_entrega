/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Vistas;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import modelo.Alumno;
import modelo.Inscripcion;
import modelo.Materia;
import persistencia.AlumnoData;
import persistencia.materiaData;

/**
 *
 * @author zalaz
 */
public class VistaListarInscripciones extends javax.swing.JInternalFrame {

    DefaultTableModel modelo = new DefaultTableModel() {
        public boolean isCellEditable(int fila, int columna) {
            return false;
        }
    };
    private ArrayList<Materia> listaM;
    private ArrayList<Alumno>listaA;
    private Inscripcion inscdata;
    private materiaData mData;
    private AlumnoData aData;
    
    
    
    public boolean isCellEditable(int fila, int columna) {
        return false;
    }

    /**
     * Creates new form VistaListarInscripciones
     */
    public VistaListarInscripciones() {
        initComponents();
        iniciarTabla();
        aData = new AlumnoData();
        listaA =aData.listaAlumno();
        modelo = new DefaultTableModel();
        inscdata = new Inscripcion();
        mData = new materiaData();
        
        CargarAlumnos();
        
        
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboalumno = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jRadiomatIncriptas = new javax.swing.JRadioButton();
        jRadioMatNoInscriptas = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTIncripcion = new javax.swing.JTable();
        jBIncribir = new javax.swing.JButton();
        jBAnular = new javax.swing.JButton();
        jBsalir = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setTitle("Formulario de inscripcion");

        jComboalumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboalumnoActionPerformed(evt);
            }
        });

        jLabel1.setText("listado de materia");

        jLabel2.setText("FORMULARIO DE INSCRIPCION");

        jRadiomatIncriptas.setText("materias inscriptas");

        jRadioMatNoInscriptas.setText("materias no inscriptas");

        jTIncripcion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTIncripcion);

        jBIncribir.setText("incribir");
        jBIncribir.setEnabled(false);

        jBAnular.setText("anular inscripcion");
        jBAnular.setEnabled(false);

        jBsalir.setText("salir");
        jBsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBsalirActionPerformed(evt);
            }
        });

        jLabel3.setText("seleccione un alumno");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jRadiomatIncriptas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jRadioMatNoInscriptas))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jBIncribir)
                                    .addGap(44, 44, 44)
                                    .addComponent(jBAnular)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jBsalir)))
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jComboalumno, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78))
            .addGroup(layout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboalumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadiomatIncriptas)
                    .addComponent(jRadioMatNoInscriptas))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBIncribir)
                    .addComponent(jBAnular)
                    .addComponent(jBsalir))
                .addGap(0, 84, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboalumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboalumnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboalumnoActionPerformed

    private void jBsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBsalirActionPerformed
      hide();
    }//GEN-LAST:event_jBsalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAnular;
    private javax.swing.JButton jBIncribir;
    private javax.swing.JButton jBsalir;
    private javax.swing.JComboBox<Alumno> jComboalumno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JRadioButton jRadioMatNoInscriptas;
    private javax.swing.JRadioButton jRadiomatIncriptas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTIncripcion;
    // End of variables declaration//GEN-END:variables
    public void iniciarTabla() {
        ArrayList <Object> filacabecera = new ArrayList();
        modelo.addColumn("Id");
        modelo.addColumn("Nombre");
        modelo.addColumn("año");
        for(Object it : filacabecera)
                modelo.addColumn(it);
    
    
       jTIncripcion.setModel(modelo);
    }

    public void CargarAlumnos(){
        for (Alumno item :listaA ) {
            jComboalumno.addItem(item);
        }
    }

    private void BorrarFilaTabla(){
        int indice = modelo.getRowCount() -1;
        for (int i = indice; i >= 0; i--) {
            modelo.removeRow(i);
        }
    }
    private void CargarDatosNoIncriptas(){
        //borrar fila de la tabla
        Alumno select= (Alumno) jComboalumno.getSelectedItem();
        
    }
    

}
