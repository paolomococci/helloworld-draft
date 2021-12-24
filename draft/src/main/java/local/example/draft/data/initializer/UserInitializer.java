package local.example.draft.data.initializer;

import com.vaadin.flow.spring.annotation.SpringComponent;

import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import local.example.draft.data.Role;
import local.example.draft.data.entity.User;
import local.example.draft.data.repository.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringComponent
public class UserInitializer {

    @Bean
    public CommandLineRunner loadData(
        PasswordEncoder passwordEncoder, 
        UserRepository userRepository
    ) {
        return args -> {
            Logger logger = LoggerFactory.getLogger(getClass());
            if (userRepository.count() != 0L) {
                logger.info("Using existing database");
                return;
            }

            logger.info("Generating demo data");

            logger.info("Generating two User entities.");

            /* normal user */
            User user = new User();
            user.setName("John Under");
            user.setUsername("johnunder");
            user.setHashedPassword(
                    passwordEncoder.encode("jo4nun6e5")
            );
            user.setRoles(Collections.singleton(Role.USER));
            userRepository.save(user);

            /* administrator user */
            User admin = new User();
            admin.setName("Amy Boss");
            admin.setUsername("amyboss");
            admin.setHashedPassword(
                    passwordEncoder.encode("amyb055")
            );
            admin.setRoles(Stream.of(Role.USER, Role.ADMIN).collect(Collectors.toSet()));
            userRepository.save(admin);

            logger.info("Generated demo data");
        };
    }
}
