<%-- 
    Document   : new-team
    Created on : 27.09.2014, 15:18:48
    Author     : Anubis
--%>

<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<c:import url="template/header.jsp" />

<h1>Sign Up A Team Here!</h1>

    <fieldset>
        <legend>Enter Your Information</legend>
<form:form method="post" modelAttribute="SignUpTeam" action="Team/createTeam" id="SignUpTeam" cssClass="form-horizontal"  autocomplete="off">
        <c:set var="TeamErrors"><form:errors path="Team"/></c:set>
        <div class="control-group<c:if test="${not empty firstNameErrors}"> error</c:if>">
            <label class="control-label" for="field-Team">First Name</label>
            <div class="controls">
                <form:input path="Team" id="field-Team" tabindex="2" maxlength="35" placeholder="Team"/>
                <form:errors path="Team" cssClass="help-inline" element="span"/>
            </div>
        </div>
        <div class="form-actions">
            <button type="submit" class="btn btn-primary">Sign up</button>
            <button type="button" class="btn">Cancel</button>
        </div>

    </fieldset>
</form:form>

<c:import url="template/footer.jsp" />
