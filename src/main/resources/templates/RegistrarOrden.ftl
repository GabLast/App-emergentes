<#include "base.ftl">
<#macro page_head>
    <#if title?has_content>
        <title>${title}</title>
    </#if>
</#macro>

<#macro page_body>
    <body>
    <h1 style="text-align: center;">Generaci&oacute;n de &oacute;rdenes autom&aacute;ticas</h1>
    </br>
    <div class="container mt-2">
        <div class="row justify-content-md-center">
            <div class="col-6">
                <div class="card text-dark" style="padding: 20px; background-color: lightgray">
                    <form action="/registrar" method="post"  enctype="application/x-www-form-urlencoded">
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
                                <label for="tiempoEntrega">Fecha Requerida:</label>
                                <input type="date" class="form-control" id="fechaRequerida" name="fechaRequerida">
                            </div>
                            <div class="form-group mb-2">
                                <label for="cantRequeridaInventario">Cantidad Requerida en Inventario:</label>
                                <input type="cantRequeridaInventario" min="1" class="form-control" id="cantRequeridaInventario" name="precioCompra">
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