/*
package cep.gouv.ht.Models;

import com.google.gson.Gson;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class MyConverter implements AttributeConverter<JsonCandidat, String> {

    private final static Gson GSON = new Gson();

    @Override
    public String convertToDatabaseColumn(JsonCandidat mjo) {
        return GSON.toJson(mjo);
    }

    @Override
    public JsonCandidat convertToEntityAttribute(String dbData) {
        return GSON.fromJson(dbData, JsonCandidat.class);
    }
}
*/
