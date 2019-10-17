/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import Controlle.Cliente;
import DAO.ClienteDao;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * 
 */
@FacesConverter("clienteConverter")
public class ClienteConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext arg0, UIComponent componente, String valor) {
        try {

            Long codigo = Long.parseLong(valor);
            ClienteDao dao = new ClienteDao();
            Cliente cliente = dao.buscarCodigo(codigo);

            return cliente;

        } catch (RuntimeException ex) {
            return null;
        }

    }

    @Override
    public String getAsString(FacesContext arg0, UIComponent componente, Object objeto) {

        try {

            Cliente cliente = (Cliente) objeto;
            Integer codigo = cliente.getCodigoCliente();
            return codigo.toString();

        } catch (RuntimeException ex) {
            return null;
        }
    }

}
