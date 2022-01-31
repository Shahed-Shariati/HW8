package repository;

import model.User;

import java.util.List;

public class UserRepository implements Repository<User>{
    @Override
    public int save(User user) {
        return 0;
    }

    @Override
    public void upDate(User user) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public User find(int id) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    public User findByUserName(){

    return null;
    }
}
