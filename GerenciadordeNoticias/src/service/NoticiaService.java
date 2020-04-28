package service;

import java.util.ArrayList;


import dao.NoticiaDAO;
import model.Noticia;




public class NoticiaService {
	
	private NoticiaDAO noticiaDao = new NoticiaDAO();
	
	public void adicionarNoticia(Noticia noticia) {
		noticiaDao.adicionar(noticia);
	}
	
	public Noticia consultarNoticia(int id) {
		
		return noticiaDao.consultar(id);	
	}
	
	public void editarNoticia(int idNoticia, Noticia noticia) {
		noticiaDao.editar(idNoticia, noticia);
	}

	
	public void excluirNoticia(Noticia noticia) {
		noticiaDao.excluir(noticia);
	}
	
	
	public ArrayList<Noticia> listarNoticias() {
		
		return noticiaDao.listarnoticias();	
	}

	


}
