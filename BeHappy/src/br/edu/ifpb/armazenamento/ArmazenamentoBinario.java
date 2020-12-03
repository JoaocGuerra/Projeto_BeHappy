package br.edu.ifpb.armazenamento;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import br.edu.ifpb.dominio.Direcao;
import br.edu.ifpb.padroes.Singleton.Direcao_Singleton;

public class ArmazenamentoBinario implements Armazenamento {

	private String nomeArquivo;

	public ArmazenamentoBinario(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}

	public Direcao recuperar() {
		Direcao direcao = null;

		try (FileInputStream fis = new FileInputStream(this.nomeArquivo);
			 ObjectInputStream ois = new ObjectInputStream(fis);) {
			direcao = (Direcao) ois.readObject();
		} catch (FileNotFoundException e) {
			direcao = Direcao_Singleton.getInstance().direcao;
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		return direcao;
	}

	public void armazenar(Direcao direcao) {
		try (FileOutputStream fos = new FileOutputStream(this.nomeArquivo);
			 ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			oos.writeObject(direcao);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}