async function getData1() {
  try {
    const response = await fetch("http://localhost:8080/api/threads/sync");
    if (response.ok) {
      const data = await response.json();
      document.getElementById("dataTextBox1").value = data.join(", "); // Display data in the text box
    } else {
      console.error(
        "Error fetching data:",
        response.status,
        response.statusText
      );
    }
  } catch (error) {
    console.error("An error occurred:", error);
  }
}

async function getData2() {
  try {
    const response = await fetch("http://localhost:8080/api/threads/sync");
    if (response.ok) {
      const data = await response.json();
      document.getElementById("dataTextBox2").value = data.join(", "); // Display data in the text box
    } else {
      console.error(
        "Error fetching data:",
        response.status,
        response.statusText
      );
    }
  } catch (error) {
    console.error("An error occurred:", error);
  }
}

async function getData3() {
  try {
    const response = await fetch("http://localhost:8080/api/threads/sync");
    if (response.ok) {
      const data = await response.json();
      document.getElementById("dataTextBox3").value = data.join(", "); // Display data in the text box
    } else {
      console.error(
        "Error fetching data:",
        response.status,
        response.statusText
      );
    }
  } catch (error) {
    console.error("An error occurred:", error);
  }
}

async function getData4() {
  try {
    const response = await fetch("http://localhost:8080/api/threads/sync");
    if (response.ok) {
      const data = await response.json();
      document.getElementById("dataTextBox4").value = data.join(", "); // Display data in the text box
    } else {
      console.error(
        "Error fetching data:",
        response.status,
        response.statusText
      );
    }
  } catch (error) {
    console.error("An error occurred:", error);
  }
}
