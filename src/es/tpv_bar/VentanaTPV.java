/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.tpv_bar;

import es.tpv_bar.gui.botones.BTCategoria;
import es.tpv_bar.gui.botones.BTLineas;
import es.tpv_bar.gui.botones.BTProducto;
import es.tpv_bar.gui.ventanas.VentanaCamareros;
import es.tpv_bar.gui.ventanas.VentanaMesas;
import es.tpv_bar.persistencia.modelos.*;
import es.tpv_bar.persistencia.pojos.*;
import es.tpv_bar.prints.Print;
import java.awt.Component;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author aperalta
 */
public class VentanaTPV extends javax.swing.JFrame {

    /**
     * Variables de los modelos de datos
     */
    VentanaTPV instanceOf;
    VentanaMesas mesa;
    CategoriaModel categorias = new CategoriaModel();
    ProductosModel productos = new ProductosModel();
    CajaModel caja = new CajaModel();
    CabezeraModel cabezeras = new CabezeraModel();
    Print impresora = new Print();
    //CamareroModel camareros = new CamareroModel();
    Camarero camarero;
    public LineaModel lineas = new LineaModel();

    /**
     * Creates new form VentanaTPV
     */
    public VentanaTPV() {
        initComponents();
        this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        this.setVisible(true);
        
        this.toFront();
        this.setAlwaysOnTop(true);
        cargarCategorias();
        instanceOf = this;
    }

    private void cargarCategorias() {
        ArrayList<Categoria> cat = categorias.getLista();
        for (int i = 0; i < cat.size(); i++) {
            final BTCategoria bt = new BTCategoria(cat.get(i));
            bt.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    cargarProductos(bt.getCategoria());
                }
            });
            this.pCategorias.add(bt);
        }
    }

    private void cargarProductos(Categoria cat) {
        this.pProductos.removeAll();
        ArrayList<Productos> prod = (ArrayList<Productos>) productos.busquedaDatos("categoria", cat);
        for (int i = 0; i < prod.size(); i++) {
            final BTProducto bt = new BTProducto(prod.get(i));
            bt.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    if (ubicacion != null) {
                        panelLineas.add(new BTLineas(bt.getProducto(), instanceOf));
                        total += bt.getProducto().getPrecio();
                    }
                    txTotal.setText(total.toString());
                    panelLineas.updateUI();
                }
            });
            this.pProductos.add(bt);
        }
        this.pProductos.updateUI();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        pCategorias = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        pProductos = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        panelLineas = new javax.swing.JPanel();
        jToolBar2 = new javax.swing.JToolBar();
        lbUbicacion = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        jLabel2 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        jButton5 = new javax.swing.JButton();
        txTotal = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        pCategorias.setLayout(new java.awt.GridLayout(0, 6));
        jScrollPane2.setViewportView(pCategorias);

        pProductos.setLayout(new java.awt.GridLayout(0, 6));
        jScrollPane3.setViewportView(pProductos);

        jToolBar1.setFloatable(false);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/tpv_bar/gui/resources/iconoComedor.png"))); // NOI18N
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton2);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/tpv_bar/gui/resources/iconoTerraza.png"))); // NOI18N
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton3);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/tpv_bar/gui/resources/iconoBarra.png"))); // NOI18N
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton4);
        jToolBar1.add(jSeparator4);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/tpv_bar/gui/resources/1334673090_Log Out.png"))); // NOI18N
        jButton1.setText("Cerrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);

        panelLineas.setLayout(new javax.swing.BoxLayout(panelLineas, javax.swing.BoxLayout.PAGE_AXIS));
        jScrollPane1.setViewportView(panelLineas);

        jToolBar2.setFloatable(false);

        lbUbicacion.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lbUbicacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/tpv_bar/gui/resources/iconoComedor.png"))); // NOI18N
        lbUbicacion.setText("Ubicacion");
        jToolBar2.add(lbUbicacion);
        jToolBar2.add(jSeparator1);

        jLabel2.setText("                 ");
        jToolBar2.add(jLabel2);
        jToolBar2.add(jSeparator3);

        jButton5.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/tpv_bar/gui/resources/1334676433_stock_print.png"))); // NOI18N
        jButton5.setText("Imprimir Ticket");
        jButton5.setFocusable(false);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jToolBar2.add(jButton5);

        txTotal.setBackground(new java.awt.Color(1, 1, 1));
        txTotal.setEditable(false);
        txTotal.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        txTotal.setForeground(new java.awt.Color(255, 51, 0));
        txTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txTotal.setText("0.0");

        jLabel1.setFont(new java.awt.Font("Verdana", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(26, 0, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/tpv_bar/gui/resources/1334302320_Cup.png"))); // NOI18N
        jLabel1.setText("La Tasca de leo");
        jLabel1.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jSeparator2)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(12, 12, 12)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jToolBar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane1)
                                .addComponent(jToolBar2, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 849, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(44, 44, 44))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        mesa = new VentanaMesas(this, true, 2);
        mesa.setVisible(true);
        lbUbicacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/tpv_bar/gui/resources/iconoComedor.png")));

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        new VentanaMesas(this, true, 1).setVisible(true);
        lbUbicacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/tpv_bar/gui/resources/iconoTerraza.png")));
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       new VentanaMesas(this,true,3).setVisible(true);
       lbUbicacion.setIcon(new javax.swing.ImageIcon(getClass().getResource
               ("/es/tpv_bar/gui/resources/iconoBarra.png")));
    }//GEN-LAST:event_jButton4ActionPerformed
    double totalCab = 0.0;
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        new VentanaCamareros(this, true).setVisible(true);
        totalCab = 0.0;
        Component[] c = this.panelLineas.getComponents();
        Cabezera cab = new Cabezera();
        cab.setCamarero(camarero);
        cab.setCod(1);
        cab.setFecha(new Date());
        cab.setEstado(0);

        cabezeras.saveDato(cab);
        for (int i = 0; i < c.length; i++) {
            BTLineas bt = (BTLineas) c[i];
            if (bt.isSelect()) {
                totalCab += bt.getLinea().getTotal();
                bt.getLinea().setCabezera(cab);
                bt.getLinea().setCobrado(true);
                lineas.saveDato(bt.getLinea());
                panelLineas.remove(bt);
            }
        }
        cab.setTotal(totalCab);
        cabezeras.saveDato(cab);
        Caja movimiento = new Caja();
        movimiento.setIdCamarero(camarero.getIdCamarero());
        movimiento.setIdCabezera(cab.getIdCabezera());
        movimiento.setFecha(new Date());
        movimiento.setMovimiento(totalCab);
        movimiento.setSaldo(caja.getSaldo() + totalCab);
        caja.saveDato(movimiento);
        System.out.println(movimiento.getIdCaja());
        impresora.setEtiqueta(this.getClass().getResource("/es/tpv_bar/prints/jaspers/ticket.jasper").getPath());
        impresora.setCabezera(cab);
        impresora.setUbi(ubicacion);
        impresora.startPrint();
        this.panelLineas.updateUI();
    }//GEN-LAST:event_jButton5ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaTPV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaTPV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaTPV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaTPV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new VentanaTPV().setVisible(true);
            }
        });
    }

    public void setUbicacion(Ubicacion ubicacion) {

        this.panelLineas.removeAll();
        this.ubicacion = ubicacion;
        this.lbUbicacion.setText(ubicacion.getNombre());
        this.lineasUbi = (ArrayList<Linea>) lineas.getLineasUbicacion(ubicacion);
        System.out.println("Ubicacion: " + this.lineasUbi.size());
        total = 0.0;
        for (int i = 0; i < lineasUbi.size(); i++) {
            Linea l = lineasUbi.get(i);
            panelLineas.add(new BTLineas(l, instanceOf));
            total += l.getTotal();
        }
        this.panelLineas.updateUI();
        this.txTotal.setText(total.toString());
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public void eliminarLinea(Linea l) {
        lineas.removeDato(l);
        this.setUbicacion(ubicacion);
    }

    public void actualizarLinea(Linea l) {
        lineas.updateDato(l);
        this.setUbicacion(ubicacion);
    }
    ArrayList<Linea> lineasUbi;
    Ubicacion ubicacion = null;
    Double total = 0.0;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JLabel lbUbicacion;
    private javax.swing.JPanel pCategorias;
    private javax.swing.JPanel pProductos;
    private javax.swing.JPanel panelLineas;
    private javax.swing.JTextField txTotal;
    // End of variables declaration//GEN-END:variables

    public Camarero getCamarero() {
        return camarero;
    }

    public void setCamarero(Camarero camarero) {
        this.camarero = camarero;
    }
}
