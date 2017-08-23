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
    <title>Score</title>
    <h1>Score   <button class="btn btn-success" onclick="addScore()">Add Score</button></h1>

    <table id="sc_table" class="table">
        <tr>
            <td>
                <table class="table table-bordered table-hover ">
                    <br>
                    <tr>
                        <td>学号</td>
                        <td>课程号</td>
                        <td>课程名</td>
                        <td>分数</td>
                        <td>操作</td>
                    </tr>
                    <c:forEach items="${scores}" var="score" varStatus="status">
                        <tr>
                            <td>${score.sno}</td>
                            <td>${score.cno}</td>
                            <td>${score.course.cname}</td>
                            <td>${score.score}</td>
                            <td>                    
                                <button onclick="findScoreBySnoCno('${score.sno}', '${score.cno}')" class="btn btn-primary">编辑</button>
                                <button onclick="deleteScoreBySnoCno('${score.sno}', '${score.cno}')" class="btn btn-danger">删除</button>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </td>
            <td>
            </td>
        </tr>
    </table>
    <script>
        function findScoreBySnoCno(sno, cno) {
            $("#myModalLabel").text("Score Edit");
            $("#modal_body").load("../sc/findScoreBySnoCno.do?sno=" + sno + "&cno=" + cno + "&mode=edit");
            $("#globeModal").modal({backdrop: 'static'});
//            window.open("../sc/findScoreBySnoCno.do?sno=" + sno + "&cno=" + cno + "&mode=edit", '', 'height=400,width=400,top=200,left=200');
        }
        function addScore() {
            $("#myModalLabel").text("Score Added");
            $("#modal_body").load("../sc/findScoreBySnoCno.do?sno=" + "&cno=" + "&mode=add");
            $("#globeModal").modal({backdrop: 'static'});
//            window.open("../sc/findScoreBySnoCno.do?sno=" + "&cno=" + "&mode=add", '', 'height=400,width=400,top=200,left=200');
        }

        function deleteScoreBySnoCno(sno, cno) {
            $.ajax({
                url: "../sc/deleteScoreBySnoCno.do",
                data: {'sno': sno, 'cno': cno},
                success: function (data, textStatus, jqXHR) {
                    $("#load_div").load("../sc/findScoreBySno.do?sno=" + sno + "#sc_table", function () {
                        closeGlobeModal();
                    });
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    showMessage(jqXHR + textStatus + errorThrown);
                }
            });
        }
    </script>
</body>
</html>
