<#include "base.ftl">
<#macro page_head>
    <#if title?has_content>
        <title>${title}</title>
    </#if>
</#macro>

<#macro page_body>
    <body>
    <div class="container mt-5" >
        <h1 style="text-align: center">Listado de Movimientos</h1>
        </br>
        <div class="row justify-content-md-center">
            <div class="col-12">
                <table class="table text-light">
                    <tr>
                        <th>Codigo Articulo</th>
                        <th>Tipo de Movimiento</th>
                        <th>Cantidad</th>
                        <th>Fecha Movimiento</th>

                    </tr>
                </table>
                <br/><br/>

            </div>
        </div>
        <div>
            <form action="/movimiento/registrar">
                <button type="submit" class="btn btn-info mb-3">Registrar Movimiento</button>
            </form>
        </div>
    </div>

    </body>
</#macro>
<@display_page/>