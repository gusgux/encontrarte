//Funcion para mostrar carrito presionando el boton de carrito
const botonCarrito= document.querySelector("#muestraCarritoFlotante");
const carritoFlotanteNav= document.querySelector("#carrito-flotante");


// function mostrarCarrito (){
    botonCarrito.addEventListener("click",()=>{
        carritoFlotanteNav.classList.add("mostrar");
         console.log("se muestra carrito");
    });

// }
//Funcion para ocultar carrito presionando el boton ocultar
function ocultarCarrito (){
    carritoFlotanteNav.classList.remove("mostrar");
    
}

carrito=[];
cargarCarrito();
// agregarObraCarrito();
agregarCarritoFlotante();

function cargarCarrito() {
    const carritoGuardado = localStorage.getItem("carrito");
    if (carritoGuardado) {
      // Si hay datos en el localStorage, analízalos y actualiza el arreglo carrito
      carrito.push(...JSON.parse(carritoGuardado));
    }
  }


function agregarCarritoFlotante(){
    for(let i =0; i<carrito.length;i++){
        carrito[i]["obra_id"]=i;
    const obra = document.createElement('div');
    obra.id="lista-carrito-flotante";
    obra.className=""
    obra.innerHTML =
    `<hr data-idObra="${carrito[i].obra_id}">
    <div id="lista-carrito-flotante" class="row tarjeta-obra" class="col-sm-12 col-md-4 col-lg-4"> <!--se agrega id para js-->
       <!--Columna 1    Imagen de producto-->
       <div class="col-sm-3 col-md-4 col-lg-4 imagen-producto-carrito-flotante"> 
           <img src="${carrito[i].imagen}" class="card-img-top" alt="imagen 1" >
       </div><!--cierre imagen-->
       <!--Columna 2-->
       <div class="col-sm-7 col-md-8 col-lg-8 ">
           <div class="card-body">
                <!--Columna 2.1-->
                <div class="col cerrar">
                    <!--Columna 2 fila 1   Nombre del producto-->
                    <div class="col-sm-11 col-md-9 col-lg-11">
                        <h5 class="card-title">${carrito[i].titulo}</h5>
                    </div>
                    <!--Columna 2 fila 1  Boton eliminar producto-->
                    <div class="col-sm-1 col-md-3 col-lg-1">
                        <a href="#">
                            <button type="button" id="${carrito[i]}" class="btn-close" aria-label="Close"></button>
                        </a>
                    </div>
                </div>
				<!--Columna 2 fila 2  Nombre artista-->
               <h6 class="nombre-artista">${carrito[i].artista}</h6>
               <br>
               <!--Columna 2 fila 3  Tamano-->
                <p class="centrado tamano-obra negro-flotante" >Largo ${carrito[i].largo} x Ancho ${carrito[i].ancho}</p> 
                <br>
                <!--Columna 2 fila 3  Tamano-->
                <div class="row"> <!--row->
                    <!--Fila 3 col 1   signo de precio-->
                    <div class="col-8">
                        <p class="precioSigno negro-flotante" >$</p>
                    </div>
					<!--Fila 3 col 2   precio-->
                    <div class="col-4" >
                        <p class="precio negro-flotante" > ${carrito[i].precio} </p> 
                    </div>
                </div>
            </div>
        </div><!--cierre columna info-->
    </div> <!--cierre fila-->
    `;
    const carritoFlotante = document.querySelector('#fila-carrito-flotante');
    carritoFlotante.insertBefore(obra,carritoFlotante[i]);
    }

}

let subTotalCarrito=[];
let subTotal = 0;

//Suma de productos
calcularSubTotal();
function calcularSubTotal (){
    
    for(let i =0; i<carrito.length;i++){
        subTotal += carrito[i].precio;
    }
    console.log (subTotal);

    const totalFooter = document.querySelector('.total-footer');
    totalFooter.textContent = '$ '+subTotal + '.00';
}

//Eliminacion del producto
const eliminarProducto = document.querySelectorAll('.btn-close');
eliminarProducto.forEach(element => {
    
    element.addEventListener('click', e =>{ 
        //Remover todo mi contenedor 
        let contenedorCarrito = e.target.parentElement.parentElement.parentElement.parentElement.parentElement.parentElement.parentElement; 
        contenedorCarrito.remove();
        //
        let precio = contenedorCarrito.querySelector('.precio');
        console.log(precio.textContent);
        const totalFooter = document.querySelector('.total-footer');
        subTotal=subTotal-parseInt(precio.textContent);
        totalFooter.textContent = '$ '+subTotal + '.00';
        //eliminar solo una fila 
        let getId = contenedorCarrito.querySelector('[data-idObra]');
        //console.log(getId.dataset.idobra);
       // console.log(getId);
        //carrito=[];
        console.log(carrito);
        let nuevoCarrito = [];
        carrito.forEach(element => {
            if (element.obra_id!= getId.dataset.idobra) {
                nuevoCarrito.push(element);
            }
        });
        console.log (nuevoCarrito);
        //se resetea el locar estorage, con los carritos eliminados 
        localStorage.setItem('carrito', JSON.stringify(nuevoCarrito));
        
    })

});
