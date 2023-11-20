package ru.kata.spring.boot_security.demo.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.repository.RoleRepository;
import ru.kata.spring.boot_security.demo.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class InitUsers {

    @Autowired
    private BCryptPasswordEncoder encoder;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;


    @EventListener(ApplicationReadyEvent.class)
    @Transactional
    public void addUsers(){
        roleRepository.deleteAll();
        userRepository.deleteAll();

        Role roleAdmin = roleRepository.save(new Role(1,"ROLE_ADMIN"));
        Role roleUser = roleRepository.save(new Role(2, "ROLE_USER"));

        userRepository.save(new User(
                List.of(roleAdmin),
                "admin",
                encoder.encode("admin"),
                22,
                "admin@mail.ru"
        ));

        userRepository.save(new User(
                List.of(roleUser),
                "user",
                encoder.encode("user"),
                22,
                "user@mail.ru"
        ));
    }
}
