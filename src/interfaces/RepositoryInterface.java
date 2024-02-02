package interfaces;

import java.util.List;

public interface RepositoryInterface<T> {

public T recuperarId(Long id);
public List<T> recuperarTodos();
public void agregar(T entidad);
public void modificar(T entidad);
public void eliminar(T entidad);
    
}
