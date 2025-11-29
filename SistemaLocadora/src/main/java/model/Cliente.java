package model;

import jakarta.persistence.Entity;

@Entity
public class Cliente extends Pessoa {

    public Cliente() {}

    public Cliente(String nome, String cpf) {
        super(nome, cpf);
    }

    @Override
    public String getTipo() {
        return "Cliente";
    }
}