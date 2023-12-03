<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
    <%@page contentType="text/html;charset=UTF-8" %>
    <%@ page import="java.util.List" %>
    <%@ page import="org.apache.commons.lang3.tuple.Pair" %>
    <%@ page import="firstwebapp.xmlmanager.Product" %>
    <TITLE> JavaServer Pages</TITLE>
    <META NAME="author" CONTENT="Marty Hall -- hall@apl.jhu.edu">
    <META NAME="keywords"
          CONTENT="JSP,JavaServer Pages,servlets">
    <META NAME="description"
          CONTENT="Lab 6">
    <LINK REL=STYLESHEET
          HREF="MyStyle.css"
          TYPE="text/css">
</HEAD>
<BODY BGCOLOR="#d5a6bd" TEXT="#000000" LINK="#0000EE"
      VLINK="#551A8B" ALINK="#FF0000">

<h2>Perfume Shop</h2>
<ul>
    <% Pair<Integer, List<Product>> result = (Pair<Integer, List<Product>>) request.getAttribute("product"); %>

    <ul>
        <%
            for (Product item : result.getRight()) {
        %>
        <li class="listItem"><%= item.getName() %> - Group:<%= item.getGroup() %>, Description:<%= item.getDescription() %>  (Price: <%= item.getPrice() %>)  </li>
        <%
            }
        %>
    </ul>
    <p style="font-weight: bold;">Total Price: <%= result.getLeft() %></p>
</ul>
</BODY>
</HTML>