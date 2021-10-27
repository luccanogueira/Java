/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.academico.controllers;

import br.academico.DAO.CursoDAO;
import br.academico.pojo.Curso;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author thiagograzianitraue
 */
public class cursoController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String tipoAcao = request.getParameter("tipoAcao");

            if (tipoAcao.equals("cadastro")) {
                Curso curso = new Curso();

                curso.setNomeCurso(request.getParameter("nomeCurso"));
                curso.setTipoCurso(request.getParameter("tipoCurso"));

                CursoDAO cDAO = new CursoDAO();
                cDAO.insereCurso(curso);

                response.sendRedirect("cadastros/sucesso.jsp?itemCadastrado=curso");
            } else if (tipoAcao.equals("edicao")) {
                //forma 1:
                int idCurso = Integer.parseInt(request.getParameter("idCurso"));
                String nomeNovo = request.getParameter("nomeCurso");
                String tipoNovo = request.getParameter("tipoCurso");
                
                CursoDAO cDAO = new CursoDAO();
                
                cDAO.atualizaCurso(idCurso, nomeNovo, tipoNovo);
                response.sendRedirect("cadastros/sucesso.jsp?itemCadastrado=curso");
                
//                //forma 2 (forma Lucca):
//                Curso c = new Curso();
//                c.setIdCurso(Integer.parseInt(request.getParameter("idCurso")));
//                c.setNomeCurso(request.getParameter("nomeCurso"));
//                c.setTipoCurso(request.getParameter("tipoCurso"));
//              
//                CursoDAO cDAO = new CursoDAO();
//                cDAO.atualizaCurso(c);
//                response.sendRedirect("cadastros/sucesso.jsp?itemCadastrado=curso");
                
               
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
