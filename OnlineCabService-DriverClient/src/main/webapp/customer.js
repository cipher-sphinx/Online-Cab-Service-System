/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


const url = "http://localhost:8080/OnlineCabService-Service/customer";

function getCustomer() {
    let id = document.getElementById("").value;
    const options = {
        method : "GET"
    };
    
    fetch(url + id, options)
        .then(res => res.json())
        .then(data => {
            if (data !== null) {
                document.getElementById("").value = data.customerNIC;
                document.getElementById("").value = data.customerUsername; 
                document.getElementById("").value = data.customerPassword;
                document.getElementById("").value = data.customerFirstName;
                document.getElementById("").value = data.customerLastName;
                document.getElementById("").value = data.customerEmail;
                document.getElementById("").value = data.customerPhoneNumber;
                document.getElementById("").value = data.customerLoginStatus;
                document.getElementById("").value = data.customerStatus;
            } else {
                alert("Not found");
            }

        });
}

function getAllCustomers() {
    
}

function addCustomer() {
    const customer = {
        "customerID" : document.getElementById("").value,
        "customerNIC" : document.getElementById("").value,
        "customerUsername" :  document.getElementById("").value,
        "customerPassword" : document.getElementById("").value,
        "customerFirstName" : document.getElementById("").value,
        "customerLastName" : document.getElementById("").value,
        "customerEmail" : document.getElementById("").value,
        "customerPhoneNumber" : document.getElementById("").value,
        "customerLoginStatus" : document.getElementById("").value,
        "customerStatus" : document.getElementById("").value
    };
                
    const options = {
        method : "POST", 
        headers : {
            "content-type" : "application/json"
        },
        body : JSON.stringify(customer)
    };
                
    fetch(url, options);
}

function updateCustomer() {
    const customer = {
        "customerID" : document.getElementById("").value,
        "customerNIC" : document.getElementById("").value,
        "customerUsername" :  document.getElementById("").value,
        "customerPassword" : document.getElementById("").value,
        "customerFirstName" : document.getElementById("").value,
        "customerLastName" : document.getElementById("").value,
        "customerEmail" : document.getElementById("").value,
        "customerPhoneNumber" : document.getElementById("").value,
        "customerLoginStatus" : document.getElementById("").value,
        "customerStatus" : document.getElementById("").value
    };
                
    const options = {
        method : "PUT", 
        headers : {
            "content-type" : "application/json"
        },
        body : JSON.stringify(customer)
    };
                
    fetch(url, options);
}

function deleteCustomer() {
    let id = document.getElementById("").value;
    const options = {
        method : "DELETE"
    };
                
    fetch(url + id, options);
}

function clearCustomer() {
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