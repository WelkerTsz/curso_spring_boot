package br.com.alura.forum.controllers.forms;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.alura.forum.model.Topico;
import br.com.alura.forum.repository.TopicoRepository;

public class AtualizaTopicoForm {

	@NotEmpty(message = "título inválido")
	@NotNull
	@Length(min = 1)
	private String titulo;
	@Length(min = 1)
	private String mensagem;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Topico atualizar(Long id, TopicoRepository topicoRepository) {
		Topico topico = topicoRepository.getOne(id);

		topico.setTitulo(this.titulo);
		topico.setMensagem(this.mensagem);

		return topico;
	}

}
