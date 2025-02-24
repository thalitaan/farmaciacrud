/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ifsertaope.cs.crud_farmaciaGASA.dao;

import ifsertaope.cs.crud_farmaciaGASA.factory.ConnectionFactory;
import ifsertaope.cs.crud_farmaciaGASA.dto.UsuarioDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author talit
 */
public class UsuarioDAO {
    
    
    private Connection connection;
    
    public UsuarioDAO() {
        connection = ConnectionFactory.getConnection();
    }
    public ResultSet autenticacaoUsuario(UsuarioDTO usuario) {
        try { 
            String sql = "SELECT * FROM usuarios WHERE user = ? and password = ?";
            
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, usuario.getUser());
            pst.setString(2, usuario.getPassword());
            
            ResultSet rs = pst.executeQuery();
            return rs;
            
        } catch (SQLException e ) {
            System.err.println("Erro ao realizar operação: " + e.getMessage());
            return null;
            
        }
    }
}


