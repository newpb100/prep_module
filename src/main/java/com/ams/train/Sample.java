package com.ams.train;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.aeonbits.owner.ConfigFactory;
import org.apache.log4j.Logger;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

@EqualsAndHashCode
@Setter
@Getter
@lombok.Data
public class Sample {
    public static Logger logger = Logger.getLogger(Sample.class);
    private String f1;
    public int a;
    public ObjectMapper om;

    public Sample(String f1, int a) {
        this.f1 = f1;
        this.a = a;
        om = new ObjectMapper();

        //log4j slf4j
        logger.info("inside constructor");
        //hamcrest
        assertThat(this.f1, is(equalTo("test string")));
    }

    public void useOwnerToCreateCfg(){
        //owner
        ServerConfig cfg = ConfigFactory.create(ServerConfig.class);
        System.out.println(cfg.host() + " : " + cfg.port());
    }

    public void useJacksonToCreateObj() {
        String car = "{\"color\" : \"black\", \"type\" : \"fiat\" }";
        JsonNode jn = null;
        try {
             jn = om.readTree(car);
        } catch (Exception e) {
        }
        System.out.println(jn.get("color").asText());
    }
}
