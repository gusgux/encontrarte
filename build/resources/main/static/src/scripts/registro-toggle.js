
import { fetchData, updateData } from "./apihttp-registro.js";
import { enviarDatos, getCorreo } from "./fetchapi.js";
const modalRegistro = new bootstrap.Modal(document.getElementById('exampleModal'))

const btnSignUp = document.querySelector("#toggle-signup") //boton de registro
const btnLogin = document.querySelector("#toggle-login")//boton de login
const loginForm = document.querySelector(".modal-login")//elemento contenedor del login
const signUp = document.querySelector(".modal-registro")//elemento contenedor del registro
signUp.classList.add("visibilty");

const showError = document.getElementById("alert-message")
const alerta = new bootstrap.Modal(document.getElementById('alert-modal'))
function showAlert(message) {
    showError.textContent = message
    alerta.toggle()
}

//cuando click al boton de cambio  registro a login se ejecuta la arrow function event
btnSignUp.addEventListener("click", event => {

    loginForm.classList.remove("visibilty");// removemos la clase del elemento login para mostrar el login
    signUp.classList.add("visibilty");// agregamos la clase al elemento registro para ocultar el registro 
})

//cuando click al boton de cambio  login a registro se ejecuta la arrow function event
btnLogin.addEventListener("click", event => {


    signUp.classList.remove("visibilty");// removemos la clase del elemento registro para mostrar el registro
    loginForm.classList.add("visibilty");// agregamos la clase al elemento login para ocultar el login
})


const modalBackdrop = document.querySelector('.modal');
modalBackdrop.addEventListener('click', function (event) {
    if (event.target === modalBackdrop) {
        modalBackdrop.style.display = "none";
    }
});


const modal = document.getElementById("exampleModal");
// Obtén una referencia al formulario
const userForm = document.getElementById('formulario');

var contador = 0;
var bandera = false;
// Agrega un evento de envío al formulario
userForm.addEventListener('submit', function (event) {

    event.preventDefault(); // Evita el envío predeterminado del formulario
    let forms = event.target;
    contador = 0;
    Array.from(forms).forEach(input => {
        // contador para checar validaciones


        if (input.checkValidity() === false) {
            contador++;
        }


        forms.classList.add('was-validated');
    })

    if (contador === 0) {
        bandera = true;
    } else {

    }
    if (bandera) {
        // Obtiene los valores de los campos del formulario
        const nombres = document.getElementById('inputName').value;
        const apellidos = document.getElementById('inputLastName').value;
        const telefono = document.getElementById('inputnumber').value;
        const correo = document.getElementById('inputemail').value;
        const contrasena = document.getElementById('password').value;
        const passConf = document.getElementById('confirmpassword').value;
        // Crea un objeto JSON con los valores del formulario
        if (contrasena === passConf) {
            const usuario = {
                nombres: nombres,
                apellidos: apellidos,
                correo: correo,
                contrasena: contrasena,
                role: "comprador",
                telefono: telefono,
                id_compras: "1"
            };

            localStorage.setItem('user', JSON.stringify(usuario));

            const prueba = {
                "nombres": "Antonia",
                "apellidos": "Villaseñor",
                "correo": "antonia@example.com",
                "contrasena": "anto1234",
                "role": "artista",
                "telefono": "3331734583",
                "id_compras": "9"
            }
            enviarDatos(usuario);
            //document.querySelector('.modal-backdrop').remove();
            modalRegistro.toggle()
        } else {
            alert("Las contraseñas no coinciden");
        }
    }


    event.preventDefault(); // Evita el envío predeterminado del formulario
    // Puedes realizar otras acciones aquí, como enviar el objeto JSON a un servidor
});

var banderalogin = false;
const formlogin = document.getElementById('formularioLogin');



const userTest2 = {
    email: "prueba@gmail.com",
    password: "12345678",
};




formlogin.addEventListener('submit', function (event) {

    event.preventDefault(); // Evita el envío predeterminado del formulario
    // Puedes realizar otras acciones aquí, como enviar el objeto JSON a un servidor

    (function () {
        'use strict'

        // Fetch all the forms we want to apply custom Bootstrap validation styles to

        var forms = document.querySelectorAll('.needs-validation');
        // Loop over them and prevent submission
        Array.from(forms)
            .forEach(function (form) {
                form.addEventListener('submit', function (event) {
                    contador = 0;

                    Array.from(form.elements).forEach(function (element) {
                        if (element.checkValidity() === false) {
                            contador++;
                        }
                    });
                    if (contador === 0) {
                        banderalogin = true;
                    } else {

                    }
                    form.classList.add('was-validated');
                }, false);

            })


    })()
    if (banderalogin) {
        // Obtiene los valores de los campos del formulario

        let email = document.getElementById('inputEmailLogin').value;

        let pass = document.getElementById("inputPasswordLogin").value;
        let user = localStorage.getItem('user');
        async function validarLogin() {
            const datos = await getCorreo(email)
            if (datos != null) {
                if (email === datos.correo && pass === datos.contrasena) {

                    // Crea un objeto JSON con los valores del formulario
                    //localStorage.setItem('userLog', JSON.stringify(userTest));

                    setTimeout(() => {
                        modal.style.display = "none";
                        document.querySelector('.modal-backdrop').remove();
                    }, 300);


                } else {
                    //alert("Correo o contraseña incorrectos")
                    modalRegistro.toggle()
                    showAlert("Correo o contraseña incorrectos")
                }
            } else {
                //alert("Correo o contraseña incorrectos")
                modalRegistro.toggle()
                showAlert("Correo o contraseña incorrectos")

            }



        }
        validarLogin();

        /*if (email === user.email && pass === user.pass) {

            // Crea un objeto JSON con los valores del formulario
            localStorage.setItem('userLog', JSON.stringify(userTest));

            setTimeout(() => {
                modal.style.display = "none";
                document.querySelector('.modal-backdrop').remove();
            }, 300);


        } else {
            alert("Correo o contraseña incorrectos")
        }

*/
    }


});

