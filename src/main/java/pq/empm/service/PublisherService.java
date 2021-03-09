package pq.empm.service;

import pq.empm.model.Publisher;

public interface PublisherService {
    void regist(Publisher publisher);

    Publisher login(String name, String pwd);

    Publisher updateInfo(Publisher publisher);

    Publisher queryInfo(String name);
}
