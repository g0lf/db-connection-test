package ru.inpas.db.connection.test.entities;

import javax.persistence.*;

@Entity
@Table(name = "test",
        indexes = {
                @Index(columnList = "some_string_value", name = "someStringValueIndex"),
                @Index(columnList = "some_long_value", name = "someLongValueIndex")
        })
public class TestEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Basic
    @Column(name = "some_long_value")
    private long someLongValue;

    @Basic
    @Column(name = "some_string_value")
    private String someStringValue;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getSomeLongValue() {
        return someLongValue;
    }

    public void setSomeLongValue(long someLongValue) {
        this.someLongValue = someLongValue;
    }

    public String getSomeStringValue() {
        return someStringValue;
    }

    public void setSomeStringValue(String someStringValue) {
        this.someStringValue = someStringValue;
    }
}
