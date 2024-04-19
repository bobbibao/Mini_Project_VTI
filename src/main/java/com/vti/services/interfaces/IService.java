package com.vti.services.interfaces;

import java.util.List;
import java.util.Optional;

public interface IService<S, P> {
	boolean insert(S s);
	boolean update(S s);
	boolean deleteById(P p);
	Optional<S> getById(P p);
	List<S> getAll();
}
