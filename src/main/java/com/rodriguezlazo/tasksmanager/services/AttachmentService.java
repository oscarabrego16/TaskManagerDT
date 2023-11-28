package com.rodriguezlazo.tasksmanager.services;

import com.rodriguezlazo.tasksmanager.dtos.NewAttachmentDTO;
import com.rodriguezlazo.tasksmanager.entities.Attachment;
import com.rodriguezlazo.tasksmanager.entities.Task;

public interface AttachmentService extends GenericService<Attachment, NewAttachmentDTO> {
    Attachment saveAttachment(NewAttachmentDTO dto, Task task);

}
