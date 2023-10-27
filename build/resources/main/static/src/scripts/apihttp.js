
const urlapi = "http://localhost:8080/api/formulario";

async function getDataAll(url) {
    try {
        const response = await fetch(url);
        if (!response.ok) {
            throw new Error("Network response failed");
        }
        const data = await response.json();
        return data;
    } catch (error) {
        console.error("Error fetching data:", error);
        return null;
    }
}

// Llama a la función getData() usando async/await
export async function fetchData() {
    const result = await getDataAll(urlapi);
    console.log(result);
}

// Llama a la función fetchData() que usa async/await
//fetchData();



// put fetch

// Función para hacer una solicitud PUT

// Uso de async/await para esperar la resolución de la promesa
async function putData(url, newData) {
    try {
        const response = await fetch(`${url}`, {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(newData)
        });

        if (!response.ok) {
            throw new Error("Network response was not ok");
        }

        const updatedData = await response.json();
        console.log("Data updated successfully:", updatedData);
    } catch (error) {
        console.error("Error updating data:", error);
    }
}

// Uso de async/await para esperar la resolución de la promesa
export async function updateData(data) {

    await putData(urlapi, data);
}

// Llama a la función que usa async/await

async function getDataw(url) {
    const list = await fetch(url);
    const response = await list.json();
    return response;
}

console.log(await getDataw(urlapi));