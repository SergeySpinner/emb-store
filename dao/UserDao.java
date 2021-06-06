package A_MyProject.dao;

import A_MyProject.entity.User;
import A_MyProject.utils.PostgresUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private static final String PRODUCT_FIELD = "username, role, mailcontact";
    private static final String SELECT_ALL = "select " + PRODUCT_FIELD + " from User";
    private static final String SELECT_BY_ID = "select " + PRODUCT_FIELD + " from User where id = ?";
    private static final String INSERT_SQL = "insert into \"User\"(" + PRODUCT_FIELD + ") values(?,?,?)";
    private static final String DELETE_SQL = "delete from \"User\" where id = ?";

    public static void main(String[] args) throws DaoException {
        User user = new User(null,"Kevin","USER","gmail@gmail.com");
        UserDao userDao = new UserDao();
        //List<User> users = new ArrayList<>();
        //users = userDao.findAll();
        //System.out.println(users.toArray().toString());
        user.setId(userDao.create(user));
        System.out.println(user.toString());

    }

    public Integer create(User user) throws DaoException {
        try(Connection connection = PostgresUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL,Statement.RETURN_GENERATED_KEYS)){
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getRole().toString());
            preparedStatement.setString(3, user.getMailContact());

            return preparedStatement.executeUpdate();
        }
        catch (SQLException | ClassNotFoundException e){
            throw new DaoException();
        }
    }

    public void delete(User user) throws DaoException{
        try(Connection connection = PostgresUtils.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_SQL)){
            preparedStatement.setInt(1, user.getId());

            preparedStatement.execute();

        }catch (SQLException | ClassNotFoundException e){
            throw new DaoException();
        }
    }

    public List<User> findAll() throws DaoException{
        List <User> users = new ArrayList<>();
        try(
                Connection connection = PostgresUtils.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(SELECT_ALL)
        ){
            while(resultSet.next()){
                User user = new User(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4)
                );
                users.add(user);
            }
        }
        catch (SQLException | ClassNotFoundException e){
            throw new DaoException();
        }
        return users;
    }

    public User getById(Integer id) throws DaoException{
        try(
                Connection connection = PostgresUtils.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID)
                ) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return new User(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4)
                );
            }
        } catch (SQLException | ClassNotFoundException e){
            throw new DaoException();
        }
        return null;
    }
}