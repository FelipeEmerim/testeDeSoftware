package br.edu.ifrs.canoas.jee.maven;

public interface TemplateEngine {
	public String prepareMessage(Template template, Cliente cliente);
}
