// Base API URL for local backend
const API_URL = "http://localhost:8080/api/users";

async function register() {
  const username = document.getElementById("registerUsername").value;
  const phoneNumber = document.getElementById("registerPhoneNumber").value;
  const registerMessage = document.getElementById("registerMessage");

  try {
    const response = await fetch(`${API_URL}/register`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        username: username,
        phone: phoneNumber
      }),
    });

    if (response.ok) {
      registerMessage.innerText = "Registration successful";
    } else {
      registerMessage.innerText = "Registration failed";
    }
  } catch (error) {
    console.error("Error:", error);
    registerMessage.innerText = "Error occurred while registering";
  }
}

async function login() {
  const phoneNumber = document.getElementById("loginPhoneNumber").value;
  const loginMessage = document.getElementById("loginMessage");

  // Basic phone number validation
  if (!phoneNumber) {
    loginMessage.textContent = "Please enter a phone number";
    loginMessage.style.color = "red";
    return;
  }

  try {
    const response = await fetch(`${API_URL}/login`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        phone: phoneNumber,
      }),
    });

    if (response.ok) {
      const message = await response.text();
      loginMessage.textContent = message;
      loginMessage.style.color = "green";

      // Optional: Redirect after successful login
      window.location.href = 'index.html';
    } else {
      const errorMessage = await response.text();
      loginMessage.textContent = errorMessage;
      loginMessage.style.color = "red";
    }
  } catch (error) {
    loginMessage.textContent = "Network error. Please try again.";
    loginMessage.style.color = "red";
    console.error("Login error:", error);
  }
}

