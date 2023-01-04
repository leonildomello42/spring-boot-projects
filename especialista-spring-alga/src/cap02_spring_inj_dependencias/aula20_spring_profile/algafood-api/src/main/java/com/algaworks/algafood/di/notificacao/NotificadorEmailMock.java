package com.algaworks.algafood.di.notificacao;

import com.algaworks.algafood.di.modelo.Cliente;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("dev")
@TipoDoNotificador(value = NivelUrgencia.NORMAL)
@Component
public class NotificadorEmailMock implements Notificador{

    public NotificadorEmailMock(){

        System.out.println("Notificador mock");
    }

    @Override
    public void notificar(Cliente cliente, String mensagem){

        System.out.printf("Notificando %s através do e-mailMock %s: %s\n",
                cliente.getNome(), cliente.getEmail(), mensagem);
    }
}
