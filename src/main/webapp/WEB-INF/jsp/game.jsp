<%--
  Created by IntelliJ IDEA.
  User: Konul Gurbanli
  Date: 6/6/2017
  Time: 5:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Söz oyunu</title>
    <link href="<c:url value="/static/css/game.css" />" rel="stylesheet">
    <link href="<c:url value="/static/css/bootstrap.min.css" />" rel="stylesheet">
    <script src="<c:url value="/static/js/jquery-3.1.0.min.js" />"></script>
    <script src="<c:url value="/static/js/bootstrap.min.js" />"></script>
    <script src="<c:url value="/static/js/game.js" />"></script>
</head>
<%--style="background-color: #00bfff"--%>
<body>
<h1 align="center" class="large" id="header">Hərflərin yerin dəyişərək gizlədilmiş sözü tapın!</h1>
<div class="Center-Container">
    <div id="container" class="Absolute-Center">
        <c:forEach var="letter" items="${word}">
            <div class="box">
                <div class="letter" draggable="true" ondragstart="drag(event)" ondrop="drop(event, this)" ondragover="allowDrop(event)">
                    <span> ${letter} </span>
                </div>
            </div>
        </c:forEach>
        <div id="div-bt">
            <button type="submit" class="btn-default" style="margin: 9px" name="done" id="done"> YOXLA </button>
            <button type="submit" class="btn-default" style="margin: 9px" name="give-up" id="give-up"> BİLMƏDİM </button>
        </div>
        <p id="word-id" hidden="true">${id}</p>
        <p id="msg"></p>
    </div>
</div>
</body>
</html>
<script>
    $('#container .box').each(function(i) {
        $(this).attr('id', 'box_' + i);
        $(this).children(':first').attr('id', 'letter_' + i);
    });

    $( "#done" ).click(function( event ) {
        event.preventDefault();
        var id = $("#word-id").text();
        $.ajax({
            url: '/words/'+id,
//            data: $("#word-id").serialize(),
            type: 'get',
            cache: false,
            success: function (data) {
                var word = data['content'];
                if(word==getWord()){
                    $("#header").hide();
                    $("#done").hide();
                    $(".box").hide();
                    $(".letter").hide();
                    $("#div-bt").hide();
                    $("#msg").html("BRAVO!");
                    $("#msg").addClass("large");
                    $("#container").append("<a href='/words/play'>YENƏ OYNA</a>");
                }
                else{
                    $( "#msg" ).html( "Bir daha yoxlayın..." );
                }

            },
            error: function(xhr,errmsg,err){
                console.log(xhr.responseText);
                $("#div-bt").html("Nəsə düz getmədi :(");
            },
        });
    });

    $( "#give-up" ).click(function( event ) {
        var id = $("#word-id").text();
        $.ajax({
            url: '/words/'+id,
//            data: $("#word-id").serialize(),
            type: 'get',
            cache: false,
            success: function (data) {
                var word = data['content'].toUpperCase();
                $("#div-bt").hide();
                $("#msg").html("Bu <b>"+word+"</b> idi. Yenidən oynamaq istəyirsən?");
                $("#container").append("<a href='/words/play'>YENƏ OYNA</a>");
            },
            error: function(xhr,errmsg,err){
                console.log(xhr.responseText);
                $("#div-bt").html("Something went wrong :(");
            },
        });

    });

</script>