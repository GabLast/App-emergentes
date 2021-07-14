<#include "base.ftl">
<#macro page_head>
    <#if title?has_content>
        <title>${title}</title>
    </#if>
</#macro>

<#macro page_body>
    <body>
    <div class="container mt-5" >
        <h1 style="text-align: center">Listado de Suplidores</h1>
        </br>
        <div class="row justify-content-md-center">
            <div class="col-12">
                <table class="table text-light">
                    <tr>
                        <th>Codigo</th>
                        <th>Descripcion</th>
                        <th>Unidad</th>
                        <th>Balance</th>

                    </tr>
                </table>
                <br/><br/>

            </div>
        </div>
        <div>
            <form action="/articulo/registrar">
                <button type="submit" class="btn btn-info mb-3">Registrar Producto</button>
            </form>
        </div>
    </div>

    </body>
</#macro>
<@display_page/>