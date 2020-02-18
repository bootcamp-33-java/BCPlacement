<%-- 
    Document   : requestUser
    Created on : Feb 15, 2020, 12:39:05 PM
    Author     : Tutus W
--%>

<%@page import="models.Request"%>
<%@page import="models.Site"%>
<%@page import="models.Skill"%>
<%@page import="models.UserSite"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Request User</title>
        <!-- Custom fonts for this template -->
        <link href="https://cdn.jsdelivr.net/npm/select2@4.0.13/dist/css/select2.min.css" rel="stylesheet" />
        <script src="https://cdn.jsdelivr.net/npm/select2@4.0.13/dist/js/select2.min.js"></script>

        <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="css/sb-admin-2.min.css" rel="stylesheet">

        <!-- Custom styles for this page -->
        <link href="vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">

    </head>
    <% // //script plate
        if (session.getAttribute("skills") == null || session.getAttribute("userSites") == null || session.getAttribute("sites") == null || session.getAttribute("requests") == null) {
            response.sendRedirect("requestUser");
        } else {
            List<Skill> skills = (List<Skill>) session.getAttribute("skills");
            List<UserSite> userSites = (List<UserSite>) session.getAttribute("userSites");
            List<Site> sites = (List<Site>) session.getAttribute("sites");
            List<Request> requests = (List<Request>) session.getAttribute("requests");
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
                        <!-- Topbar Navbar -->
                        <ul class="navbar-nav ml-auto">

                            <!-- Nav Item - Search Dropdown (Visible Only XS) -->
                            <li class="nav-item dropdown no-arrow d-sm-none">
                                <a class="nav-link dropdown-toggle" href="#" id="searchDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <i class="fas fa-search fa-fw"></i>
                                </a>
                                <!-- Dropdown - Messages -->
                                <div class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in" aria-labelledby="searchDropdown">
                                    <form class="form-inline mr-auto w-100 navbar-search">
                                        <div class="input-group">
                                            <input type="text" class="form-control bg-light border-0 small" placeholder="Search for..." aria-label="Search" aria-describedby="basic-addon2">
                                            <div class="input-group-append">
                                                <button class="btn btn-primary" type="button">
                                                    <i class="fas fa-search fa-sm"></i>
                                                </button>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </li>

                            <!-- Nav Item - Alerts -->



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
                        <h1 class="h3 mb-2 text-gray-800">Request User</h1>
                        <!--<p class="mb-4">DataTables is a third party plugin that is used to generate the demo table below. For more information about DataTables, please visit the <a target="_blank" href="https://datatables.net">official DataTables documentation</a>.</p>-->

                        <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                            <form action="requestUser" method="POST" id="reques" >
                                <div class="modal-dialog" role="document">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title" id="exampleModalLabel">Insert Request User</h5>
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                <span aria-hidden="true">&times;</span>
                                            </button>
                                        </div>
                                        <div class="modal-body">
                                            <table border="0" >
                                                <tbody>
                                                    <tr>
                                                        <td>User Request</td>
                                                        <td>
                                                            <select class="form-control" onchange="checkDuplicates" id="userSite" name="userSite">
                                                                <% for (UserSite us : userSites) {%>
                                                                <option value="<%=us.getId()%>"><%=us.getName()%></option>
                                                                <% }%>
                                                            </select>
                                                        </td>
                                                    </tr>
                                                    
                                                    <tr>
                                                        <td>Skill</td>
                                                        <td>
                                                            <select class="form-control" onchange="checkDuplicates"  id="skill" name="skill">
                                                                <% for (Skill skill : skills) {%>
                                                                <option value="<%=skill.getId()%>"><%=skill.getName()%></option>
                                                                <% }%>
                                                            </select>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td>Quantity</td>
                                                        <td><input type="text" class="form-control" name="quantity" value="" /></td>
                                                    </tr>
                                                    <tr>
                                                        <td>Start Date</td>
                                                        <td><input type="date" class="form-control" name="startDateReq" value="" /></td>
                                                    </tr>
                                                    <tr>
                                                        <td>End Date</td>
                                                        <td><input type="date" class="form-control" name="endDateReq" value="" /></td>
                                                    </tr>
                                                    <tr>
                                                        <td>Note</td>
                                                        <td><input type="text" class="form-control" name="note" value="" /></td>
                                                    </tr>
                                                </tbody>
                                            </table>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                            <button name="modalForm" type="submit" class="btn btn-primary">Save </button>
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                        <div class="modal fade" id="exampleModal2" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                            <form action="user" method="POST" id="users">
                                <div class="modal-dialog" role="document">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title" id="exampleModalLabel">Insert User Site</h5>
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                <span aria-hidden="true">&times;</span>
                                            </button>
                                        </div>
                                        <div class="modal-body">

                                            <table border="0" >
                                                <tbody>
                                                    <tr>
                                                        <td>Requester</td>
                                                        <td><input type="text" class="form-control" name="name" value="" /></td>
                                                    </tr>
                                                    <tr>
                                                        <td>Project Name</td>
                                                        <td><input type="text" class="form-control" name="project" value="" /></td>
                                                    </tr>
                                                    <tr>
                                                        <td>Divisi</td>
                                                        <td><input type="text" class="form-control" name="division" value="" /></td>
                                                    </tr>
                                                    <tr>
                                                        <td>Team</td>
                                                        <td><input type="text" class="form-control" name="team" value="" /></td>
                                                    </tr>
                                                    <tr>
                                                        <td>Site</td>
                                                        <td>
                                                            <select class="form-control" onchange="checkDuplicates"  id="site" name="site">

                                                                <% for (Site site : sites) {%>
                                                                <option  value="<%=site.getId()%>"><%=site.getName()%></option>
                                                                <% }%>
                                                            </select>
                                                            
                                                        </td>
                                                    </tr>
                                                </tbody>
                                            </table>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                            <button name="modalForm" type="submit" class="btn btn-primary">Save </button>
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>

                        <!-- DataTales Example -->
                        <div class="card shadow mb-4">
                            <div align ="right" class="card-header py-3"> 
                                <button type="button" class="btn btn-primary align-right" data-toggle="modal" data-target="#exampleModal">
                                    Insert Request
                                </button>
                                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal2">
                                    Insert User
                                </button> 
                            </div>
                            <form action="requestUser" method="GET">
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
                                                        if (req.getStep().equals("new")) {

                                                %>
                                                <tr>
                                                    <td><%= i++%></td>
                                                    <td><%= req.getUserSite().getName()%></td>
                                                    <td><%= req.getSkill().getName()%></td>
                                                    <td><%= req.getQuantity()%></td>
                                                    <td><%= req.getStartDate()%></td>
                                                    <td><%= req.getEndDate()%></td>
                                                    <td><%= req.getNote()%></td>
                                                     <td><a href="requestUser?action=next&id=<%=req.getId()%>&quantity=<%=req.getQuantity() %>&startDateReq=<%=req.getStartDate() %>
                                                       &endDateReq=<%=req.getEndDate() %>&note=<%=req.getNote() %>&userSite=<%=req.getUserSite() %>&skill=<%=req.getSkill() %>" >
                                                        <button type="button" class="btn btn-danger btn-sm">Interview</button></a></td>
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
                            </form>
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
                        <a class="btn btn-primary" href="login.jsp">Logout</a>
                    </div>
                </div>
            </div>
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



    </body>
    <% }
        session.removeAttribute("skills");
        session.removeAttribute("sites");
        session.removeAttribute("userSites");
        session.removeAttribute("requests");
    %>
</html>
