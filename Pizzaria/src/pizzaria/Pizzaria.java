/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pizzaria;

import com.br.mackenzie.pizzaria.dao.DAOCliente;
import com.br.mackenzie.pizzaria.dao.DAOProduto;
import com.br.mackenzie.pizzaria.dao.DAOSabor;
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
        System.out.println("Teste");
        DAOCliente dao1 = new DAOCliente();
        DAOProduto dao2 = new DAOProduto();
        DAOSabor dao3 = new DAOSabor();
    }
    
}
