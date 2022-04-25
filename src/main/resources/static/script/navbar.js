const body = document.querySelector("body");
const burger_icon = document.getElementById("topnav_hamburger_icon");
const menu = document.getElementById("topnav_responsive_menu");
const icon = document.getElementById("topnav_hamburger_icon");
const root = document.getElementById("root");
const overlay = document.getElementById("overlay");


burger_icon.addEventListener("click", (e) => {
    if (!menu.classList.contains("open")) {
        menu.classList.add("open");
        icon.classList.add("open");
        root.style.overflowY = "hidden";
    } else {
        menu.classList.remove("open");
        icon.classList.remove("open");
        root.style.overflowY = "";
    }
})