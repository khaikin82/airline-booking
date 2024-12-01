package com.khaikin.airline.user;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserDto> userDtos = users.stream().map(user -> modelMapper.map(user, UserDto.class))
                .collect(Collectors.toList());
        return userDtos;
    }

    @Override
    public UserDto getUserById(int userId) {
        User user = userRepository.getReferenceById(userId);
        UserDto userDto = modelMapper.map(user, UserDto.class);
        return userDto;
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUserById(int userId) {
        if (!userRepository.existsById(userId)) {
            throw new UsernameNotFoundException("User not found with id " + userId);
        }
        userRepository.deleteById(userId);
    }
}
