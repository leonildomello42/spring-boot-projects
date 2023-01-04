package com.algaworks.algafood.di.notificacao;

import com.algaworks.algafood.di.modelo.Cliente;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Qualifier("sms")
@Component
public class NotificadorSMS implements Notificador{

    @Override
    public void notificar(Cliente cliente, String mensagem){

        System.out.printf("Notificando %s por SMS através telefone %s: %s\n",
                cliente.getNome(), cliente.getTelefone(), mensagem);
    }
}
