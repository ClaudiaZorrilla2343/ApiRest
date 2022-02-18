package com.proof.app.sofka.services;

import com.proof.app.sofka.models.dao.IUserDao;
import com.proof.app.sofka.models.entities.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImpl implements IEntityService<User>{

    @Autowired
    private IUserDao iUserDao;

    /**
     *Para sobrescribir metodos(override)
     */
    @Override
    public List<User> findAll() {
        return (List<User>) iUserDao.findAll();
    }

    @Override
    public User findById(Long id) {
        return iUserDao.findById(id).orElse(null);
    }

    @Override
    public void save(User entity) {
        iUserDao.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        iUserDao.deleteById(id);
    }
}
