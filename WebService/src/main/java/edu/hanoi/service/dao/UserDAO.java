package edu.hanoi.service.dao;

import edu.hanoi.service.model.User;
import org.apache.tomcat.websocket.WsSession;

import java.util.List;

public interface UserDAO {
    public List<User> list();
}
