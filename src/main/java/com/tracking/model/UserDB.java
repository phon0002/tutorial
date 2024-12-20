package com.tracking.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;

@EnableScan
@DynamoDBTable(tableName = "YourTableName")
public class UserDB implements Persistable<String> {

    @Id
    private String id;

    private String attributeName;

    // Getters and setters

    @Override
    @DynamoDBHashKey
    public String getId() {
        return this.id;
    }

    @Override
    public boolean isNew() {
        // Implement this method as needed
        return id == null;
    }
}

