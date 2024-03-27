package com.example.Capstone.Project.user;

import com.example.Capstone.Project.enums.Role;
import com.example.Capstone.Project.exceptions.NotFoundException;
import com.example.Capstone.Project.exceptions.UnauthorizedException;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.UUID;

@Service
public class UserSRV {
    @Autowired
    UserDAO userDAO;

    @Autowired
    PasswordEncoder passwordEncoder;
    //@Autowired
    //EmailSender emailSender;

    public Page<User> getAll(int pageNumber, int pageSize, String orderBy){
        if (pageNumber > 20) pageSize = 20;
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(orderBy));
        return userDAO.findAll(pageable);
    }

    public User save(UserDTO userDTO) throws IOException{
        if(userDAO.existsByEmail(userDTO.email())) throw new BadRequestException("Email già esistente.");

        User user = new User(userDTO.name(), userDTO.surname(), userDTO.email(), passwordEncoder.encode(userDTO.password()), userDTO.getSeason(), Role.USER);
        return userDAO.save(user);
    }

    public User findById(UUID id) {
        return userDAO.findById(UUID.fromString(String.valueOf(id))).orElseThrow(() -> new NotFoundException(String.valueOf(id)));
    }

    public User findByEmail(String email) {
        return userDAO.findByEmail(email).orElseThrow(()-> new NotFoundException(email));
    }

    public User findByIdAndUpdate(UUID id, UserDTO userDTO, User user){
        User found = findById(UUID.fromString(String.valueOf(id)));
        if(!user.getId().equals(found.getId())) throw new UnauthorizedException("Utente con id sbagliato");
        found.setName(userDTO.name());
        found.setSurname(userDTO.surname());
        found.setEmail(userDTO.email());
        found.setPassword(userDTO.password());
        return userDAO.save(found);
    }

    public void deleteById(UUID id, User user){
        User found = findById(id);
        if(!user.getId().equals(UUID.fromString(String.valueOf(id)))) throw new UnauthorizedException("Utente con id sbagliato");
        userDAO.delete(found);
    }





}
