public class ArvoreBinariaBusca {
    private No raiz;

    public ArvoreBinariaBusca() {
        this.raiz = null;
    }


    public void inserir(int valor) {
        raiz = inserirRecursivo(raiz, valor);
    }

    private No inserirRecursivo(No atual, int valor) {
        if (atual == null) return atual = new No(valor);

        if (valor < atual.valor) {
            atual.esquerda = inserirRecursivo(atual.esquerda, valor);
        } else if (valor > atual.valor) {
            atual.direita = inserirRecursivo(atual.direita, valor);
        }

        return atual;
    }

    public boolean buscar(int valor) {
        return buscarRecurisvo(raiz, valor);
    }

    private boolean buscarRecurisvo(No atual, int valor) {
        if (atual == null) return false;
        if (valor == atual.valor) return true;

        if (valor < atual.valor) {
            return buscarRecurisvo(atual.esquerda, valor);
        }
        return buscarRecurisvo(atual.direita, valor);
    }

    public void remover(int valor) {
        raiz = removerRecursivo(raiz, valor);
    }

    private No buscarMenor(No atual) {
        while (atual.esquerda != null) {
            atual = atual.esquerda;
        }
        return atual;
    }

    private No removerRecursivo(No atual, int valor) {
        if (atual == null) return null;

        if (valor < atual.valor) {
            atual.esquerda = removerRecursivo(atual.esquerda, valor);
        } else if (valor > atual.valor) {
            atual.direita = removerRecursivo(atual.direita, valor);
        } else {
            if (atual.esquerda == null && atual.direita == null) {
                return null;
            } else if (atual.esquerda == null) {
                return atual.direita;
            } else if (atual.direita == null) {
                return atual.esquerda;
            } else {
                No sucessor = buscarMenor(atual.direita);
                atual.valor = sucessor.valor;
                atual.direita = removerRecursivo(atual.direita, sucessor.valor);
            }
        }
        return atual;
    }

    public void imprimirEmOrdem() {
        System.out.print("Em ordem: ");
        imprimirEmOrdemRecursivo(raiz);
        System.out.println();
    }
    private void imprimirEmOrdemRecursivo(No no) {
        if (no != null) {
            imprimirEmOrdemRecursivo(no.esquerda);
            System.out.print(no.valor + " ");
            imprimirEmOrdemRecursivo(no.direita);
        }
    }
}
