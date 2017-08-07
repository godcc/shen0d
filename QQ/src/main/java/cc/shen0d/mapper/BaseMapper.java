package cc.shen0d.mapper;

import java.util.List;

public interface BaseMapper<T> {
	T getOne(Long id);

	List<T> getAll();

	void insert(T t);

	void update(T t);

	void delete(Long id);

}
