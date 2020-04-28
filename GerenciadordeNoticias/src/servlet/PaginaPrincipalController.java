package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Noticia;
import service.NoticiaService;

@WebServlet("/paginaPrincipal.do")
public class PaginaPrincipalController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	 private final NoticiaService noticiaService = new NoticiaService();
	
	 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {			
		
		List<Noticia> noticias = noticiaService.listarNoticias();
		PrintWriter out = response.getWriter();
		out.println("<a href='listaNoticias.do'>Lista de noticias - Administrador</a>");		
		
		out.println("<h1>REAL NEWS</h1>");
		if (noticias.isEmpty()) {
			out.println("<p>Não Há Noticias</p>");
		} else {
			for (Noticia noticia : noticias) {
				out.println("<p><b>Titulo: </b><a href='paginaNoticia.do?id=" + noticia.getId() + "'>" + noticia.getTitulo() + "</a></p>");
				out.println("<p><b>Descrição: </b>" + noticia.getDescricao() + "</p>");
				out.println("<p><b>Texto: </b>" + noticia.getTexto() + "</p>");
				out.println("<hr>");
			}
		}
		
	}
	
}
