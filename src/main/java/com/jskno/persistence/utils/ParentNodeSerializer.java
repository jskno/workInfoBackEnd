//@formatter:off
/**
 *  $$Id$$
 *       . * .
 *     * RRRR  *    Copyright (c) 2018 EUIPO: European Union Intellectual
 *   .   RR  R   .  Property Office (trade marks and designs)
 *   *   RRR     *
 *    .  RR RR  .   ALL RIGHTS RESERVED
 *     * . _ . *
 */
//@formatter:on
package com.jskno.persistence.utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.jskno.persistence.entity.InfoNode;

import java.io.IOException;

/**
 * Created by Jose on 20/01/18.
 */
public class ParentNodeSerializer extends JsonSerializer<InfoNode> {

    @Override
    public void serialize(InfoNode infoNode, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
            throws IOException, JsonProcessingException {

        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("id", infoNode.getId());
        jsonGenerator.writeStringField("title", infoNode.getTitle());
        jsonGenerator.writeEndObject();
    }
}
