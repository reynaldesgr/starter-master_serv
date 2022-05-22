<#ftl encoding="utf-8">
<#import "common/nav.ftl" as navbar>
<#import "common/footer.ftl" as footer>

<html lang="fr">

<head>
    <title>Elèves</title>
    <link rel="stylesheet" type="text/css" href="/css/main.css"/>
    <@navbar.navbar_css/>
    <@footer.footer_css/>
</head>

<body xmlns="http://www.w3.org/1999/html">
<@navbar.navbar userlog??/>
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
            <#if empty_classes??>
                <h2> Ajouter un élève </h2>
                    <section>
                        <p> Pas de classes disponibles. Ajoutez de nouvelles classes. </p>
                    </section>
            <#else>
            <section>
                <h2> Ajouter un élève </h2>
                <p> Précisez le nom, le prénom et la classe du nouvel élève. </p>
                <form id="addstudent" method="post" action="/add-student">
                    <label for="lastname"><b>Nom</b>
                    </label>
                    <input type="text" name="lastname" id="lastname" placeholder="Nom">
                    <br><br>
                    <label for="firstname"><b>Prénom</b>
                    </label>
                    <input type="text" name="firstname" id="firstname" placeholder="Prénom">
                    <br><br>
                    <label for="studentclass"><b>Classe</b>
                    </label>
                    <SELECT name = "studentclass" id="studentclass" size = "1">
                        <#list classes as class>
                        <OPTION value="${class.idClass}"> ${class.idClass} - ${class.classname}
                            </#list>
                    </SELECT>
                    <br><br>
                    <input type="submit" name="log" id="log" value="Confirmer">
                    <br><br>
                </form>
            </section>
            </#if>
            <#if !empty??>
                <#if empty_classes??>
                <h2> Modifier un élève </h2>
                <section>
                    <p> Veuillez ajouter une classe pour modifier un élève. </p>
                </section>
                <#else>
                <section>
                    <h2> Modifier un élève </h2>
                        <p> Précisez l'élève et la nouvelle classe attribuée à cet élève. </p>
                        <form id = "studentclass" method="post" action="/update-student">
                            <label for="name">Elève</label>
                        <SELECT name = "name" id="name" size = "1">
                            <#list students as student>
                                <OPTION value="${student.id_student}"> ${student.id_student} - ${student.firstName} ${student.lastName}
                            </#list>
                        </SELECT>
                        <label for="studentclass"> dans la classe :</label>
                        <SELECT name = "studentclass" id="studentclass" size = "1">
                            <#list classes as class>
                            <OPTION value="${class.idClass}"> ${class.idClass} - ${class.classname}
                                </#list>
                        </SELECT>
                        <input type="submit" name="sub_class" id="sub_class" value="Confirmer">
                        </form>
                </section>
                </#if>
            </#if>
        </#if>
        <br/>
        <a href="/index"> Retourner à l'accueil </a>
    </main>
<@footer.footer/>
<@navbar.navbar_js/>
</body>

</html>
