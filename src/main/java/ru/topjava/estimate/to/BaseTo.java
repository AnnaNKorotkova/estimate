package ru.topjava.estimate.to;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import ru.topjava.estimate.HasId;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
public class BaseTo implements HasId {

//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    protected Long id;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}
