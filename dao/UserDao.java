package A_MyProject.dao;

import A_MyProject.entity.User;
import A_MyProject.entity.UserRole;
import A_MyProject.utils.PostgresUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private static final String USER_FIELD_FULL = "id, username, role, mailcontact, login, password";
    private static final String USER_FIELD = "username, role, mailcontact, login, password";
    private static final String SELECT_ALL = "select " + USER_FIELD_FULL + " from \"User\"";
    private static final String SELECT_BY_ID = "select " + USER_FIELD_FULL + " from \"User\" where id = ?";
    private static final String INSERT_SQL = "insert into \"User\"(" + USER_FIELD + ") values(?,?,?,?,?)";
    private static final String DELETE_SQL = "delete from \"User\" where id = ?";

//    public static void main(String[] args) throws DaoException {
//        UserDao userDao = new UserDao();
//        User user = new User(null,"Ben", UserRole.MANUFACTURER.toString(),"gmail@gmail.com","1","1");
//        User user1 = new User(null, "Kevin", UserRole.ADMIN.toString(),"gmail@gmail.com","2","1");
//        List<User> users = userDao.findAll();
//        for(User f: users)
//            System.out.println(f.toString());
//
//    }

    public Integer create(User user) throws DaoException {
        try(Connection connection = PostgresUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL,Statement.RETURN_GENERATED_KEYS)){

            Integer generatedKey = 0;
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getRole().toString());
            preparedStatement.setString(3, user.getMailContact());
            preparedStatement.setString(4, user.getLogin());
            preparedStatement.setString(5, user.getPassword());

            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if(resultSet.next()){
                generatedKey = resultSet.getInt(1);
            }
            return generatedKey;
        }
        catch (SQLException | ClassNotFoundException e){
            throw new DaoException();
        }
    }

    public void delete(User user) throws DaoException{
        try(
                Connection connection = PostgresUtils.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(DELETE_SQL)
        ){
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
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6)
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
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6)
                );
            }
        } catch (SQLException | ClassNotFoundException e){
            throw new DaoException();
        }
        return null;
    }
}