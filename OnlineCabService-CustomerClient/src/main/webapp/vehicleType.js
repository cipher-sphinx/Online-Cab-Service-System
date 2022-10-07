/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */




const url = "http://localhost:8080/OnlineCabService-Service/vehicletype";

function getVehicleType() {
    let id = document.getElementById("txtID").value;
    const options = {
        method : "GET"
    };
    
    fetch(url + id, options)
        .then(res => res.json())
        .then(data => {
            if (data !== null) {
               document.getElementById("").value = data.typeName;
               document.getElementById("").value = data.vehicleCapacity;
               document.getElementById("").value = data.PricePerKmInLKR;
            } else {
                alert("Not found");
            }

        });
}

function getAllVehicleTypes() {
    
}

function addVehicleType() {
    const vehicletype = {
        "typeID" : document.getElementById("").value,
        "typeName" : document.getElementById("").value,
        "vehicleCapacity" :  document.getElementById("").value,
        "pricePerKmInLKR" : document.getElementById("").value
    };
                
    const options = {
        method : "POST", 
        headers : {
            "content-type" : "application/json"
        },
        body : JSON.stringify(vehicletype)
    };
                
    fetch(url, options);
}

function updateVehicleType() {
    const vehicletype = {
        "typeID" : document.getElementById("").value,
        "typeName" : document.getElementById("").value,
        "vehicleCapacity" :  document.getElementById("").value,
        "pricePerKmInLKR" : document.getElementById("").value
    };
                
    const options = {
        method : "PUT", 
        headers : {
            "content-type" : "application/json"
        },
        body : JSON.stringify(vehicletype)
    };
                
    fetch(url, options);
}

function deleteVehicleType() {
    let id = document.getElementById("txtID").value;
    const options = {
        method : "DELETE"
    };
                
    fetch(url + id, options);
}

function clearVehicleType() {
    document.getElementById("").value = "";
    document.getElementById("").value = "";
    document.getElementById("").value = "";
    document.getElementById("").value = "";
    document.getElementById("").value = "";
}