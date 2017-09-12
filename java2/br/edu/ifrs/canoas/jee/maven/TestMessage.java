package br.edu.ifrs.canoas.jee.maven;


import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.*;
import org.junit.Test;

import static org.mockito.Mockito.*;


public class TestMessage {

	private static final String CLIENTE_EMAIL = "Felipe Emerim";
	private static final String MSG_CONTENT = "Caro Felipe, "+"você ganhou uma Ferrari";
	
	public void testSendMessage()
	{
	
		Cliente cliente = mock(Cliente.class);
		Template template = mock(Template.class);
		TemplateEngine templateEngine = mock(TemplateEngine.class);
		MailServer mailServer = mock(MailServer.class);
		
		Messenger messenger = new Messenger(mailServer, templateEngine);
		
		when(cliente.getEmail()).thenReturn(CLIENTE_EMAIL);
		
		when(templateEngine.prepareMessage(template, cliente)).thenReturn(MSG_CONTENT);
		
		messenger.sendMessage(cliente, template);
		
		verify(mailServer).send(CLIENTE_EMAIL, MSG_CONTENT);
	}
	

}
