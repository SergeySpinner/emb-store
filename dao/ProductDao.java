package A_MyProject.dao;

import A_MyProject.entity.Product;
import A_MyProject.utils.PostgresUtils;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {
    private static final String PRODUCT_FIELD_FULL = "id, prodname, price, prodquantity, prodinfo";
    private static final String PRODUCT_FIELD = "prodname ,price, prodquantity, prodinfo";
    private static final String SELECT_ALL = "select " + PRODUCT_FIELD_FULL + " from \"Product\"";
    private static final String SELECT_BY_ID = "select " + PRODUCT_FIELD_FULL + " from \"Product\" where id = ?";
    private static final String INSERT_SQL = "insert into \"Product\"(" + PRODUCT_FIELD + ") values(?,?,?,?)";
    private static final String DELETE_SQL = "delete from \"Product\" where id = ?";

//    public static void main(String[] args) throws DaoException {
//        Product product = new Product(null,"Shirt", 2200, 7, "Summer type");
//        ProductDao productDao = new ProductDao();
//        //product.setId(productDao.create(product));
//        List<Product> products = productDao.findAll();
//
//    }

    public Integer create(Product product) throws DaoException{
        try(
                Connection connection = PostgresUtils.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)
        ) {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setInt(2, product.getPrice());
            preparedStatement.setInt(3, product.getProdQuantity());
            preparedStatement.setString(4, product.getProdInfo());

            preparedStatement.execute();
            Integer generatedKey = 0;

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if(resultSet.next()){
                generatedKey = resultSet.getInt(1);
            }

            return generatedKey;

        }catch (SQLException | ClassNotFoundException e){
            throw new DaoException();
        }
    }

    public void delete(Product product) throws DaoException{
        try(
                Connection connection = PostgresUtils.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(DELETE_SQL)
                ){
            preparedStatement.setInt(1, product.getId());
            preparedStatement.execute();
        }catch (SQLException | ClassNotFoundException e){
            throw new DaoException();
        }
    }

    public List<Product> findAll() throws DaoException{
        List<Product> products = new ArrayList<>();
        try(
                Connection connection = PostgresUtils.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(SELECT_ALL)
                ){
            while (resultSet.next()){
                products.add(new Product(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getInt(3),
                        resultSet.getInt(4),
                        resultSet.getString(5)
                ));
            }

        }catch (SQLException | ClassNotFoundException e){
            throw new DaoException();
        }
        return products;
    }

    public Product getById(Integer id) throws DaoException{
        try(
                Connection connection = PostgresUtils.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID)
                ){
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return new Product(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getInt(3),
                        resultSet.getInt(4),
                        resultSet.getString(5));
            }
        }catch (SQLException | ClassNotFoundException e){
            throw new DaoException();
        }
        return null;
    }
}
