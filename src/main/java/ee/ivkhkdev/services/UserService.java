package ee.ivkhkdev.services;

import ee.ivkhkdev.interfaces.AppHelper;
import ee.ivkhkdev.interfaces.Service;
import ee.ivkhkdev.model.User;
import ee.ivkhkdev.interfaces.Repository;


import java.util.List;

public class UserService implements Service {
    private final Repository<User> repository;
    private AppHelper <User> appHelperUser;

    public UserService(AppHelper appHelperUser, Repository<User> repository) {
        this.appHelperUser = appHelperUser;
        this.repository = repository;
    }

    public boolean add() {
        User user = appHelperUser.create();
        if(user == null ) return false;
        users.add(user);
        try{
            repository.save(user);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    @Override
    public boolean print() {
        return false;
    }

    @Override
    public List list() {
        return users;
    }

    public boolean printList() {
        return users;
    }
}