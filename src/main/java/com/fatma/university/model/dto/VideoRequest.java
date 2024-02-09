package com.fatma.university.model.dto;

import com.fatma.university.model.entity.Category;
import com.fatma.university.model.entity.Source;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VideoRequest {
    private byte[] videoByte;
    private long categoryId;
    private long sourceId;
    @ManyToOne
    private Category category;
    @ManyToOne
    private Source source;
}
