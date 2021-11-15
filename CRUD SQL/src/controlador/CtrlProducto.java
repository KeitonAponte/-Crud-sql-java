package controlador;

import modelo.*;
import vista.FrmPruducto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Action;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class CtrlProducto implements ActionListener {

    private final Producto mod;
    private final ConsultasProducto modC;
    private final FrmPruducto frm;

    public CtrlProducto(Producto mod, ConsultasProducto modC, FrmPruducto frm) {
        this.mod = mod;
        this.modC = modC;
        this.frm = frm;
        //acciones para  los botones
        this.frm.btnGuardar.addActionListener(this);
        this.frm.btnBuscar.addActionListener(this);
        this.frm.btnEliminar.addActionListener(this);
        this.frm.btnModificar.addActionListener(this);
        this.frm.btnLimpiar.addActionListener(this);
    }
    //metodo para iniciar la vists

    public void iniciar() {
        frm.setTitle("Ventas");
        frm.setLocationRelativeTo(null);
        frm.txtId.setVisible(false);

    }

    //meotod que escuche clic a  los botones
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frm.btnGuardar) {
            mod.setCodigo(frm.txtCodigo.getText());
            mod.setNombre(frm.txtNombre.getText());
            mod.setPrecio(Double.parseDouble(frm.txtPrecio.getText()));
            mod.setCantidad(Integer.parseInt(frm.txtCantidad.getText()));
            if (modC.registar(mod)) {
                JOptionPane.showMessageDialog(null, "Registro guardado");
                Limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar");
                Limpiar();
            }
        }

        if (e.getSource() == frm.btnModificar) {
            mod.setId(Integer.parseInt(frm.txtId.getText()));
            mod.setCodigo(frm.txtCodigo.getText());
            mod.setNombre(frm.txtNombre.getText());
            mod.setPrecio(Double.parseDouble(frm.txtPrecio.getText()));
            mod.setCantidad(Integer.parseInt(frm.txtCantidad.getText()));
            if (modC.registar(mod)) {
                JOptionPane.showMessageDialog(null, "Registro Modificado");
                Limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Modificar");
                Limpiar();
            }
        }

        if (e.getSource() == frm.btnEliminar) {
            mod.setId(Integer.parseInt(frm.txtId.getText()));

            if (modC.registar(mod)) {
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
                Limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Eliminar");
                Limpiar();
            }
        }

        if (e.getSource() == frm.btnBuscar) {
            mod.setCodigo(frm.txtCodigo.getText());

            if (modC.registar(mod)) {
                frm.txtId.setText(String.valueOf(mod.getId()));
                frm.txtCodigo.setText(mod.getCodigo());
                frm.txtNombre.setText(mod.getNombre());
                frm.txtPrecio.setText(String.valueOf(mod.getPrecio()));
                frm.txtCantidad.setText(String.valueOf(mod.getCantidad()));

            } else {
                JOptionPane.showMessageDialog(null, "No se encontro Registro");
                Limpiar();
            }
        }

        if (e.getSource() == frm.btnLimpiar) {
            Limpiar();
        }
    }

    public void Limpiar() {

        frm.txtCantidad.setText(null);
        frm.txtCodigo.setText(null);
        frm.txtId.setText(null);
        frm.txtNombre.setText(null);
        frm.txtPrecio.setText(null);

    }

}
