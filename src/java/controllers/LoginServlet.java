/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.AccountDAO;
import daos.EmployeeDAO;
import daos.GeneralDAO;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Account;
import models.Employee;
import org.mindrot.jbcrypt.BCrypt;
import tools.HibernateUtil;

/**
 *
 * @author Tutus W
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    private static String token;
    private final EmployeeDAO<Employee> emdao = new EmployeeDAO<>(HibernateUtil.getSessionFactory(), Employee.class);
    private final AccountDAO<Account> aadao = new AccountDAO<>(HibernateUtil.getSessionFactory(), Account.class);
//    private final GeneralDAO<Account> adao = new GeneralDAO<>(HibernateUtil.getSessionFactory(), Account.class);
    private Employee employee;
    
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
            request.getSession().setAttribute("employee", employee);
            RequestDispatcher rd = request.getRequestDispatcher("requestUser.jsp");
            rd.include(request, response);
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
        token = request.getParameter("token");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        
        try {
            Account account = aadao.getByToken(token);
            if (account != null) {
                account = new Account(account.getId(), account.getPassword(), new Short("1"), account.getToken(), employee);
                aadao.saveOrDelete(account, false);
                out.println("<script src= 'https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'> </script>");
                out.println("<script src= 'https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
                out.println("<script src= 'https://unpkg.com/sweetalert/dist/sweetalert.min.js'></script>");
                out.println("<script>");
                out.println("$(document).ready(function(){");
                out.println("swal ('Sukses !', 'Email berhasil diverifikasi!', 'success');");
                out.println("});");
                out.println("</script>");
            }
        } catch (Exception e) {
        }
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
        PrintWriter out = response.getWriter();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        try {
            employee = emdao.getByEmail(email);
            if (employee != null) {
                Account a = aadao.getById(employee.getEmail());
                if (BCrypt.checkpw(password, a.getPassword())) {
                    
                    out.println("<script src= 'https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'> </script>");
                    out.println("<script src= 'https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
                    out.println("<script src= 'https://unpkg.com/sweetalert/dist/sweetalert.min.js'></script>");
                    out.println("<script>");
                    out.println("$(document).ready(function(){");
                    out.println("swal ('Sukses !', 'Berhasil login!', 'success');");
                    out.println("});");
                    out.println("</script>");
                } else {
                    out.println("<script src= 'https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'> </script>");
                    out.println("<script src= 'https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
                    out.println("<script src= 'https://unpkg.com/sweetalert/dist/sweetalert.min.js'></script>");
                    out.println("<script>");
                    out.println("$(document).ready(function(){");
                    out.println("swal ('Gagal !', 'Gagal login!', 'error');");
                    out.println("});");
                    out.println("</script>");
                }
            }
        } catch (Exception e) {
        }
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
