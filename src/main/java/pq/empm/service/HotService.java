package pq.empm.service;

import java.util.List;
import java.util.Map;

public interface HotService {
    List<Map> query(String text);

    int queryClickTimesByType(String text);
}
