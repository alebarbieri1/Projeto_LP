/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pizzaria;

import com.br.mackenzie.pizzaria.dao.DAOUsuario;
import com.br.mackenzie.pizzaria.model.javabeans.Usuario;

/**
 *
 * @author Alexandre Lopes e Felipe Teixeira
 */
public class Pizzaria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DAOUsuario daousuario = new DAOUsuario();
        Usuario u = new Usuario();
        u.setNomeUsuario("alexandre");
        u.setSenha("123");
        u.setTipoUsuario(1);
        long codigo = daousuario.create(u);
        u.setCodigo_usuario(codigo);
    }
    
}
