package org.blackpowerc.training.fullstackspring.housing;

import jakarta.persistence.Column;
import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.blackpowerc.training.fullstackspring.BaseEntity;

/**
 * Une soumission pour avoir une location.
 */
@Entity
@Table(name = "applications")
public class Application extends BaseEntity
{
    @NotBlank
    @Column(nullable = false)
    private String lastName ;

    @NotBlank
    @Column(nullable = false)
    private String firstName ;

    @Email
    @NotBlank
    @Column(nullable = false)
    private String email ;

    @ManyToOne(optional = false)
    @JoinColumn(
            name = "location_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "location_application_fk", value = ConstraintMode.CONSTRAINT)
    )
    private HousingLocation location ;

    public String getLastName() {
        return lastName ;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName ;
    }

    public String getFirstName() {
        return firstName ;
    }

    public void setFirstName(String firstname) {
        this.firstName = firstname ;
    }

    public String getEmail() {
        return email ;
    }

    public void setEmail(String email) {
        this.email = email ;
    }

    public HousingLocation getLocation() {
        return location ;
    }

    public void setLocation(HousingLocation location) {
        this.location = location ;
    }
}
