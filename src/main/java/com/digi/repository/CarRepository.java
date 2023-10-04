//package com.digi.repository;
//
//import com.dgi.exceptions.ErrorMessages;
//import com.dgi.exceptions.car.CarNotFoundException;
//import com.dgi.model.Car;
//import com.dgi.util.MyDatasource;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class CarRepository {
//
//    public void insert(Car car) {
//        Connection connection = MyDatasource.getConnection();
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO car value (0,?,?,?,?)");
//            preparedStatement.setString(1, car.getName());
//            preparedStatement.setString(2, car.getModel());
//            preparedStatement.setInt(3, car.getYear());
//            preparedStatement.setInt(4, car.getUserId());
//            preparedStatement.execute();
//            System.out.println("Car is created");
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public void delete(int id) {
//        Connection connection = MyDatasource.getConnection();
//        Car carById = getById(id);
//        if (carById == null) {
//            throw new CarNotFoundException(ErrorMessages.CAR_NOT_FOUND);
//        }
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM car where car_id = ?");
//            preparedStatement.setInt(1, id);
//            preparedStatement.executeUpdate();
//            System.out.println("Car is deleted");
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public Car getById(int id) {
//        Connection connection = MyDatasource.getConnection();
//        Car car = null;
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM car WHERE car_id = ?");
//            preparedStatement.setInt(1, id);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()) {
//                car = new Car();
//                car.setId(id);
//                car.setName(resultSet.getString("name"));
//                car.setModel(resultSet.getString("model"));
//                car.setYear(resultSet.getInt("year"));
//                car.setUserId(resultSet.getInt("user_id"));
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return car;
//    }
//
//    public List<Car> getAll() {
//        Connection connection = MyDatasource.getConnection();
//        List<Car> cars = new ArrayList<>();
//        try {
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery("SELECT * FROM car");
//            while (resultSet.next()) {
//                Car car = new Car();
//                car.setId(resultSet.getInt("id"));
//                car.setName(resultSet.getString("name"));
//                car.setModel(resultSet.getString("model"));
//                car.setYear(resultSet.getInt("year"));
//                car.setUserId(resultSet.getInt("user_id"));
//                cars.add(car);
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return cars;
//    }
//
//
////    private List<Car> getCarModelList(ResultSet resultSet) throws SQLException {
////        List<Car> cars = new ArrayList<>();
////        while (resultSet.next()) {
////            cars.add(resultSetMapToCarModel(resultSet));
////        }
////        return cars;
////    }
////
////    private Car getCarModel(ResultSet resultSet) throws SQLException {
////        if (resultSet.next()) {
////            return resultSetMapToCarModel(resultSet);
////        }
////        return null;
////    }
////
////    private Car resultSetMapToCarModel(ResultSet resultSet) throws SQLException {
////        Car car = new Car();
////        car.setId(resultSet.getInt("id"));
////        car.setName(resultSet.getString("name"));
////        car.setModel(resultSet.getString("model"));
////        car.setYear(resultSet.getInt("year"));
////        car.setUserId(resultSet.getInt("user_id"));
////        return car;
////    }
//}
