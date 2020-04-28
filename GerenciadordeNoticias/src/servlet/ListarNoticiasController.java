package servlet;

import java.io.IOException;
import java.util.ArrayList;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Noticia;
import service.NoticiaService;

@WebServlet("/listaNoticias.do")
public class ListarNoticiasController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private final NoticiaService noticiaService = new NoticiaService();
    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html"); 
		response.getWriter().println("<a href='index.html'>Adicionar Nova Noticia</a>");
		response.getWriter().println("<a href='paginaPrincipal.do'>Página Principal</a>");
		response.getWriter().println("<h1>Lista de Noticias</h1>");
		response.getWriter().println("<title>Gerenciador de Noticias da RealNews</title>");
		
		ArrayList<Noticia> listaNoticia = noticiaService.listarNoticias();
		
		
		for(Noticia noticia : listaNoticia) {
			response.getWriter().println(
					"<table border='1px'width='100%'>"
							+"<tr>"
								+"<th>Código da Noticia</th>"								
								+"<th>Descrição da Noticia</th>"
								+"<th>Titulo da Noticia</th>"
								+"<th>Texto da Noticia</th>"
								+"<th>Editar</th>"
								+"<th>Remover</th>"
							+"</tr>"
							+"<tr>"
								+"<td>"+noticia.getId()+"</td>"
								+"<td>"+noticia.getDescricao()+"</td>"
								+"<td>"+noticia.getTitulo()+"</td>"
								+"<td>"+noticia.getTexto()+"</td>"								
								+"<td><a href=attNoticia.do?id="+noticia.getId()+">Editar</a></td>"
								+"<td><a href=removerNoticia.do?id="+noticia.getId()+">Remover</a></td>"
							+"</tr>"
					+"</table>");
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
