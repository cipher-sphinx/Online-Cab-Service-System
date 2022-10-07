/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


const url = "http://localhost:8080/OnlineCabService-Service/driver";

function getDriver() {
    let id = document.getElementById("txtID").value;
    const options = {
        method : "GET"
    };
    
    fetch(url + id, options)
        .then(res => res.json())
        .then(data => {
            if (data !== null) {
                document.getElementById("").value = data.driverNIC;
                document.getElementById("").value = data.driverUsername; 
                document.getElementById("").value = data.driverPassword;
                document.getElementById("").value = data.driverFirstName;
                document.getElementById("").value = data.driverLastName;
                document.getElementById("").value = data.driverEmail;
                document.getElementById("").value = data.driverPhoneNumber;
                document.getElementById("").value = data.driverrLoginStatus;
                document.getElementById("").value = data.driverStatus;
                document.getElementById("").value = data.city.cityID;
                document.getElementById("").value = data.city.cityName;
                document.getElementById("").value = data.city.cityEmail;
                document.getElementById("").value = data.city.cityPhoneNumber;
            } else {
                alert("Not found");
            }

        });
}

function getAllDrivers() {
    
}

function addDriver() {
    const driver = {
        "driverID" : document.getElementById("").value,
        "driverNIC" : document.getElementById("").value,
        "driverUsername" :  document.getElementById("").value,
        "driverPassword" : document.getElementById("").value,
        "driverFirstName" : document.getElementById("").value,
        "driverLastName" : document.getElementById("").value,
        "driverEmail" : document.getElementById("").value,
        "driverPhoneNumber" : document.getElementById("").value,
        "driverLoginStatus" : document.getElementById("").value,
        "driverLicenceID" : document.getElementById("").value,
        "driverStatus" : document.getElementById("").value,
        "cityID" : document.getElementById("").value
    };
                
    const options = {
        method : "POST", 
        headers : {
            "content-type" : "application/json"
        },
        body : JSON.stringify(driver)
    };
                
    fetch(url, options);
}

function updateDriver() {
    const driver = {
        "driverID" : document.getElementById("").value,
        "driverNIC" : document.getElementById("").value,
        "driverUsername" :  document.getElementById("").value,
        "driverPassword" : document.getElementById("").value,
        "driverFirstName" : document.getElementById("").value,
        "driverLastName" : document.getElementById("").value,
        "driverEmail" : document.getElementById("").value,
        "driverPhoneNumber" : document.getElementById("").value,
        "driverLoginStatus" : document.getElementById("").value,
        "driverLicenceID" : document.getElementById("").value,
        "driverStatus" : document.getElementById("").value,
        "cityID" : document.getElementById("").value
    };
                
    const options = {
        method : "PUT", 
        headers : {
            "content-type" : "application/json"
        },
        body : JSON.stringify(driver)
    };
                
    fetch(url, options);
}

function deleteDriver() {
    let id = document.getElementById("txtID").value;
    const options = {
        method : "DELETE"
    };
                
    fetch(url + id, options);
}

function clearDriver() {
    document.getElementById("").value = "";
    document.getElementById("").value = "";
    document.getElementById("").value = "";
    document.getElementById("").value = "";
    document.getElementById("").value = "";
    document.getElementById("").value = "";
    document.getElementById("").value = "";
    document.getElementById("").value = "";
    document.getElementById("").value = "";
    document.getElementById("").value = "";
    document.getElementById("").value = "";
    document.getElementById("").value = "";
}