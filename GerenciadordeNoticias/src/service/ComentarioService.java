package service;

import java.util.ArrayList;


import dao.ComentarioDAO;
import model.Comentario;


public class ComentarioService {
private ComentarioDAO comentarioDao;
	
	public ComentarioService() {
		this.comentarioDao = new ComentarioDAO();
	}

	public ArrayList<Comentario> listar(int idNoticia){
		return comentarioDao.listaComentarios(idNoticia);	
	}

		public void adicionarComentario(Comentario comentario) {
		comentarioDao.adicionarComentario(comentario);
	}


}
