package repository;

import model.Customer;

import java.util.List;

public class CustomerRepository implements Repository<Customer>{
    @Override
    public int save(Customer customer) {
        return 0;
    }

    @Override
    public void upDate(Customer customer) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Customer find(int id) {
        return null;
    }

    @Override
    public List<Customer> findAll() {
        return null;
    }
}
