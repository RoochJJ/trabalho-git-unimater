

import cadastro.Pessoa;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PessoaService {
    private List<cadastro.Pessoa> pessoas = new ArrayList<>();
    private int currentId = 1;

    public void adicionarPessoa(String nome, int idade) {
        cadastro.Pessoa pessoa = new Pessoa(currentId++, nome, idade);
        pessoas.add(pessoa);
    }

    public List<Pessoa> listarPessoas() {
        return pessoas;
    }

    public boolean alterarPessoa(int id, String novoNome, int novaIdade) {
        Optional<Pessoa> pessoaOpt = pessoas.stream().filter(p -> p.getId() == id).findFirst();
        if (pessoaOpt.isPresent()) {
            Pessoa pessoa = pessoaOpt.get();
            pessoa.setNome(novoNome);
            pessoa.setIdade(novaIdade);
            return true;
        }
        return false;
    }

    public boolean excluirPessoa(int id) {
        return pessoas.removeIf(p -> p.getId() == id);
    }
}

