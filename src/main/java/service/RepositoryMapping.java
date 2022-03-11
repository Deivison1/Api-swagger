package service;

import org.springframework.web.bind.annotation.RequestMethod;

public @interface RepositoryMapping {

	String value();

	RequestMethod method();

}
