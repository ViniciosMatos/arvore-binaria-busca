void main() {
    ArvoreBinariaBusca arvore = new ArvoreBinariaBusca();

    arvore.inserir(41);
    arvore.inserir(96);
    arvore.inserir(89);
    arvore.inserir(45);
    arvore.inserir(20);
    arvore.inserir(11);
    arvore.inserir(15);

    IO.println(arvore.buscar(96));

    arvore.remover(100);
    arvore.imprimirEmOrdem();
}
