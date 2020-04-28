package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Noticia;
import service.NoticiaService;



@WebServlet("/removerNoticia.do")
public class RemoveNoticiaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private final NoticiaService noticiaService = new NoticiaService();
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Noticia noticia = new Noticia();
		noticia.setId(Integer.parseInt(request.getParameter("id")));
		
		noticiaService.excluirNoticia(noticia);
		
		response.sendRedirect("listaNoticias.do");
	}
		

	

}
