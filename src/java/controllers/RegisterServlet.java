/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.EmployeeDAO;
import daos.GeneralDAO;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Account;
import models.Batch;
import models.BatchClassMember;
import models.Employee;
import models.StudyClass;
import org.mindrot.jbcrypt.BCrypt;
import tools.HibernateUtil;

/**
 *
 * @author Tutus W
 */
@WebServlet(name = "RegisterServlet", urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {

    private final GeneralDAO<Account> adao = new GeneralDAO<>(HibernateUtil.getSessionFactory(), Account.class);
    private final GeneralDAO<Employee> edao = new GeneralDAO<>(HibernateUtil.getSessionFactory(), Employee.class);
    private final GeneralDAO<Batch> bdao = new GeneralDAO<>(HibernateUtil.getSessionFactory(), Batch.class);
    private final GeneralDAO<StudyClass> scdao = new GeneralDAO<>(HibernateUtil.getSessionFactory(), StudyClass.class);
    private final EmployeeDAO<Employee> emdao = new EmployeeDAO<>(HibernateUtil.getSessionFactory(), Employee.class);

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
//            request.getSession().setAttribute("employee", edao.getData(null));
            request.getSession().setAttribute("account", adao.getData(null));
            request.getSession().setAttribute("batchs", bdao.getData(null)); // membuat nama session untuk servlet register
            request.getSession().setAttribute("studyClasss", bdao.getData(null)); // membuat nama session untuk servlet register
            RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
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
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String phoneNumber = request.getParameter("phoneNumber");
        String email = request.getParameter("email");
        String hireDate = request.getParameter("hireDate");
        String status = request.getParameter("status");
        String university = request.getParameter("university");
        String availability = request.getParameter("availability");
        String password = request.getParameter("password");
        String Batch = request.getParameter("idBatch");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
//        String password = request.getParameter("password");
//        String batchClassMember = request.getParameter("batchClassMember");

//        try{
//        SimpleDateFormat simple = new SimpleDateFormat("dd/mm/yyyy");
//        Batch batch = new Batch(Integer.parseInt(id), simple.parse(startDate), simple.parse(endDate));
//        bdao.saveOrDelete(batch, false);
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//        StudyClass sc = new StudyClass();
//        scdao.saveOrDelete(sc, false);
        try {
            Employee employee = new Employee(id, name, email, phoneNumber, university, Date.valueOf(hireDate), status, availability);
            edao.saveOrDelete(employee, false);

            int n = 60;
            String pass = BCrypt.hashpw(password, BCrypt.gensalt());
            String token = RegisterServlet.getAlphaNumericString(n);
            Account account = new Account(id, pass, new Short("0"), token, new Employee(id));
            adao.saveOrDelete(account, false);

            //kirim email
            JavaMailUtil.sendMail(email, "http://localhost:8084/Bootcamp_Placemennt/login.jsp?id="+token);
        } catch (Exception e) {
            e.printStackTrace();
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

    static String getAlphaNumericString(int n) {

        // chose a Character random from this String 
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        // create StringBuffer size of AlphaNumericString 
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {

            // generate a random number between 
            // 0 to AlphaNumericString variable length 
            int index
                    = (int) (AlphaNumericString.length()
                    * Math.random());

            // add Character one by one in end of sb 
            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }


}
