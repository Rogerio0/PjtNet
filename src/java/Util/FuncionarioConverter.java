/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import Controlle.Funcionario;
import DAO.FuncionarioDao;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Gilvan
 */
@FacesConverter("funcionarioConverter")
public class FuncionarioConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext arg0, UIComponent componente, String valor) {
        try {

            Long codigo = Long.parseLong(valor);
            FuncionarioDao dao = new FuncionarioDao();
            Funcionario funcionario = dao.buscarCodigo(codigo);

            return funcionario;

        } catch (RuntimeException ex) {
            return null;
        }

    }

    @Override
    public String getAsString(FacesContext arg0, UIComponent componente, Object objeto) {

        try {

            Funcionario funcionario = (Funcionario) objeto;
            Integer codigo = funcionario.getCodigoFuncionario();
            return codigo.toString();

        } catch (RuntimeException ex) {
            return null;
        }
    }

}
