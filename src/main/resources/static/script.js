// Wait for the DOM to fully load before attaching the event listener
document.addEventListener("DOMContentLoaded", function () {

    // Select the form element with id="jsonForm"
    const form = document.getElementById("jsonForm");

    // Handle the submission of the JSON-based form
    form.addEventListener("submit", async function (event) {
        // Prevent the default behavior (which would reload the page)
        event.preventDefault();

        // Get the value entered into the input field with ID "nameJson"
        const name = document.getElementById("nameJson").value;

        // Send a POST request to the backend at the /greet-json endpoint
        const response = await fetch("/greet-json", {
            method: "POST", // Use HTTP POST method to send data
            headers: {
                "Content-Type": "application/json" // Tell the server we're sending JSON data
            },
            body: JSON.stringify({ name: name }) // Convert the JS object to JSON format
        });

        // Wait for the server's JSON response and parse it into a JavaScript object
        const data = await response.json();

        // Update the content of the HTML element with ID "jsonResponse"
        // with the 'message' field returned from the server
        document.getElementById("jsonResponse").textContent = data.message;
    });

});
