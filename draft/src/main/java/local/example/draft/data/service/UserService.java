package local.example.draft.data.service;

import java.util.Optional;

import local.example.draft.data.entity.User;
import local.example.draft.data.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    public User create(User entity) {
        return repository.save(entity);
    }

    public Optional<User> read(Integer id) {
        return repository.findById(id);
    }

    public Page<User> list(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public User update(User entity) {
        return repository.save(entity);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    public int count() {
        return (int) repository.count();
    }
}
