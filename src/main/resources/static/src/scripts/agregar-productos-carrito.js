carrito=[];
cargarCarrito();
// agregarObraCarrito();
agregarCarrito();

function cargarCarrito() {
    const carritoGuardado = localStorage.getItem("carrito");
    if (carritoGuardado) {
      // Si hay datos en el localStorage, analízalos y actualiza el arreglo carrito
      carrito.push(...JSON.parse(carritoGuardado));
    }
  }


function agregarCarrito(){
    for(let i =0; i<carrito.length;i++){
        carrito[i]["obra_id"]=i;
    const obra = document.createElement('div');
    obra.id="lista-carrito";
    obra.className=""
    obra.innerHTML =
    `<hr  data-idObra="${carrito[i].obra_id}">
    <div class="row g-2 tarjeta-obra ">
        <!--Columna 1  Imagen-->
       <div class="col-sm-3 col-md-4 col-lg-4 carrito-imagen">
         <img src="${carrito[i].imagen}" class="w-100 " alt="...">
       </div>
       <!--Columna 2 Contenido-->
       <div class="col-sm-9 col-md-8 col-lg-8">
          <!--Fila 1-->
           <div class="d-flex">
               <!--Nombre obra-->
               <div class="col-sm-11 col-md-10 col-lg-11">
                   <h2 class="card-title">${carrito[i].titulo}</h2>
               </div>
               <!--Eliminar obra-->
               <div class="col-sm-1 col-md-2 col-lg-1">
                   <button type="button" id="${carrito[i]}" class="btn-close" aria-label="Close"></button>
               </div>
           </div>
           <!--Fila 2 Nombre artista-->
           <div>
               <h3 class="nombre-artista">${carrito[i].artista}</h3>
           </div>
           <!--Fila 3 Descripcion-->
           <div>
               <p class="descripcion-obra">${carrito[i].descripcion} </p>
           </div>
           <!--Fila 4  -->
           <div class="d-flex">
               <div class="col-sm-6 col-md-5 col-lg-6">
                   <h4 class="tamano-obra-carrito">Largo ${carrito[i].largo}cm x Ancho ${carrito[i].ancho}cm</h4>
               </div>
               <div class="col-sm-2 col-md-2 col-lg-2">
                <p class="precio-signo-carrito">$</p>
               </div>
               <div class="col-sm-4 col-md-5 col-lg-4">
                   <p class="precio">${carrito[i].precio}</p>
               </div>
           </div>
       </div>
     </div><!--Cierre Fila-->
    `;
    const carritoFlotante = document.querySelector('#creacion-fila-carrito');
    carritoFlotante.insertBefore(obra,carritoFlotante[i]);
    }

}

let subTotalCarrito=[];
let subTotal = 0;
let costoEnvio = 850;

//Suma de productos
calcularSubTotal();
function calcularSubTotal (){
    
    for(let i =0; i<carrito.length;i++){
        subTotal += carrito[i].precio;
    }
    console.log (subTotal);
    console.log(carrito.length)
    const totalFooter = document.querySelector('.sub-total-carrito');
    totalFooter.textContent = '$ '+subTotal + '.00';
}

//Suma total
calcularTotal();
function calcularTotal() {
    //Condicion si no hay obras el total es 0 
    if(carrito.length == 0){
        costoEnvio=0;
    }
    const total = subTotal + costoEnvio;
    console.log(total);

    const totalElement = document.querySelector('.precio-total-carrito');
    totalElement.textContent = 'Total= $'+total+'.00';
    
}


//Eliminacion del producto
const eliminarProducto = document.querySelectorAll('.btn-close');
eliminarProducto.forEach(element => {
    
    element.addEventListener('click', e =>{ 
        //Remover todo mi contenedor 
        let contenedorCarrito = e.target.parentElement.parentElement.parentElement.parentElement.parentElement; 
        contenedorCarrito.remove();
        
        let precio = contenedorCarrito.querySelector('.precio');
        console.log(precio.textContent);
        const totalFooter = document.querySelector('.sub-total-carrito');
        subTotal=subTotal-parseInt(precio.textContent);
        totalFooter.textContent = '$ '+subTotal + '.00';
        calcularTotal();
        //eliminar solo una fila 
        let getId = contenedorCarrito.querySelector('[data-idObra]');
       
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
