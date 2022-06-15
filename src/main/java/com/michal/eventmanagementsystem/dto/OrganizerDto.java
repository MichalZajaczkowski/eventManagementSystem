package com.michal.eventmanagementsystem.dto;

import lombok.*;
import org.openapitools.jackson.nullable.JsonNullable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class OrganizerDto {
    private Long id;
    private JsonNullable <String> name;
    private JsonNullable <String> description;
}
