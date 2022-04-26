<#ftl encoding="utf-8">
<#import "common/nav.ftl" as navbar>
<#import "common/footer.ftl" as footer>

<html lang="fr">
<head>
    <title>Connexion</title>
    <link rel="stylesheet" type="text/css" href="/css/main.css"/>
    <@navbar.navbar_css/>
    <@footer.footer_css/>
</head>

<body>
<@navbar.navbar user_log??/>
    <main>
        <h2>${login_title}</h2><br>
        <div class="login">
            <form id="login" method="post" action="/login">
                <label for="username">
                    <b>
                        Nom d'utilisateur
                    </b>
                </label>
                <input type="text" name="username" id="username" required placeholder="Nom d'utilisateur">
                <label for="password">
                    <b>
                        Mot de passe
                    </b>
                </label>
                <input type="password" name="password" id="password" required placeholder="Mot de passe">
                <input type="submit" class="button center-button" name="log" id="log" value="Connexion">
            </form>
        </div>
    </main>
<@footer.footer/>
<@navbar.navbar_js/>
</body>
</html>