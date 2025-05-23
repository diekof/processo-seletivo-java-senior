package br.com.diegosilva.seletivo.domain;


import java.util.Objects;

public abstract class Entity<ID extends Identifier>  implements AssertionConcern{

    protected final ID id;

    protected Entity(final ID id) {
        this.id = this.assertArgumentNotNull(id, "'id' should not be null");
    }

    public ID id() {
        return id;
    }


    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Entity<?> entity = (Entity<?>) o;
        return id().equals(entity.id());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id());
    }
}