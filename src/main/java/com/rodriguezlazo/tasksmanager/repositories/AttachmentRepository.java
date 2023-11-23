package com.rodriguezlazo.tasksmanager.repositories;

import com.rodriguezlazo.tasksmanager.entities.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttachmentRepository extends JpaRepository<Attachment,Long> {
    //Attachment findAttachmentByTask(Long id);
}
