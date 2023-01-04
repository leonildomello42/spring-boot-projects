package com.algaworks.algafood.di.service;

import com.algaworks.algafood.di.modelo.Cliente;
import com.algaworks.algafood.di.notificacao.NivelUrgencia;
import com.algaworks.algafood.di.notificacao.Notificador;
import com.algaworks.algafood.di.notificacao.NotificadorEmail;
import com.algaworks.algafood.di.notificacao.TipoDoNotificador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

//@Component
public class AtivacaoClienteService {

    @TipoDoNotificador(NivelUrgencia.NORMAL)
    @Autowired(required = false)
    private Notificador notificador;

    //@PostConstruct
    public void init(){
        System.out.println("init");
    }

    //@PreDestroy
    public void destroy(){
        System.out.println("destroy");
    }

    public void ativer(Cliente cliente){

        cliente.ativar();
        this.notificador.notificar(cliente, "Seu cadastro no sistema está ativo!");
    }
}
