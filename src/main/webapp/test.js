'use strict';
let completePage = (data)=>{
    let select=document.querySelector('select');
    console.log(data);
    for (let i = 0; i < data.pizzaTypes.length; i++){
        let option = document.createElement("option");
        option.innerText = data.pizzaTypes[i];
        select.appendChild(option);
    }
}
fetch('/order', {
    method: 'GET',
    headers: {
        'Content-Type': 'application/json;charset:=utf-8'
    }})
    .then(response => response.json())
    .then((data) => completePage(data));