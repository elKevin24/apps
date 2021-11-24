/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author kcordon
 */
import com.mashape.unirest.http.*;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class servicios_web {

    public static boolean ConsultarRetencion(String contenedor) {

        JSONObject jsonobj = null;
        Integer codigo;
        boolean mensaje = false;
        JSONArray retencion = null;

        long fecha = new Date().getTime();
        Date currentDate = new Date(fecha);
        DateFormat df = new SimpleDateFormat("dd:MM:yy:HH:mm:ss");

        try {
            Unirest.setTimeouts(10, 10);
            Unirest.setHttpClient(org.apache.http.impl.client.HttpClients.custom()
                    .disableRedirectHandling()
                    .build());
            HttpResponse<String> response = Unirest.post("https://farm3.sat.gob.gt/retencion-liberacion-ws/rest/privado/retencionLiberacion/consultar")
                    .header("Authorization", "Basic MzEzMzIyMjpFbXBvcm5hYzIwMTUr")
                    .header("Content-Type", "application/json")
                    .header("Accept", "application/json;charset=utf-8")
                    .header("Cookie", "visid_incap_2112329=0xk+tVssSjegRxb6moVvoquKumAAAAAAQUIPAAAAAABebEr5ELkke+K1Kp+CTHG/")
                    .body("{\r\n    \"noContenedor\": \"" + contenedor + "\"\r\n}")
                    .asString();

            if (response.getStatus() == 200) {

                long fecha2 = new Date().getTime();
                Date currentDate2 = new Date(fecha2);

                System.out.println("entrada: " + df.format(currentDate) + "  salida: " + df.format(currentDate2));

                //System.err.println("entro 200");
                jsonobj = new JSONObject(response.getBody());
                codigo = (Integer) jsonobj.get("codigo");
                //System.err.println("codigo" + codigo);
                if (codigo == 0) {

                    retencion = jsonobj.getJSONArray("retencionLiberacion");
                    for (int i = 0; i < retencion.length(); i++) {
                        try {
                            JSONObject jsonObject = retencion.getJSONObject(i);
                            //System.err.println("Lista"+jsonObject);
                            if (jsonObject.has("entidadRetiene") && jsonObject.has("estado")) {

                                String estado = jsonObject.getString("estado");

                                if ("R".equals(estado)) {
                                    //entidad = jsonObject.getString("entidadRetiene");
                                    //System.err.println("Estado: " + estado + " Contenedor: " + contenedor + " Entidad: " + entidad);
                                    mensaje = true;
                                }

                            }
                        } catch (JSONException e) {
                            System.err.println("" + e);
                        }

                    }
                }
                //System.out.println(jsonobj);

            }

        } catch (UnirestException | JSONException ex) {
            Logger.getLogger(servicios_web.class.getName()).log(Level.SEVERE, null, ex);
        }

        return mensaje;

    }

    public static String ConsultarATCLista(String contenedor) {

        JSONObject jsonobj = null;
        Integer codigo;
        String mensaje = null;
        JSONObject operacion;
        JSONArray atc = null;

        try {

            Unirest.setTimeouts(10, 10);
            Unirest.setHttpClient(org.apache.http.impl.client.HttpClients.custom()
                    .disableRedirectHandling()
                    .build());
            HttpResponse<String> response = Unirest.post("https://farm3.sat.gob.gt/atc-ws/rest/privado/atc/consultarAtcPorContenedor")
                    .header("Authorization", "Basic MzEzMzIyMjpFbXBvcm5hYzIwMTUr")
                    .header("Content-Type", "application/json")
                    .header("Accept", "application/json;charset=utf-8")
                    .header("Cookie", "incap_ses_995_2112329=A4dpaap81Ruukbs/lfPODROM22AAAAAA9sZ3MA0ZETu2fi9vWHvdVQ==; nlbi_2112329=RESzEzDfTXx9rpGw8GHfvAAAAADvlJIOGzPqPWYHNzQRpS0M; visid_incap_2112329=0xk+tVssSjegRxb6moVvoquKumAAAAAAQUIPAAAAAABebEr5ELkke+K1Kp+CTHG/")
                    .body("{\r\n\"noContenedor\": \"" + contenedor + "\"\r\n\r\n}")
                    .asString();

            if (response.getStatus() == 200) {
                //System.err.println("entro 200");
                jsonobj = new JSONObject(response.getBody());
                codigo = (Integer) jsonobj.get("codigo");
                //System.err.println("codigo" + codigo);
                if (codigo == 1) {

                    operacion = (JSONObject) jsonobj.get("operacion");
                    atc = operacion.getJSONArray("atc");
                    JSONObject jsonObject = atc.getJSONObject(0);

                    if (jsonObject.has("estado")) {
                        String estado = (String) jsonObject.get("estado");

                        mensaje = estado;
                        System.err.println("" + mensaje);
                    }

                }
                //System.out.println(jsonobj);
            }

        } catch (UnirestException | JSONException ex) {
            Logger.getLogger(servicios_web.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mensaje;

    }

    public static JSONObject Consultar(String contenedor) {

        long fecha = new Date().getTime();
        Date currentDate = new Date(fecha);
        DateFormat df = new SimpleDateFormat("dd:MM:yy:HH:mm:ss.sss");
        

        System.out.println("entrada: " + df.format(currentDate));
        JSONObject jsonobj = null;
        String mensaje = null;
        String retenciones = null;
        JSONArray errorArray = null;

        try {
            Unirest.setTimeouts(500, 500);
            Unirest.setHttpClient(org.apache.http.impl.client.HttpClients.custom()
                    .disableRedirectHandling()
                    .build());
            HttpResponse<String> response = Unirest.post("https://farm3.sat.gob.gt/retencion-liberacion-ws/rest/privado/retencionLiberacion/consultar")
                    .header("Authorization", "Basic MzEzMzIyMjpFbXBvcm5hYzIwMTUr")
                    .header("Content-Type", "application/json")
                    .header("Accept", "application/json;charset=utf-8")
                    .header("Cookie", "visid_incap_2112329=0xk+tVssSjegRxb6moVvoquKumAAAAAAQUIPAAAAAABebEr5ELkke+K1Kp+CTHG/")
                    .body("{\r\n    \"noContenedor\": \"" + contenedor + "\"\r\n}")
                    .asString();

            if (response.getStatus() == 200) {
                System.err.println("entro 200 Consultar");
                jsonobj = new JSONObject(response.getBody());

                //mensaje = (String) jsonobj.get("mensaje");
                //  errorArray = jsonobj.getJSONArray("retencionLiberacion");
                //System.out.println(jsonobj);
//                System.out.println(mensaje);
//                System.out.println(errorArray);
//                for (int i = 0; i < errorArray.length(); i++) {
//                    
//                    try {
//                        JSONObject jsonObject = errorArray.getJSONObject(i);
//                        System.err.println("Lista"+jsonObject);
//                        if(jsonObject.has("entidadRetiene")&&jsonObject.has("estado")){
//                            
//                            String entidad = jsonObject.getString("entidadRetiene");
//                            String estado = jsonObject.getString("estado");
//                            if("R".equals(estado)&&"SEPA".equals(entidad)){
//                                System.err.println("Estado"+estado+ "Entidad que Retiene: "+entidad);
//                            }
//                            if("R".equals(estado)&&"DIPA".equals(entidad)){
//                                System.err.println("Estado"+estado+ "Entidad que Retiene: "+entidad);
//                            }
//                            if("R".equals(estado)&&"MAGA".equals(entidad)){
//                                System.err.println("Estado"+estado+ "Entidad que Retiene: "+entidad);
//                            }
//                            if("R".equals(estado)&&"SGDAIA".equals(entidad)){
//                                System.err.println("Estado"+estado+ "Entidad que Retiene: "+entidad);
//                            }
//                            
//                        }
//                    } catch (JSONException e) {
//                        System.err.println(""+e);
//                    }
//                    
//                }
            }

        } catch (UnirestException | JSONException ex) {
            Logger.getLogger(servicios_web.class.getName()).log(Level.SEVERE, null, ex);
        }
        long fecha1 = new Date().getTime();
        Date currentDate1 = new Date(fecha1);
        DateFormat df1 = new SimpleDateFormat("dd:MM:yy:HH:mm:ss.sss");
        

        System.out.println("salida: " + df1.format(currentDate1));
        return jsonobj;

    }

    public static JSONObject ConsultarATC(String contenedor) {

        JSONObject jsonobjATC = null;
        String mensaje = null;
        String retenciones = null;
        JSONArray errorArray = null;

        try {
            Unirest.setTimeouts(500, 500);
            Unirest.setHttpClient(org.apache.http.impl.client.HttpClients.custom()
                    .disableRedirectHandling()
                    .build());
            HttpResponse<String> response = Unirest.post("https://farm3.sat.gob.gt/atc-ws/rest/privado/atc/consultarAtcPorContenedor")
                    .header("Authorization", "Basic MzEzMzIyMjpFbXBvcm5hYzIwMTUr")
                    .header("Content-Type", "application/json")
                    .header("Accept", "application/json;charset=utf-8")
                    .header("Cookie", "incap_ses_995_2112329=A4dpaap81Ruukbs/lfPODROM22AAAAAA9sZ3MA0ZETu2fi9vWHvdVQ==; nlbi_2112329=RESzEzDfTXx9rpGw8GHfvAAAAADvlJIOGzPqPWYHNzQRpS0M; visid_incap_2112329=0xk+tVssSjegRxb6moVvoquKumAAAAAAQUIPAAAAAABebEr5ELkke+K1Kp+CTHG/")
                    .body("{\r\n\"noContenedor\": \"" + contenedor + "\"\r\n\r\n}")
                    .asString();
            //System.out.println(response.getBody());
            if (response.getStatus() == 200) {
                System.err.println("entro 200 ConsultarATC");
                jsonobjATC = new JSONObject(response.getBody());
                //mensaje = (String) jsonobj.get("mensaje");
                //  errorArray = jsonobj.getJSONArray("retencionLiberacion");
                //System.out.println(jsonobjATC);
//                System.out.println(mensaje);
//                System.out.println(errorArray);

//                for (int i = 0; i < errorArray.length(); i++) {
//                    
//                    try {
//                        JSONObject jsonObject = errorArray.getJSONObject(i);
//                        System.err.println("Lista"+jsonObject);
//                        if(jsonObject.has("entidadRetiene")&&jsonObject.has("estado")){
//                            
//                            String entidad = jsonObject.getString("entidadRetiene");
//                            String estado = jsonObject.getString("estado");
//                            if("R".equals(estado)&&"SEPA".equals(entidad)){
//                                System.err.println("Estado"+estado+ "Entidad que Retiene: "+entidad);
//                            }
//                            if("R".equals(estado)&&"DIPA".equals(entidad)){
//                                System.err.println("Estado"+estado+ "Entidad que Retiene: "+entidad);
//                            }
//                            if("R".equals(estado)&&"MAGA".equals(entidad)){
//                                System.err.println("Estado"+estado+ "Entidad que Retiene: "+entidad);
//                            }
//                            if("R".equals(estado)&&"SGDAIA".equals(entidad)){
//                                System.err.println("Estado"+estado+ "Entidad que Retiene: "+entidad);
//                            }
//                            
//                        }
//                    } catch (JSONException e) {
//                        System.err.println(""+e);
//                    }
//                    
//                }
            }
        } catch (UnirestException | JSONException ex) {
            Logger.getLogger(servicios_web.class.getName()).log(Level.SEVERE, null, ex);
        }
        return jsonobjATC;

    }
}
