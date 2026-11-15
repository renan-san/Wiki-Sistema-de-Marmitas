package minharefeicao.controller;

import minharefeicao.entity.Pagamento;

public class ControladorDePagamento {
    private Pagamento entidadePagamento = new Pagamento();

    // 52 processarPagamento()
    public boolean processarPagamento(String dadosCartao) {
        // 53 solicitarAutorizacao() (Simulando Operadora de Cartão)
        boolean autorizacaoAprovada = true; 
        
        if (autorizacaoAprovada) {
            // 55 registrarPagamento()
            entidadePagamento.registrarPagamento(dadosCartao);
            return true; // 57 pagamentoAprovado
        }
        return false;
    }
}