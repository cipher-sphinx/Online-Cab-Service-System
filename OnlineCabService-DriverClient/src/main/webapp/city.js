/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


/* global fetch */

const url = "http://localhost:8080/OnlineCabService-Service/city";

function getCity() {
    let id = document.getElementById("cityID").value;
    const options = {
        method : "GET"
    };
    
    fetch(url + "/" + id, options)
        .then(response => response.json())
        .then(data => {
            if (data !== null) {                   //this data. values are from postman
                document.getElementById("cityID").value = data.cityID;
                document.getElementById("cityName").value = data.cityName;
                document.getElementById("cityEmail").value = data.cityEmail; 
                document.getElementById("cityPhoneNumber").value = data.cityPhoneNumber;
            } else {
                alert("Not found");
            }
        })
        .catch((error) => {
            console.log(error);
        });
}

function getAllCities() {
    fetch(url)
        .then((response) => response.json())
        .then((data) => {
            console.log(data);
        })
        .catch((error) => {
            console.log(error);
        });
}

function addCity() {
    const city = {
        //"cityID" : document.getElementById("").value,
        "cityName" : document.getElementById("").value,
        "cityEmail" :  document.getElementById("").value,
        "cityPhoneNumber" :  document.getElementById("").value
    };
                
    const options = {
        method : "POST", 
        headers : {
            "content-type" : "application/json"
        },
        body : JSON.stringify(city)
    };
                
    fetch(url, options);
}

function updateCity() {
    const city = {
        "cityID" : document.getElementById("cityID").value,
        "cityName" : document.getElementById("cityName").value,
        "cityEmail" :  document.getElementById("cityEmail").value,
        "cityPhoneNumber" :  document.getElementById("cityPhoneNumber").value
    };
                
    const options = {
        method : "PUT", 
        headers : {
            "content-type" : "application/json"
        },
        body : JSON.stringify(city)
    };
                
    fetch(url, options);
}

function deleteCity() {
    let id = document.getElementById("txtID").value;
    const options = {
        method : "DELETE"
    };
                
    fetch(url + id, options);
}

function clearCity() {
    document.getElementById("").value = "";
    document.getElementById("").value = "";
    document.getElementById("").value = "";
    document.getElementById("").value = "";
}