package com.epam.Common;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.Collections;
import java.util.HashSet;
import java.util.TreeSet;

/**
 * Created on 16/04/16.
 *
 * @author Vladislav Boboshko
 */
public class StringToHashtags {
    public static HashSet<String> proceed(String jsonWithHashtags) {
        HashSet<String> result = new HashSet<>();
        try {
            JSONObject income = ((JSONObject) new JSONParser().parse(jsonWithHashtags));
            JSONArray tags = (JSONArray) income.get("hashtags");
            tags.forEach(o -> result.add((String) o));
            return result;
        } catch (ParseException e) {
            return new HashSet<>();
        }
    }
}
