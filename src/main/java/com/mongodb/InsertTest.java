package com.mongodb;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.Arrays;

/**
 * Created by JagdambikaS on 1/27/2016.
 */
public class InsertTest {
    public static void main(String[] args) {
        MongoClient mongoClient = new MongoClient();
        MongoDatabase database = mongoClient.getDatabase("course");
        MongoCollection<Document> courseCollection = database.getCollection("courses");

        courseCollection.drop();

        Document coursera = new Document("name", "Coursera")
                .append("type", "Online Course");

        Document railsCast = new Document("name", "Rails Cast")
                .append("type", "Online Course");

        courseCollection.insertMany(Arrays.asList(coursera, railsCast));

        System.out.println(courseCollection.find().first());
        System.out.println(courseCollection.find(new Document("name", "Coursera")));
        System.out.println(courseCollection.count(new Document("name", "Rails Cast")));
    }
}
