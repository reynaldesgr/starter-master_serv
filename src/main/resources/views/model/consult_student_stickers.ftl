<#ftl encoding="utf-8">

<body xmlns="http://www.w3.org/1999/html">
<h1> Gommettes de ${student.firstName} ${student.lastName} </h1>
<ul>
    <#list consult_stickers as student_sticker>
        <li> ${student_sticker.id} ${student_sticker.color_sticker} -  N° élève: ${student_sticker.id_student} :
        ${student_sticker.student_firstname} ${student_sticker.student_lastname}
        <br/> par ${student_sticker.teacher_firstname} ${student_sticker.teacher_lastname} </br>
        <strong> Raison </strong> : ${student_sticker.reason}
        <a href="/delete-student-sticker/${student_sticker.id}"> Supprimer </a>
        <br/><br/>
    </#list>
</ul>
<a href="/index"> Retourner à l'accueil </a>
</body>

</html>
