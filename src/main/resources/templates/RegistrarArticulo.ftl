<#include "base.ftl">
<#macro page_head>
    <#if title?has_content>
        <title>${title}</title>
    </#if>
</#macro>

<#macro page_body>
    <body>
    <h1 style="text-align: center;">Ingrese los datos del Articulo: </h1>
    </br>
    <div class="container mt-2">
        <div class="row justify-content-md-center">
            <div class="col-6">
                <div class="card text-dark" style="padding: 20px; background-color: lightgray">
                    <form action="/articulo/registrar" method="post"  enctype="application/x-www-form-urlencoded">

                        <div class="form-group mb-2">
                            <label for="descripcion">Descripci&oacute;n:</label>
                            <input type="text" class="form-control" id="descripcion" name="descripcion" required>
                        </div>

                        <div class="form-group mb-2">
                            <label for="unidadCompra">Unidad Compra:</label>
                            <input type="text" class="form-control" id="unidadCompra" name="unidadCompra" required>
                        </div>

                        <div class="form-group mb-2">
                            <label for="balanceActual">Unidades en Inventario:</label>
                            <input type="number" min="0" class="form-control" id="balanceActual" name="balanceActual" required>
                        </div>
                        <button type="submit" class="btn btn-primary btn-custom1 mt-2">Registrar</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
    </body>
</#macro>
<@display_page/>