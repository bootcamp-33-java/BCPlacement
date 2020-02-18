/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.GeneralDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Employee;
import models.EmployeeInterview;
import models.Interview;
import models.SkillSet;
import models.Request;
import models.Site;
import models.Skill;
import models.UserSite;
import tools.HibernateUtil;

/**
 *
 * @author Tutus W
 */
@WebServlet(name = "AppointmentServlet", urlPatterns = {"/appointment"})
public class AppointmentServlet extends HttpServlet {

    private final GeneralDAO<Skill> skdao = new GeneralDAO<>(HibernateUtil.getSessionFactory(), Skill.class);
    private final GeneralDAO<Site> sidao = new GeneralDAO<>(HibernateUtil.getSessionFactory(), Site.class);
    private final GeneralDAO<UserSite> usdao = new GeneralDAO<>(HibernateUtil.getSessionFactory(), UserSite.class);
    private final GeneralDAO<Request> rdao = new GeneralDAO<>(HibernateUtil.getSessionFactory(), Request.class);
//    private final GeneralDAO<Employee> edao = new GeneralDAO<>(HibernateUtil.getSessionFactory(), Employee.class);
    private final GeneralDAO<SkillSet> ssdao = new GeneralDAO<>(HibernateUtil.getSessionFactory(), SkillSet.class);
    private final GeneralDAO<Interview> indao = new GeneralDAO<>(HibernateUtil.getSessionFactory(), Interview.class);
    private final GeneralDAO<EmployeeInterview> eidao = new GeneralDAO<>(HibernateUtil.getSessionFactory(), EmployeeInterview.class);

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
            request.getSession().setAttribute("skills", skdao.getData(null));
            request.getSession().setAttribute("sites", sidao.getData(null));
            request.getSession().setAttribute("userSites", usdao.getData(null)); // membuat nama session untuk servlet register
            request.getSession().setAttribute("requests", rdao.getData(null)); // membuat nama session untuk servlet register
            request.getSession().setAttribute("interviews", indao.getData(null)); // membuat nama session untuk servlet register
//            request.getSession().setAttribute("employees", edao.getData(null)); // membuat nama session untuk servlet register
            request.getSession().setAttribute("skillSets", ssdao.getData(null)); // membuat nama session untuk servlet register
            request.getSession().setAttribute("emplyoeeInterviews", ssdao.getData(null)); // membuat nama session untuk servlet register
//            request.getSession().setAttribute("studyClasss", bdao.getData(null));
            RequestDispatcher rd = request.getRequestDispatcher("interviewAppointment.jsp");
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
        String idUser = request.getParameter("idUser");
        String name = request.getParameter("name");
//        String nameUserSite = request.getParameter("nameUserSite");
        String site = request.getParameter("site");
        String userSite = request.getParameter("userSite");
        String skillSet = request.getParameter("skillSets");
        String interviewDate = request.getParameter("interviewDate");
        String interviewer = request.getParameter("interviewer");
        String employee = request.getParameter("employee");
        String interview = request.getParameter("interview");
        String result = request.getParameter("result");

//        Skill skill1 = new Skill(id, name);
//        skdao.saveOrDelete(skill1, false);
//        try {
////        Interview interview = new Interview(Integer.parseInt(id), interviewer, simple.parse(interviewDate), new UserSite(Integer.parseInt(userSite)));
////        indao.saveOrDelete(interview, false);
//            indao.saveOrDelete(new Interview(0, interviewer, simple.parse(interviewDate), new UserSite(Integer.parseInt(userSite))), false);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        try {
            SimpleDateFormat simple = new SimpleDateFormat("dd/mm/yyyy");
//            public Interview(Integer id, String interviewer, Date interviewDate, UserSite userSite) {
            indao.saveOrDelete(new Interview(0, interviewer, simple.parse("30/12/2019"), new UserSite(Integer.parseInt(userSite))), false);
        } catch (Exception e) {
        }
            eidao.saveOrDelete(new EmployeeInterview(Integer.parseInt(id), new Employee(employee), new Interview(Integer.parseInt(interview)), result), false);
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
