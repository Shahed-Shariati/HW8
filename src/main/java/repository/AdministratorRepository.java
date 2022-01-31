package repository;

import model.Adminstrator;

import java.util.List;

public class AdministratorRepository implements Repository<Adminstrator>{
    @Override
    public int save(Adminstrator adminstrator) {
        return 0;
    }

    @Override
    public void upDate(Adminstrator adminstrator) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Adminstrator find(int id) {
        return null;
    }

    @Override
    public List<Adminstrator> findAll() {
        return null;
    }
}
