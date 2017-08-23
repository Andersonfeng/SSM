<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<%@ include file="./tools.jsp" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
    <title>Student Info</title>
    <div class="container">
        <h1>Student Info    <button type="button" onclick="initAddStudentForm()" class="btn btn-success" >Add Student</button></h1>
        <div class="table-responsive">
            <table  class="table">
                <tr>
                    <td>
                        <table class="table table-bordered table-hover ">

                            <td>姓名</td>
                            <td>性别</td>
                            <td>年龄</td>
                            <td>学号</td>
                            <td>操作</td>
                            <c:forEach items="${students}" var="student" varStatus="status" >
                                <tr>
                                    <td>${student.sname}</td>
                                    <td>${student.ssex}</td>
                                    <td>${student.sage}</td>
                                    <td>${student.sno}</td>
                                    <td>                    
                                        <button id="findStudentBySno_${status.index}" onclick="findStudentBySno('${student.sno}', this);" class="btn btn-primary" >编辑</button>
                                        <button id="find_score_${status.index}" onclick="loadScore('../sc/findScoreBySno.do?sno=${student.sno}', this)" class="btn btn-info">成绩</button>
                                        <button onclick="deleteStudentBySno('${student.sno}')" class="btn btn-danger">删除</button>
                                    </td>
                                </tr>
                            </c:forEach>
                        </table>
                    </td>
                    <td>
                    </td>
                </tr>
            </table>
            <div id="load_div" ></div>

        </div>
        <script>


            function goto(url) {
                window.location.href = url;
            }

            function loadScore(url, obj) {
                $("button[id*='find_score_']").each(function () {
                    $(this).removeAttr("disabled", "");
                });
                $(obj).attr("disabled", "true");
                $("#load_div").load(url + "#sc_table", function () {
                    $("#load_div").show("fast");
                    goto('#load_div');
                });
            }

            function findScoreBySno(sno) {
                $.ajax({
                    url: "../sc/findScoreBySno.do?sno=" + sno,
                    success: function (data, textStatus, jqXHR) {
                        showMessage(data, "location.reload();");
                    },
                    error: function (jqXHR, textStatus, errorThrown) {
                        showMessage("error:" + jqXHR + textStatus + errorThrown);
                    }
                });
            }
            function deleteStudentBySno(sno) {
                var is_delete = confirm("是否要删除该学生?  " + sno);
                if (is_delete == true) {
                    $.ajax({
                        url: "./deleteStudentBySno.do?sno=" + sno,
                        success: function (data, textStatus, jqXHR) {
                            showMessage(data, "location.reload();");
//                            location.reload();
                        },
                        error: function (jqXHR, textStatus, errorThrown) {
                            showMessage("error:" + jqXHR + textStatus + errorThrown);
                        }
                    });
                }
            }

            function initAddStudentForm() {
//                window.open("./findStudentBySno.do?sno=", 'add_student', "height=450,width=400,top=200,left=200,resizable=0");
                $("#myModalLabel").text("Student Added");
                $("#modal_body").load("./findStudentBySno.do?sno=");
                $("#globeModal").modal({backdrop: 'static'});
            }

            function findStudentBySno(sno, obj) {
                $("#myModalLabel").text("Student Edit");
                $("#modal_body").load("./findStudentBySno.do?sno=" + sno);
                $("#globeModal").modal({show: true, backdrop: 'static'});
//                            window.open("./findStudentBySno.do?sno=" + sno, 'edit_student', "height=450,width=400,top=200,left=200,resizable=0");
            }
        </script>
    </body>
</html>
