<#ftl encoding="utf-8">

<body xmlns="http://www.w3.org/1999/html">

<h1> Liste des élèves </h1>
<ul>
    <#list students as student>
        <li>${student.id_student} - ${student.firstName} ${student.lastName} <br/>
            <strong> Classe </strong> : ${student.student_class}<br/>
            <#if userlog??> <a href="delete-student/${student.id_student}"> Supprimer </a> </#if>
        </li>
    </#list>
</ul>
    <#if userlog??>
            <section>
            <h2> Ajouter un élève </h2>
                <p> Précisez le nom, le prénom et la classe du nouvel élève. </p>
                <form id="addstudent" method="post" action="/add-student">
                    <label><b>Nom</b>
                    </label>
                    <input type="text" name="lastname" id="lastname" placeholder="Nom">
                    <br><br>
                    <label><b>Prénom</b>
                    </label>
                    <input type="text" name="firstname" id="firstname" placeholder="Prénom">
                    <br><br>
                    <label><b>Classe</b>
                    </label>
                    <input type="text" name="studentclass" id="studentclass" placeholder="Classe">
                    <br><br>
                    <input type="submit" name="log" id="log" value="Confirmer">
                    <br><br>
                </form>
        </section>
        <section>
            <h2> Modifier un élève </h2>
                <p> Précisez l'élève et la nouvelle classe attribuée à cet élève. </p>
                <form id = "studentclass" method="post" action="/update-student">
                <SELECT name = "name" size = "1">
                    <#list students as student>
                        <OPTION> ${student.id_student} - ${student.firstName} ${student.lastName}
                    </#list>
                </SELECT>
                <label for="class"> dans la classe :</label>
                    <input type="text" id="class" name="class"><br><br>
                <input type="submit" name="sub_class" id="sub_class" value="Confirmer">
                </form>
        </section>
    </#if>
<br/>
<a href="/index"> Retourner à l'accueil </a>
</body>

</html>
