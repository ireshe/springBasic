package xyz.qualon.pos.pos.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import xyz.qualon.pos.pos.entity.Customer;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface CustomerRepo extends JpaRepository<Customer, Integer> {

    List<Customer> findAllByIsActiveEquals(boolean activeStatus);
}
