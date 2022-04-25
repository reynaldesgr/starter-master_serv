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
        <h1> Liste des élèves </h1>
        <div class="table-container">
            <table>
                <thead>
                <tr>
                    <th>Identifiant</th>
                    <th>Prénom</th>
                    <th>Nom</th>
                    <th>Classe</th>
                    <th>Professeur</th>
                    <#if userlog??><th>Suppression</th></#if>
                </tr>
                </thead>
                <tbody>
                <#list students as student>
                    <tr>
                        <td>${student.id_student}</td>
                        <td>${student.firstName}</td>
                        <td>${student.lastName}</td>
                        <td>${student.classEntity.classname}</td>
                        <td>${student.classEntity.teacher.lastName} ${student.classEntity.teacher.firstName}</td>
                        <#if userlog??><td><a href="delete-student/${student.id_student}"> Supprimer </a></td></#if>
                    </tr>
                </#list>
                </tbody>
            </table>
        </div>
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
    </main>
<@footer.footer/>
<@navbar.navbar_js/>
</body>

</html>