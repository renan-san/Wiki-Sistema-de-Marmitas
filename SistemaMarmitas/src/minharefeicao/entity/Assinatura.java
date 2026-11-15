package minharefeicao.entity;

import java.util.UUID;

public class Assinatura {
    private String celular;
    private Plano plano;
    private String preferencias;
    private String endereco;
    private String status = "INICIADA";
    private String numeroProtocolo;

    public Assinatura(String celular) { this.celular = celular; }

    public void definirPlano(Plano plano) { this.plano = plano; }
    public void armazenarPreferencias(String preferencias) { this.preferencias = preferencias; }
    public void armazenarEndereco(String endereco) { this.endereco = endereco; }
    
    public void alterarStatus(String novoStatus) { this.status = novoStatus; }
    
    public String gerarNumeroProtocolo() {
        this.numeroProtocolo = UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        return this.numeroProtocolo;
    }

    public String toCSV() {
        return numeroProtocolo + ";" + celular + ";" + plano.getNome() + ";" + 
               preferencias + ";" + endereco + ";" + status;
    }
}