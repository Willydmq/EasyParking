
function loadData(){
    let request = sendRequest('producto/list', 'GET', '')
    let table = document.getElementById('products-table');
    table.innerHTML = "";
    request.onload = function(){
        
        let data = request.response;
        console.log(data);
        data.forEach((element, index) => {
            table.innerHTML += `
                <tr>
                    <th>${element.idProducto}</th>
                    <td>${element.nombreProducto}</td>
                    <td>${element.valorCompra}</td>
                    <td>${element.valorVenta}</td>
                    <td>${element.cantidad}</td>
                    <td>
                        <button type="button" class="btn btn-primary" onclick='window.location = "/form_productos.html?id=${element.idProducto}"'>Editar</button>
                        <button type="button" class="btn btn-danger" onclick='deleteProducto(${element.idProducto})'>Eliminar</button>
                    </td>
                </tr>

                `
        });
    }
    request.onerror = function(){
        table.innerHTML = `
            <tr>
                <td colspan="6">Error al recuperar los datos.</td>
            </tr>
        `;
    }
}

function loadProducto(idProducto){
    let request = sendRequest('producto/list/'+idProducto, 'GET', '')
    let name = document.getElementById('product-name')
    let sale = document.getElementById('product-sale-value')
    let purchase = document.getElementById('product-purchase-value')
    let quantity = document.getElementById('product-quantity')
    let id = document.getElementById('product-id')
    request.onload = function(){
        
        let data = request.response
        id.value = data.idProducto
        name.value = data.nombreProducto
        sale.value = data.valorVenta
        purchase.value = data.valorCompra
        quantity.value = data.cantidad
    }
    request.onerror = function(){
        alert("Error al recuperar los datos.");
    }
}

function deleteProducto(idProducto){
    let request = sendRequest('producto/'+idProducto, 'DELETE', '')
    request.onload = function(){
        loadData()
    }
}

function saveProducto(){
    let name = document.getElementById('product-name').value
    let sale = document.getElementById('product-sale-value').value
    let purchase = document.getElementById('product-purchase-value').value
    let quantity = document.getElementById('product-quantity').value
    let id = document.getElementById('product-id').value
    let data = {'idProducto': id,'nombreProducto':name,'valorVenta': sale, 'valorCompra': purchase, 'cantidad':quantity }
    let request = sendRequest('producto/', id ? 'PUT' : 'POST', data)
    request.onload = function(){
        window.location = 'productos.html';
    }
    request.onerror = function(){
        alert('Error al guardar los cambios.')
    }
}