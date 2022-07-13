package com.pluralsight.conferencedemo.repositories.handler;

import com.pluralsight.conferencedemo.models.Speaker;
import com.pluralsight.conferencedemo.repositories.SpeakerJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleAfterSave;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolationException;
import javax.xml.bind.ValidationException;

@Component
@RepositoryEventHandler
public class SpeakerEventHandler {

    @Autowired
    private SpeakerJpaRepository speakerRepository;

    @HandleBeforeCreate
    public void handleSpeakerCreate(Speaker speaker) {
        Speaker foundSpeaker = speakerRepository.findFirstByFirstName(speaker.getFirstName());
        if (foundSpeaker != null) {
            System.out.println("Speaker already exists:" + foundSpeaker.getFirstName());
            throw new ConstraintViolationException("Speaker already exists", null);
        }
    }
}
