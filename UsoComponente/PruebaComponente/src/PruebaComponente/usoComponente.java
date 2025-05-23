/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package PruebaComponente;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.Arrays;
import java.util.List;
import javax.swing.ImageIcon;

/**
 *
 * @author sarai
 */
public class usoComponente extends javax.swing.JFrame {

    public usoComponente() {
        initComponents(); // Inicializa el JFrame y los componentes agregados con el GUI Builder
        configurarGaleria();
    }

    private void configurarGaleria() {
        // Lista de imágenes desde el paquete resources del proyecto
        List<ImageIcon> imagenes = Arrays.asList(
            new ImageIcon(getClass().getResource("/imagenes/imagen1.jpg")),
            new ImageIcon(getClass().getResource("/imagenes/imagen2.jpg")),
            new ImageIcon(getClass().getResource("/imagenes/imagen3.png")),
            new ImageIcon(getClass().getResource("/imagenes/imagen4.jpg")),
            new ImageIcon(getClass().getResource("/imagenes/imagen5.jpg")),
            new ImageIcon(getClass().getResource("/imagenes/imagen6.jpg")),
            new ImageIcon(getClass().getResource("/imagenes/imagen7.jpg")),
            new ImageIcon(getClass().getResource("/imagenes/imagen8.jpg")),
            new ImageIcon(getClass().getResource("/imagenes/imagen9.jpg")),
            new ImageIcon(getClass().getResource("/imagenes/imagen_10.jpg"))
        );
        
           
        // Asigna la lista de imágenes
        componenteGaleria1.setImagenes(imagenes);
        
        /*

        // Instancias de todas las Propiedades básicas manualmente
        componenteGaleria1.setIntervalo(10000);                  // Tiempo entre imágenes en milisegundos
        componenteGaleria1.setDimension(new Dimension(500, 400)); // Tamaño preferido del área de imagen
        componenteGaleria1.setAutoCambio(true);                 // Habilita cambio automático con temporizador
        componenteGaleria1.setCambioPorClick(false);            // Habilita navegación con clic izquierdo/derecho
        componenteGaleria1.setMostrarFlechas(true);  // Si se activa mostrar flecha, se desactivará el 
                                                       // cambio de imagnes por click y viceversa
       
        componenteGaleria1.setLoop(true);                      // Si llega al final, vuelve al inicio
        componenteGaleria1.setEscalarImagenes(true);           // Escala las imágenes al tamaño del panel
        componenteGaleria1.setPosicionInfo("NORTH");           // Muestra la barra de info abajo ("NORTH", "SOUTH", "NONE")
        componenteGaleria1.setMostrarControles(true);          // Muestra los botones de agregar y eliminar imagen
        componenteGaleria1.setMostrarNumero(true);             // Muestra el conteo de imágenes (ej. "Imagen 3 de 10")
        componenteGaleria1.setTransicionSuave(false);          // (Futuro) Habilitar efecto de transición suave
        componenteGaleria1.setMensajeSinImagen("No hay imágenes disponibles"); // Texto si no hay imágenes 

        */
        
        // Inicia la galería si hay imágenes
        componenteGaleria1.iniciarGaleria();
        
    }
    



    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        componenteGaleria1 = new componentegaleriadeimagenes.ComponenteGaleria();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        componenteGaleria1.setCambioPorClick(false);
        componenteGaleria1.setEscalarImagenes(true);
        componenteGaleria1.setLoop(false);
        componenteGaleria1.setMostrarBarraSuperior(true);
        componenteGaleria1.setMostrarControles(true);
        componenteGaleria1.setMostrarNumero(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(componenteGaleria1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(componenteGaleria1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(usoComponente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(usoComponente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(usoComponente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(usoComponente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new usoComponente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private componentegaleriadeimagenes.ComponenteGaleria componenteGaleria1;
    // End of variables declaration//GEN-END:variables
}
