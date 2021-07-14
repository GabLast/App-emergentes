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
                    <form action="/registrar" method="post"  enctype="application/x-www-form-urlencoded">

                        <div class="form-group mb-2">
                            <label for="nombre">Descripci&oacute;n:</label>
                            <input type="text" class="form-control" id="desc" name="desc">
                        </div>

                        <div class="form-group mb-2">
                            <label for="precio">Unidad Compra:</label>
                            <input type="text" class="form-control" id="unid" name="unid">
                        </div>

                        <div class="form-group mb-2">
                            <label for="precio">Balance:</label>
                            <input type="text" class="form-control" id="balance" name="balance">
                        </div>

                        <button type="submit" class="btn btn-primary mt-2">Registrar Articulo</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
    </body>
</#macro>
<@display_page/>