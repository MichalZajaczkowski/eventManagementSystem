//package com.michal.eventmanagementsystem.mapper;
//
//
//import com.michal.eventmanagementsystem.dto.PlaceDto;
//import com.michal.eventmanagementsystem.model.Place;
//import com.michal.eventmanagementsystem.model.PlaceAddress;
//import org.openapitools.jackson.nullable.JsonNullable;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//@Component
//public class PlaceMapperImpl implements PlaceMapper {
//
//    @Autowired
//    private JsonNullableMapper jsonNullableMapper;
//
//    public Place PlaceDtoToPlace(PlaceDto placeDto) {
//        if (placeDto == null) {
//            return null;
//        }
//
//        String description = null;
//        String placeName = null;
//        PlaceAddress placeAddress = null;
//
//        description = jsonNullableMapper.unwrap(placeDto.getDescription());
//        placeName = jsonNullableMapper.unwrap(placeDto.getPlaceName());
//        placeAddress = jsonNullableMapper.unwrap2(placeDto.getPlaceAddress());
//
//        Place place = new Place(placeAddress, placeName, description);
//        return place;
//    }
//
//    public PlaceDto placeToPlaceDto(Place place) {
//        if (place == null) {
//            return null;
//        }
//
//        JsonNullable<String> description = null;
//        JsonNullable<String> placeName = null;
//        JsonNullable<PlaceAddress> placeAddress = null;
//
//        description = jsonNullableMapper.wrap(place.getDescription());
//        placeName = jsonNullableMapper.wrap(place.getPlaceName());
//        placeAddress = jsonNullableMapper.wrap2(place.getPlaceAddress());
//
//        PlaceDto placeDto = new PlaceDto(placeAddress, placeName, description);
//        return placeDto;
//    }
//
//    public void update(PlaceDto update, Place description) {
//        if (update == null) {
//            return;
//        }
//        if (update.hasPlaceAddress()) {
//            description.setPlaceAddress(jsonNullableMapper.unwrap2(update.getPlaceAddress()));
//        }
//        if (update.hasPlaceName()) {
//            description.setPlaceName(jsonNullableMapper.unwrap(update.getPlaceName()));
//        }
//        if (update.hasDescription()) {
//            description.setDescription(jsonNullableMapper.unwrap(update.getDescription()));
//        }
//    }
//}
