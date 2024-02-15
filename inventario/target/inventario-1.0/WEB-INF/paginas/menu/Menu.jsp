
<section id="dash" class="py-4 mb-4 bg-light">

    <div class="container">

        <div class="row">

            

            <div class="col-md-6">


                <a href="${pageContext.request.contextPath}/controlador?accion=entradas">
                    <div class="card text-center bg-success text-white mb-3">
                        <div class="card-body">

                            <h3>ENTRADAS</h3>
                            <h4 class="display-4"><i class="fa-solid fa-upload"></i></h4>
                        </div>
                    </div>
                </a>



                

                    
                <a href="${pageContext.request.contextPath}/controlador?accion=inventario">
                    <div class="card text-center bg-warning text-white mb-3">
                        <div class="card-body">
                            <h3>STOCK</h3>
                            <h4 class="display-4"><i class="fa-solid fa-list-check"></i></h4>
                        </div>
                    </div>
                </a>

            </div>
                    
                    <div class="col-md-6">


               



                <a href="${pageContext.request.contextPath}/controlador?accion=salidas">
                    <div class="card text-center bg-danger text-white mb-3">
                        <div class="card-body">
                            <h3>SALIDAS</h3>
                            <h4 class="display-4"><i class="fa-solid fa-download"></i></h4>
                        </div>
                    </div>
                </a>

                    
                <a href="#" data-toggle="modal" data-target="#agregarProductoModal">
                    <div class="card text-center bg-info text-white mb-3">
                        <div class="card-body">
                            <h3>AÑADIR PRODUCTO</h3>
                            <h4 class="display-4"><i class="fa-brands fa-product-hunt"></i></h4>
                        </div>
                    </div>
                </a>

            </div>




        </div>

    </div>


</section>
                    
                <jsp:include page="/WEB-INF/paginas/productos/agregarProducto.jsp"/>