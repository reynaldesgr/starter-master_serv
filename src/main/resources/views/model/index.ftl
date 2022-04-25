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
        <a href="/students"> Consulter les élèves </a><br/>
        <a href="/teachers"> Consulter les professeurs </a> <br/><br/>
        <a href="/stickers"> Liste des gommettes </a><br/>
        <a href="/students-stickers"> Historique des gommettes </a><br/><br/>
        <#if user_log??>
            <br/>
            <a href="/put-students"> Modifier/Ajouter un élève </a><br/>
            <a href="/put-stickers"> Mettre des gommettes </a><br/><br/>
            <a href="/put-classes"> Gestion des classes </a><br/><br/>
            <a href="/disconnect"> Se déconnecter </a>
        <#else>
            <a href="/login"> Se connecter </a>
        </#if>
    </main>
<@footer.footer/>
<@navbar.navbar_js/>
</body>
</html>