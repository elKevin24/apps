/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var listaconte = new Array();
async function retencionode(cont) {

    var settings = {
        "url": "https://srvnjs.santotomasport.com.gt:3000/retencion/" + cont + "",
        "method": "GET",
        "timeout": 0,
    };

    $.ajax(settings).done(function (response) {
       

        if (response == 'R') {
            //console.log(response);
//            listaconte.push(cont);
             document.getElementById(cont).innerHTML = '<label style="display: none;">2</label><img src="img/bullet-red.png" data-bs-toggle="tooltip" data-bs-placement="top" title="Retenido">';
          
            //console.log(cont);
            //console.log(listaconte);                    
        }
    });
    
    return listaconte;
}




//function array() {
//
//  console.log(listaconte);
//  for (var i = 0; i < listaconte.length; i++) {
//
//        try {
//            // console.log(listaconte[i]);
//            document.getElementById(listaconte[i]).innerHTML = '<label style="display: none;">2</label><img src="img/bullet-red.png" data-bs-toggle="tooltip" data-bs-placement="top" title="Retenido">';
//            // declaraciones para try
//
//        } catch (e) {
//            // pasar el objeto exception al controlador de errores (es decir, su propia función)
//        }
//    }
//}
