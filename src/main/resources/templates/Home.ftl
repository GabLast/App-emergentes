<#include "base.ftl">
<#macro page_head>
    <#if title?has_content>
        <title>${title}</title>
    </#if>
</#macro>

<#macro page_body>
<body>
<#-- <p class="text-center">Esta es la home</p>-->
</body>
</#macro>
<@display_page/>