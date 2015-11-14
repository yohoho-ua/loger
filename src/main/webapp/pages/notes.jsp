<%--<%@page import="domain.Note"%>--%>
<%--<%@page import="dao.impl.NoteDaoImpl"%>--%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>

<jsp:useBean id="currentNote" class="domain.Note" scope="page"/>
<jsp:useBean id="noteDao" class="dao.impl.NoteDaoImpl" scope="page"/>
<%@include file="/pages/jspf/left_menu.jspf" %>

<% request.setCharacterEncoding("UTF-8");

    String noteUuid = "";
    try {
        noteUuid = request.getParameter("note_uuid");
        currentNote = noteDao.getNoteByUuid(noteUuid);

    } catch (Exception ex) {
        ex.printStackTrace();
    }
%>

<div class="note_view">
    <table cellpadding="5" style="font-size: 12px; border: 2px solid #79bbff;">

        <tr class="tr_notes_attr">
            <td class="td_left">
                <strong>Title:</strong>
            </td>
            <td class="td_right">
                <input type="text" name="title" value=" <%=currentNote.getTitle() %>" size="80" />
            </td>
        </tr>
        <tr class="tr_notes_attr">
            <td class="td_left">
                <strong>Owner:</strong>
            </td>
            <td class="td_right">
                <%=currentNote.getOwner() %>
            </td>
        </tr>
        <tr class="tr_notes_attr">
            <td class="td_left">
                <strong>Created:</strong>
            </td>
            <td class="td_right">
                <%=currentNote.getDate_created() %>
            </td>
        </tr>
        <tr class="tr_notes_attr">
            <td class="td_left">
                <strong>Catalog:</strong>
            </td>
            <td class="td_right">
                <%=currentNote.getCatalog() %>
            </td>
        </tr>

        <div class="content">
            <jsp:useBean id="content" class="domain.Content" scope="page"/>
            <jsp:useBean id="contentDao" class="dao.impl.ContentDaoImpl" scope="page"/>
            <% content = contentDao.getContentByUuid(currentNote.getContent());%>
            <form action="" method="post">
                <p><textarea rows="20" cols="80" name="text"><%=content.getText()%></textarea></p>
                <p><input type="submit" value="Save"></p>
            </form>

        </div>


    </table>
</div>




