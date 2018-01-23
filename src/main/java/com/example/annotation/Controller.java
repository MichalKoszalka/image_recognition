package com.example.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import com.example.enums.Screen;

@Retention(RetentionPolicy.RUNTIME)
public @interface Controller {
	Screen screen();
	String path();
}
