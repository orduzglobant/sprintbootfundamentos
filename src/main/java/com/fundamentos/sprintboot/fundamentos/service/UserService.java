package com.fundamentos.sprintboot.fundamentos.service;

import com.fundamentos.sprintboot.fundamentos.entity.User;
import com.fundamentos.sprintboot.fundamentos.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public void saveTransactional(List<User> users){
        users.stream().peek(user -> log.info("Usuario insertado"+user))
                .forEach(userRepository::save);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    public User update(User user, Long id) {
        return userRepository.findById(id)
                .map(
                    user1 -> {
                                user1.setEmail(user.getEmail());
                                user1.setBirthDate(user.getBirthDate());
                                user1.setName(user.getName());
                                return userRepository.save(user1);
                            }
                    ).orElseThrow(()->new RuntimeException("No se encontro usuario a modificar"));
    }

    public List<User> findAll(PageRequest of) {
        return userRepository.findAll(of).getContent();

    }


    /*public List<User> getAllPagination(int page, int size) {
        return userRepository.findAll(PageRequest.of(page, size)).getContent();
    }*/

}
