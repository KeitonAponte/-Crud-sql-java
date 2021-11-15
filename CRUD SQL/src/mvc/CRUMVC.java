package mvc;

import modelo.*;
import vista.FrmPruducto;
import controlador.CtrlProducto;

/**
 *
 * @author User
 */
public class CRUMVC {

    public static void main(String[] args) {
        Producto mod = new Producto();
        ConsultasProducto modC = new ConsultasProducto();
        FrmPruducto frm = new FrmPruducto();
        CtrlProducto ctrl = new CtrlProducto(mod, modC, frm);
        ctrl.iniciar();
        frm.setVisible(true);
    }
    
}
