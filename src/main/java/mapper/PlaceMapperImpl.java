package mapper;


import com.michal.eventmanagementsystem.dto.PlaceDto;
import com.michal.eventmanagementsystem.model.Place;
import com.michal.eventmanagementsystem.model.PlaceAddress;
import org.openapitools.jackson.nullable.JsonNullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PlaceMapperImpl implements PlaceMapper {

    @Autowired
    private JsonNullableMapper jsonNullableMapper;


    @Override
    public Place map(PlaceDto entity) {
        if (entity == null) {
            return null;
        }

        String description = null;
        String placeName = null;
        String placeAddress = null;

        description = jsonNullableMapper.unwrap(entity.getDescription());
        placeName = jsonNullableMapper.unwrap(entity.getPlaceName());
        placeAddress = String.valueOf(jsonNullableMapper.unwrap2(entity.getPlaceAddress()));

        Place place = new Place(placeAddress, placeName, description);
        return place;
    }

    @Override
    public PlaceDto map(Place entity) {
        if (entity == null) {
            return null;
        }

        JsonNullable<String> description = null;
        JsonNullable<String> placeName = null;
        JsonNullable<PlaceAddress> placeAddress = null;

        description = jsonNullableMapper.wrap(entity.getDescription());
        placeName = jsonNullableMapper.wrap(entity.getPlaceName());
        placeAddress = jsonNullableMapper.wrap2(entity.getPlaceAddress());

        PlaceDto placeDto = new PlaceDto(placeAddress, placeName, description);
        return placeDto;
    }

    @Override
    public void update(PlaceDto update, Place description) {
        if (update == null) {
            return;
        }
        if (update.hasPlaceAddress()) {
            description.setPlaceAddress(jsonNullableMapper.unwrap2(update.getPlaceAddress()));
        }
        if (update.hasPlaceName()) {
            description.setPlaceName(jsonNullableMapper.unwrap(update.getPlaceName()));
        }
        if (update.hasDescription()) {
            description.setDescription(jsonNullableMapper.unwrap(update.getDescription()));
        }
    }
}
