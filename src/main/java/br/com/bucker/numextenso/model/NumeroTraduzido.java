package br.com.bucker.numextenso.model;

import java.util.Objects;

public class NumeroTraduzido {
    public NumeroTraduzido(){
        super();
    }

    public NumeroTraduzido(String extenso) {
        this.extenso = extenso;
    }

    public String extenso;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NumeroTraduzido that = (NumeroTraduzido) o;
        return Objects.equals(extenso, that.extenso);
    }

    @Override
    public int hashCode() {

        return Objects.hash(extenso);
    }
}
