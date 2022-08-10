package de.gie.tool.commontasks.url.alias.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Alias {
    @Id
    @SequenceGenerator(
            name = "alias_sequence",
            sequenceName = "alias_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "alias_sequence"
    )

    private Long id;
    private String longUrl;
    private String aliasName;
    private LocalDate creationDate;
    private LocalDate expirationDate;

    public Alias() {
    }

    public Alias(String longUrl, String aliasName) {
        this.longUrl = longUrl;
        this.aliasName = aliasName;
        this.creationDate = LocalDate.now();
        this.expirationDate = creationDate.plusDays(3);       // Duration time default is 3 Days
    }

    public Alias(String longUrl, String aliasName, int durationInDays) {
        this.longUrl = longUrl;
        this.aliasName = aliasName;
        this.creationDate = LocalDate.now();
        this.expirationDate = creationDate.plusDays(durationInDays);
    }

    public String getLongUrl() {
        return longUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }

    public String getAliasName() {
        return aliasName;
    }

    public void setAliasName(String aliasName) {
        this.aliasName = aliasName;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public void setExpirationDate(int duratioInDays) {
        this.expirationDate = this.creationDate.plusDays(duratioInDays);
    }

    @Override
    public String toString() {
        return "Alias{" +
                "id=" + id +
                ", longUrl='" + longUrl + '\'' +
                ", aliasName='" + aliasName + '\'' +
                ", creationDate=" + creationDate +
                ", expirationDate=" + expirationDate +
                '}';
    }

}

