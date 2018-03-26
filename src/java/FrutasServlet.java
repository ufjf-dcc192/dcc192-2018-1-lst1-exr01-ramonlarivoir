/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ramon Larivoir
 */
@WebServlet(urlPatterns = {"/fruta.html"})
public class FrutasServlet extends HttpServlet {
    
    private List<String> frutas = new ArrayList<String>();
    private Comparador c = new Comparador();
    
    public FrutasServlet() {
        frutas.add("Maça");
        frutas.add("Banana");
        frutas.add("Laranja");
        frutas.add("Uva");
        frutas.add("Pêssego");
        frutas.add("Goiaba");        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
            String ordenacao = request.getParameter("ordenacao");
        
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Frutas</title>");
            out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">");        out.println("</head>");
            out.println("<body class='container'>");
            out.println("<h1>Frutas</h1>");
            out.println("<ul>");
            out.println("<a href='?ordenacao=a'>Ordenação alfabética</a>");
            out.println("<a href='?ordenacao=r'>Ordenação randômica</a>");
            out.println("<a href='?ordenacao=t'>Ordenação por tamanho</a>");
            switch(ordenacao) {
                case "a":
                    Collections.sort(frutas);
                    break;
                
                case "r":
                    Collections.shuffle(frutas);
                    break;
                    
                case "t":
                    Collections.sort(frutas, c);
            }
            for (String fruta : frutas) {
                out.println("<li>" + fruta + "</li>");

            }
            out.println("</ul>");
            out.println("</body>");
            out.println("</html>");
        }
        
    }

    
}
