package minharefeicao.entity;

import java.util.Arrays;
import java.util.List;

public class Plano {
    private String nome;
    private double valor;

    public Plano(String nome, double valor) {
        this.nome = nome;
        this.valor = valor;
    }

    public static List<Plano> consultarPlanosDisponiveis() {
        return Arrays.asList(new Plano("Mensal Básico", 300.0), new Plano("Mensal Premium", 500.0));
    }

    public String getNome() { return nome; }
    public double getValor() { return valor; }
    
    @Override
    public String toString() { return nome + " (R$ " + valor + ")"; }
}