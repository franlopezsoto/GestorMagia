import React, { useState } from 'react';
import axios from 'axios';

function App() {
    const [nombre, setNombre] = useState('');
    const [tipo, setTipo] = useState('');
    const [descripcion, setDescripcion] = useState('');
    const [response, setResponse] = useState(null);

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            const res = await axios.post('http://localhost:8080/hechizos', {
                nombre,
                tipo,
                descripcion,
            });
            setResponse(res.data);
        } catch (error) {
            console.error(error);
        }
    };

    return (
        <div className="App">
            <h1>Mago de Pruebas</h1>
            <form onSubmit={handleSubmit}>
                <div>
                    <label>Nombre:</label>
                    <input type="text" value={nombre} onChange={(e) => setNombre(e.target.value)} />
                </div>
                <div>
                    <label>Tipo:</label>
                    <input type="text" value={tipo} onChange={(e) => setTipo(e.target.value)} />
                </div>
                <div>
                    <label>Descripción:</label>
                    <input type="text" value={descripcion} onChange={(e) => setDescripcion(e.target.value)} />
                </div>
                <button type="submit">Enviar Hechizo</button>
            </form>
            {response && (
                <div>
                    <h2>Respuesta del Servidor:</h2>
                    <pre>{JSON.stringify(response, null, 2)}</pre>
                </div>
            )}
        </div>
    );
}

export default App;
