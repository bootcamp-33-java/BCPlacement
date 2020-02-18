<%-- 
    Document   : register
    Created on : Feb 13, 2020, 2:47:14 PM
    Author     : Tutus W
--%>

<%@page import="models.StudyClass"%>
<%@page import="models.Skill"%>
<%@page import="java.util.List"%>
<%@page import="models.Batch"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">
        <link href="https://cdn.jsdelivr.net/npm/select2@4.0.13/dist/css/select2.min.css" rel="stylesheet" />
        <script src="https://cdn.jsdelivr.net/npm/select2@4.0.13/dist/js/select2.min.js"></script>
        <title>Register</title>

        <!-- Custom fonts for this template-->
        <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

        <!-- Custom styles for this template-->
        <link href="css/sb-admin-2.min.css" rel="stylesheet">

        <style>
            * {
                box-sizing: border-box;
            }

            body {
                background-color: #f1f1f1;
            }

            #regForm {
                background-color: #ffffff;
                margin: 100px auto;
                font-family: Raleway;
                padding: 40px;
                width: 70%;
                min-width: 300px;
            }

            h1 {
                text-align: center;  
            }

            input {
                padding: 10px;
                width: 100%;
                font-size: 17px;
                font-family: Raleway;
                border: 1px solid #aaaaaa;
            }

            /* Mark input boxes that gets an error on validation: */
            input.invalid {
                background-color: #ffdddd;
            }

            /* Hide all steps by default: */
            .tab {
                display: none;
            }

            button {
                background-color: #4CAF50;
                color: #ffffff;
                border: none;
                padding: 10px 20px;
                font-size: 17px;
                font-family: Raleway;
                cursor: pointer;
            }

            button:hover {
                opacity: 0.8;
            }

            #prevBtn {
                background-color: #bbbbbb;
            }

            /* Make circles that indicate the steps of the form: */
            .step {
                height: 15px;
                width: 15px;
                margin: 0 2px;
                background-color: #bbbbbb;
                border: none;  
                border-radius: 50%;
                display: inline-block;
                opacity: 0.5;
            }

            .step.active {
                opacity: 1;
            }

            /* Mark the steps that are finished and valid: */
            .step.finish {
                background-color: #4CAF50;
            }
        </style>
    </head>
    <% // //script plate
        if (session.getAttribute("batchs") == null) {
            response.sendRedirect("register");
        } else {
            List<Batch> batchs = (List<Batch>) session.getAttribute("batchs");
//            List<Skill> skills = (List<Skill>) session.getAttribute("skills");
//            List<StudyClass> studyClass = (List<StudyClass>) session.getAttribute("studyClass");
    %>
    <body class="bg-gradient-primary">
        <form action="register" method="POST" id="regForm">
            <div class="container">

                <!--<div class="card o-hidden border-0 shadow-lg my-5">-->
                <div class="card-body p-0">
                    <!-- Nested Row within Card Body -->
                    <div class="row">
                        <div class="col-lg-5 d-none d-lg-block" style="padding : 2%">
                            <img src="https://www.metrodata.co.id/web/images/business/2014-08-20-112626.png">
                        </div>
                        <div class="col-lg-7">
                            <div class="p-5">
                                <div class="container col-sm-8">
                                    <div class="text-center">
                                        <h1>Register</h1>
                                    </div>
                                    <!-- One "tab" for each step in the form: -->
                                    <div>

                                    </div>
                                    <div class="tab">Id
                                        <div>
                                            <p><input class="form-control form-control-user" placeholder="Name..." oninput="this.className = ''" name="id"></p>
                                        </div>
                                        <div>Name
                                            <p><input class="form-control form-control-user" placeholder="Name..." oninput="this.className = ''" name="name"></p>
                                        </div>
                                        <div>Phone Number
                                            <p><input type="number" class="form-control form-control-user" placeholder="Phone Number..." oninput="this.className = ''" name="phoneNumber"></p>
                                        </div>
                                    </div>
                                    <div class="tab">        
                                        <div>Hire Date
                                            <p><input type="date" class="form-control form-control-user" placeholder="Hire Date..." oninput="this.className = ''" name="hireDate"></p>
                                        </div>
                                        <div>University
                                            <p><input class="form-control form-control-user" placeholder="University..." oninput="this.className = ''" name="university"></p>
                                        </div>
                                        <div>Batch
                                            <p>
                                                <select class="form-control" onchange="checkDuplicates"  id="idBatch" name="idBatch">
                                                    <% for (Batch batch : batchs) {%>
                                                    <option value="<%=batch.getId()%>"><%=batch.getId()%></option>
                                                    <% }%>
                                                </select>
                                            </p>
                                        </div>
                                    </div>
                                    <div class="tab">
                                        <div>Email
                                            <p><input type="email" class="form-control form-control-user" placeholder="Email..." oninput="this.className = ''" name="email"></p>
                                        </div>
                                        <div>Password
                                            <p><input class="form-control form-control-user" placeholder="Password..." oninput="this.className = ''" name="password" type="password"></p>
                                        </div>
                                    </div>
                                    <div style="overflow:auto;">
                                        <div style="float:right;">
                                            <button type="button" id="prevBtn" onclick="nextPrev(-1)" class="btn btn-primary btn-user btn-block">Previous</button>
                                            <button type="button" id="nextBtn" onclick="nextPrev(1)" class="btn btn-primary btn-user btn-block">Next</button>
                                        </div>
                                    </div>
                                    <!-- Circles which indicates the steps of the form: -->
                                    <div style="text-align:center;margin-top:40px;">
                                        <span class="step"></span>
                                        <span class="step"></span>
                                        <span class="step"></span>
                                    </div>
                                    <div class="text-center">
                                        <a class="small" href="login.jsp">Already have an account? Login!</a>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>

                </div>
            </div>

            <!--</div>-->
        </form>

        <!-- Bootstrap core JavaScript-->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

        <!-- Core plugin JavaScript-->
        <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

        <!-- Custom scripts for all pages-->
        <script src="js/sb-admin-2.min.js"></script>

        <script>
                                                var currentTab = 0; // Current tab is set to be the first tab (0)
                                                showTab(currentTab); // Display the current tab

                                                function showTab(n) {
                                                    // This function will display the specified tab of the form...
                                                    var x = document.getElementsByClassName("tab");
                                                    x[n].style.display = "block";
                                                    //... and fix the Previous/Next buttons:
                                                    if (n == 0) {
                                                        document.getElementById("prevBtn").style.display = "none";
                                                    } else {
                                                        document.getElementById("prevBtn").style.display = "inline";
                                                    }
                                                    if (n == (x.length - 1)) {
                                                        document.getElementById("nextBtn").innerHTML = "Submit";
                                                    } else {
                                                        document.getElementById("nextBtn").innerHTML = "Next";
                                                    }
                                                    //... and run a function that will display the correct step indicator:
                                                    fixStepIndicator(n)
                                                }

                                                function nextPrev(n) {
                                                    // This function will figure out which tab to display
                                                    var x = document.getElementsByClassName("tab");
                                                    // Exit the function if any field in the current tab is invalid:
                                                    if (n == 1 && !validateForm())
                                                        return false;
                                                    // Hide the current tab:
                                                    x[currentTab].style.display = "none";
                                                    // Increase or decrease the current tab by 1:
                                                    currentTab = currentTab + n;
                                                    // if you have reached the end of the form...
                                                    if (currentTab >= x.length) {
                                                        // ... the form gets submitted:
                                                        document.getElementById("regForm").submit();
                                                        return false;
                                                    }
                                                    // Otherwise, display the correct tab:
                                                    showTab(currentTab);
                                                }

                                                function validateForm() {
                                                    // This function deals with validation of the form fields
                                                    var x, y, i, valid = true;
                                                    x = document.getElementsByClassName("tab");
                                                    y = x[currentTab].getElementsByTagName("input");
                                                    // A loop that checks every input field in the current tab:
                                                    for (i = 0; i < y.length; i++) {
                                                        // If a field is empty...
                                                        if (y[i].value == "") {
                                                            // add an "invalid" class to the field:
                                                            y[i].className += " invalid";
                                                            // and set the current valid status to false
                                                            valid = false;
                                                        }
                                                    }
                                                    // If the valid status is true, mark the step as finished and valid:
                                                    if (valid) {
                                                        document.getElementsByClassName("step")[currentTab].className += " finish";
                                                    }
                                                    return valid; // return the valid status
                                                }

                                                function fixStepIndicator(n) {
                                                    // This function removes the "active" class of all steps...
                                                    var i, x = document.getElementsByClassName("step");
                                                    for (i = 0; i < x.length; i++) {
                                                        x[i].className = x[i].className.replace(" active", "");
                                                    }
                                                    //... and adds the "active" class on the current step:
                                                    x[n].className += " active";
                                                }
        </script>

    </body>
    <% }
        session.removeAttribute("batchs");
//        session.removeAttribute("departments");
//        session.removeAttribute("employees");
%>
</html>
