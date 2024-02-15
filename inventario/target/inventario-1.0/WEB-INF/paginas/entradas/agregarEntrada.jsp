
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 

<div class="modal fade" id="agregarEntradaModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-title">Agregar Entrada</h5>
                <button class="close" data-dismiss="modal">
                    <span>&times;</span>
                </button>
            </div>

            <form action="${pageContext.request.contextPath}/controlador?accion=insertarEntrada" method="POST" class="was-validated">

                <div class="modal-body">

                    <div class="form-group">
                        <label for="producto">PRODUCTO:</label>
                        <select id="idProducto" class="form-control" name="idProducto">
                            <!<!-- iterar el codigo del producto -->
                            <c:forEach var="producto" items="${productos}">
                                <option value="${producto.codigo}"> ${producto.descripcion} </option>
                            </c:forEach>
                        </select>
                    </div>

                    <div class="form-group">
                        <label for="fecha">FECHA:</label>
                        <input type="date" name="fecha" class="form-control" required="true">
                    </div>

                    <div class="form-group">
                        <label for="cantidad">CANTIDAD:</label>
                        <input type="number" name="cantidad" class="form-control" required="rue">
                    </div>

                    

                    

                    
                    

                <div class="modal-footer">
                    <button class="btn-primary" type="submit" style="border-radius: 4px">Guardar</button>
                    <button class="btn-primary" type="reset" style="border-radius: 4px">Limpiar Campos</button>
                </div>
            </form>

        </div>

    </div>
</div>
            </div>