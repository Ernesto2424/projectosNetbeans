<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 

<div class="modal fade" id="agregarProductoModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-title">Agregar Producto</h5>
                <button class="close" data-dismiss="modal">
                    <span>&times;</span>
                </button>
            </div>

            <form action="${pageContext.request.contextPath}/controlador?accion=insertarProducto" method="POST" class="was-validated">

                <div class="modal-body">

                    <div class="form-group">
                        <label for="descripcion">DESCRIPCIÓN:</label>
                        <input type="text" name="descripcion" class="form-control" required="rue">

                    </div>



                    <div class="form-group">
                        <label for="costo">COSTO:</label>
                        <input type="number" name="costo" class="form-control" required="rue" step="0.01">
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
