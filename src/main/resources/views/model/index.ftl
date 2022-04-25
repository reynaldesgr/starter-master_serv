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
<@navbar.navbar/>
    <main>
        <h1> Accueil </h1>
        <h2>${index_title}</h2>
        <#if user_log??>
            <p> Vous êtes connecté en tant que <strong> ${user_log} </strong> </p>
        </#if>
        <div class="row">
        
            <div class="column">

                <button onclick="location.href='/students'" type="button" class = "index_link">Consulter les élèves</button>

                <button onclick="location.href='/teachers'" type="button" class = "index_link">Consulter les professeurs</button>

                <#if user_log??>
                    <button onclick="location.href='/put-students'" type="button" class = "index_link">Modifier/Ajouter un élève</button>

                    <button onclick="location.href='/put-stickers'" type="button" class = "index_link">Mettre des gommettes</button>
                </#if>
            </div>
            
            <div class="column">

                <button onclick="location.href='/stickers'" type="button" class = "index_link">Liste des gommettes</button>

                <button onclick="location.href='/students-stickers'" type="button" class = "index_link">Historique des gommettes</button>
                

                <#if user_log??>
                    <button onclick="location.href='/put-classes'" type="button" class = "index_link">Gestion des classes</button>
                    
                    <button onclick="location.href='/disconnect'" type="button" class = "index_link">Se déconnecter</button>
                </#if>
            </div>
    
        </div>
        <#if user_log??>
            <h2> Consulter les gommettes d'un élève </h2>
                <form id="putsticker_index" method="post" action="/consult-student-stickers">
                    <SELECT name = "student_name" size="1">
                        <#list students as student>
                            <OPTION> ${student.id_student} - ${student.firstName} ${student.lastName}
                        </#list>
                    </SELECT>
                        <input type="submit" name="sub_consult" id="sub_consult" value="Confirmer">
                </form>
        <#else>
            <button onclick="location.href='/login'" type="button" class = "index_link" id = "login_link">Se connecter</button>
        </#if>
    </main>
<@footer.footer/>
<@navbar.navbar_js/>
</body>
</html>