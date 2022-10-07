/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

/* global fetch */

const url = "http://localhost:8080/OnlineCabService-Service/booking";

function getBooking() {
    let id = document.getElementById("txtID").value;
    const options = {
        method : "GET"
    };
    
    fetch(url + id, options)
        .then(res => res.json())
        .then(data => {
            if (data !== null) {
               document.getElementById("").value = data.name;
               document.getElementById("").value = data.dob; 
            } else {
                alert("Not found");
            }

        });
}

function getAllBookings() {
    
}

function addBooking() {
    const person = {
        "id" : document.getElementById("txtID").value,
        "name" : document.getElementById("txtName").value,
        "dob" :  document.getElementById("txtDOB").value
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

function updateBooking() {
    const person = {
        "id" : document.getElementById("txtID").value,
        "name" : document.getElementById("txtName").value,
        "dob" :  document.getElementById("txtDOB").value
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

function deleteBooking() {
    let id = document.getElementById("txtID").value;
    const options = {
        method : "DELETE"
    };
                
    fetch(url + id, options);
}

function clearCity() {
    document.getElementById("txtID").value = "";
    document.getElementById("txtName").value = "";
    document.getElementById("txtDOB").value = "";
}
