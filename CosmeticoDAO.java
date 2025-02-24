/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ifsertaope.cs.crud_farmaciaGASA.dao;
import ifsertaope.cs.crud_farmaciaGASA.factory.ConnectionFactory;
import ifsertaope.cs.crud_farmaciaGASA.dto.CosmeticoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author talit
 */
public class CosmeticoDAO {
  
    private final Connection connection;

    public CosmeticoDAO() {
        connection = ConnectionFactory.getConnection();
    }

    // Operações do sistema (CRUD - Create (criar), Read (ler), Update (atualizar) e Delete (apagar)).
    public void adicionarCosmetico(CosmeticoDTO cosmetico) {
        try {
            String query = "INSERT INTO cosmeticos (CodCosmetico, nome, preco, quantidade) VALUES (?, ?, ?)";

            try ( PreparedStatement pst = connection.prepareStatement(query)) {
                pst.setInt(1, cosmetico.getCodCosmetico());
                pst.setString(2, cosmetico.getnome());
                pst.setFloat(3, cosmetico.getpreco());
                pst.setInt(4, cosmetico.getquantidade());
                
                pst.executeUpdate();
                pst.close();

            }
        } catch (SQLException e) {
            System.err.println("Erro ao realizar operação: " + e.getMessage());
        }
    }

    public List<CosmeticoDTO> listarCosmeticos() {
        List<CosmeticoDTO> cosmeticos = new ArrayList();

        try {
            String query = "SELECT * FROM cosmeticos";

            try ( Statement st = connection.createStatement()) {

                try ( ResultSet rs = st.executeQuery(query)) {
                    while (rs.next()) {
                        int CodCosmetico = rs.getInt("CodCosmetico");
                        String nome = rs.getString("nome");
                        float preco = rs.getFloat("preco");
                        int quantidade = rs.getInt("quantidade");

                        CosmeticoDTO cosmetico = new CosmeticoDTO(CodCosmetico, nome, preco, quantidade);

                        cosmeticos.add(cosmetico);

                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao realizar operação: " + e.getMessage());
        }
        return cosmeticos;
    }

    public void atualizarCosmeticos(CosmeticoDTO cosmetico) {
        try {
            String query = "UPDATE cosmeticos SET nome = ?, preco = ?, quantidade = ? WHERE CodCosmetico = ?";
            try ( PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setString(1, cosmetico.getnome());
                ps.setFloat(2, cosmetico.getpreco());
                ps.setInt(3, cosmetico.getquantidade());
                ps.setInt(4, cosmetico.getCodCosmetico());
               

                ps.executeUpdate();
                ps.close();
            }
        } catch (SQLException e) {
            System.err.println("Erro ao realizar operação: " + e.getMessage());
        }
    }

    public void excluirCosmeticos(int CodCosmetico) {
        try {
            String query = "DELETE FROM cosmeticos WHERE CodCosmetico = ?";
            try ( PreparedStatement pst = connection.prepareStatement(query)) {
                pst.setInt(1, CodCosmetico);
                pst.executeUpdate();
                pst.close();
            }
        } catch (SQLException e) {
            System.err.println("Erro ao realizar operação: " + e.getMessage());
        }
    }

    private static class cosmetico {

        private static int getCodCosmetico() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private static String getnome() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private static float getpreco() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private static int getquantidade() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        public cosmetico() {
        }
    }
}



