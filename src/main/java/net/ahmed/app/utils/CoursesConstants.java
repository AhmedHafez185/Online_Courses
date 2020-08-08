package net.ahmed.app.utils;

import javax.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class CoursesConstants {
	@Autowired
	static
	ServletContext servletContext;
	final public static String IMAGES = servletContext.getRealPath("/") + "resources\\images\\";
	final public static String CV_FILES = servletContext.getRealPath("/") + "resources\\cv_files\\";
	final public static String PAGES_IMAGES = "\\resources\\img\\";
	final public static String COURSE_VIDEOS = servletContext.getRealPath("/") + "resources\\courses_video\\";

}
