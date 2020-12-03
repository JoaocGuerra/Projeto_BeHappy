package br.edu.ifpb.padroes.Iterator;

import br.edu.ifpb.dominio.Avaliacao;

import java.util.Collection;
import java.util.List;


public class ListAvaliacoes implements IteratorList{

    List<Avaliacao> list;
    int position = 0;

    public ListAvaliacoes(Collection<Avaliacao> list) {
        this.list = (List<Avaliacao>) list;
    }

    @Override
    public boolean hasNext() {
        if (position >= list.size() || list.get(position) == null) {
            return false;
        } else {
            return true;
        }

    }

    @Override
    public Object next() {
        Avaliacao avaliacao = list.get(position);
        position++;
        return avaliacao;
    }
}
