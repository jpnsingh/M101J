package com.mongodb;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.BsonDocument;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.Arrays;
import java.util.Date;

/**
 * Created by JagdambikaS on 1/27/2016.
 */
public class HelloWorldMongoDBStyle {
    public static void main(String[] args) {
        MongoClientOptions clientOptions = MongoClientOptions.builder().connectionsPerHost(100).build();
        MongoClient mongoClient = new MongoClient(new ServerAddress(), clientOptions);

        MongoDatabase database = mongoClient.getDatabase("test");
        MongoCollection<Document> collection = database.getCollection("names");
        MongoCollection<BsonDocument> names = database.getCollection("names", BsonDocument.class);

        Document document = new Document()
                .append("str", "MongoDB, Hello")
                .append("int", 42)
                .append("long", 1L)
                .append("double", 1.1)
                .append("bool", false)
                .append("date", new Date())
                .append("objectId", new ObjectId())
                .append("null", null)
                .append("embededDoc", new Document("x", 0))
                .append("lis", Arrays.asList(1, 2, 3));

        String str = document.getString("str");
        int i = document.getInteger("int");
    }
}
