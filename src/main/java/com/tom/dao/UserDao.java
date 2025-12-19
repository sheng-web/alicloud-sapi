package com.tom.dao;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// 仅保留@Component（声明为Spring组件），移除@Data
@Component
public class UserDao {
    private List<User> users = new ArrayList<>();

    // 添加用户（补充空值校验，避免NullPointerException）
    public void addUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("用户不能为null");
        }
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
        if (updatedUser == null) {
            throw new IllegalArgumentException("更新的用户信息不能为null");
        }
        findUserById(id).ifPresent(user -> {
            user.setName(updatedUser.getName());
            user.setAge(updatedUser.getAge());
            user.setHeight(updatedUser.getHeight());
            user.setWeight(updatedUser.getWeight());
        });
    }
}