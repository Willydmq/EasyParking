async function saveUser() {
  try {
    let username = document.getElementById("username").value;
    let password = document.getElementById("password").value;

    await sendRequest("user/signup", "POST", {
      username,
      password,
    });
    window.location = "login.html?message=User created";
  } catch (error) {
    console.error(error.toString());
  }
}
