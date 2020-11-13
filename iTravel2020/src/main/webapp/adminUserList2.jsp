<%@ page import="java.time.Instant" %><%--
  Created by IntelliJ IDEA.
  User: J&C
  Date: 11/10/2020
  Time: 7:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="itravel.model.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href="resources/css/page-user.css" rel="stylesheet" type="text/css">
    <link href="resources/css/main.css" rel="stylesheet" type="text/css">

    <!--<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js" type="text/javascript"></script>
        <script type="text/javascript" src="resources/js/BookMnAjax.js"></script>
   // <script type="text/javascript" src="resources/js/common.js"></script>
-->
    <script type="text/javascript" src="resources/js/ShowUserListAjax.js"></script>
    <title>iTravel</title>
</head>

<body>
<%@include file="adminHeader.jsp"%>


<div id="">
    <div id="contentHead">
        <h1>Admin Main Page</h1>
    </div>
    <div id="contentBody">
        <div>Search: <input type="text" id="searchId"/></div>
        <hr/>
        <div id="updMemberForm">
            <form>
                <table>
                    <tr><td><label for="id">User ID</label></td><td><input type="text" id="id" name="id"></td></tr>
                    <tr><td><label for="title">Title</label></td><td><input type="text" id="title" name="title"></td></tr>
                    <tr><td><label for="author">Author</label></td><td><input type="text" id="author" name="author"></td></tr>
                    <tr><td><label for="subject">Subject</label></td><td><input type="text" id="subject" name="subject"></td></tr>
                    <tr><td><label for="isbn">ISBN</label></td><td><input type="text" id="isbn" name="isbn"></td></tr>
                    <tr><td></td><td>
                        <input type="hidden" value="false" id="isValid">
                        <input type="button" value="Add" id="add">
                        <input type="button" value="Update" id="upd">
                        <input type="button" value="Delete" id="del">
                        <select id="showUser">
                            <option id = "allUser">All User</option>
                            <option id = "deactivatedUser">Deactivated User</option>
                            <option id = "activatedUser">Activated User</option>
                        </select>
                    </td></tr>

                </table>
            </form>
        </div>


        <div id="tabsHistory" class="tabs autohash ui-tabs ui-corner-all ui-widget ui-widget-content">

            <div id="humans" aria-labelledby="ui-id-1" role="tabpanel"
                 class="ui-tabs-panel ui-corner-bottom ui-widget-content" aria-hidden="false"
                 style="display: block;">

                <table id="showUserList" >
                    <thead>
                    <tr>
                        <th id = "userId" >ID</th>
                        <th id = "userType">UserType</th>
                        <th id = "userFullName">FullName</th>
                        <th id = "userGender">Gender</th>
                        <th id = "UserAddress">Address</th>
                        <th id = "UserbirthYear">BirthYear</th>
                        <th id = "UserEmail">Email</th>
                        <th id = "UserPassWord">Password</th>

                    </tr>
                    </thead>
                    <tbody id="myTable">
                    </tbody>
                </table>
                <div class="historyPager small sansserif gray">
                     <br><input type="button" value="Export to Excel" id="toexcel">
                </div>
            </div>
        </div>
    </div>
</div>



</body>
</html>
