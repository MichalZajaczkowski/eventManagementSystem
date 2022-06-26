package com.michal.eventmanagementsystem.dto;

import com.michal.eventmanagementsystem.model.Status;
import lombok.*;
import org.openapitools.jackson.nullable.JsonNullable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class StatusDto {

    private Long id;
    private JsonNullable<String> description;

    public boolean hasDescription() {
        return description != null && description.isPresent();
    }

    public Status toStatus() {
        Status status = new Status();
        status.setId(id);
        status.setDescription(description.orElse(null));
        return status;
    }
}
