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
import models.Request;
import models.Site;
import models.Skill;
import models.UserSite;
import tools.HibernateUtil;

/**
 *
 * @author Tutus W
 */
@WebServlet(name = "RequestServlet", urlPatterns = {"/requestUser"})
public class RequestServlet extends HttpServlet {

    private final GeneralDAO<Skill> skdao = new GeneralDAO<>(HibernateUtil.getSessionFactory(), Skill.class);
    private final GeneralDAO<Site> sidao = new GeneralDAO<>(HibernateUtil.getSessionFactory(), Site.class);
    private final GeneralDAO<UserSite> usdao = new GeneralDAO<>(HibernateUtil.getSessionFactory(), UserSite.class);
    private final GeneralDAO<Request> rdao = new GeneralDAO<>(HibernateUtil.getSessionFactory(), Request.class);
    private final GeneralDAO<Employee> edao = new GeneralDAO<>(HibernateUtil.getSessionFactory(), Employee.class);

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
            request.getSession().setAttribute("userSites", usdao.getData(null));
            request.getSession().setAttribute("skills", skdao.getAll());
            request.getSession().setAttribute("sites", sidao.getAll()); // membuat nama session untuk servlet register
            request.getSession().setAttribute("requests", rdao.getData(null)); // membuat nama session untuk servlet register
            request.getSession().setAttribute("employees", edao.getAll()); // membuat nama session untuk servlet register
//            request.getSession().setAttribute("studyClasss", bdao.getData(null));
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

        String action = request.getParameter("action");
        String id = request.getParameter("id");
//        
//        if (request.getParameter("action") != null) {
//            if (request.getParameter("action").equals("next")) {
//                Request req = rdao.getById(request.getParameter("id"));
//                rdao.saveOrDelete(new Request(req.getId(), req.getQuantity(), req.getStartDate(), req.getEndDate(), req.getNote(), new Skill(req.getSkill().getId()), new UserSite(req.getUserSite().getId()), "interview"), false);
//            }
//        }

//            if (request.getParameter("action") != null && request.getParameter("id") != null) {
//                if (request.getParameter("action").equals("next")) {
//                    Request req = rdao.getById(request.getParameter("id"));
//                request.getSession().setAttribute("request", req);
//                }
//        }

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
        String action = request.getParameter("action");
        String id = request.getParameter("id");
        String name = request.getParameter("name");
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
        rdao.saveOrDelete(new Request(0, Integer.parseInt(quantity), Date.valueOf(startDateReq), Date.valueOf(endDateReq),
                note, new Skill(skill), new UserSite(Integer.parseInt(userSite)), "new"), false);

        
        if (request.getParameter("action") != null) {
            if (request.getParameter("action").equals("next")) {
//                         Request req = new Request(Integer.parseInt(request.getParameter("id")),"interview");
//                         rdao.saveOrDelete(req, false);
                try {
                    SimpleDateFormat simple = new SimpleDateFormat("dd/mm/yyyy");
//                    rdao.saveOrDelete(new Request(Integer.parseInt(request.getParameter("id")), Integer.parseInt(request.getParameter("quantity")),
//                            Date.valueOf(request.getParameter("startDateReq")), Date.valueOf(request.getParameter("endDateReq")),
//                            request.getParameter("note"), new Skill(request.getParameter("skill")), new UserSite(Integer.parseInt(request.getParameter("userSite"))), "interview"), false);
////                    rdao.saveOrDelete(req, false);
                      Request req = new Request(Integer.parseInt(id), Integer.parseInt(quantity), simple.parse(startDateReq),
                              simple.parse(endDateReq), note, new Skill(skill), new UserSite(Integer.parseInt(userSite)), "interview");
                      rdao.saveOrDelete(req, false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.2
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
