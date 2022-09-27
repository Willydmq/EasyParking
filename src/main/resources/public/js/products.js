async function loadData() {
  let response = await sendRequest("product/all", "GET", "");
  let table = document.getElementById("products-table");
  table.innerHTML = "";
  let data = await response;
  console.log(data);
  data.forEach((element) => {
    table.innerHTML += `
                <tr>
                    <th>${element.id}</th>
                    <td>${element.name}</td>
                    <td>${element.razonsocial}</td>
                    <td>${element.email}</td>
                    <td>${element.plazacarro}</td>
                    <td>${element.plazamoto}</td>
                    <td>
                        <button type="button" class="btn btn-primary" onclick='window.location = "form_products.html?id=${element.id}"'>Editar</button>
                        <button type="button" class="btn btn-danger" onclick='deleteProducto(${element.id})'>Eliminar</button>
                    </td>
                </tr>

                `;
  });
}

async function loadProducto(idProducto) {
  let response = await sendRequest("product/" + idProducto, "GET", "");
  let name = document.getElementById("product-name");
  let razonsocial = document.getElementById("product-razonsocial");
  let email = document.getElementById("product-email");
  let plazacarro = document.getElementById("product-plazacarro");
  let plazamoto = document.getElementById("product-plazamoto");
  let id = document.getElementById("product-id");

  let data = await response;
  let product = data;
  id.value = product.id;
  name.value = product.name;
  razonsocial.value = product.razonsocial;
  email.value = product.email;
  plazacarro.value = product.plazacarro;
  plazamoto.value = product.plazamoto;
}

async function deleteProducto(idProducto) {
  try {
    await sendRequest("product/" + idProducto + "/remove", "DELETE", "");
    loadData();
  } catch (error) {
    console.error(error.toString());
  }
}

async function saveProducto() {
  try {
    let name = document.getElementById("product-name").value;
    let razonsocial = document.getElementById("product-razonsocial").value;
    let email = document.getElementById("product-email").value;
    let plazacarro = document.getElementById("product-plazacarro").value;
    let plazamoto = document.getElementById("product-plazamoto").value;
    let id = document.getElementById("product-id").value;
    let data = {
      id: id,
      name: name,
      razonsocial: razonsocial,
      email: email,
      plazacarro: plazacarro,
      plazamoto: plazamoto,
    };
    let response = id
      ? await sendRequest("product/" + id, "PUT", data)
      : await sendRequest("product", "POST", data);
    window.location = "products.html";
    console.log(response);
  } catch (error) {
    console.error(error.toString());
  }
}
