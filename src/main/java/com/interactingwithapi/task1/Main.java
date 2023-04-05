package com.interactingwithapi.task1;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        UsersApi usersApi = new UsersApi();

////      Получение информации обо всех пользователях
//        List<User> users = usersApi.getUsers();
//        for (User user : users) {
//            System.out.println(user);
//            System.out.println();
//        }

////      Получение информации о пользователе с определенным id
//        User userById = usersApi.getUserById(3);
//        System.out.println(userById);
//
//        System.out.println();
//
////      Получение информации о пользователе с опредленным username
//        User leopoldoCorkery = usersApi.getUserByUsername("Leopoldo_Corkery");
//        System.out.println(leopoldoCorkery);

////      Обновление объекта
//        User user = new User.Builder()
//                .setId(11)
//                .setName("Emir")
//                .setUsername("Emir_Doe")
//                .setEmail("emir@gmail.com")
//                .setAddress(new User.Address.Builder()
//                        .setStreet("43 Veel St")
//                        .setSuite("Apt 4B")
//                        .setCity("New York")
//                        .setZipcode("1232")
//                        .setGeo(new User.Address.Geo.Builder()
//                                .setLat("45.123")
//                                .setLng("12.345")
//                                .build()
//                        )
//                        .build()
//                )
//                .setPhone("555-1234")
//                .setWebsite("emir.com")
//                .setCompany(new User.Company.Builder()
//                        .setName("Shop")
//                        .setCatchPhrase("Hello")
//                        .setBs("Innovative applications")
//                        .build()
//                )
//                .build();
//
//        try {
//            User resultUser = usersApi.updateUser(1, user);
//            System.out.println("Обновленный пользователь: " + resultUser);
//        } catch (IOException e) {
//            System.err.println("Ошибка при обновлении пользователя: " + e.getMessage());
//        }

////      Удаление объекта
//        int userIdToDelete = 1;
//
//        try {
//            boolean isDeleted = usersApi.deleteUser(userIdToDelete);
//            if (isDeleted) {
//                System.out.println("Пользователь с ID " + userIdToDelete + " успешно удален.");
//            } else {
//                System.out.println("Не удалось удалить пользователя с ID " + userIdToDelete);
//            }
//        } catch (IOException e) {
//            System.err.println("Ошибка при удалении пользователя: " + e.getMessage());
//        }

//        создание нового объекта


//        User newUser = new User.Builder()
//                .setId(usersApi.getMaxUserId() + 1)
//                .setName("New User")
//                .setUsername("newuser")
//                .setEmail("newuser@example.com")
//                .setAddress(new User.Address.Builder()
//                        .setStreet("New Street")
//                        .setSuite("New Suite")
//                        .setCity("New City")
//                        .setZipcode("New Zipcode")
//                        .setGeo(new User.Address.Geo.Builder()
//                                .setLat("0.0")
//                                .setLng("0.0")
//                                .build())
//                        .build())
//                .setPhone("123-456-7890")
//                .setWebsite("www.newuser.com")
//                .setCompany(new User.Company.Builder()
//                        .setName("New Company")
//                        .setCatchPhrase("New CatchPhrase")
//                        .setBs("New Bs")
//                        .build())
//                .build();
//
//        User createdUser = usersApi.createUser(newUser);
//
//        System.out.println("Новый пользователь создан:");
//        System.out.println(createdUser);
    }
}
