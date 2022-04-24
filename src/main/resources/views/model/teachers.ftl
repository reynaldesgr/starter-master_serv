<#ftl encoding="utf-8">

<html lang="fr">

<head>
    <link rel="stylesheet" type="text/css" href="css/main.css"/>
</head>

<body xmlns="http://www.w3.org/1999/html">
    <main>
        <h1> Liste des professeurs </h1>
        <div class="table-container">
            <table>
                <thead>
                <tr>
                    <th>Identifiant</th>
                    <th>Prénom</th>
                    <th>Nom</th>
                </tr>
                </thead>
                <tbody>
                <#list teachers as teacher>
                    <tr>
                        <td>${teacher.id_teacher}</td>
                        <td>${teacher.firstName}</td>
                        <td>${teacher.lastName}</td>
                    </tr>
                </#list>
                </tbody>
            </table>
        </div>
        <br/>
        <a href="/index"> Retourner à l'accueil </a>
    </main>
</body>

</html>
