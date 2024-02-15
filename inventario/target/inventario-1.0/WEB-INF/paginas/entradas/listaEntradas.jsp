<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="es_MX"/>

<section id="entradas">

    <div class="container">
        <div class="row">
            <div class="col-md-11">
                <div>
                    <div class="card">
                        <div class="card-header">
                            <h4>ENTRADAS</h4>
                            <table class="table table-striped">
                                <thead class="thead-dark">
                                    <tr>
                                        <th>CÓDIGO</th>
                                        <th>FECHA</th>
                                        <th>ID PRODUCTO</th>
                                        <th>DESCRIPCION</th>
                                        <th>CANTIDAD</th>
                                    </tr>
                                </thead>

                                <tbody>
                                    <!-- iterrar cada elemento de la lista -->
                                    <c:forEach var="entrada" items="${entradas}"> 
                                        <tr>
                                    <td>${entrada.codigo}</td>
                                    <td>${entrada.fecha}</td>
                                    <td>${entrada.producto.codigo}</td>
                                    <td>${entrada.producto.descripcion}</td>
                                    <td>${entrada.cantidad}</td>
                                        </tr>



                                </c:forEach>

                                </tbody>

                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<!<!-- agregar abajo de este comentario el link de la pagina para agregar una nueva entrada -->
<jsp:include page="/WEB-INF/paginas/entradas/agregarEntrada.jsp"/>