package com.pluralsight.conferencedemo.models.projections;

import com.pluralsight.conferencedemo.models.Session;
import com.pluralsight.conferencedemo.models.Speaker;
import org.springframework.data.rest.core.config.Projection;

import java.util.List;

@Projection(name = "sessionsDetail", types = { Session.class })  //types kismina projeksiyonda gozukmesini istedigimiz seyleri ekleriz
public interface SessionsDetail {

    String getSessionName();
    String getSessionDescription();
    Integer getSessionLength();
    List<Speaker> getSpeakers();

}
