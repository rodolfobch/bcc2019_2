/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package janelasinternas;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.jdesktop.observablecollections.ObservableCollections;

/**
 *
 * @author Laboratorio
 */
public class ClienteDAO extends DAO<Cliente> {

    @Override
    public boolean inserir(Cliente element) {
        String sql = "INSERT INTO cliente (nome,endereco,datanasc) values (?,?,?);";
        try{
            PreparedStatement stmt = conn.prepareStatement(sql,
                                        Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, element.getNome());
            stmt.setString(2, element.getEndereco());
            stmt.setDate(3, element.getDataNasc());
            
            if(stmt.executeUpdate()==1){
                ResultSet rs = stmt.getGeneratedKeys();
                rs.next();
                element.setIdCliente(rs.getInt(1));
                return true;
            }
        }catch(SQLException e){
            System.out.println("erro ao inserir");
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean alterar(Cliente element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean remover(Cliente element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Cliente> listar() {
        List<Cliente> lstClientes = new ArrayList<>();
        lstClientes = ObservableCollections.observableList(lstClientes);
        
        String sql = "SELECT * FROM cliente;";
        try{
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()){
                Cliente c = new Cliente();
                c.setIdCliente(rs.getInt("id_cliente"));
                c.setNome(rs.getString("nome"));
                c.setEndereco(rs.getString("endereco"));
                c.setDataNasc(rs.getDate("datanasc"));
                lstClientes.add(c);
            }
        }catch(SQLException e){
            System.out.println("erro ao listar: "+e.getMessage());
        }
        return lstClientes;
    }
    
    public static void main(String[] args) {
        Cliente c = new Cliente();
        c.setNome("Mario ','Rua ZYC'),('abc','def'); -- ");
        c.setEndereco("Rua XYZ");
        
        ClienteDAO cd = new ClienteDAO();
        cd.inserir(c);
    }
        
}
