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


@WebServlet("/addNoticia.do")
public class AddNoticiaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final NoticiaService noticiaService = new NoticiaService();
   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	@SuppressWarnings("unused")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
		PrintWriter out= response.getWriter();
		
		Noticia noticia = new Noticia();
		
		noticia.setDescricao(request.getParameter("descricao"));
		noticia.setTitulo(request.getParameter("titulo"));	
		noticia.setTexto(request.getParameter("texto"));	
		
		
		noticiaService.adicionarNoticia(noticia);
		
		
		 if(noticia != null){  
	            out.print("<p>Noticia Salva com Sucesso!</p>");  
	            request.getRequestDispatcher("index.html").include(request, response); 
	            
	        }else{  
	            out.println("Desculpe não foi possivel Salvar");  
	        }  
		
		 out.close();  
		
	}
	

}
