<#ftl encoding="utf-8">

<body xmlns="http://www.w3.org/1999/html">

<h1> Liste des élèves </h1>
<ul>
    <#list students as student>
        <li>${student.id_student} - ${student.firstName} ${student.lastName} <br/>
            <strong> Classe </strong> : ${student.classEntity.classname}<br/>
            <#if userlog??> <a href="delete-student/${student.id_student}"> Supprimer </a> </#if>
        </li>
    </#list>
</ul>
    <#if userlog??>
        <section>
            <h2> Mettre une gomette </h2>
                    <form id="putsticker" method="post" action="/put-stickers">
                    <SELECT name = "name" size = "1">
                    <#list students as student>
                            <OPTION> ${student.id_student} - ${student.firstName} ${student.lastName}
                    </#list>
                    </SELECT>
                    <SELECT name = "color" size = "1">
                    <#list id_stickers as sticker>
                           <OPTION> ${sticker.id_sticker} - ${sticker.color} - ${sticker.description}
                    </#list>
                    </SELECT>
                    <label for="reason"> Raison :</label>
                      <input type="text" id="reason" name="reason"><br><br>
                    <input type="submit" name="sub" id="sub" value="Confirmer">
                    </form>
        </section>
        <section>
            <h2> Consulter les gommettes d'un élève </h2>
                <form id="putsticker" method="post" action="/consult-student-stickers">
                    <SELECT name = "student_name" size="1">
                        <#list students as student>
                            <OPTION> ${student.id_student} - ${student.firstName} ${student.lastName}
                        </#list>
                    </SELECT>
                        <br><br>
                        <input type="submit" name="sub_consult" id="sub_consult" value="Confirmer">
            </form>
        </section>
    </#if>
<br/>
<a href="/index"> Retourner à l'accueil </a>
</body>

</html>