package model;

import jakarta.persistence.Entity;

@Entity
public class Funcionario extends Pessoa {

    private double salario;

    public Funcionario() {}

    public Funcionario(String nome, String cpf, double salario) {
        super(nome, cpf);
        this.salario = salario;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String getTipo() {
        return "Funcionário";
    }
}