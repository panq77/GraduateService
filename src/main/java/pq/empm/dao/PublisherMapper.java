package pq.empm.dao;

import pq.empm.model.Publisher;

public interface PublisherMapper {
    int insert(Publisher record);
    int update(Publisher publisher);
    Publisher queryByName(String name);
}