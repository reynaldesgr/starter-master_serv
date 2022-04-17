
<html>
<head>
    <title>Connexion</title>
</head>
<body>
    <h2>${login_title}</h2><br>
    <div class="login">
    <form id="login" method="post" action="/login">
        <label><b>Nom d'utilisateur
        </b>
        </label>
        <input type="text" name="username" id="username" placeholder="Nom d'utilisateur">
        <br><br>
        <label><b>Mot de passe
        </b>
        </label>
        <input type="password" name="password" id="password" required placeholder="Mot de passe">
        <br><br>
        <input type="submit" name="log" id="log" value="Connexion">
        <br><br>
    </form>
</div>
<br/>
<a href="/index"> Retourner à l'accueil </a>
</body>
</html>