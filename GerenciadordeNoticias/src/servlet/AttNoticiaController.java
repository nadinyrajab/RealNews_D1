package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Noticia;
import service.NoticiaService;




@WebServlet("/attNoticia.do")
public class AttNoticiaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final NoticiaService noticiaService = new NoticiaService();
       
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NoticiaService noticiaService = new NoticiaService(); 
		int idNoticia = Integer.parseInt(request.getParameter("id"));
		Noticia noticia = noticiaService.consultarNoticia(idNoticia);
				
				response.setContentType("text/html");
				
				PrintWriter out = response.getWriter();
				
				out.println("<form action='attNoticia.do' method='post'>");
				out.println("<table>");
				out.println("ID: " + noticia.getId());
				out.println("<tr><td></td><td><input type=\"hidden\" name='id' value='"
								+ noticia.getId() + "'/></td></tr>");
				out.println("<tr><td>Descrição:</td><td>");
				out.println("<input type='text' name='descricao' value='" 
								+ noticia.getDescricao() + "'/></td></tr>");
				out.println("<tr><td>Titulo:</td><td>");
				out.println("<input type='text' name='titulo' value='" 
								+ noticia.getTitulo() + "'/></td></tr>");
				out.println("<tr><td>Texto:</td><td>");
				out.println("<input type='text' name='texto' value='"
								+ noticia.getTexto() + "'/></td></tr> ");
								out.println("<tr><td colspan='2'><input type=\"submit\" value=\"Atualizar Noticia\"/></td></tr>");
				out.println("</table>");
				out.println("</form>");
		
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Noticia noticia = new Noticia();
		
		int idNoticia = Integer.parseInt(request.getParameter("id"));
		noticia.setDescricao(request.getParameter("descricao"));
		noticia.setTitulo(request.getParameter("titulo"));	
		noticia.setTexto(request.getParameter("texto"));	
		
		
		noticiaService.editarNoticia(idNoticia, noticia);
			
		 
			   response.sendRedirect("listaNoticias.do");
	            
	      
		
	}	
	

}
