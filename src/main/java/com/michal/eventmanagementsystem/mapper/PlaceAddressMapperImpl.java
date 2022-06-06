//package com.michal.eventmanagementsystem.mapper;
//
//import com.michal.eventmanagementsystem.dto.PlaceAddressDto;
//import com.michal.eventmanagementsystem.model.PlaceAddress;
//import org.openapitools.jackson.nullable.JsonNullable;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//@Component
//public class PlaceAddressMapperImpl  implements PlaceAddressMapper {
//
//    @Autowired
//    private JsonNullableMapper jsonNullableMapper;
//
//    @Override
//    public PlaceAddress placeAddressDtoToPlaceAddress(PlaceAddressDto placeAddressDto) {
//        if (placeAddressDto == null) {
//            return null;
//        }
//
//        String country = null;
//        String city = null;
//        String streetName = null;
//        String streetNumber = null;
//        String zipCode = null;
//        String phone = null;
//
//        country = jsonNullableMapper.unwrap(placeAddressDto.getCountry());
//        city = jsonNullableMapper.unwrap(placeAddressDto.getCity());
//        streetName = jsonNullableMapper.unwrap(placeAddressDto.getStreetName());
//        streetNumber = jsonNullableMapper.unwrap(placeAddressDto.getStreetNumber());
//        zipCode = jsonNullableMapper.unwrap(placeAddressDto.getZipCode());
//        phone = jsonNullableMapper.unwrap(placeAddressDto.getPhone());
//
//        PlaceAddress placeAddress = new PlaceAddress(country, city, streetName, streetNumber, zipCode, phone);
//        return placeAddress;
//    }
//
//    @Override
//    public PlaceAddressDto placeAddressToPlaceAddressDto(PlaceAddress placeAddress) {
//        if (placeAddress == null) {
//            return null;
//        }
//
//        JsonNullable<String> country = null;
//        JsonNullable<String> city = null;
//        JsonNullable<String> streetName = null;
//        JsonNullable<String> streetNumber = null;
//        JsonNullable<String> zipCode = null;
//        JsonNullable<String> phone = null;
//
//        country = jsonNullableMapper.wrap(placeAddress.getCountry());
//        city = jsonNullableMapper.wrap(placeAddress.getCity());
//        streetName = jsonNullableMapper.wrap(placeAddress.getStreetName());
//        streetNumber = jsonNullableMapper.wrap(placeAddress.getStreetNumber());
//        zipCode = jsonNullableMapper.wrap(placeAddress.getZipCode());
//        phone = jsonNullableMapper.wrap(placeAddress.getPhone());
//
//        PlaceAddressDto placeAddressDto = new PlaceAddressDto(country, city, streetName, streetNumber, zipCode, phone);
//        return placeAddressDto;
//
//    }
//    @Override
//    public void updatePlaceAddress(PlaceAddressDto update, PlaceAddress description) {
//
//        if (update == null) {
//            return;
//        }
//
//        if (update.hasCountry()) {
//            description.setCountry(jsonNullableMapper.unwrap(update.getCountry()));
//        }
//        if (update.hasCity()) {
//            description.setCity(jsonNullableMapper.unwrap(update.getCity()));
//        }
//        if (update.hasStreetName()) {
//            description.setStreetName(jsonNullableMapper.unwrap(update.getStreetName()));
//        }
//        if (update.hasStreetNumber()) {
//            description.setStreetNumber(jsonNullableMapper.unwrap(update.getStreetNumber()));
//        }
//        if (update.hasZipCode()) {
//            description.setZipCode(jsonNullableMapper.unwrap(update.getZipCode()));
//        }
//        if (update.hasPhone()) {
//            description.setPhone(jsonNullableMapper.unwrap(update.getPhone()));
//        }
//    }
//}
