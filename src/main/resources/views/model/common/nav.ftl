<#macro navbar_css>
    <link rel="stylesheet" type="text/css" href="/css/navbar.css"/>
</#macro>

<#macro navbar>
    <div id="root">
        <div id="topnav" class="topnav">
            <a id="home_link" class="topnav_link" href="/">Accueil</a>

            <!-- Menu Classic -->
            <nav id="topnav_menu">
                <a class="topnav_link" href="/students">Elèves</a>
                <a class="topnav_link" href="/teachers">Professeurs</a>
                <a class="topnav_link" href="/stickers">Gommettes</a>
                <a class="topnav_link" href="/students-stickers">Historique</a>
                <#if user_log??>
                    <a class="topnav_link" href="/put-students">Gestion des élèves</a>
                    <a class="topnav_link" href="/put-stickers">Gestion des gommettes</a>
                    <a class="topnav_link" href="/put-classes"> Gestion des classes</a>
                    <a class="topnav_link" href="/disconnect">Déconnection</a>
                <#else>
                    <a class="topnav_link" href="/login"> Se connecter </a>
                </#if>
            </nav>

            <div id="topnav_hamburger_icon">
                <!-- Burger Menu -->
                <span></span>
                <span></span>
                <span></span>
            </div>

            <!-- Responsive Menu -->
            <nav id="topnav_responsive_menu">
                <ul>
                    <li><a href="/students" class="topnav_responsive_menu_a">Elèves</a></li>
                    <li><a href="/teachers" class="topnav_responsive_menu_a">Professeurs</a></li>
                    <li><a href="/stickers" class="topnav_responsive_menu_a">Gommettes</a></li>
                    <li><a href="/students-stickers" class="topnav_responsive_menu_a">Historique</a></li>
                    <#if user_log??>
                        <li><a class="topnav_responsive_menu_a" href="/put-students">Gestion des élèves</a></li>
                        <li><a class="topnav_responsive_menu_a" href="/put-stickers">Gestion des gommettes</a></li>
                        <li><a class="topnav_responsive_menu_a" href="/put-classes"> Gestion des classes</a></li>
                        <li><a class="topnav_responsive_menu_a" href="/disconnect">Déconnection</a></li>
                    <#else>
                        <li><a class="topnav_responsive_menu_a" href="/login"> Se connecter </a></li>
                    </#if>
                </ul>
            </nav>
        </div>
    </div>
</#macro>

<#macro navbar_js>
    <script src="/script/navbar.js"></script>
</#macro>

</html>
