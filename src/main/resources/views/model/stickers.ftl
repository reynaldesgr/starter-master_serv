<#ftl encoding="utf-8">
<#import "common/nav.ftl" as navbar>
<#import "common/footer.ftl" as footer>

<html lang="fr">

<head>
    <title>Gommettes</title>
    <link rel="stylesheet" type="text/css" href="/css/main.css"/>
    <@navbar.navbar_css/>
    <@footer.footer_css/>
</head>

<body xmlns="http://www.w3.org/1999/html">
<@navbar.navbar userlog??/>
    <main>
        <h1> Liste des gommettes </h1>
        <#if stickers??>
        <div class="table-container">
            <table>
                <thead>
                <tr>
                    <th>Identifiant</th>
                    <th>Couleur</th>
                    <th>Description</th>
                    <#if userlog??><th>Suppression</th></#if>
                </tr>
                </thead>
                <tbody>
                <#list stickers as sticker>
                    <tr>
                        <td>${sticker.id_sticker}</td>
                        <td>${sticker.color}</td>
                        <td>${sticker.description}</td>
                        <#if userlog??><td><a href="/delete-sticker/${sticker.id_sticker}"> Supprimer </a></td></#if>
                    </tr>
                </#list>
                </tbody>
            </table>
        </div>
        </#if>
        <#if userlog??>
            <#if stickers??>
                <section>
                    <h2> Modifier une gommette </h2>
                    <p> Choisissez le numéro de la gommette à modifier et saissisez ses nouvelles informations
                    <form id="change" method="post" action="/modify-sticker">
                        <label for="id">Gommette:</label>
                        <SELECT name = "id" id="id" size="1">
                            <#list stickers as sticker>
                                    <OPTION> ${sticker.id_sticker}
                            </#list>
                        </SELECT><br/>
                        <label for="color">Couleur</label>
                        <SELECT name = "color" id="color" size="1">
                            <OPTION> ROUGE
                            <OPTION> VERT
                            <OPTION> BLEU
                        </SELECT><br/>
                        <label for="description"> Description :</label>
                            <input type="text" id="description" name="description"><br><br>
                        <input type="submit" name="modify" id="modify" value="Confirmer">
                    </form>
                </section>
            </#if>
            <section>
                <h2> Ajouter une nouvelle gommette </h2>
                <p> Pour ajouter une nouvelle gommette vous devez précisez
                sa <strong> couleur </strong> et lui donner une <strong> description </strong>. </p>
                <form id="change" method="post" action="/add-sticker">
                    <label for="color2">Couleur</label>
                    <SELECT name ="color" id="color2" size="1">
                        <OPTION> ROUGE
                        <OPTION> VERT
                        <OPTION> BLEU
                    </SELECT><br/>
                    <label for="description"> Description :</label>
                        <input type="text" id="description" name="description"><br><br>
                    <input type="submit" name="add" id="add" value="Confirmer">
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
