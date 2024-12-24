package com.tom.dao;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UserDao {
    private List<User> users = new ArrayList<>();

    // 添加用户
    public void addUser(User user) {
        users.add(user);
    }

    // 根据 ID 查找用户
    public Optional<User> findUserById(long id) {
        return users.stream()
                .filter(user -> user.getId() == id)
                .findFirst();
    }

    // 根据 ID 删除用户
    public void deleteUserById(long id) {
        users.removeIf(user -> user.getId() == id);
    }

    // 根据 ID 修改用户信息
    public void updateUserById(long id, User updatedUser) {
        findUserById(id).ifPresent(user -> {
            user.setName(updatedUser.getName());
            user.setAge(updatedUser.getAge());
            user.setHeight(updatedUser.getHeight());
            user.setWeight(updatedUser.getWeight());
        });
    }
}
