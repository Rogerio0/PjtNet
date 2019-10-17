/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author Gilvan
 */
public class JSFUtil {

    public static void AdicionarMensagemSucesso(String mensagem) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
                mensagem, mensagem);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, msg);
    }

    public static void AdicionarMensagemErro(String mensagem) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                mensagem, mensagem);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, msg);

    }

    public static String getParam(String nome) {
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext externalContext = context.getExternalContext();
        Map<String, String> parametros = externalContext.
                getRequestParameterMap();
        String valor = parametros.get(nome);
        return valor;

    }
}
