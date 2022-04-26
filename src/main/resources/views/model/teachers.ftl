<#ftl encoding="utf-8">
<#import "common/nav.ftl" as navbar>
<#import "common/footer.ftl" as footer>

<html lang="fr">

<head>
    <title>Professeurs</title>
    <link rel="stylesheet" type="text/css" href="/css/main.css"/>
    <@navbar.navbar_css/>
    <@footer.footer_css/>
</head>

<body xmlns="http://www.w3.org/1999/html">
<@navbar.navbar user_log??/>
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
<@footer.footer/>
<@navbar.navbar_js/>
</body>

</html>
