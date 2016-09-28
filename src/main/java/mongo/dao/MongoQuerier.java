package mongo.dao;

import java.util.HashMap;
import java.util.List;

public interface MongoQuerier {

    public List<HashMap<String, Object>> query();

    public HashMap<String, Object> defineRow();
}
