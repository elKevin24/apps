/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var listaconte1 = new Array();
async function atc(cont) {

    var settings = {
        "url": "http://172.20.10.107:8082/atc1/" + cont + "",
        "method": "GET",
        "timeout": 0,
    };

    $.ajax(settings).done(function (response) {
                  
       // listaconte1.push(cont);       
       
            
            // console.log(response);
            listaconte1.push([cont, response]);
            
        
       
    });
    
    return listaconte1;
}

function array_atc() {
console.log(listaconte1);
  
  for (var i = 0; i < listaconte1.length; i++) {

if(listaconte1[i][1] == 'R'){
    //console.log(listaconte1[i][0]);
     try {
            // console.log(listaconte[i]);
            document.getElementById(listaconte1[i][0]+"atc").innerHTML = '<img src="img/bullet-green.png" data-bs-toggle="tooltip" data-bs-placement="top" title="Registrado">';
            // declaraciones para try

        } catch (e) {
            // pasar el objeto exception al controlador de errores (es decir, su propia función)
        }
    
}


if(listaconte1[i][1] == 'sin respuesta de sat'){
    
     try {
            // console.log(listaconte[i]);
            document.getElementById(listaconte1[i][0]+"atc").innerHTML = '<img src="img/Bullet-grey.png" data-bs-toggle="tooltip" data-bs-placement="top" title="sin respuesta de sat">';
            // declaraciones para try

        } catch (e) {
            // pasar el objeto exception al controlador de errores (es decir, su propia función)
        }
    
}


       
    }
}
