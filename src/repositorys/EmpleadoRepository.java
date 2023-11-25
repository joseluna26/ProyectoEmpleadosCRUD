package repositorys;

import java.util.List;

import interfaces.RepositoryInterface;
import models.Empleado;

public class EmpleadoRepository implements RepositoryInterface<Empleado>{

    @Override
    public Empleado recuperarId(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'recuperarId'");
    }

    @Override
    public List<Empleado> recuperarTodos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'recuperarTodos'");
    }

    @Override
    public void agregar(Empleado entidad) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'agregar'");
    }

    @Override
    public void modificar(Empleado entidad) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'modificar'");
    }

    @Override
    public void eliminar(Empleado entidad) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminar'");
    }
    
}
