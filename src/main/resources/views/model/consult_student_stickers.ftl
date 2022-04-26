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
<@navbar.navbar user_log??/>
    <main>
        <h1> Gommettes de ${student.firstName} ${student.lastName} </h1>
        <ul>
            <#list consult_stickers as student_sticker>
                <li>
                    ${student_sticker.id} ${student_sticker.color_sticker} -  N° élève: ${student_sticker.id_student} :
                    ${student_sticker.student_firstname} ${student_sticker.student_lastname}
                    <br/> <strong> Description </strong> : ${student_sticker.sticker.description}
                    <br/> <strong> par </strong> : ${student_sticker.teacher_firstname} ${student_sticker.teacher_lastname} </br>
                    <strong> Raison </strong> : ${student_sticker.reason}
                    <a href="/delete-student-sticker/${student_sticker.id_student}/${student_sticker.id}"> Supprimer </a>
                </li>
                <br/><br/>
            </#list>
        </ul>
        <a href="/index"> Retourner à l'accueil </a>
    </main>
<@footer.footer/>
<@navbar.navbar_js/>
</body>

</html>
