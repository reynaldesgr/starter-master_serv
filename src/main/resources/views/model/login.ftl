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
<@navbar.navbar/>
    <main>
        <h2>${login_title}</h2><br>
        <div class="login">
            <form id="login" method="post" action="/login">
                <label for="username">
                    <b>
                        Nom d'utilisateur
                    </b>
                </label>
                <input type="text" name="username" id="username" placeholder="Nom d'utilisateur">
                <br><br>
                <label for="password">
                    <b>
                        Mot de passe
                    </b>
                </label>
                <input type="password" name="password" id="password" required placeholder="Mot de passe">
                <br><br>
                <input type="submit" name="log" id="log" value="Connexion">
                <br><br>
            </form>

        </div>
    </main>
<@footer.footer/>
<@navbar.navbar_js/>
</body>
</html>