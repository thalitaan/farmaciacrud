/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ifsertaope.cs.crud_farmaciaGASA.factory;

import java.sql.*;

/**
 *
 * @author talit
 */
public class ConnectionFactory {
    // Configurações do banco de dados

    private static final String URL = "jdbc:mariadb://localhost:3306/farmaciagasa?user=root&password=032200 [root on Default schema]";
    private static final String USUARIO = "GASA";
    private static final String SENHA = "GASA123";

    // Método para obter uma conexão com o banco de dados.
    public static Connection getConnection() {
        try {
            // Carrega o driver JDBC
            Class.forName("org.mariadb.jdbc.Driver");

            // Retorna a conexão com o banco de dados
            return DriverManager.getConnection(URL, USUARIO, SENHA);

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Erro ao obter a conexão com o banco de dados: " + e.getMessage(), e);
        }
    }

    // Método para fechar a conexão com o banco de dados.
    public static void closeConnection(Connection connection) {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao fechar a conexão com o banco de dados: " + e.getMessage(), e);
        }
    }
}
