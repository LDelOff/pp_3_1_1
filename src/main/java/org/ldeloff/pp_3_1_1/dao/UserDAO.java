package org.ldeloff.pp_3_1_1.dao;

import org.ldeloff.pp_3_1_1.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface UserDAO extends PagingAndSortingRepository<User, Long> {
    List<User> allUser();
    void add(User user);
    void delete(long id);
    void edit(User user);
    User getById(long id);
}
