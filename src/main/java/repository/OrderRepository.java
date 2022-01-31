package repository;

import model.Order;

import java.util.List;

public class OrderRepository implements Repository<Order> {
    @Override
    public int save(Order order) {
        return 0;
    }

    @Override
    public void upDate(Order order) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Order find(int id) {
        return null;
    }

    @Override
    public List<Order> findAll() {
        return null;
    }
}
