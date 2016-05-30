/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.fci.ec.lp2.action;

import com.br.mackenzie.pizzaria.dao.DAOUsuario;
import com.br.mackenzie.pizzaria.dao.DAOUsuarioInfo;
import com.br.mackenzie.pizzaria.model.javabeans.Usuario;
import com.br.mackenzie.pizzaria.model.javabeans.UsuarioInfo;

/**
 *
 * @author Inmetrics
 */
public class UsuarioAction extends ActionSupport {

    public String login() {
        String usuario = this.getRequest().getParameter("usuario");
        String senha = this.getRequest().getParameter("senha");

        DAOUsuario dao_usuario = new DAOUsuario();
        Usuario u = dao_usuario.readByName(usuario);

        if (u == null) {
            this.getRequest().getSession().setAttribute("msgErro", "Usuário não encontrado!");
            return "erro.jsp";
        } else if (u.getSenha().equals(senha)) {
            this.getRequest().getSession().setAttribute("usuario", u);
            return "home.jsp";
        } else {
            this.getRequest().getSession().setAttribute("msgErro", "Senha Incorreta!");
            return "erro.jsp";
        }
    }

    public String logout() {
        // Remove todas as variáveis da sessão
        this.getRequest().getSession().invalidate();
        return "index.jsp";
    }

    public String cadastrar() {
        UsuarioInfo usuarioInfo = new UsuarioInfo();
        usuarioInfo.setCep(this.getRequest().getParameter("cep"));
        usuarioInfo.setCpf(Long.parseLong(this.getRequest().getParameter("cpf")));
        usuarioInfo.setEndereco(this.getRequest().getParameter("endereco"));
        usuarioInfo.setNome(this.getRequest().getParameter("nome"));
        usuarioInfo.setTelefone(this.getRequest().getParameter("telefone"));
        Usuario u = new Usuario();
        u.setNomeUsuario(this.getRequest().getParameter("nome_usuario"));
        u.setSenha(this.getRequest().getParameter("senha"));
        u.setTipoUsuario(Integer.parseInt(this.getRequest().getParameter("acesso")));
        u.setUsuarioInfo(usuarioInfo);

        DAOUsuario daoUsuario = new DAOUsuario();
        DAOUsuarioInfo daoInfo = new DAOUsuarioInfo();
        u.setCodigo_usuario(daoUsuario.create(u));
        usuarioInfo.setUsuario(u);
        daoInfo.create(usuarioInfo);

        Usuario usuarioAutenticado = daoUsuario.readByName(u.getNomeUsuario());
        this.getRequest().getSession().setAttribute("usuario", usuarioAutenticado);
        return "home.jsp";
    }
}
