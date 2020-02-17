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
//            request.getSession().setAttribute("employees", edao.getData(null)); // membuat nama session untuk servlet register
            request.getSession().setAttribute("skillSets", ssdao.getData(null)); // membuat nama session untuk servlet register
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

        String id = request.getParameter("id");
        String idUser = request.getParameter("idUser");
        String name = request.getParameter("name");
//        String nameUserSite = request.getParameter("nameUserSite");
        String site = request.getParameter("site");
        String project = request.getParameter("project");
        String division = request.getParameter("division");
        String team = request.getParameter("team");
        String quantity = request.getParameter("quantity");
        String startDateReq = request.getParameter("startDateReq");
        String endDateReq = request.getParameter("endDateReq");
        String note = request.getParameter("note");
        String userSite = request.getParameter("userSite");
        String skill = request.getParameter("skill");
        String step = request.getParameter("step");
        String action = request.getParameter("action");

        if (request.getParameter("action") != null) {
            if (request.getParameter("action").equals("next")) {
//            Request requ = new Request(Integer.parseInt(request.getParameter("id")), "interview");
                try {
                    SimpleDateFormat simple = new SimpleDateFormat("dd/mm/yyyy");
                    Request req = new Request(Integer.parseInt(request.getParameter("id")), Integer.parseInt(request.getParameter("quantity")),
                            simple.parse(request.getParameter("startDateReq")), simple.parse(request.getParameter("endDateReq")),
                            request.getParameter("note"), new Skill(request.getParameter("skill")), new UserSite(Integer.parseInt(request.getParameter("userSite"))), "interview");
                    rdao.saveOrDelete(req, false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
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
        String id = request.getParameter("id");
        String idUser = request.getParameter("idUser");
        String name = request.getParameter("name");
//        String nameUserSite = request.getParameter("nameUserSite");
        String site = request.getParameter("site");
        String project = request.getParameter("project");
        String division = request.getParameter("division");
        String team = request.getParameter("team");
        String quantity = request.getParameter("quantity");
        String startDateReq = request.getParameter("startDateReq");
        String endDateReq = request.getParameter("endDateReq");
        String note = request.getParameter("note");
        String userSite = request.getParameter("userSite");
        String skill = request.getParameter("skill");
        String step = request.getParameter("step");

//        Skill skill1 = new Skill(id, name);
//        skdao.saveOrDelete(skill1, false);
        try {
            Request req = new Request(Integer.parseInt("0"), Integer.parseInt(quantity), Date.valueOf(startDateReq), Date.valueOf(endDateReq), note, new Skill(skill), new UserSite(Integer.parseInt(userSite)), step);
            rdao.saveOrDelete(req, false);

            UserSite user = new UserSite(0, name, project, division, team, new Site(Integer.parseInt(site)));
            usdao.saveOrDelete(user, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String skillSet = request.getParameter("skillSets");
        String date = request.getParameter("date");
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
