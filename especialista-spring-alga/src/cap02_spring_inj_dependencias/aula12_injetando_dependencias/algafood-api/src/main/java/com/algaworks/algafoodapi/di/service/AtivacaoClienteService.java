package com.algaworks.algafoodapi.di.service;

import com.algaworks.algafoodapi.di.modelo.Cliente;
import com.algaworks.algafoodapi.di.notificacao.Notificador;
import com.algaworks.algafoodapi.di.notificacao.NotificadorEmail;
import org.springframework.stereotype.Component;

@Component
public class AtivacaoClienteService {

    private Notificador notificador;

    public AtivacaoClienteService(NotificadorEmail notificador) {
        this.notificador = notificador;
    }

    public void ativar(Cliente cliente) {

        cliente.ativar();
        notificador.notificar(cliente, "Seu cadastro no sistema está ativo!");
    }
}
