/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import Controlle.Instalacao;
import DAO.InstalacaoDao;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Gilvan
 */
@FacesConverter("instalacaoConverter")
public class InstalacaoConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext arg0, UIComponent componente, String valor) {
        try {

            Long codigo = Long.parseLong(valor);
            InstalacaoDao dao = new InstalacaoDao();
            Instalacao instalacao = dao.buscarCodigo(codigo);

            return instalacao;

        } catch (RuntimeException ex) {
            return null;
        }

    }

    @Override
    public String getAsString(FacesContext arg0, UIComponent componente, Object objeto) {

        try {

            Instalacao instalacao = (Instalacao) objeto;
            Integer codigo = instalacao.getCodigoInstalacao();
            return codigo.toString();

        } catch (RuntimeException ex) {
            return null;
        }
    }

}
