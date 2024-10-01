console.log("script loaded");

let currentTheme = getTheme();
document.addEventListener("DOMContentLoaded", ()=>{

    changeTheme();
})
function changeTheme() {
    const changeThemeButton = document.querySelector("#theme_change_button");
    changePageTheme(currentTheme,currentTheme);
    changeThemeButton.addEventListener("click",(event) =>{
        const oldTheme = currentTheme;
        if(currentTheme==="dark"){
            currentTheme="light";
        }else{
            currentTheme="dark";
        }
        changePageTheme(currentTheme,oldTheme);
    });
    
}

function setTheme(theme){
    localStorage.setItem("theme",theme);
}

function getTheme(){
    let theme = localStorage.getItem("theme");
    return theme ? theme : "light";
}

function changePageTheme(newTheme,oldTheme){
    setTheme(currentTheme);
        document.querySelector("html").classList.remove(oldTheme);
        document.querySelector("html").classList.add(newTheme);
        document.querySelector("#theme_change_button").querySelector("span").textContent=
        currentTheme== "light" ? "Dark" : "Light";
}