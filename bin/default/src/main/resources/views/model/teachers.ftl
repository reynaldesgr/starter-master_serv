<#ftl encoding="utf-8">

<html lang="fr">

<head>
    <link rel="stylesheet" type="text/css" href="css/main.css"/>
</head>

<body xmlns="http://www.w3.org/1999/html">
    <main>
        <h1> Liste des professeurs </h1>
        <ul>
            <#list teachers as teacher>
                <li>${teacher.id_teacher} - ${teacher.lastName} ${teacher.firstName}<br/>
                 [<strong> username </strong>] : ${teacher.userName}</li>
            </#list>
        </ul>
        <br/>
        <a href="/index"> Retourner à l'accueil </a>
    </main>
</body>

</html>
