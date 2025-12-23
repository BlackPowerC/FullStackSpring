package org.blackpowerc.training.fullstackspring;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@MappedSuperclass
public abstract class BaseEntity implements Serializable
{
    @Id
    @GeneratedValue(generator = "uuid2")
    protected UUID id ;

    @CreationTimestamp
    @Column(nullable = false)
    protected LocalDateTime createdAt ;

    @Column(nullable = true)
    @LastModifiedDate @UpdateTimestamp
    protected LocalDateTime updatedAt ;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false ;

        BaseEntity that = (BaseEntity) o ;

        return Objects.equals(id, that.id) ;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0 ;
    }
}
