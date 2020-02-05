package com.caguilera.rockpaperscissors.util;

import io.restassured.response.ValidatableResponse;
import org.apache.commons.io.IOUtils;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.json.JSONException;
import org.json.JSONObject;
import org.skyscreamer.jsonassert.Customization;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.skyscreamer.jsonassert.comparator.CustomComparator;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;


/**
 * A Hamcrest matcher for matching JSON in JSON resource files.
 */
public class JsonMatcher extends BaseMatcher<ValidatableResponse> {

    private final Class<?> callerClass;

    private String expected;

    /**
     * @param callerClass The class that will call the matcher.
     */
    public JsonMatcher(Class<?> callerClass) {
        this.callerClass = callerClass;
    }

    private List<Customization> customizations = new ArrayList<>();

    @Override
    public boolean matches(Object item) {
        if (item instanceof String) {
            try {
                JSONAssert.assertEquals(
                        expected,
                        (String) item,
                        new CustomComparator(JSONCompareMode.STRICT, customizations.toArray(new Customization[]{}))
                );
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText(expected);
    }

    /**
     * @param jsonResourceFile The JSON resource file that this matcher will match against.
     * @return A matcher for matching JSON.
     * @throws RuntimeException with nested {@link IOException} If the resource file cannot be loaded.
     */
    public JsonMatcher forFile(String jsonResourceFile) {
        try {
            expected = loadFromClasspath(jsonResourceFile, callerClass);
            return this;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param jsonPath JSON path to ignore.
     * @return A matcher for matching JSON in JSON resource files ignoring the supplied JSON path.
     */
    public JsonMatcher ignoring(String jsonPath) {
        customizations.add(Customization.customization(jsonPath, this::ignore));
        return this;
    }

    public JsonMatcher expectingNotNull(String jsonPath) {
        customizations.add(Customization.customization(jsonPath, this::notNull));
        return this;
    }

    private <T> boolean ignore(T expected, T actual) {
        return true;
    }

    private <T> boolean notNull(T expected, T actual) {
        return JSONObject.NULL != expected;
    }

    public static JsonMatcher hasSameContentAs(Class<?> callerClass, String jsonResourceFile) {
        return new JsonMatcher(callerClass).forFile(jsonResourceFile);
    }

    public static String loadFromClasspath(String jsonFile, Class<?> callerClass) throws IOException {
        try (InputStream inputStream = callerClass.getResourceAsStream(jsonFile)) {
            if (inputStream == null) {
                String packageName = callerClass.getPackageName();
                throw new IOException(String.format("File [%s] not found in package [%s]", jsonFile, packageName));
            }
            return IOUtils.toString(inputStream, UTF_8);
        }
    }
}
