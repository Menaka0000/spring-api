package com.zincat.springapi.contactPerson.service.impl;

import com.zincat.springapi.common.entity.ContactPerson;
import com.zincat.springapi.common.repository.ContactPersonRepo;
import com.zincat.springapi.contactPerson.service.ContactPersonService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

/**
 * author: Menaka Lakshan
 */

@Service
@Transactional
public class ContactPersonServiceImpl implements ContactPersonService {

    private final ContactPersonRepo contactPersonRepo;

    public ContactPersonServiceImpl(ContactPersonRepo contactPersonRepo) {
        this.contactPersonRepo = contactPersonRepo;
    }

    @Override
    public ContactPerson saveContactPerson(ContactPerson contactPerson) {
        return contactPersonRepo.save(contactPerson);
    }
}
