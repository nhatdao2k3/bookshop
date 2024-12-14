package com.group2.bookshopwebsite.service;

import com.group2.bookshopwebsite.entity.Contact;

import java.util.List;
import org.springframework.data.domain.Sort;

public interface ContactService {
    Contact saveContact(Contact contact);

    List<Contact> getAllContacts();
    List<Contact> getAllContacts(Sort sort);

    void deleteById(Long id);

    Contact getContactById(Long id);
}
