package mapper;

import com.michal.eventmanagementsystem.model.PlaceAddress;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.openapitools.jackson.nullable.JsonNullable;

@Mapper(componentModel = "spring")
public interface JsonNullableMapper {
    @Named("unwrap")
    default String unwrap(JsonNullable<String> nullable) {
        return nullable.orElse(null);
    }

    @Named("wrap")
    default JsonNullable<String> wrap(String entity) {
        return JsonNullable.of(entity);
    }

    @Named("unwrap2")
    default PlaceAddress unwrap2(JsonNullable<PlaceAddress> nullable) {
        return nullable.orElse(null);
    }

    @Named("wrap2")
    default JsonNullable<PlaceAddress> wrap2(PlaceAddress entity) {
        return JsonNullable.of(entity);
    }

}
