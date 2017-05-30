package com.github.alebabai.jmp2k17.jpa.converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.alebabai.jmp2k17.jpa.domain.Meta;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class MetaConverter implements AttributeConverter<Meta, String> {

    private final ObjectMapper mapper;

    public MetaConverter() {
        this.mapper = new ObjectMapper();
    }

    @Override
    public String convertToDatabaseColumn(Meta attribute) {
        try {
            return mapper.writeValueAsString(attribute);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Meta convertToEntityAttribute(String dbData) {
        try {
            return mapper.readValue(dbData, Meta.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
