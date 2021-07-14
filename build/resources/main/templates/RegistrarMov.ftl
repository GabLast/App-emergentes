<#include "base.ftl">
<#macro page_head>
    <#if title?has_content>
        <title>${title}</title>
    </#if>
</#macro>

<#macro page_body>
    <body>
    <h1 style="text-align: center;">Registrar Movimiento: </h1>
    </br>
    <div class="container mt-2">
        <div class="row justify-content-md-center">
            <div class="col-6">
                <div class="card text-dark" style="padding: 20px; background-color: lightgray">
                    <form action="/registrar" method="post"  enctype="application/x-www-form-urlencoded">

                        <div class="form-group mb-2">
                            <label for="exampleFormControlSelect1">Articulo:</label>
                            <select class="form-control" id="exampleFormControlSelect1">
                                <option>1</option>
                                <option>2</option>
                                <option>3</option>
                                <option>4</option>
                                <option>5</option>
                            </select>
                        </div>

                        <div class="form-group mb-2">
                            <label for="cant">Cantidad:</label>
                            <input type="text" class="form-control" id="cant" name="cant">
                        </div>



                        <button type="submit" class="btn btn-primary mt-2">Aceptar</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
    </body>
</#macro>
<@display_page/>