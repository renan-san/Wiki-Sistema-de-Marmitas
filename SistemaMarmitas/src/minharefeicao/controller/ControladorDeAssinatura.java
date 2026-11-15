package minharefeicao.controller;

import java.util.List;
import minharefeicao.entity.Assinatura;
import minharefeicao.entity.Cardapio;
import minharefeicao.entity.Pedido;
import minharefeicao.entity.Plano;
import minharefeicao.persistence.PersistenciaCSV;

public class ControladorDeAssinatura {
    private Assinatura assinaturaAtual;
    private Pedido pedidoAtual;
    private Cardapio cardapio = new Cardapio();
    private ControladorDePagamento ctrlPagamento = new ControladorDePagamento();
    private String codigoGerado;

    public void validarCelular(String celular) {
        this.assinaturaAtual = new Assinatura(celular);
        gerarCodigoConfirmacao();
    }

    private void gerarCodigoConfirmacao() { this.codigoGerado = "1234"; }
    public String getCodigoConfirmacao() { return this.codigoGerado; }
    
    public boolean conferirCodigoValido(String codigoInformado) { return codigoGerado.equals(codigoInformado); }

    public List<Plano> consultarPlanosDisponiveis() { return Plano.consultarPlanosDisponiveis(); }
    public void confirmarPlano(Plano plano) { assinaturaAtual.definirPlano(plano); }
    public void registrarPreferencias(String preferencias) { assinaturaAtual.armazenarPreferencias(preferencias); }

    public void iniciarPedido() { this.pedidoAtual = new Pedido(); }
    
    public List<String> obterPratosDisponiveis(Plano plano, String prefs) { return cardapio.consultarPratos(plano, prefs); }
    public void adicionarPratoAoPedido(String prato) { pedidoAtual.adicionarPratos(prato); }

    public List<String> obterAcompanhamentosDisponiveis() { return cardapio.consultarAcompanhamentos(); }
    public void adicionarAcompanhamentoAoPedido(String acomp) { pedidoAtual.adicionarAcompanhamentos(acomp); }

    // NOVOS: Métodos de Bebidas e Sobremesas
    public List<String> obterBebidasDisponiveis() { return cardapio.consultarBebidas(); }
    public void adicionarBebidaAoPedido(String bebida) { pedidoAtual.adicionarBebidas(bebida); }
    
    public List<String> obterSobremesasDisponiveis() { return cardapio.consultarSobremesas(); }
    public void adicionarSobremesaAoPedido(String sobremesa) { pedidoAtual.adicionarSobremesas(sobremesa); }

    public void confirmarEndereco(String endereco) {
        assinaturaAtual.armazenarEndereco(endereco);
        pedidoAtual.alterarStatus("AGUARDANDO_PAGAMENTO"); 
    }

    public boolean realizarPagamento(String dadosCartao) {
        boolean aprovado = ctrlPagamento.processarPagamento(dadosCartao);
        if (aprovado) {
            assinaturaAtual.alterarStatus("ATIVA"); 
            pedidoAtual.alterarStatus("APROVADO");  
        }
        return aprovado;
    }

    public String finalizarEGerarProtocolo() { 
        String protocolo = assinaturaAtual.gerarNumeroProtocolo();
        PersistenciaCSV.salvarAssinatura(assinaturaAtual); 
        return protocolo; 
    }
    
    public Pedido getPedidoAtual() { return pedidoAtual; }
}