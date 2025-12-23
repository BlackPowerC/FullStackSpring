package org.blackpowerc.training.fullstackspring.housing;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.blackpowerc.training.fullstackspring.BaseEntity;

@Builder @Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "housing_locations")
public class HousingLocation extends BaseEntity
{
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
}
