<#ftl encoding="utf-8">

<html lang="fr">

<head>
    <link rel="stylesheet" type="text/css" href="css/main.css"/>
</head>

<body xmlns="http://www.w3.org/1999/html">
    <main>
        <h1> Liste des classes </h1>
        <ul>
            <#list classes as class>
                <li>${class.idClass} - ${class.classname} <br/>
                    <#assign classId=class.idClass/>
                    <strong> Professeur </strong> : ${class.teacher.lastName} ${class.teacher.firstName}<br/>
                    <#if userlog?? && classId!=0 >
                        <a href="delete-class/${class.idClass}"> Supprimer </a>
                    </#if>
                </li>
            </#list>
        </ul>
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
                            <#assign teacherId=teacher.id_teacher/>
                            <#if teacherId!=0 >
                                <OPTION value="${teacher.id_teacher}"> ${teacher.lastName} - ${teacher.firstName}
                            </#if>
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
                        <#assign classId=class.idClass/>
                        <#if classId!=0 >
                        <OPTION value="${class.idClass}"> ${class.classname}
                            </#if>
                            </#list>
                    </SELECT>
                    <label for="new_classname"> Nouveau nom:</label>
                    <input type="text" name="classname" id="new_classname" placeholder="Nouveau nom">
                    <label for="new_classTeacher"> Nouveau professeur:</label>
                    <SELECT name = "classTeacher" id="new_classTeacher" size = "1">
                        <#list teachers as teacher>
                        <#assign teacherId=teacher.id_teacher/>
                        <#if teacherId!=0 >
                        <OPTION value="${teacher.id_teacher}"> ${teacher.lastName} - ${teacher.firstName}
                            </#if>
                            </#list>
                    </SELECT>
                    <input type="submit" name="sub_class" id="sub_class" value="Confirmer">
                </form>
            </section>
        </#if>
        <br/>
        <a href="/index"> Retourner à l'accueil </a>
    </main>
</body>

</html>
