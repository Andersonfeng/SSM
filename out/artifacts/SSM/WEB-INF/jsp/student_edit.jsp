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
    <title>Student Edit</title>
    <div class="container-fluid" id="student_edit">
        <!--<h1>Student Edit</h1>-->
        <form id="student_form" onsubmit="return false;">
            <div class="form-group">
                <label for="sname">姓名:</label>
                <input class="form-control" type="text" name="sname" id="sname" value="${student.sname}">
            </div>
            <div class="form-group">
                <label for="ssex">性别:</label>
                <input class="form-control" type="text" name="ssex" id="ssex" value="${student.ssex}">
            </div>
            <div class="form-group">
                <label for="sage">年龄:</label>
                <input class="form-control" type="text" name="sage" id="sage" value="${student.sage}">
            </div>
            <div class="form-group">
                <label for="sno">学号:</label>
                <input class="form-control" type="text" name="sno" id="sno" value="${student.sno}" 
                       <c:if test="${submit_type=='update'}">
                           readonly disabled
                       </c:if>
                       >
            </div>
            <!--            <div class="form-group" style="display: none;">
                            <input type="submit"  id="submit_button" value="${submit_button}" class="form-control btn btn-success">
                        </div>-->
            <input type="hidden" id="submit_type" value="${submit_type}">
        </form>
    </div>

    <script>
        $("#student_form").submit(function (e) {
            var submit_type = $("#submit_type").val();
            var submit_url;
            if (submit_type === "update") {
                submit_url = "./updateStudentBySno.do";
            } else if (submit_type === "add") {
                submit_url = "./insertStudent.do";
            }
            $.ajax({
                url: submit_url,
                type: 'POST',
                data: {
                    sname: $("#sname").val(),
                    ssex: $("#ssex").val(),
                    sage: $("#sage").val(),
                    sno: $("#sno").val()
                },
                dataType: 'text',
                success: function (data, textStatus, jqXHR) {
                    showMessage(data, "window.location.reload();");

                },
                error: function (jqXHR, textStatus, errorThrown) {
                    showMessage("error:" + textStatus + jqXHR + errorThrown);
                }
            });
            //            e.preventDefault();
        });
    </script>
</body>
</html>
