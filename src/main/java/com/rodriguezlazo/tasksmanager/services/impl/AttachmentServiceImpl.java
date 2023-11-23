package com.rodriguezlazo.tasksmanager.services.impl;

import com.rodriguezlazo.tasksmanager.dtos.NewAttachmentDTO;

import com.rodriguezlazo.tasksmanager.entities.Attachment;
import com.rodriguezlazo.tasksmanager.entities.Project;
import com.rodriguezlazo.tasksmanager.entities.Task;
import com.rodriguezlazo.tasksmanager.repositories.AttachmentRepository;
import com.rodriguezlazo.tasksmanager.services.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class AttachmentServiceImpl implements AttachmentService {

    @Autowired
    private AttachmentRepository repository;

    @Transactional(rollbackFor = Exception.class)
    public Attachment saveAttachment(NewAttachmentDTO dto, Task task) {
        Attachment attachment = new Attachment();
        attachment.setFile_name(dto.getFile_name());
        attachment.setFile_type(dto.getFile_type());
        attachment.setFile_size(dto.getFile_size());
        attachment.setTask(task);
        return repository.save(attachment);
    }

    @Override
    public Optional<Attachment> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Attachment save(NewAttachmentDTO dto) {
        return null;
    }

    @Override
    public Iterable<Attachment> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}
