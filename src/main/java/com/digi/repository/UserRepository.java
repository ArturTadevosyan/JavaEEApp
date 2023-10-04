//package com.digi.repository;
//
//import com.dgi.exceptions.ErrorMessages;
//import com.dgi.exceptions.user.UserNotFoundException;
//import com.dgi.model.User;
//import com.dgi.util.MyDatasource;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class UserRepository {
//
//    public void insert(User user) {
//        try {
//            Connection connection = MyDatasource.getConnection();
//            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO user value (0,?,?,?,?,?)");
//            preparedStatement.setString(1, user.getName());
//            preparedStatement.setString(2, user.getSurname());
//            preparedStatement.setInt(3, user.getAge());
//            preparedStatement.setString(4, user.getEmail());
//            preparedStatement.setString(5, user.getPassword());
//            preparedStatement.execute();
//            System.out.println("User is created");
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public void update(User user) {
//        Connection connection = MyDatasource.getConnection();
//        User userDb = getByEmail(user.getEmail());
//        if (userDb == null) {
//            throw new UserNotFoundException(ErrorMessages.USER_NOT_FOUND);
//        }
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE user SET " +
//                    "first_name = ? ," +
//                    "last_name = ? ," +
//                    "age = ? WHERE id = ?"
//            );
//            preparedStatement.setString(1, user.getName() != null ? user.getName() : userDb.getName());
//            preparedStatement.setString(2, user.getSurname() != null ? user.getSurname() : userDb.getSurname());
//            preparedStatement.setInt(3, user.getAge() != 0 ? user.getAge() : userDb.getAge());
//            preparedStatement.setInt(4, userDb.getId());
//            preparedStatement.executeUpdate();
//            System.out.println("User is updated");
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public void delete(int id) {
//        Connection connection = MyDatasource.getConnection();
//        User userById = getById(id);
//        if (userById == null){
//            throw  new UserNotFoundException(ErrorMessages.USER_NOT_FOUND);
//        }
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM user where id = ?");
//            preparedStatement.setInt(1, id);
//            preparedStatement.executeUpdate();
//            System.out.println("User is deleted");
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public List<User> getAll() {
//        Connection connection = MyDatasource.getConnection();
//        List<User> users = new ArrayList<>();
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM user");
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()) {
//                User user = new User();
//                user.setId(resultSet.getInt("id"));
//                user.setName(resultSet.getString("first_name"));
//                user.setSurname(resultSet.getString("last_name"));
//                user.setAge(resultSet.getInt("age"));
//                user.setEmail(resultSet.getString("email"));
//                user.setPassword(resultSet.getString("password"));
//                users.add(user);
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return users;
//    }
//
//    public User getByEmail(String email) {
//        Connection connection = MyDatasource.getConnection();
//        User user = null;
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM user WHERE email = ?");
//            preparedStatement.setString(1, email);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()) {
//                user = new User();
//                user.setId(resultSet.getInt("id"));
//                user.setName(resultSet.getString("first_name"));
//                user.setSurname(resultSet.getString("last_name"));
//                user.setAge(resultSet.getInt("age"));
//                user.setEmail(email);
//                user.setPassword(resultSet.getString("password"));
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return user;
//    }
//
//    public User getById(int id) {
//        Connection connection = MyDatasource.getConnection();
//        User user = null;
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM user WHERE id = ?");
//            preparedStatement.setInt(1, id);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()) {
//                user = new User();
//                user.setId(id);
//                user.setName(resultSet.getString("first_name"));
//                user.setSurname(resultSet.getString("last_name"));
//                user.setAge(resultSet.getInt("age"));
//                user.setEmail(resultSet.getString("email"));
//                user.setPassword(resultSet.getString("password"));
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return user;
//    }
//
//
////    private List<User> getUserModelList(ResultSet usersResultSet) throws SQLException {
////        List<User> users = new ArrayList<>();
////        while (usersResultSet.next()) {
////            users.add(userResultSetMapToUserModel(usersResultSet));
////        }
////        return users;
////    }
//
////    private User getUserModel(ResultSet resultSet) throws SQLException {
////        if (resultSet.next()) {
////            return userResultSetMapToUserModel(resultSet);
////        }
////        return null;
////    }
//
////    private User userResultSetMapToUserModel(ResultSet resultSet) throws SQLException {
////        User user = new User();
////        user.setId(resultSet.getInt("id"));
////        user.setName(resultSet.getString("first_name"));
////        user.setSurname(resultSet.getString("last_name"));
////        user.setAge(resultSet.getInt("age"));
////        user.setEmail(resultSet.getString("email"));
////        user.setPassword(resultSet.getString("password"));
////        return user;
////    }
//}
