/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


const url = "http://localhost:8080/OnlineCabService-Service/street";

function getStreet() {
    let id = document.getElementById("txtID").value;
    const options = {
        method : "GET"
    };
    
    fetch(url + id, options)
        .then(res => res.json())
        .then(data => {
            if (data !== null) {
                document.getElementById("").value = data.streetName;
                document.getElementById("").value = data.city.cityID; 
                document.getElementById("").value = data.city.CityName; 
                document.getElementById("").value = data.city.CityEmail; 
                document.getElementById("").value = data.city.CityPhoneNumber; 
            } else {
                alert("Not found");
            }

        });
}

function getAllStreets() {
    
}

function addStreet() {
    const street = {
        "streetID" : document.getElementById("").value,
        "streetName" : document.getElementById("").value,
        "cityID" :  document.getElementById("").value
    };
                
    const options = {
        method : "POST", 
        headers : {
            "content-type" : "application/json"
        },
        body : JSON.stringify(street)
    };
                
    fetch(url, options);
}

function updateStreet() {
    const street = {
        "streetID" : document.getElementById("").value,
        "streetName" : document.getElementById("").value,
        "cityID" :  document.getElementById("").value
    };
                
    const options = {
        method : "PUT", 
        headers : {
            "content-type" : "application/json"
        },
        body : JSON.stringify(street)
    };
                
    fetch(url, options);
}

function deleteStreet() {
    let id = document.getElementById("").value;
    const options = {
        method : "DELETE"
    };
                
    fetch(url + id, options);
}

function clearCity() {
    document.getElementById("").value = "";
    document.getElementById("").value = "";
    document.getElementById("").value = "";
}