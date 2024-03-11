function downloadCsv1() {
  const endpoint = "http://localhost:8080/api/threads/csv/download"; // Replace with your endpoint URL
  const filename = "data.csv"; // Replace with your desired filename

  const xhr = new XMLHttpRequest();
  xhr.open("GET", endpoint, true);
  xhr.responseType = "blob";

  xhr.onprogress = (event) => {
    if (event.lengthComputable) {
      const percent = (event.loaded / event.total) * 100;
      document.getElementById("progress1").value = percent;
    }
  };

  xhr.onload = () => {
    if (xhr.status === 200) {
      const blob = xhr.response;
      const link = document.createElement("a");
      link.href = window.URL.createObjectURL(blob);
      link.download = filename;
      link.click();
    }
  };

  xhr.send();
}

function downloadCsv2() {
  const endpoint = "http://localhost:8080/api/threads/csv/download"; // Replace with your endpoint URL
  const filename = "data.csv"; // Replace with your desired filename

  const xhr = new XMLHttpRequest();
  xhr.open("GET", endpoint, true);
  xhr.responseType = "blob";

  xhr.onprogress = (event) => {
    if (event.lengthComputable) {
      const percent = (event.loaded / event.total) * 100;
      document.getElementById("progress2").value = percent;
    }
  };

  xhr.onload = () => {
    if (xhr.status === 200) {
      const blob = xhr.response;
      const link = document.createElement("a");
      link.href = window.URL.createObjectURL(blob);
      link.download = filename;
      link.click();
    }
  };

  xhr.send();
}

function downloadCsv3() {
  const endpoint = "http://localhost:8080/api/threads/csv/download"; // Replace with your endpoint URL
  const filename = "data.csv"; // Replace with your desired filename

  const xhr = new XMLHttpRequest();
  xhr.open("GET", endpoint, true);
  xhr.responseType = "blob";

  xhr.onprogress = (event) => {
    if (event.lengthComputable) {
      const percent = (event.loaded / event.total) * 100;
      document.getElementById("progress3").value = percent;
    }
  };

  xhr.onload = () => {
    if (xhr.status === 200) {
      const blob = xhr.response;
      const link = document.createElement("a");
      link.href = window.URL.createObjectURL(blob);
      link.download = filename;
      link.click();
    }
  };

  xhr.send();
}

function downloadCsv4() {
  const endpoint = "http://localhost:8080/api/threads/csv/download"; // Replace with your endpoint URL
  const filename = "data.csv"; // Replace with your desired filename

  const xhr = new XMLHttpRequest();
  xhr.open("GET", endpoint, true);
  xhr.responseType = "blob";

  xhr.onprogress = (event) => {
    if (event.lengthComputable) {
      const percent = (event.loaded / event.total) * 100;
      document.getElementById("progress4").value = percent;
    }
  };

  xhr.onload = () => {
    if (xhr.status === 200) {
      const blob = xhr.response;
      const link = document.createElement("a");
      link.href = window.URL.createObjectURL(blob);
      link.download = filename;
      link.click();
    }
  };

  xhr.send();
}
