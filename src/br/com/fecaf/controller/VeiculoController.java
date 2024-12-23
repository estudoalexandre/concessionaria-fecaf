package br.com.fecaf.controller;

import br.com.fecaf.database.Conexao;
import br.com.fecaf.model.Veiculo;
import br.com.fecaf.view.VeiculoView;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class VeiculoController {
    Conexao conexao = new Conexao();
    VeiculoView veiculoView = new VeiculoView();

    public void consultarVeiculos(){
        try{
            Connection objConnection = conexao.getConnection();
            Statement statement = objConnection.createStatement();

            String queryConsultarVeiculos = "select * from veiculo";
            ResultSet resultSet = statement.executeQuery(queryConsultarVeiculos);

            while(resultSet.next()){
                Veiculo veiculo = new Veiculo();

                veiculo.setModelo(resultSet.getString("modelo"));
                veiculo.setMarca(resultSet.getString("marca"));
                veiculo.setAno(resultSet.getInt("ano"));
                veiculo.setRodas(resultSet.getString("rodas"));
                veiculo.setTipo(resultSet.getString("tipo"));
                veiculo.setCombustivel(resultSet.getString("combustivel"));
                veiculo.setCor(resultSet.getString("cor"));
                veiculo.setCambioAutomatico(resultSet.getBoolean("cambio_automatico"));

                veiculoView.exibirVeiculo(veiculo);

            }
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

}
