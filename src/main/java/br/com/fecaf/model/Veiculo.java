package br.com.fecaf.model;


import jakarta.persistence.*;

@Entity
@Table(name = "veiculo")
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String modelo;
    private String marca;
    private int ano;
    private String rodas;
    private String tipo;
    private String combustivel;
    private String cor;
    private boolean cambioAutomatico;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getRodas() {
        return rodas;
    }

    public void setRodas(String rodas) {
        this.rodas = rodas;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public boolean isCambioAutomatico() {
        return cambioAutomatico;
    }

    public void setCambioAutomatico(boolean cambioAutomatico) {
        this.cambioAutomatico = cambioAutomatico;
    }
}
