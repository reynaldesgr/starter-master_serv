<#ftl encoding="utf-8">
<#import "common/nav.ftl" as navbar>
<#import "common/footer.ftl" as footer>

<html lang="fr">
<head>
    <link rel="stylesheet" type="text/css" href="/css/main.css"/>
    <@navbar.navbar_css/>
    <@footer.footer_css/>
    <title> Bienvenue </title>
</head>

<body>
<@navbar.navbar user_log??/>
    <main>
        <h1> Accueil </h1>
        <h2>${index_title}</h2>
        <#if user_log??>
            <p> Vous êtes connecté en tant que <strong> ${user_log} </strong> </p>
        </#if>
        <div class="row">

            <div class="column">
                <a href="/students" class = "button">Consulter les élèves</a>
                <a href="/teachers" class = "button">Consulter les professeurs</a>
            </div>

            <#if user_log??>
                <div class="column">
                    <a href="/put-students" class = "button">Modifier/Ajouter un élève</a>
                    <a href="/put-stickers" class = "button">Mettre des gommettes</a>
                </div>
            </#if>

            <div class="column">
                <a href="/stickers" class = "button">Liste des gommettes</a>
                <a href="/students-stickers" class = "button">Historique des gommettes</a>
            </div>

            <#if user_log??>
                <div class="column">
                    <a href="/put-classes" class = "button">Gestion des classes</a>
                    <a href="/disconnect" class = "button">Se déconnecter</a>
                </div>
                <#if !empty_students??>
                    <h2> Consulter les gommettes d'un élève </h2>
                    <form id="putsticker_index" method="post" action="/consult-student-stickers">
                        <label for="student_name">Nom </label>
                        <SELECT name = "student_name" id="student_name" size="1">
                            <#list students as student>
                            <OPTION> ${student.id_student} - ${student.firstName} ${student.lastName}
                                </#list>
                        </SELECT>
                        <input type="submit" name="sub_consult" id="sub_consult" value="Confirmer">
                    </form>
                </#if>
            <#else>
                <div class="column">
                    <a href="/login" class = "button center-button">Se connecter</a>
                </div>
            </#if>
        </div>
    </main>
<@footer.footer/>
<@navbar.navbar_js/>
</body>
</html>