<%-- 
    Document   : interviewAppointment
    Created on : Feb 17, 2020, 2:06:20 AM
    Author     : Tutus W
--%>

<%@page import="models.Employee"%>
<%@page import="models.SkillSet"%>
<%@page import="models.Site"%>
<%@page import="models.Request"%>
<%@page import="models.UserSite"%>
<%@page import="models.Skill"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>SB Admin 2 - Tables</title>

        <!-- Custom fonts for this template -->
        <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="css/sb-admin-2.min.css" rel="stylesheet">

        <!-- Custom styles for this page -->
        <link href="vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">

        <!--CDN Select2-->
        <link href="https://cdn.jsdelivr.net/npm/select2@4.0.13/dist/css/select2.min.css" rel="stylesheet" />
        <script src="https://cdn.jsdelivr.net/npm/select2@4.0.13/dist/js/select2.min.js"></script>

        <script src="https://code.jquery.com/jquery-3.4.0.js"></script>
        <link href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.6-rc.0/css/select2.min.css" rel="stylesheet" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.6-rc.0/js/select2.min.js"></script>


    </head>
    <% // //script plate
        if (session.getAttribute("skills") == null || session.getAttribute("userSites") == null
                || session.getAttribute("sites") == null || session.getAttribute("requests") == null
                || session.getAttribute("skillSets") == null || session.getAttribute("employees") == null) {
            response.sendRedirect("appointment");
        } else {
            List<Skill> skills = (List<Skill>) session.getAttribute("skills");
            List<UserSite> userSites = (List<UserSite>) session.getAttribute("userSites");
            List<Site> sites = (List<Site>) session.getAttribute("sites");
            List<Request> requests = (List<Request>) session.getAttribute("requests");
            List<Employee> employees = (List<Employee>) session.getAttribute("employees");
            List<SkillSet> skillSets = (List<SkillSet>) session.getAttribute("skillSets");
    %>
    <body id="page-top">

        <!-- Page Wrapper -->
        <div id="wrapper">


            <%@include file="common/sidebar.jsp" %>
            <!-- Content Wrapper -->
            <div id="content-wrapper" class="d-flex flex-column">

                <!-- Main Content -->
                <div id="content">

                    <!-- Topbar -->
                    <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

                        <!-- Sidebar Toggle (Topbar) -->
                        <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                            <i class="fa fa-bars"></i>
                        </button>

                        <!-- Topbar Search -->
                        <form class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
                            <div class="input-group">
                                <input type="text" class="form-control bg-light border-0 small" placeholder="Search for..." aria-label="Search" aria-describedby="basic-addon2">
                                <div class="input-group-append">
                                    <button class="btn btn-primary" type="button">
                                        <i class="fas fa-search fa-sm"></i>
                                    </button>
                                </div>
                            </div>
                        </form>

                        <!-- Topbar Navbar -->
                        <ul class="navbar-nav ml-auto">

                            <div class="topbar-divider d-none d-sm-block"></div>

                            <!-- Nav Item - User Information -->
                            <li class="nav-item dropdown no-arrow">
                                <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <span class="mr-2 d-none d-lg-inline text-gray-600 small">Valerie Luna</span>
                                    <img class="img-profile rounded-circle" src="https://source.unsplash.com/QAB-WJcbgJk/60x60">
                                </a>
                                <!-- Dropdown - User Information -->
                                <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="userDropdown">
                                    <a class="dropdown-item" href="#">
                                        <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                                        Profile
                                    </a>
                                    <a class="dropdown-item" href="#">
                                        <i class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>
                                        Settings
                                    </a>
                                    <a class="dropdown-item" href="#">
                                        <i class="fas fa-list fa-sm fa-fw mr-2 text-gray-400"></i>
                                        Activity Log
                                    </a>
                                    <div class="dropdown-divider"></div>
                                    <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">
                                        <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                                        Logout
                                    </a>
                                </div>
                            </li>

                        </ul>

                    </nav>
                    <!-- End of Topbar -->

                    <!-- Begin Page Content -->
                    <div class="container-fluid">

                        <!-- Page Heading -->
                        <h1 class="h3 mb-2 text-gray-800">Interview Appointment</h1>
                        <p class="mb-4">Developer menunggu untuk di interview</p>

                        <!-- DataTales Example -->
                        <div class="card shadow mb-4">
                            <div class="card-header py-3">
                                <h6 class="m-0 font-weight-bold text-primary">Who?</h6>
                            </div>
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                        <thead>
                                            <tr>
                                                <th>No</th>
                                                <th>Requester</th>
                                                <th>Skill</th>
                                                <th>Quantity</th>
                                                <th>Start Date</th>
                                                <th>End date</th>
                                                <th>Note</th>
                                                <th>Action</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <% int i = 1;
                                                for (Request req : requests) {%>
                                            <% try {
                                                    if (req.getStep().equals("interview")) {

                                            %>
                                            <tr>
                                                <td><%= i++%></td>
                                                <td><%= req.getUserSite().getName()%></td>
                                                <td><%= req.getSkill().getName()%></td>
                                                <td><%= req.getQuantity()%></td>
                                                <td><%= req.getStartDate()%></td>
                                                <td><%= req.getEndDate()%></td>
                                                <td><%= req.getNote()%></td>
                                                <td>
                                                    <button type="button" class="btn btn-primary align-right" data-toggle="modal" data-target="#interviewModal">
                                                        Choose Interviewed
                                                    </button>
                                                </td>
                                            </tr>
                                            <% }
                                                    } catch (Exception e) {
                                                        e.printStackTrace();
                                                    }
                                                }
                                            %>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>

                    </div>
                    <!-- /.container-fluid -->

                </div>
                <!-- End of Main Content -->

                <!-- Footer -->
                <footer class="sticky-footer bg-white">
                    <div class="container my-auto">
                        <div class="copyright text-center my-auto">
                            <span>Copyright &copy; Your Website 2019</span>
                        </div>
                    </div>
                </footer>
                <!-- End of Footer -->

            </div>
            <!-- End of Content Wrapper -->

        </div>
        <!-- End of Page Wrapper -->

        <!-- Scroll to Top Button-->
        <a class="scroll-to-top rounded" href="#page-top">
            <i class="fas fa-angle-up"></i>
        </a>

        <!-- Logout Modal-->
        <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                        <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">×</span>
                        </button>
                    </div>
                    <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
                    <div class="modal-footer">
                        <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                        <a class="btn btn-primary" href="login.html">Logout</a>
                    </div>
                </div>
            </div>
        </div>
        <div class="modal fade" id="interviewModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <form action="appointment" method="POST">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Ready to Choose Assigned?</h5>
                            <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">×</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <table border="0" >
                                <tbody>
                                    <tr>
                                        <td>Choose Assigment</td>
                                        <td>
                                            <select class="form-control js-example-basic-multiple" onchange="checkDuplicates"  id="skillSet" name="id">

                                                <% for (SkillSet ss : skillSets) {%>
                                                <option value="<%=ss.getEmployee().getId()%>"><%=ss.getSkill().getName() + "  -  " + ss.getEmployee().getName()%></option>
                                                <% }%>
                                            </select>
                                        </td>

                                    </tr>
                                    <tr>
                                        <td>User :</td>
                                        <td>
                                            <select class="form-control js-example-basic-multiple" onchange="checkDuplicates"  id="skillSet" name="userSite">

                                                <% for (UserSite us : userSites) {%>
                                                <option value="<%=us.getId()%>"><%=us.getName()%></option>
                                                <% }%>
                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>Date</td>
                                        <td><input type="datetime-local" class="form-control" name="interviewDate" value="" /></td>
                                    </tr>
                                    <tr>
                                        <td>Interview With</td>
                                        <td><input type="text" class="form-control" name="interviewer" value="" /></td>
                                    </tr>

                                </tbody>
                            </table>
                        </div>
                        <div class="modal-footer">
                            <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                            <!--<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>-->
                            <button name="modalForm" type="submit" class="btn btn-primary">Save </button>
                        </div>
                    </div>
                </div>
            </form>
        </div>

        <!-- Bootstrap core JavaScript-->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

        <!-- Core plugin JavaScript-->
        <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

        <!-- Custom scripts for all pages-->
        <script src="js/sb-admin-2.min.js"></script>

        <!-- Page level plugins -->
        <script src="vendor/datatables/jquery.dataTables.min.js"></script>
        <script src="vendor/datatables/dataTables.bootstrap4.min.js"></script>

        <!-- Page level custom scripts -->
        <script src="js/demo/datatables-demo.js"></script>

        <script>
                                                $(document).ready(function () {
                                                    $('.js-example-basic-multiple').select2();
                                                });
        </script>


    </body>
    <% }
        session.removeAttribute("skills");
        session.removeAttribute("sites");
        session.removeAttribute("skillSets");
    %>
</html>
