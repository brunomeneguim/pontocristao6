/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pontocristao.controle;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import pontocristao.modelo.Funcionario;

/**
 *
 * @author Marco
 */
public class ControleSistema extends ControleBase {
    
    public static Funcionario FuncionarioLogado;
    
    public static Funcionario getFuncionarioLogado(Session sessao)
    {
        String sql = "SELECT * FROM Funcionario WHERE id = " + FuncionarioLogado.getId();
        Query q = sessao.createSQLQuery(sql).addEntity(Funcionario.class);
        
        List<Funcionario> funcionarios = q.list();
        
        return funcionarios.get(0);
    }
}
