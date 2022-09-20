async function getUser() {
  const basicAuthorization = await localStorage.getItem("user");
  return basicAuthorization; // return base 64 string with user data
}

function setUser(username, password) {
  const encodeCredentials = btoa(`${username}:${password}`, "base64");
  return localStorage.setItem("user", `Basic ${encodeCredentials}`);
}

getUser().then(function (user) {
  if (
    !user &&
    !location.pathname.includes("login.html") &&
    !location.pathname.includes("signup.html")
  ) {
    window.location = "login.html";
  }
  if (user && location.pathname.includes("login.html")) {
    window.location = "parqueadero.html";
  }
});

async function logout() {
  let response = await sendRequest("logout", "POST");
  if (response.status == 0) {
    localStorage.removeItem("user");
    window.location = "login.html?message=Successful Closing Session";
  }
  return false;
}

async function login() {
  try {
    let username = document.getElementById("username").value;
    let password = document.getElementById("password").value;

    await sendRequest("user/login", "POST", {
      username,
      password,
    });
    await setUser(username, password);
    window.location = "parqueadero.html";
  } catch (error) {
    console.error(error.toString());
    window.location = "login.html?error=Invalid username and password.";
  }

  return false;
}
