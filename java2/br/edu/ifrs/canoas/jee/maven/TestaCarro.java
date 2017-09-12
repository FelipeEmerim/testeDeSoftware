package br.edu.ifrs.canoas.jee.maven;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.*;
import org.junit.Test;

import static org.mockito.Mockito.*;




public class TestaCarro{

	private Carro renegade = mock(Carro.class);
	
		@Test(expected = RuntimeException.class)
		public void disparaExcecao()
		{
			when(renegade.precisaCombustivel()).thenThrow(new RuntimeException());
			try{
				renegade.precisaCombustivel();
			}catch(RuntimeException e){
				assertThat(e).isInstanceOf(RuntimeException.class);
				throw e;
			}
		    
		}
	
	
	@Test
	public void testEhCarro()
	{
		assertThat(renegade instanceof Carro).isTrue();
	}
	
	@Test
	public void testeComportamentoPadrao()
	{
		assertThat(renegade.precisaCombustivel()).isFalse();
		assertThat(renegade.getTemperaturaMotor()).isCloseTo(0.0, within(0.1));
		assertThat(renegade.getTemperaturaMotor()).isEqualTo(0.0, offset(0.1));
		assertThat(renegade.getTemperaturaMotor()).isCloseTo(0.0, withinPercentage(10));
       
		
	}
	
	@Test
	public void testeStub()
	{
		assertEquals("A temperatura do motor é de zero graus",0.0,renegade.getTemperaturaMotor(), 0.0);
		
		when(renegade.getTemperaturaMotor()).thenReturn(200.00);
		
		assertEquals("A temperatura do motor é de duzentos graus",200.00,renegade.getTemperaturaMotor(), 0.0);
	}
	
	
	
	
	
	
	
	
	
}
