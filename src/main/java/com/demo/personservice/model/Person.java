package com.demo.personservice.model;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UuidGenerator;
import org.hibernate.annotations.UuidGenerator.Style;
import org.hibernate.type.SqlTypes;

@Data
@EqualsAndHashCode(exclude = {"documents", "addresses", "contacts"})
@ToString(exclude = {"documents", "addresses", "contacts"})
@Entity
@Table(name = "persons")
public class Person {

    @Id
    @GeneratedValue
    @UuidGenerator(style = Style.AUTO)
    @Column(name = "id", columnDefinition = "char(36)")
    @JdbcTypeCode(SqlTypes.CHAR)
    private UUID id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "enabled")
    private Boolean enabled;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Document> documents = new LinkedHashSet<>();

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Address> addresses = new LinkedHashSet<>();

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Contact> contacts = new LinkedHashSet<>();

    public void addDocument(final Document document) {
        document.setPerson(this);
        documents.add(document);
    }

    public void addAddress(final Address address) {
        address.setPerson(this);
        addresses.add(address);
    }

    public void addContact(final Contact contact) {
        contact.setPerson(this);
        contacts.add(contact);
    }

}