/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


const url = "http://localhost:8080/OnlineCabService-Service/admin";

function getAdmin() {
    let id = document.getElementById("txtID").value;
    const options = {
        method : "GET"
    };
    
    fetch(url + id, options)
        .then(res => res.json())
        .then(data => {
            if (data !== null) {
                document.getElementById("").value = data.adminNIC;
                document.getElementById("").value = data.adminUsername; 
                document.getElementById("").value = data.adminPassword;
                document.getElementById("").value = data.adminFirstName;
                document.getElementById("").value = data.adminLastName;
                document.getElementById("").value = data.adminEmail;
                document.getElementById("").value = data.adminPhoneNumber;
                document.getElementById("").value = data.adminLoginStatus;
            } else {
                alert("Not found");
            }

        });
}

function getAllAdmins() {
    
}

function addAdmin() {
    const person = {
        "adminID" : document.getElementById("").value,
        "adminNIC" : document.getElementById("").value,
        "adminUsername" :  document.getElementById("").value,
        "adminPassword" : document.getElementById("").value,
        "adminFirstName" : document.getElementById("").value,
        "adminLastName" : document.getElementById("").value,
        "adminEmail" : document.getElementById("").value,
        "adminPhoneNumber" : document.getElementById("").value,
        "adminLoginStatus" : document.getElementById("").value
    };
                
    const options = {
        method : "POST", 
        headers : {
            "content-type" : "application/json"
        },
        body : JSON.stringify(person)
    };
                
    fetch(url, options);
}

function updateAdmin() {
    const person = {
        "adminID" : document.getElementById("").value,
        "adminNIC" : document.getElementById("").value,
        "adminUsername" :  document.getElementById("").value,
        "adminPassword" : document.getElementById("").value,
        "adminFirstName" : document.getElementById("").value,
        "adminLastName" : document.getElementById("").value,
        "adminEmail" : document.getElementById("").value,
        "adminPhoneNumber" : document.getElementById("").value,
        "adminLoginStatus" : document.getElementById("").value
    };
                
    const options = {
        method : "PUT", 
        headers : {
            "content-type" : "application/json"
        },
        body : JSON.stringify(person)
    };
                
    fetch(url, options);
}

function deleteAdmin() {
    let id = document.getElementById("txtID").value;
    const options = {
        method : "DELETE"
    };
                
    fetch(url + id, options);
}

function clearAdmin() {
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