<#ftl encoding="utf-8">
<#import "common/nav.ftl" as navbar>
<#import "common/footer.ftl" as footer>

<html lang="fr">

<head>
    <link rel="stylesheet" type="text/css" href="css/main.css"/>
    <@navbar.navbar_css/>
    <@footer.footer_css/>
</head>

<body xmlns="http://www.w3.org/1999/html">
<@navbar.navbar/>
    <main>
        <h1> Liste des classes </h1>
        <div class="table-container">
            <table>
                <thead>
                <tr>
                    <th>Identifiant</th>
                    <th>Nom</th>
                    <th>Professeur</th>
                    <#if userlog??><th>Suppression</th></#if>
                </tr>
                </thead>
                <tbody>
                <#list classes as class>
                    <tr>
                        <td>${class.idClass}</td>
                        <td>${class.classname}</td>
                        <td>${class.teacher.lastName} ${class.teacher.firstName}</td>
                        <#if userlog??><td><a href="delete-class/${class.idClass}"> Supprimer </a></td></#if>
                    </tr>
                </#list>
                </tbody>
            </table>
        </div>
        <#if userlog??>
            <section>
                <h2> Ajouter une classe </h2>
                <p> Précisez le nom et le professeur de la classe. </p>
                <form id="addClassroom" method="post" action="/add-classroom">
                    <label><b>Nom de la classe : </b>
                    </label>
                    <input type="text" name="classname" id="classname" placeholder="Nom">
                    <br><br>
                    <SELECT name = "classTeacher" size = "1">
                        <#list teachers as teacher>
                                <OPTION value="${teacher.id_teacher}"> ${teacher.lastName} - ${teacher.firstName}
                        </#list>
                    </SELECT>
                    <br><br>
                    <input type="submit" name="log" id="log" value="Confirmer">
                    <br><br>
                </form>
            </section>
            <section>
                <h2> Modifier une classe </h2>
                <p> Précisez la classe, son nouveau nom et son nouveau professeur </p>
                <form method="post" action="/update-classes">
                    <label for="classId"> Classe à modifier: </label>
                    <SELECT name = "classId" id="classId" size = "1">
                        <#list classes as class>
                        <OPTION value="${class.idClass}"> ${class.classname}
                            </#list>
                    </SELECT>
                    <label for="new_classname"> Nouveau nom:</label>
                    <input type="text" name="classname" id="new_classname" placeholder="Nouveau nom">
                    <label for="new_classTeacher"> Nouveau professeur:</label>
                    <SELECT name = "classTeacher" id="new_classTeacher" size = "1">
                        <#list teachers as teacher>
                        <OPTION value="${teacher.id_teacher}"> ${teacher.lastName} - ${teacher.firstName}
                            </#list>
                    </SELECT>
                    <input type="submit" name="sub_class" id="sub_class" value="Confirmer">
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
