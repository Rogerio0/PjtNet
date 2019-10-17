/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import Controlle.Fornecedo;
import DAO.FornecedoDao;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * 
 */
@FacesConverter("fornecedoConverter")
public class FornecedoConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext arg0, UIComponent componente, String valor) {
        try {

            Long codigo = Long.parseLong(valor);
            FornecedoDao dao = new FornecedoDao();
            Fornecedo fornecedo = dao.buscarCodigo(codigo);

            return fornecedo;

        } catch (RuntimeException ex) {
            return null;
        }

    }

    @Override
    public String getAsString(FacesContext arg0, UIComponent componente, Object objeto) {

        try {

            Fornecedo fornecedo = (Fornecedo) objeto;
            Integer codigo = fornecedo.getCodigoFornecedo();
            return codigo.toString();

        } catch (RuntimeException ex) {
            return null;
        }
    }

}
