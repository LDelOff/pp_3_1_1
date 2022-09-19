package org.ldeloff.pp_3_1_1.dao;

import org.ldeloff.pp_3_1_1.model.User;

import java.util.List;

public interface UserDAO{
    List<User> allUser();
    void add(User user);
    void delete(long id);
    void edit(User user);
    User getById(long id);
}
