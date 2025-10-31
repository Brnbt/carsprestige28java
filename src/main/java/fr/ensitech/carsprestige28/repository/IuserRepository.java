package fr.ensitech.carsprestige28.repository;

import fr.ensitech.carsprestige28.entity.User;

import java.util.List;

public interface IuserRepository {

    void addUser(User user) throws Exception;

    User getUserbyEmail(String email) throws Exception;

    User getUserbyId(Integer id) throws Exception;

    void updateUser(User user) throws Exception;

    void deleteUser(User user) throws Exception;


    List<User> getAllUsers() throws Exception;
}
