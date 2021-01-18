package at.htl.finoview.controller;

import at.htl.finoview.database.Database;
import at.htl.finoview.model.Account;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

public class AccountRepository implements Persistent<Account> {

    private DataSource dataSource = Database.getDataSource();

    @Override
    public void save(Account entity) {

    }

    @Override
    public void insert(Account entity) {
//        try (Connection connection = dataSource.getConnection()) {
//            String sql = "INSERT INTO account  (iban) VALUES (?)";
//
//            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//            statement.setString(1, questionnaire.getQnDescription());
//
//
//            if (statement.executeUpdate() == 0) {
//                throw new SQLException("Update of QUESTIONNAIRE failed, no rows affected");
//            }
//
//
//            try (ResultSet keys = statement.getGeneratedKeys()) {
//                if (keys.next()) {
//                    questionnaire.setQnId(keys.getLong(1));
//                } else {
//                    throw new SQLException("Insert into QUESTIONNAIRE failed, no ID obtained");
//                }
//            }
//
//
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

    }

    @Override
    public void delete(long id) {

    }

    @Override
    public List<Account> findAll() {
        return null;
    }
}
