<#include "base.ftl">
<#macro page_head>
    <#if title?has_content>
        <title>${title}</title>
    </#if>
</#macro>

<#macro page_body>
    <body>
    <h1 style="text-align: center;">Ingrese los datos del Suplidor: </h1>
    </br>
    <div class="container mt-2">
        <div class="row justify-content-md-center">
            <div class="col-6">
                <div class="card text-dark" style="padding: 20px; background-color: lightgray">
                    <form action="/suplidor/registrar" method="post" enctype="application/x-www-form-urlencoded">
                        <#if articulos?has_content>
                            <div class="form-group mb-2">
                                <label for="exampleFormControlSelect1">Art&iacute;culo:</label>
                                <select class="form-select" id="exampleFormControlSelect1" name="idarticulo" required>
                                    <option selected>Seleccione</option>
                                    <#list articulos as arti>
                                        <option value="${arti.codigoArticulo}">
                                            ${arti.descripcion}
                                        </option>
                                    </#list>
                                </select>
                            </div>
                            <div class="form-group mb-2">
                                <label for="idSuplidor">C&oacute;digo del Suplidor:</label>
                                <input type="number" min="1" class="form-control" id="idSuplidor" name="idSuplidor" required>
                            </div>
                            <div class="form-group mb-2">
                                <label for="tiempoEntrega">Tiempo Entrega:</label>
                                <input type="number" min="1" class="form-control" id="tiempoEntrega" name="tiempoEntrega" required>
                            </div>
                            <div class="form-group mb-2">
                                <label for="precioCompra">Precio Compra:</label>
                                <input type="number" min="1" class="form-control" id="precioCompra" name="precioCompra" required>
                            </div>

                            <button type="submit" class="btn btn-primary mt-2">Registrar Suplidor</button>
                        <#else>
                            <h4 style="text-align: center;">No hay articulos registrados. Registrar articulos antes de continuar</h4>
                        </#if>
                    </form>
                </div>
            </div>
        </div>
    </div>
    </body>
</#macro>
<@display_page/>