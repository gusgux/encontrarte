const barra1 = document.querySelector(".barraMenu1");
const barra2 = document.querySelector(".barraMenu2");
const barra3 = document.querySelector(".barraMenu3");
 let moved = false;
const botonAbrir= document.getElementById("botonAbrir");
// const botonCerrar= document.getElementById("botonCerrar");
const contenedorNavList= document.getElementById("contenedorNavList");
const navList = document.getElementById("navList");
const modalRegistroLogin =document.querySelector("#exampleModal"); 
const loginBoton =document.querySelector("#loginBotonCabecera"); 
// const menuB =document.querySelector("#loginBotonCabecera"); 


let styleNavList= window.getComputedStyle(navList);// asi guaramos un objeto que tendrá los valores del CSS de contenedor navList
let styleContenedorNavList= window.getComputedStyle(contenedorNavList);// asi guaramos un objeto que tendrá los valores del CSS de contenedor navList
let direccionNavList;    
let visibilityContenedorNavList;
menuBurguerContenedor = document.querySelector(".menuBurguerContenedor")
let botonazos=0;

function moveBox() {
    const box = document.querySelector(".menuBurguerContenedor");;
  
    if (!moved) {
      box.style.transform = 'translateY(-130px)'; // Desplazar el div hacia la derecha
    } else {
      box.style.transform = 'translateY(0)'; // Regresar el div a la posición inicial
    }
  
    moved = !moved;
  }

menuBurguerContenedor.addEventListener("click",()=>{
//botonCerrar.classList.add("visible") // se cambio a un solo botón que utilizará el toggle para quitar y poner la etiqueta visible
contenedorNavList.classList.toggle("visible");
barra1.classList.toggle("activoBarraMenu1");
barra2.classList.toggle("activoBarraMenu2");
barra3.classList.toggle("activoBarraMenu3");
menuBurguerContenedor.classList.toggle("active");
console.log("contenedor Nav visible");

moveBox();

});

/*
botonCerrar.addEventListener("click",()=>{
    contenedorNavList.classList.remove("visible");
    botonCerrar.classList.remove("visible");
});
*/
// Agrega un listener para cuando se haga un resize cambie la probiedad del botón 
//la siguiente función sirve para poder arreglar un bug del boton de cerrar, de tal manera que se remueve el visible al boton cuando se agranda la pantalla teniendo abierta la navbar y se agrega el visible cuando se hace pequña y se esta mostrando el contenedor de la navList y y navList flex-direction es   columna
window.addEventListener("resize",()=>{ 
    direccionNavList=styleNavList.getPropertyValue("flex-direction")
    visibilityContenedorNavList=styleContenedorNavList.getPropertyValue("visibility");

   /* console.log("el valor de flex direction es: " + direccionNavList);*/
   //Línea de codigo utilizada para confirmar la salida que arroja la función 
if(innerWidth>770) {
//    botonCerrar.classList.remove("visible"); 
}

if(innerWidth<770 && direccionNavList =='column' && visibilityContenedorNavList=="visible" ) {
    
    // botonCerrar.classList.add("visible"); 
 }

});