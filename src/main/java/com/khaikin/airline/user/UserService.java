package com.khaikin.airline.user;

import java.util.List;

public interface UserService {

    public List<UserDto> getAllUsers();

    public UserDto getUserById(int userId);

    public User createUser(User user);

    public void deleteUserById(int userId);

}
