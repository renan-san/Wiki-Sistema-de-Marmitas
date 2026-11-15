package minharefeicao.entity;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private List<String> pratos = new ArrayList<>();
    private List<String> acompanhamentos = new ArrayList<>();
    private List<String> bebidas = new ArrayList<>(); // NOVO
    private List<String> sobremesas = new ArrayList<>();
    private String status = "CRIADO";

    public void adicionarPratos(String prato) { this.pratos.add(prato); }
    public void adicionarAcompanhamentos(String acomp) { this.acompanhamentos.add(acomp); }
    public void adicionarBebidas(String bebida) { this.bebidas.add(bebida); } // NOVO
    public void adicionarSobremesas(String sobremesa) { this.sobremesas.add(sobremesa); }
    
    public void alterarStatus(String novoStatus) { this.status = novoStatus; }
    
    public String getResumo() {
        return "Pratos: " + pratos + " | Acomp: " + acompanhamentos + 
               " | Bebidas: " + bebidas + " | Sobr: " + sobremesas;
    }
}