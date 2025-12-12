package org.blackpowerc.training.fullstackspring.housing;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder @Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "housing_locations")
public class HousingLocation
{
    @Id
    @GeneratedValue(generator = "uuid2")
    private UUID id ;

    @Version @JsonIgnore
    private Integer version ;

    @Column(nullable = false)
    private String name ;

    @Column(nullable = false)
    private String city ;

    @Column(nullable = false)
    private String state ;

    @Column(nullable = false)
    private String photo ;

    private Integer availableUnits ;

    private Boolean wifi ;

    private Boolean laundry ;

    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime createdAt ;

    @UpdateTimestamp
    @Column(nullable = true)
    private LocalDateTime updatedAt ;
}
