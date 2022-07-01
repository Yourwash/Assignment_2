<%-- 
    Document   : index
    Created on : Jun 21, 2022, 1:32:00 PM
    Author     : georg
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Trainers</title>

        <!-- CSS only  -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

        <!-- JavaScript Bundle with Popper  -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>

        <!-- Latest compiled and minified CSS  -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

        <!-- jQuery library  -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

        <!-- Custom CSS -->       
        <style><%@include file="/WEB-INF/css/Stylesheet-1.css"%></style>

        <!-- Custom JavaScript -->
        <script type="text/javascript"><%@include file="/WEB-INF/js/trainers.js"%></script>

    </head>

    <body style="background-color: black; color: white;">
        <div id="container mb-0 pb-0" class="content">
            <header class="jumbotron bg-warning text-center mt-4">
                <h1>Trainers' Page</h1>           
            </header>

            <nav class="navbar navbar-expand-lg navbar-light bg-warning">
                <a href="#" class="navbar-brand">Trainer's Form</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar"><span
                        class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="collapsibleNavbar">
                    <ul class="navbar-nav text-center">
                        <li class="nav-item">
                            <a class="nav-link" href="courses.html">Course's Form</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="students.html">Students's Form</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="assignments.html">Assignment's Form</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="trainers_per_course.html">Trainers per Course</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="students_per_course.html">Students per Course</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="assignments_per_course.html">Assignments per Course</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="assignment_per_student_per_course.html">Assignments per Student per
                                Course</a>
                        </li>
                    </ul>
                </div>
            </nav><!-- End of Bootstrap Navigation Bar -->

            <h1>Trainers' Data</h1>
            <div class='row border-top border-bottom border-secondary mb-2 mx-2'>
                <div class='col fs-4 fw-bold'>Id</div>
                <div class='col fs-4 fw-bold'>First Name</div>
                <div class='col fs-4 fw-bold'>Last Name</div>
                <div class='col fs-4 fw-bold'>Subjects</div>
                <div class='col fs-4 fw-bold'>Actions</div>
            </div>
            <form action="create" method="post" class="row border-bottom border-warning mx-2" id="create-trainer">
                <div class='col'><input type="hidden"></div>
                <div class='col'>
                    <input class="form-control" type="text" name="trnFirstName" id="first-name" required>
                    <div class="valid-feedback">
                        Looks good!
                    </div>
                    <div class="invalid-feedback">
                        Does not look good!
                    </div></div>
                <div class='col'>
                    <input class="form-control" type="text" name="trnLastName" id="last-name" required>
                    <div class="valid-feedback">
                        Looks good!
                    </div>
                    <div class="invalid-feedback">
                        Does not look good!
                    </div>         
                </div>
                <div class='col pb-2' id="subject-list">                  
                    <c:forEach items='${subjectList}' var="subject">
                        <span class='row border-bottom border-secondary mb-0'>
                            <div class='col'>${subject.subTitle}
                                <input id="subject-${subject.subjectKey}" class="float-right mt-2"
                                       type="checkbox" name="subjectIdSet" value="${subject.subjectKey}">
                            </div>
                        </span>
                    </c:forEach>   
                </div>
                <div class="col">
                    <input type="submit" class='btn btn-warning text-black mb-2' id="add-submit" value="Add a new Trainer.">
                    <div id="subject-list-check" class="form-label is-valid">
                        <div id="subject-list-valid" class="valid-feedback">
                            Subject list looks good!
                        </div>
                        <div id="subject-list-invalid" class="invalid-feedback">
                            You must choose at least one subject!
                        </div>  
                    </div>
                </div>
            </form>

            <c:forEach items='${trainerList}' var="trainer">
                <div id="table-row-${trainer.trainerKey}" class='row border-bottom border-warning mx-2'>
                    <div class='col mt-2'>${trainer.trainerKey}</div>
                    <div class='col mt-2'>${trainer.trnFirstName}</div>
                    <div class='col mt-2'>${trainer.trnLastName}</div>
                    <div class='col pb-2'>
                        <c:forEach items='${trainer.subjectsSet}' var="subject">
                            <span class='row border-bottom border-secondary mb-0'>
                                <div class='col'>${subject.subTitle}</div>
                            </span>
                        </c:forEach>
                    </div>
                    <div class='col pt-1 pb-2'>
                        <a href='delete/${trainer.trainerKey}' class='btn btn-danger text-black'>Delete</a>&nbsp;&nbsp;&nbsp;
                        <button id="replace-${trainer.trainerKey}" class='btn btn-warning text-black' value="${trainer.trainerKey}">Update</button>
                    </div>
                </div>

                <form id="update-form-${trainer.trainerKey}" action="update/${trainer.trainerKey}" method="post" class='row border-bottom border-warning mx-2' style="display: none">
                    <div class='col mt-2'>${trainer.trainerKey}</div><input type="hidden">
                    <div class='col'>
                        <input class="form-control mt-2" type="text" name="trnFirstName" id="first-name-${trainer.trainerKey}" value="${trainer.trnFirstName}" required>
                        <div class="valid-feedback">
                            Looks good!
                        </div>
                        <div class="invalid-feedback">
                            Does not look good!
                        </div></div>
                    <div class='col'>
                        <input class="form-control mt-2" type="text" name="trnLastName" id="last-name-${trainer.trainerKey}" value="${trainer.trnLastName}" required>
                        <div class="valid-feedback">
                            Looks good!
                        </div>
                        <div class="invalid-feedback">
                            Does not look good!
                        </div>         
                    </div>
                    <div class='col pb-2' id="subject-list-${trainer.trainerKey}">
                        <c:forEach items='${subjectList}' var="subject">
                            <span class='row border-bottom border-secondary mb-0'>
                                <div class='col'>${subject.subTitle}
                                    <input class="float-right mt-2" type="checkbox" name="subjectIdSet" value="${subject.subjectKey}" id="subject-${trainer.trainerKey}-${subject.subjectKey}"
                                           <c:forEach items='${trainer.subjectsSet}' var="trnsubject">
                                               <c:choose>
                                                   <c:when test="${subject.subjectKey==trnsubject.subjectKey}">
                                                       checked
                                                   </c:when>
                                               </c:choose>
                                           </c:forEach>
                                           >
                                </div>
                            </span>
                        </c:forEach>
                    </div>
                    <div class="col">
                        <input type="submit" class='btn btn-warning text-black mt-2' id="update-submit-${trainer.trainerKey}" value="Update Trainer.">
                        <div id="subject-list-check" class="form-label is-valid">
                            <div id="subject-list-valid-${trainer.trainerKey}" class="valid-feedback">
                                Subject list looks good!
                            </div>
                            <div id="subject-list-invalid-${trainer.trainerKey}" class="invalid-feedback">
                                You must choose at least one subject!
                            </div>  
                        </div>
                    </div>
                </form>            
            </c:forEach>
            <footer   class="jumbotron bg-warning text-center mt-2">
                <P style="color: black">Copyright &copy; 2022 Yourwash-A.E.</P>
            </footer>

        </div><!-- End of Container -->

    </body>
</html>
