package com.chc.tanda.concepthubclassessbackend.assistors;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author Zeeshan Adil
 * Created by mhmdz on Jun 10, 2020
 */
public class CompositeIdClass implements Serializable {

    private Integer id;
    private String serial;

    public CompositeIdClass() {
    }

    public CompositeIdClass(Integer id, String serial) {
        this.id = id;
        this.serial = serial;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        CompositeIdClass serial1 = (CompositeIdClass) o;
        if (id != serial1.id)
            return false;
        return serial == serial1.serial;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, serial);
    }
}
