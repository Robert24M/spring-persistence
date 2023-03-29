package me.learnspring.springpersistence.repositories;

import me.learnspring.springpersistence.model.Purchase;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PurchaseRepository {

    private final JdbcTemplate jdbcTemplate;

    public PurchaseRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addPurchase(Purchase purchase) {
        String sql = "INSERT INTO purchases(product, price) VALUES(?, ?)";

        jdbcTemplate.update(sql,
                purchase.getProduct(),
                purchase.getPrice());
    }

    public List<Purchase> findAllPurchases() {
        String sql = "SELECT * FROM purchases";

        RowMapper<Purchase> purchaseRowMapper = ((rs, rowNum) -> {
            Purchase purchase = new Purchase();
            purchase.setId(rs.getInt("id"));
            purchase.setProduct(rs.getString("product"));
            purchase.setPrice(rs.getBigDecimal("price"));

            return purchase;
        });

        return jdbcTemplate.query(sql,purchaseRowMapper);
    }
}
