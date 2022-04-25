<#ftl encoding="utf-8">
<#import "common/nav.ftl" as navbar>
<#import "common/footer.ftl" as footer>

<html lang="fr">

<head>
    <link rel="stylesheet" type="text/css" href="/css/main.css"/>
    <@navbar.navbar_css/>
    <@footer.footer_css/>
</head>

<body xmlns="http://www.w3.org/1999/html">
<@navbar.navbar/>
    <main>
        <h1> Historique des gommettes </h1>
        <#if student_stickers??>
        <div class="table-container">
            <table>
                <thead>
                    <tr>
                        <th>Date</th>
                        <th>Couleur</th>
                        <th>Description</th>
                        <th>Raison</th>
                        <th>Elève receveur</th>
                        <th>Professeur attribuant</th>
                    </tr>
                </thead>
                <tbody>
                <#list student_stickers as student_sticker>
                    <tr>
                        <td>${student_sticker.date_sticker}</td>
                        <td>${student_sticker.color_sticker}</td>
                        <td>${student_sticker.sticker.description}</td>
                        <td>${student_sticker.reason}</td>
                        <td>${student_sticker.student_firstname} ${student_sticker.student_lastname}</td>
                        <td>${student_sticker.teacher_firstname} ${student_sticker.teacher_lastname}</td>
                    </tr>
                </#list>
                </tbody>
            </table>
        </div>
        </#if>
        <a href="/index"> Retourner à l'accueil </a>
    </main>
<@footer.footer/>
<@navbar.navbar_js/>
</body>

</html>
