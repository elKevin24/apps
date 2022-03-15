/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

async function ultimo_estado(duca) {
    console.log(duca);

    var settings = {
		"url": "https://srvnjs.santotomasport.com.gt:3000/web/declaracion/ultimoEstado/noDeclaraciones/"+duca+"",
		"method": "GET",
		"timeout": 0,
};

//GTSTCST-21-079927-0001-6

$.ajax(settings).done(function (response) {
		console.log(response);
                if(response == "1"){
                    document.getElementById("btn1").className = "btn btn-success";
                }else{
                    document.getElementById("btn1").className = "btn btn-danger";
                }
});   
   
}


