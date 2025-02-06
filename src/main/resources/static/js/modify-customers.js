async function loadCustomer(){
    if(isNew){
        return;
    }
    let id = getCustomerId();
    let customer = await getCustomerById(id);

    document.getElementById('txtFirstname').value = customer.name;
    document.getElementById('txtLastname').value = customer.lastName;
    document.getElementById('txtEmail').value = customer.email;
    document.getElementById('txtAddress').value = customer.address;
}

function getCustomerId(){
    let auxSplit = location.href.split('id=');
    let id = auxSplit[1];
    return id;
}

function isNew() {
    let hasIdInUrl = window.location.href.includes('id=');
    return !hasIdInUrl;
}

async function getCustomerById(id) {
    let url = URL_SERVER + 'customer/'+id;
    let response = await fetch(url);
    let json = await response.json();
    return json;
}

function clickCreate(){

    let name = document.getElementById('txtFirstname').value;
    let lastName = document.getElementById('txtLastname').value;
    let email = document.getElementById('txtEmail').value;
    let address = document.getElementById('txtAddress').value;

    let customer = {
        "name": name,
        "lastName": lastName,
        "email": email,
        "address": address    
    };
    save(customer);
}

async function save(customer){        
    let url = URL_SERVER + 'customer';
    let methodType = isNew()? 'POST': 'PUT';

    if(!isNew()){
        url += '/' + getCustomerId();
    }

    let config = {
        "method": methodType,
        "body": JSON.stringify(customer),
        "headers": {    
            'Content-Type': 'application/json'
        }
    };    
    await fetch(url, config);
    alert('El cliente se guardó correctamente')
    window.location.href = 'customers.html';
}

loadCustomer();