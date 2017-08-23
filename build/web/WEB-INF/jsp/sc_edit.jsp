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
    <title>Score Edit</title>
    <div class="container-fluid">
        <td>
            <form id="sc_form" onsubmit="return false;">
                <div class="form-group">
                    <label for="sno">学号:</label>
                    <select class="form-control" name='sno' id='sno'>
                        <c:choose>
                            <c:when test="${mode=='edit'}">
                                <option selected value="${sc.sno}">${sc.sno}</option>
                            </c:when>
                            <c:otherwise>
                                <c:forEach items="${students}" var="student">
                                    <option value="${student.sno}">${student.sno}</option>
                                </c:forEach>

                            </c:otherwise>
                        </c:choose>
                    </select>
                </div>
                <div class="form-group">
                    <label for="cno">课程号:</label>
                    <select class="form-control" id='cno' name='cno'>
                        <c:choose>
                            <c:when test="${mode=='edit'}">
                                <option selected value="${sc.cno}">${sc.cno}</option>
                            </c:when>
                            <c:otherwise>
                                <c:forEach items="${courses}" var="course">
                                    <option value="${course.cno}">${course.cno}</option>
                                </c:forEach>
                            </c:otherwise>
                        </c:choose>
                    </select>
                </div>
                <div class="form-group">
                    <label for="score">分数:</label>
                    <input class="form-control" type="text" name="score" id="score" value="${sc.score}">
                </div>
                <!--                    <div class="form-group">
                                        <input class="form-control btn btn-success" id="submit_type" type="submit" value="${submit_type}">
                                    </div>-->
            </form>
        </td>
        <td>
        </td>
    </div>
    <script>
        $("#sc_form").submit(function () {
            var submit_type = '${submit_type}';
            var data = $("#sc_form").serializeArray();
            var url;
            if (submit_type === 'update') {
                url = "../sc/editScoreBySnoCno.do";
            } else if (submit_type === 'add') {
                url = "../sc/addScore.do";
            }
            $.ajax({
                url: url,
                data: data,
                success: function (data, textStatus, jqXHR) {
                    $("#load_div").load("../sc/findScoreBySno.do?sno=" + $("#sno").val() + "#sc_table", function () {
                        showMessage(data);
//                        closeGlobeModal();
//                        window.close();
                    });
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    showMessage("error:" + jqXHR + textStatus + errorThrown);
                }
            });
        });
    </script>
</body>
</html>
