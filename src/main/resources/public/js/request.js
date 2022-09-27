const url = "http://localhost:8080/";

/*async function sendRequest(endPoint, method, data) {
  return new Promise(async (resolve, reject) => {
    let request = new XMLHttpRequest();
    request.open(method, url + endPoint);
    request.responseType = "json";
    request.setRequestHeader("Content-Type", "application/json");

    // Adjuntan su autenticacion
    if (!endPoint.includes("/user/login")) {
      const credentials = await getUser();
      request.setRequestHeader("Authorization", credentials);
      // o pueden agregar una query param asi -> endPoint+=`?=${credentials}`
    }

    request.send(data ? JSON.stringify(data) : data);

    // falla la peticion
    request.onerror = function (err) {
      reject(err.toString());
      alert("Request error: " + err.toString());
    };

    // peticiin exitosa
    request.onload = function () {
      console.log("response", request.response);
      resolve(request.response.data);
    };
  });
}*/
/*
async function sendRequest(endPoint, method, data) {
  const myHeaders = new Headers();
  myHeaders.set("Content-Type", "application/json");
  myHeaders.set("Accept", "application/json");

  if (!endPoint.includes("/user/login")) {
    const credentials = await getUser();
    myHeaders.set("Authorization", credentials);
  }

  const config = {
    method,
    mode: endPoint == "logout" ? "no-cors" : "cors",
    headers: myHeaders,
    body: data ? JSON.stringify(data) : data,
  };
  if (method.toUpperCase() === "GET" || method.toUpperCase() === "DELETE") {
    delete config["body"];
  }
  const myRequest = new Request(url + endPoint, config);

  const response = await fetch(myRequest).catch(function (error) {
    alert(`Error: ${error.message}`);
  });

  if (
    !response.ok &&
    !endPoint.includes("user/login") &&
    response.status != 0 // when is 0 is OK because is no-cors
  ) {
    alert("Request error");
  }

  if (endPoint == "logout") {
    return response;
  } else {
    const responseData = await response?.json();
    return responseData.data;
  }
}*/
async function sendRequest(endPoint, method, data) {
  const myHeaders = new Headers();
  myHeaders.set("Content-Type", "application/json");
  myHeaders.set("Accept", "application/json");

  if (!endPoint.includes("/user/login")) {
    const credentials = await getUser();
    myHeaders.set("Authorization", credentials);
  }

  const config = {
    method,
    mode: endPoint == "logout" ? "no-cors" : "cors",
    headers: myHeaders,
    body: data ? JSON.stringify(data) : data,
  };
  if (method.toUpperCase() === "GET" || method.toUpperCase() === "DELETE") {
    delete config["body"];
  }
  const myRequest = new Request(url + endPoint, config);

  const response = await fetch(myRequest).catch(function (error) {
    alert(`Error: ${error.message}`);
  });

  if (
    !response.ok &&
    !endPoint.includes("user/login") &&
    response.status != 0 // when is 0 is OK because is no-cors
  ) {
    alert("Request error");
  }

  if (endPoint == "logout") {
    return response;
  } else {
    const responseData = await response?.json();
    return responseData.data;
  }
  // let request = new XMLHttpRequest();
  // request.open(method, url + endPoint);
  // request.responseType = "json";
  // request.setRequestHeader("Content-Type", "application/json");
  // request.send(data ? JSON.stringify(data) : data);
  // return request;
}
