/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modeloBeans.ModeloMedico;

public class ControleMedico {
    ConexaoBD conex = new ConexaoBD();
    ModeloMedico mod = new ModeloMedico();

public void Salvar(ModeloMedico mod){
    conex.conexao();
try{
    PreparedStatement pst = conex.con.prepareStatement("insert into medicos (nome_medico, especialidade_medico,crm_medico) values(?,?,?)");
    pst.setString(1, mod.getNome());
    pst.setString(2, mod.getEspecialidade());
    pst.setInt(3, mod.getCrm());
    pst.execute();
    JOptionPane.showMessageDialog(null,"Dados inseridos com sucesso!!");
}catch(SQLException ex){
    JOptionPane.showMessageDialog(null, "Erro ao inserir dados!\nErro: "+ex);
}
    conex.desconecta();
}   
}

