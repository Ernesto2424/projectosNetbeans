
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/9c67a9a5ec.js" crossorigin="anonymous"></script>
        
        <title>INVENTARIO</title>
    </head>
    <body>
        
        <jsp:include page="/WEB-INF/paginas/comunes/cabecero.jsp"/>
        <jsp:include page="/WEB-INF/paginas/inventario/botonesNavegacion.jsp"/>
        <jsp:include page="/WEB-INF/paginas/inventario/listaInventario.jsp"/>
        <jsp:include page="/WEB-INF/paginas/comunes/piePagina.jsp"/>



    </body>
</html>
