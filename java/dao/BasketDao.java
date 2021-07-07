package dao;

import entity.Basket;
import entity.Product;
import utils.PostgresUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BasketDao {
    private static final String BASKET_FIELD = "userid, productid, basketstate";
    private static final String BASKET_FIELD_FULL = "id ,userid, productid, basketstate";
    private static final String SELECT_BY_ID = "select " + BASKET_FIELD_FULL + " from \"Basket\" where userid = ?";
    private static final String INSERT_SQL = "insert into \"Basket\"(" + BASKET_FIELD + ") values(?,?,?)";
    private static final String DELETE_SQL = "delete from \"Basket\" where id = ?";
    private static final String CLEAR_BASKET_SQL = "delete form \"Basket\" where userid = ?";
    private static final String UPDATE_SQL = "update \"Basket\" set basketstate = ? where userid = ?";

    private ProductDao productDao = new ProductDao();

    public void insertBasket(Basket basket) throws DaoException {
        try (Connection connection = PostgresUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL)
        ) {
            preparedStatement.setString(3, basket.getBasketState().toString());
            preparedStatement.setInt(1, basket.getBuyerId());

            for (Product product : basket.getBasketList()) {
                preparedStatement.setInt(2, product.getId());
                preparedStatement.execute();
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new DaoException();
        }
    }

    public void clearBasket(Basket basket) throws DaoException {
        try (
                Connection connection = PostgresUtils.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(CLEAR_BASKET_SQL)
        ) {
            preparedStatement.setInt(1, basket.getBuyerId());
            preparedStatement.execute();
        } catch (SQLException | ClassNotFoundException e) {
            throw new DaoException();
        }
    }

    public void deletePositionOfBasket(Integer id) throws DaoException {
        try (
                Connection connection = PostgresUtils.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(DELETE_SQL)
        ) {
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException | ClassNotFoundException e) {
            throw new DaoException();
        }
    }

    public void updateBasket(Basket basket) throws DaoException {
        try (
                Connection connection = PostgresUtils.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SQL)
        ) {
            preparedStatement.setString(1, basket.getBasketState().toString());
            preparedStatement.setInt(2, basket.getBuyerId());
            preparedStatement.execute();
        } catch (SQLException | ClassNotFoundException e) {
            throw new DaoException();
        }
    }

    public Basket getUsersBasket(Integer userId) throws DaoException {
        Basket basket = new Basket();
        try (
                Connection connection = PostgresUtils.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID)
        ) {
            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            basket.setBuyerId(userId);
            while (resultSet.next()) {
                basket.setBasketState(resultSet.getString("basketstate"));
                Product product = productDao.getById(resultSet.getInt("productid"));
                basket.addToIdList(resultSet.getInt("id"));
                basket.addToBasketList(product);
            }

        } catch (SQLException | ClassNotFoundException e) {
            throw new DaoException();
        }
        return basket;
    }
}
