package br.com.fecaf;

import br.com.fecaf.controller.VeiculoController;
import br.com.fecaf.database.Conexao;
import br.com.fecaf.model.Carro;
import br.com.fecaf.model.Moto;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        VeiculoController veiculoController = new VeiculoController();
        Scanner scanner = new Scanner(System.in);

        veiculoController.consultarVeiculos();


    }
}
