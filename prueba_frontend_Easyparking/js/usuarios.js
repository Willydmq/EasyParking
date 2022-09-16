
function loadData(){
    let request = sendRequest('usuario/list', 'GET', '')
    let table = document.getElementById('users-table');
    table.innerHTML = "";
    request.onload = function(){
        
        let data = request.response;
        console.log(data);
        data.forEach((element, index) => {
            table.innerHTML += `
                <tr>
                    <th>${element.idUsuario}</th>
                    <td>${element.usuario}</td>
                    <td>${element.clave}</td>
                    <td>
                        <div class="form-check form-switch">
                            <input ${element.activo ? "checked" : "uncheked"} class="form-check-input" type="checkbox" role="switch" disabled>
                        </div>
                    </td>
                    <td>
                        <button type="button" class="btn btn-primary" onclick='window.location = "/form_usuarios.html?id=${element.idUsuario}"'>Editar</button>
                        <button type="button" class="btn btn-danger" onclick='deleteUser(${element.idUsuario})'>Eliminar</button>
                    </td>
                </tr>

                `
        });
    }
    request.onerror = function(){
        table.innerHTML = `
            <tr>
                <td colspan="5">Error al recuperar los datos.</td>
            </tr>
        `;
    }
}

function loadUser(idUsuario){
    let request = sendRequest('usuario/list/'+idUsuario, 'GET', '')
    let email = document.getElementById('user-email')
    let password = document.getElementById('user-password')
    let id = document.getElementById('user-id')
    let status = document.getElementById('user-status')
    request.onload = function(){
        
        let data = request.response;
        email.value = data.usuario
        password.value = data.clave
        id.value = data.idUsuario
        status.checked = data.activo
    }
    request.onerror = function(){
        alert("Error al recuperar los datos.");
    }
}

function deleteUser(idUsuario){
    let request = sendRequest('usuario/'+idUsuario, 'DELETE', '')
    request.onload = function(){
        loadData()
    }
}

function saveUser(){
    let email = document.getElementById('user-email').value
    let password = document.getElementById('user-password').value
    let id = document.getElementById('user-id').value
    let status = document.getElementById('user-status').checked
    let data = {'idUsuario': id,'usuario':email,'clave': password, 'activo': status }
    let request = sendRequest('usuario/', id ? 'PUT' : 'POST', data)
    request.onload = function(){
        window.location = 'usuarios.html';
    }
    request.onerror = function(){
        alert('Error al guardar los cambios.')
    }
}