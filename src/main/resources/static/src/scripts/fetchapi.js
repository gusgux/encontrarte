// Define los datos a enviar
/*const data = {
    "nombres": "Antonio",
    "apellidos": "Martinez",
    "correo": "antonio@example.com",
    "contrasena": "antonio1234",
    "role": "artista",
    "telefono": "3331234433",
    "id_compras": "8"
};
*/

// Define la URL de la API
const url = 'http://localhost:8080/api/usuario';

// Configura la solicitud POST

export async function enviarDatos(data) {
    try {
        const response = await fetch(url, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        });

        if (response.status === 200) {
            console.log('El usuario se creó exitosamente.');
        } else {
            console.error('Hubo un error al crear el usuario. Código de estado:', response.status);
            const errorText = await response.json();
            if (errorText) {
                console.error(errorText); // Imprime los detalles del error si los hubiera
            }
        }
    } catch (error) {
        console.error('Hubo un error en la solicitud:', error);
    }
}


/*export function enviarDatos(data) {
    fetch(url, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
        .then(response => {
            console.log(response)
            if (response.status === 200) {
                console.log('El usuario se creó exitosamente.');
            } else {
                console.error('Hubo un error al crear el usuario. Código de estado:', response.status);
                return response.json();
            }
        })
        .then(errorText => {
            if (errorText) {
                console.error(errorText); // Imprime los detalles del error si los hubiera
            }
        })
        .catch(error => {
            console.error('Hubo un error en la solicitud:', error);
        });
}
*/

/*export async function getCorreo(email) {
    const list = await fetch(`http://localhost:8080/api/usuario/byCorreo?correo=${email}`);
    const response = await list.json();
    return response;
}
*/
export async function getCorreo(email) {
    try {
        const list = await fetch(`http://localhost:8080/api/usuario/byCorreo?correo=${email}`);
        if (!list.ok) {
            // Si la respuesta no es "ok" (código de estado no exitoso), maneja el error
            throw new Error('Hubo un error en la solicitud.');

        }
        const response = await list.json();
        return response;

    } catch (error) {
        console.log('Hubo un error en la solicitud:', error);
        return null; // Puedes devolver null u otro valor predeterminado en caso de error
    }
}

export async function getByEmail(email) {
    // Define la URL de la API con el correo electrónico específico como parámetro
    const url = `http://localhost:8080/api/usuario/byCorreo?correo=${email}`;
    //console.log(url);

    try {
        const response = await fetch(url);

        if (response.status === 200) {
            const data = await response.json(); // Parsea la respuesta como JSON
            return data;
        } else {
            console.error('Hubo un error al obtener el usuario. Código de estado:', response.status);
            return null; // Puedes devolver null u otro valor predeterminado en caso de error
        }
    } catch (error) {
        console.error('Hubo un error en la solicitud:', error);
        return null; // Manejo de errores y retorno de valor predeterminado
    }
}
//METODO GETBYEMAIL
// http://localhost:8080/api/usuario/byCorreo?correo=limon@email.com
/*export function getByEmail(email) {
    // Define la URL de la API con el correo electrónico específico como parámetro
    let datos;
    const url = `http://localhost:8080/api/usuario/byCorreo?correo=${email}`;
    //console.log(url)
    // Realiza la solicitud GET
    fetch(url)
        .then(response => {
            if (response.status === 200) {
                return response.json(); // Parsea la respuesta como JSON
            } else {
                console.error('Hubo un error al obtener el usuario. Código de estado:', response.status);
            }
        })
        .then(data => {
            const correo = data
            datos = data
            return correo
        })
        .catch(error => {
            console.error('Hubo un error en la solicitud:', error);
        });
    console.log(datos)
    return datos
}
*/

// Ejemplo de uso: obtén el usuario con correo electrónico "alicia@example.com"
//getByEmail("antonia@example.com");


