<#ftl encoding="utf-8">

<html lang="fr">

<head>
    <link rel="stylesheet" type="text/css" href="css/main.css"/>
</head>

<body xmlns="http://www.w3.org/1999/html">
    <main>
        <ul>
            <h1> Historique des gommettes </h1>
            <#list student_stickers as student_sticker>
                <li> ${student_sticker.id} - <i> N° de gommette: ${student_sticker.id_sticker} </i> -
                ${student_sticker.color_sticker} -  <i> N° élève: ${student_sticker.id_student} </i> -
                 ${student_sticker.student_firstname} ${student_sticker.student_lastname}
                <br/> <strong> Description </strong> : ${student_sticker.sticker.description}
                <br/> <strong> Par </strong> : ${student_sticker.teacher_firstname} ${student_sticker.teacher_lastname}
                <br/> <strong> Attribué le </strong> : ${student_sticker.date_sticker} <br/>
                <strong> Raison </strong> : ${student_sticker.reason}  </li>
                <br/>
            </#list>
        </ul>
        <a href="/index"> Retourner à l'accueil </a>
    </main>
</body>

</html>
