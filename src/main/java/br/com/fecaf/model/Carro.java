package br.com.fecaf.model;

import jakarta.persistence.Entity;

@Entity
public class Carro extends Veiculo {
    private double motor;
    private boolean arCondicionado;
    private int portas;

    public double getMotor() {
        return motor;
    }

    public void setMotor(double motor) {
        this.motor = motor;
    }

    public boolean isArCondicionado() {
        return arCondicionado;
    }

    public void setArCondicionado(boolean arCondicionado) {
        this.arCondicionado = arCondicionado;
    }

    public int getPortas() {
        return portas;
    }

    public void setPortas(int portas) {
        this.portas = portas;
    }
}
