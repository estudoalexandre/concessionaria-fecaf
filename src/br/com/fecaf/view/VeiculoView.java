package br.com.fecaf.view;

import java.util.Scanner;

import br.com.fecaf.model.Veiculo;

public class VeiculoView {
    Scanner scanner = new Scanner(System.in);


    public void exibirVeiculo(Veiculo veiculo) {
        System.out.println("===== Informações do Veículo =====");
        System.out.println("Modelo: " + veiculo.getModelo());
        System.out.println("Marca: " + veiculo.getMarca());
        System.out.println("Ano: " + veiculo.getAno());
        System.out.println("Rodas: " + veiculo.getRodas());
        System.out.println("Tipo: " + veiculo.getTipo());
        System.out.println("Combustível: " + veiculo.getCombustivel());
        System.out.println("Cor: " + veiculo.getCor());
        System.out.println("Câmbio Automático: " + (veiculo.isCambioAutomatico() ? "Sim" : "Não"));
        System.out.println("==================================");
    }
}
