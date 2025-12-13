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
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Builder @Entity
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

    @Column(nullable = true)
    @LastModifiedDate @UpdateTimestamp
    private LocalDateTime updatedAt ;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Integer getAvailableUnits() {
        return availableUnits;
    }

    public void setAvailableUnits(Integer availableUnits) {
        this.availableUnits = availableUnits;
    }

    public Boolean getWifi() {
        return wifi;
    }

    public void setWifi(Boolean wifi) {
        this.wifi = wifi;
    }

    public Boolean getLaundry() {
        return laundry;
    }

    public void setLaundry(Boolean laundry) {
        this.laundry = laundry;
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
        if (o == null || getClass() != o.getClass()) return false;

        HousingLocation that = (HousingLocation) o;

        return Objects.equals(this.id, that.id) ;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.id) ;
    }
}
