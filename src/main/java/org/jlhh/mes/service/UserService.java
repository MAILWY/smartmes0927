package org.jlhh.mes.service;

import org.jlhh.mes.repository.UserReposiotry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wangjialin on 2017/9/17.
 */
@Service
public class UserService {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private UserReposiotry userReposiotry;


    public UserReposiotry getUserReposiotry() {
        return userReposiotry;
    }

    public void setUserReposiotry(UserReposiotry userReposiotry) {
        this.userReposiotry = userReposiotry;
    }
}
