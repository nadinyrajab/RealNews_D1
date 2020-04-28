package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Comentario;
import model.Noticia;
import service.ComentarioService;
import service.NoticiaService;



@WebServlet("/paginaNoticia.do")
public class PaginaNoticiaController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private final NoticiaService noticiaService = new NoticiaService();
	private final ComentarioService comentarioService = new ComentarioService();
	private final Comentario comentario = new Comentario();
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		response.getWriter().println("<a href='paginaPrincipal.do'>Voltar a Home</a>");

		String parameterId = request.getParameter("id") != null && !request.getParameter("id").isEmpty()
				? request.getParameter("id")
				: "-1";
		int id = Integer.parseInt(parameterId);

		if (id <= 0) {
			out.println("<h1>Não foi possivel encontrar Noticia.</h1>");
			return;
		}
		
		Noticia resultado = noticiaService.consultarNoticia(id);

		if (!resultado.isValid()) {
			out.println("<h1>Noticia não encontrada.</h1>");
		} else {
			out.println("<h1>RealNews<h1>");
			out.println("<hr>");
			out.println("<h1>" + resultado.getTitulo() + "</h1>");
			out.println("<h3>" + resultado.getDescricao() + "</h3>");
			out.println("<p>" + resultado.getTexto() + "</p>");
			out.println("<hr>");
			out.println("<h4>Comentários</h4>");

			
			ArrayList<Comentario> comentarios = comentarioService.listar(id);

			if (comentarios.isEmpty()) {
				out.println("<p>Nenhum Comentário.</p>");
			} else {
				for (Comentario comentario : comentarios) {
					out.println("<h5>" + comentario.getNome() + "</h5>");
					out.println("<p>" + comentario.getComentario() + "</p>");
					out.println("<hr>");
				}
			}

			out.println("<form method='post'");
			out.println("<label>Adicionar comentário:</label>");
			out.println("<br>");
			out.println("<input type='hidden' name='idNoticia' value='" + id + "'>");
			out.println("<input type='text' name='nome' placeholder='Seu nome' required>");
			out.println("<br>");
			out.println("<textarea name='texto' placeholder='Seu comentário' required></textarea>");
			out.println("<br>");
			out.println("<input type='submit' value='Enviar'>");
			out.println("</form>");
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nome = request.getParameter("nome"),
				texto = request.getParameter("texto"),
				parameterIdNoticia = request.getParameter("idNoticia") != null && !request.getParameter("idNoticia").isEmpty()
						? request.getParameter("idNoticia")
								: "-1";
						
		int idNoticia = Integer.parseInt(parameterIdNoticia);


		comentario.setIdNoticia(idNoticia);
		comentario.setNome(nome);
		comentario.setComentario(texto);
	
		comentarioService.adicionarComentario(comentario);
		
		
		
		doGet(request, response);
	}

}
