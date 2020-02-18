/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import daos.GeneralDAO;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.List;
import models.Account;
import models.Batch;
import models.Employee;
import models.EmployeeInterview;
import models.Interview;
import models.Request;
import models.Site;
import models.Skill;
import models.UserSite;
import org.hibernate.SessionFactory;

/**
 *
 * @author Tutus W
 */
public class ManualTestGeneral {
//    private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public static void main(String[] args) {
        // ---------------------------------------- Deklarasi DAO ----------------------------------------//
//        GeneralDAO<Account> adao = new GeneralDAO<>(HibernateUtil.getSessionFactory(), Account.class);
        GeneralDAO<Account> adao = new GeneralDAO<>(sessionFactory, Account.class);
        GeneralDAO<Employee> edao = new GeneralDAO<>(sessionFactory, Employee.class);
        GeneralDAO<Batch> bdao = new GeneralDAO<>(sessionFactory, Batch.class);
        GeneralDAO<UserSite> usdao = new GeneralDAO<>(sessionFactory, UserSite.class);
        GeneralDAO<Request> rdao = new GeneralDAO<>(sessionFactory, Request.class);
        GeneralDAO<Skill> sdao = new GeneralDAO<>(sessionFactory, Skill.class);
        GeneralDAO<Interview> indao = new GeneralDAO<>(sessionFactory, Interview.class);
        GeneralDAO<EmployeeInterview> eidao = new GeneralDAO<>(sessionFactory, EmployeeInterview.class);
//
//        try {
//            SimpleDateFormat simple = new SimpleDateFormat("dd/mm/yyyy");
//        indao.saveOrDelete(new Interview(0, "Gugun", simple.parse("12/12/2019"), new UserSite(2)), false);
//        }catch(Exception e ){
//            
//        }

            System.out.println(eidao.saveOrDelete(new EmployeeInterview(0, new Employee("16152"), new Interview(8), "PENDING"), false));

//        for (Employee t : edao.getData(null)) {
//            System.out.print(t.getId() + "  | ");
//            System.out.println(t.getName() + " | ");
//            System.out.println(t.getPhoneNumber() + " | ");
//            System.out.println(t.getUniversity() + " | ");
//        }
//        for (Account t : adao.getData(null)) {
//            System.out.print(t.getId() + "  | ");
//            System.out.println(t.getPassword()+ " | ");
//            System.out.println(t.getIsVerified()+ " | ");
//            System.out.println(t.getToken()+ " | ");
//        }
        // ---------------------------------------- Testing  ----------------------------------------//       
//        Get By ID
//        Request req = rdao.getById(9);
//        rdao.saveOrDelete(new Request(req.getId(), req.getQuantity(), req.getStartDate(), req.getEndDate(), req.getNote(), new Skill(req.getSkill().getId()), new UserSite(req.getUserSite().getId()), "interview"), false);
//        System.out.println(department.getId() + "\n" + department.getName());
//        System.out.println(department.getManagerial()== null ? "0" : department.getManagerial().getId());
//        System.out.println(department.getLocation().getId());
//        System.out.println("-----------------------------------");
        //Get Daata
//        for (Employee e : edao.getData("11")) {
//            System.out.println(e.getId()+ "\n" + e.getName());
//            System.out.println(e.getName()== null ? "0" : e.getId());
//            System.out.println(e.getEmail()+ "\n");
//        }
        //SAVE OR DELETE
//        System.out.println(igdao.saveOrDelete(new Department(new Short("301")),true));
        //DEPARTMENT END ------------------------------------------------------------------------
        //Spesial aja
        //Lain-lain
        //Save ato Update ato Delete
        //Region
//        try{
//                    SimpleDateFormat simple = new SimpleDateFormat("dd/mm/yyyy");
//////        System.out.println(sudao.saveOrDelete(new UserSite(0,"nana",982111,"asa@gmail.com","12/12/2011","0"), false));
//////          System.out.println(usdao.saveOrDelete(new UserSite("tutus","mobile","it","dev",new Site(1)), false));
////          System.out.println(usdao.saveOrDelete(new UserSite("tutus","mobile","it","dev",new Site(1)), false));
////            System.out.println(rdao.saveOrDelete(new Request(Integer.SIZE, Integer.SIZE, startDate, endDate, note, skill, userSite), true));
//          System.out.println(rdao.saveOrDelete(new Request(0,3,simple.parse("01/01/2018"), simple.parse("02/02/2019"), 
//                  "laki 2 sisanya cewe",  new Skill("IT_NET"), new UserSite(2), "new"), false));
//          System.out.println(usdao.saveOrDelete(new UserSite(0, "Aqira", "Mobile", "ADD", "bootcamp", new Site(2)), false));
////            System.out.println(usdao.saveOrDelete(new UserSite(0, "Dev", "Bootcamp Placement", "ADD", "Dev", new Site(2)), false));
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//          System.out.println(usdao.saveOrDelete(new UserSite(0,"agus", "baru", "ADD", "IT", new Site(1)), false));
//          System.out.println(usdao.saveOrDelete(new UserSite(0, "yuni", "sistem informasi", "IT", "nana", new Site(2)), false));
//            System.out.println(usdao.saveOrDelete(new UserSite(0,"Tutus", "project beneran", "ADD2", "bootcamp", new Site(3)), false));
//        System.out.println(rdao.saveOrDelete(new Region (new BigDecimal(11), "cobaa"), false));
//        System.out.println(edao.saveOrDelete(new Region (new BigDecimal(11), "coba"), true));
//        System.out.println(edao.saveOrDelete(new Employee()., true);
        /*
        //Country
        System.out.println(cdao.saveOrDelete(new Country("ad", "asasasa", new Region(new BigDecimal(11))), false));
        System.out.println(cdao.saveOrDelete(new Country("ad", "asasasaaa", new Region(new BigDecimal(11))), false));
        System.out.println(cdao.saveOrDelete(new Country("ad", "asasasa", new Region(new BigDecimal(11))), true));
         */
//        try {
//            SimpleDateFormat simple = new SimpleDateFormat("dd/mm/yyyy");
//            System.out.println(edao.saveOrDelete(new Employee(0,"tutus","widiya","kka@mail.com","121",simple.parse("01/01/2011"),BigDecimal.valueOf(10),BigDecimal.valueOf(0),new Department(new Short("100")),new Employee(Integer.parseInt("90")),new Job("AD_VP")),true));
//        }catch(Exception e){
//        e.printStackTrace();
////        }
//                ----------- saveordelete---------------
//        try {
//            SimpleDateFormat simple = new SimpleDateFormat("dd/mm/yyyy");
//        System.out.println(edao.saveOrDelete(new Employee("16150", "galih", "galih@gmail.com", "081217727", "UDINUS", simple.parse("01/01/2020"), "", ""), false));
//    }catch(Exception e){
//        e.printStackTrace();
//    }
//        try {
////            request.getSession().setAttribute("account", adao.getData(null));
////            Account account = new Account(id, pass, new Short("0"), "43242", new Employee(id));
//            SimpleDateFormat simple = new SimpleDateFormat("dd/mm/yyyy");
//            System.out.println(edao.saveOrDelete(new Employee("12480", "tutu", "tutu@gmail.com", "088888888", "uksw", simple.parse("01/01/2020"), "", ""), false));
//            Employee emp = edao.getById("12480");
//            System.out.println(adao.saveOrDelete(new Account(emp.getId() , "tuu", new Short("0"), "08812488888",new Employee(emp.getId())), false));
//        } catch (Exception e) {
//            e.printStackTrace();
    }
//        try {
//            SimpleDateFormat simple = new SimpleDateFormat("dd/mm/yyyy");
//            System.out.println(bdao.saveOrDelete(new Batch(Integer.parseInt("12"), simple.parse("11/12/2011"), simple.parse("14/12/2011") ), false));
//            } catch (Exception e) {
//            e.printStackTrace();
//        }
//public Account(String id, String password, short isVerified, String token) {
//        Account e = new Account("8918", "password", new Short("0"), "token");
//        System.out.println(adao.saveOrDelete(e,false));
//        System.out.println(adao.saveOrDelete(new Account(0, "qqq",new Short("0"),"papspd"), false));
//        try {
////            SimpleDateFormat simple = new SimpleDateFormat("dd/mm/yyyy");
//            Account a = new Account();
//            System.out.println(adao.saveOrDelete(new Account(a.getId("16157"),", new Short("0"),"pasa"), false));
//        }catch(Exception e){
//        e.printStackTrace();
//        }
//        System.out.println(adao.getData(adao)"");(emp.get(0), pass, new Short("0"), "");
}
