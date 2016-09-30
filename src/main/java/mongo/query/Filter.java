package mongo.query;

import java.util.List;

import org.bson.Document;

import com.mongodb.client.FindIterable;

public interface Filter {
    public List<Document> filtrate();

    public void setDocuments(FindIterable<Document> documents);

}
