/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package janelasinternas;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

/**
 *
 * @author Laboratorio
 */
public class AreaDeTrabalho extends JDesktopPane{
    private JInternalFrame cadCliente;
    
    public void abrirCadastroCliente(){
        if(cadCliente==null){
            cadCliente = new CadastroCliente();
            cadCliente.setVisible(true);
            add(cadCliente);
        }
    }
    public void fecharCadastroCliente(){
        cadCliente=null;
    }
}
