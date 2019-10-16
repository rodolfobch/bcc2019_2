/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package janelasinternas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Laboratorio
 */
public abstract class DAO<E> {
    protected Connection conn;
    
    public abstract boolean inserir(E element);
    public abstract boolean alterar(E element);
    public abstract boolean remover(E element);
    public abstract List<E> listar();
    
    public DAO(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            String url = "jdbc:mysql://localhost/aula?serverTimezone=UTC";
            String user = "root";
            String pass = "";
            
            conn = DriverManager.getConnection(url,user,pass);
        }catch(ClassNotFoundException e){
            System.out.println("erro no driver");
        }catch(SQLException e){
            System.out.println("erro ao conectar");
        }
    }
}
