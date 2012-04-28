/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.tpv_bar.gui.botones;

import es.tpv_bar.VentanaTPV;
import es.tpv_bar.gui.DlTecladoNum;
import es.tpv_bar.persistencia.modelos.LineaModel;
import es.tpv_bar.persistencia.pojos.Linea;
import es.tpv_bar.persistencia.pojos.Productos;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JOptionPane;

/**
 *
 * @author aperalta
 */
public class BTLineas extends javax.swing.JPanel {

    /**
     * Creates new form BTLineas
     */
    public BTLineas() {
        initComponents();
    }
    Productos producto;
    VentanaTPV parent;
    Linea linea;
    
    
    
    public BTLineas(Productos producto,VentanaTPV parent) {
        this();
        this.parent = parent;
        this.producto = producto;
        
        this.linea = new Linea();
        
        addProducto();
        
    }
    
    public BTLineas(Linea linea,VentanaTPV parent){
        this();
        this.parent = parent;
        this.producto = linea.getProductos();
        this.linea = linea;
         this.lbProducto.setText(this.producto.getNombre());
        this.txPrecio.setText(this.linea.getPrecio().toString());
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txPrecio1 = new javax.swing.JTextField();
        lbProducto = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        txPrecio = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        txPrecio1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txPrecio1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txPrecio1.setText("0.0");
        txPrecio1.setToolTipText("");

        setMaximumSize(new java.awt.Dimension(322, 39));
        setName("");

        lbProducto.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lbProducto.setText("Producto");
        lbProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbProductoMouseClicked(evt);
            }
        });

        jCheckBox1.setSelected(true);

        txPrecio.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txPrecio.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txPrecio.setText("0.0");
        txPrecio.setToolTipText("");
        txPrecio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txPrecioMouseClicked(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/tpv_bar/gui/resources/1334646224_list-remove.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jCheckBox1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbProducto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCheckBox1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txPrecio, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
DlTecladoNum tld;
    private void txPrecioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txPrecioMouseClicked
     tld =  new DlTecladoNum(parent,true,this.txPrecio);
     tld.setVisible(true);
     tld.addWindowListener(new WindowListener() {

            @Override
            public void windowOpened(WindowEvent e) {
                
            }

            @Override
            public void windowClosing(WindowEvent e) {
                
            }

            @Override
            public void windowClosed(WindowEvent e) {
                System.out.println("Escribiendo....");
               
               linea.setPrecio(Double.parseDouble(txPrecio.getText()));
               linea.setTotal(Double.parseDouble(txPrecio.getText()));
               parent.actualizarLinea(linea);
               System.out.println(linea.getPrecio());
            }

            @Override
            public void windowIconified(WindowEvent e) {
                
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
               
            }

            @Override
            public void windowActivated(WindowEvent e) {
               
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
               
            }
        });
    }//GEN-LAST:event_txPrecioMouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
       if(JOptionPane.showConfirmDialog(parent, "¿Esta seguro de eliminar este producto?")==0){
           this.parent.eliminarLinea(linea);
       }
    }//GEN-LAST:event_jLabel1MouseClicked

    private void lbProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbProductoMouseClicked
        if(this.jCheckBox1.isSelected()){
            this.jCheckBox1.setSelected(false);
        }else{
            this.jCheckBox1.setSelected(true);
        }
    }//GEN-LAST:event_lbProductoMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbProducto;
    private javax.swing.JTextField txPrecio;
    private javax.swing.JTextField txPrecio1;
    // End of variables declaration//GEN-END:variables

private void addProducto(){
        this.lbProducto.setText(this.producto.getNombre());
        this.txPrecio.setText(this.producto.getPrecio().toString());
        this.linea.setPrecio(this.producto.getPrecio());
        this.linea.setCatidad(1.0);
        this.linea.setProductos(producto);
        this.linea.setUbicacion(this.parent.getUbicacion());
        this.linea.setTotal(this.producto.getPrecio());
        this.parent.lineas.saveDato(this.linea);
}

    public boolean isSelect() {
        return this.jCheckBox1.isSelected();
    }

    public void setSelect(boolean select) {
        this.jCheckBox1.setSelected(select);
    }

    public Linea getLinea() {
        return linea;
    }

    public void setLinea(Linea linea) {
        this.linea = linea;
    }

  
    
}
