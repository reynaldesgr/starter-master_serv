<#ftl encoding="utf-8">

<body xmlns="http://www.w3.org/1999/html">

<h1> Liste des professeurs </h1>
<ul>
    <#list teachers as teacher>
        <li>${teacher.id_teacher} - ${teacher.lastName} ${teacher.firstName}<br/>
         [<strong> username </strong>] : ${teacher.userName}</li>
    </#list>
</ul>
<br/>
<a href="/index"> Retourner à l'accueil </a>
</body>

</html>
