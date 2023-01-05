package com.algaworks.algafoodapi.di.notificacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.algaworks.algafoodapi.di.modelo.Cliente;


//@Profile("prod")
@TipoDoNotificador(NivelUrgencia.NORMAL)
@Component
public class NotificadorEmail implements Notificador {

	@Autowired
	NotificadorProperties properties;
	
	@Override
	public void notificar(Cliente cliente, String mensagem) {

		System.out.println(properties.getPortaServidor());
		System.out.println(properties.getHostServidor());
		
		System.out.printf("Notificando %s através do e-mail %s : %s\n", 
				cliente.getNome(), cliente.getEmail(), mensagem);
	}

}
