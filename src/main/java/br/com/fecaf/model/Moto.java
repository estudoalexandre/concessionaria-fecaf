package br.com.fecaf.model;

import jakarta.persistence.Entity;

@Entity
public class Moto extends Veiculo {

    private int cilindradas;
    private boolean bauCarga;

    public int getCilindradas() {
        return cilindradas;
    }

    public void setCilindradas(int cilindradas) {
        this.cilindradas = cilindradas;
    }

    public boolean isBauCarga() {
        return bauCarga;
    }

    public void setBauCarga(boolean bauCarga) {
        this.bauCarga = bauCarga;
    }
}
