package br.com.fecaf.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    DatabaseConfig databaseConfig = new DatabaseConfig();

    private String servidor, banco, user, password;

    public Connection conexao;

    public Conexao(){
        this.servidor = "localhost";
        this.banco = databaseConfig.getDatabase();
        this.user = databaseConfig.getUser();
        this.password = databaseConfig.getPassword();
    }

    public boolean connectDrive(){
        try {
            this.conexao = DriverManager.getConnection("jdbc:mysql://" + this.servidor + "/" + this.banco, this.user, this.password);
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Connection getConnection(){
        boolean validarConexao = connectDrive();

        System.out.println(validarConexao);
        if(validarConexao){
            return this.conexao;
        }
        return null;
    }
}
