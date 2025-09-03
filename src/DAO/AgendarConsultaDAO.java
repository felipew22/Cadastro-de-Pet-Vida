package DAO;

import connectionDataBase.IniciarDB;
import models.AgendarConsulta;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class AgendarConsultaDAO {


    //Inserir
    public void insert (AgendarConsulta agendarConsulta){
        String sql = "INSERT INTO agendar_consulta(data_hora,id_tutor,id_veterinario,id_animal) VALUES (?,?,?,?)";

        System.out.println(sql);

        try {
            Connection connection = IniciarDB.obterConexao();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setTimestamp(1, new Timestamp(agendarConsulta.getDatahora().getTime()));
            ps.setInt(2, agendarConsulta.getTutor());
            ps.setInt(3,agendarConsulta.getVeterinario());
            ps.setInt(4,agendarConsulta.getAnimal());

            ps.execute();
            JOptionPane.showMessageDialog(null, "Cadastro realizado com Sucesso!");
            ps.close();
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro no cadastro!");
            e.printStackTrace();
        }
    }

    //Atualizar
    public void update(AgendarConsulta agendarConsulta){
        String sql = "UPDATE agendar_consulta SET data_hora=? ,id_tutor=? ,id_veterinario=? ,id_animal=? WHERE id=?";
        System.out.println(sql);

        try {
            Connection connection = IniciarDB.obterConexao();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setTimestamp(1, new Timestamp(agendarConsulta.getDatahora().getTime()));
            ps.setInt(2, agendarConsulta.getTutor());
            ps.setInt(3,agendarConsulta.getVeterinario());
            ps.setInt(4,agendarConsulta.getAnimal());

            ps.execute();
            JOptionPane.showMessageDialog(null, "Alteração realizado com Sucesso!");
            ps.close();
            connection.close();
    } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Deletar
    public void delete(AgendarConsulta agendarConsulta) {
        String sql =   "DELETE FROM agendar_consulta WHERE id=?";
        System.out.println(sql);
        try {
            Connection connection = IniciarDB.obterConexao();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, agendarConsulta.getId());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Exclusão realizada com sucesso");
            ps.close();
            connection.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Usuario não excluido");
            e.printStackTrace();
        }
    }

    // Consultar
    public void consulta(AgendarConsulta agendarConsulta) {
        String sql = "select a.data_hora, b.nome, d.nome, e.nome_pet from agendar_consulta a, tutor b, veterinario c, funcionarios d, animal e where a.id=?";

        System.out.println(sql);
        try {
            Connection connection = IniciarDB.obterConexao();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, agendarConsulta.getId());
            ResultSet rs = ps.executeQuery();
            agendarConsulta.setExiste(false);
            while (rs.next()){
                agendarConsulta.setExiste(true);
                agendarConsulta.setDatahora(rs.getTimestamp(1));
                agendarConsulta.setTutorname(rs.getString(2));
                agendarConsulta.setVeterinarioname(rs.getString(3));
                agendarConsulta.setAnimalname(rs.getString(4));

            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public ArrayList listAgendamentos(){
        ArrayList<AgendarConsulta> listaAgendar = new ArrayList<>();

        String sql = "select a.data_hora, b.nome, d.nome, e.nome_pet,a.id from agendar_consulta a, tutor b, veterinario c, funcionarios d, animal e ";

        try{
            Connection connection = IniciarDB.obterConexao();
            PreparedStatement ps = connection.prepareStatement(sql);

            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()){
                AgendarConsulta agendarConsulta = new AgendarConsulta();

                agendarConsulta.setDatahora(resultSet.getTimestamp(1));
                agendarConsulta.setTutorname(resultSet.getString(2));
                agendarConsulta.setVeterinarioname(resultSet.getString(3));
                agendarConsulta.setAnimalname(resultSet.getString(4));
                agendarConsulta.setId(5);

                listaAgendar.add(agendarConsulta);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return listaAgendar;
    }

}