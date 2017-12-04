package com.andkantor.snowfox.style;

import static java.lang.annotation.ElementType.PACKAGE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.CLASS;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.immutables.value.Value;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Target({PACKAGE, TYPE})
@Retention(CLASS)
@JsonSerialize
@JsonDeserialize
@Value.Style(
        get = {"*"},
        typeAbstract = {"Abstract*"},
        visibility = Value.Style.ImplementationVisibility.PUBLIC,
        overshadowImplementation = true,
        builderVisibility = Value.Style.BuilderVisibility.PUBLIC)
public @interface SnowFoxStyle {
}
