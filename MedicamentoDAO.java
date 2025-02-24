/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ifsertaope.cs.crud_farmaciaGASA.dao;
import ifsertaope.cs.crud_farmaciaGASA.factory.ConnectionFactory;
import ifsertaope.cs.crud_farmaciaGASA.dto.MedicamentoDTO;
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
public class MedicamentoDAO {
    private Connection connection;
    private List<MedicamentoDTO> medicamentos;

    public MedicamentoDAO() {
        connection = ConnectionFactory.getConnection();
    }

    // Operações do sistema (CRUD - Create (criar), Read (ler), Update (atualizar) e Delete (apagar)).
    public void adicionarMedicamento(MedicamentoDTO medicamento) {
        try {
            String query = "INSERT INTO medicmanetos (CodMedicamento, nome, preco, quantidade ) VALUES (?, ?, ?)";

            try ( PreparedStatement pst = connection.prepareStatement(query)) {
                pst.setInt(1, medicamento.getCodMedicamento());
                pst.setString(2, medicamento.getnome());
                pst.setFloat(3, medicamento.getpreco());
                pst.setInt(4, medicamento.getquantidade());
                
                pst.executeUpdate();
                pst.close();

            }
        } catch (SQLException e) {
            System.err.println("Erro ao realizar operação: " + e.getMessage());
        }
    }

    public List<MedicamentoDTO> listarMedicamentos() {
        List<MedicamentoDTO> Medicamentos = new ArrayList();

        try {
            String query = "SELECT * FROM medicamentos";

            try ( Statement st = connection.createStatement()) {

                try ( ResultSet rs = st.executeQuery(query)) {
                    while (rs.next()) {
                        int CodMedicamento = rs.getInt("CodMedicamento");
                        String nome = rs.getString("nome");
                        float preco = rs.getFloat("preco");
                        int quantidade = rs.getInt("quantidade");

                        MedicamentoDTO medicamento = new MedicamentoDTO(CodMedicamento, nome, preco, quantidade);

                        medicamentos.add(medicamento);

                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao realizar operação: " + e.getMessage());
        }
        return medicamentos;
    }

    public void atualizarMedicamento(MedicamentoDTO Medicamento) {
        try {
            String query = "UPDATE medicamentos SET nome = ?, preco = ?, quantidade = ? WHERE CodMedicamento = ?";
            try ( PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setString(1, Medicamento.getnome());
                ps.setFloat(2, Medicamento.getpreco());
                ps.setInt(3, Medicamento.getquantidade());
                ps.setInt(4, Medicamento.getCodMedicamento());
               

                ps.executeUpdate();
                ps.close();
            }
        } catch (SQLException e) {
            System.err.println("Erro ao realizar operação: " + e.getMessage());
        }
    }

    public void excluirMedicamento(int CodMedicamento) {
        try {
            String query = "DELETE FROM medicamentos WHERE CodMedicamento = ?";
            try ( PreparedStatement pst = connection.prepareStatement(query)) {
                pst.setInt(1, CodMedicamento);
                pst.executeUpdate();
                pst.close();
            }
        } catch (SQLException e) {
            System.err.println("Erro ao realizar operação: " + e.getMessage());
        }
    }

}
