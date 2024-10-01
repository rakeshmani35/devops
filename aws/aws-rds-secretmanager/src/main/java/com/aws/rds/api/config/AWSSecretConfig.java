package com.aws.rds.api.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.secretsmanager.SecretsManagerClient;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueRequest;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueResponse;

import javax.sql.DataSource;

@Configuration
public class AWSSecretConfig {

    @Bean
    public DataSource dataSource() throws JsonProcessingException {
        String secret = getSecret();

        JsonNode secretNode = new ObjectMapper().readTree(secret);
        String username = secretNode.get("username").asText();
        String password = secretNode.get("password").asText();
        String host = secretNode.get("host").asText();
        String port = secretNode.get("port").asText(); //3306
        String dbname = secretNode.get("dbname").asText();
        String dbconnection = secretNode.get("engine").asText(); // mysql
        //jdbc:mysql://host:3306/dbname
        String url = "jdbc:" + dbconnection + "://" + host + ":" + port + "/" + dbname;

        // create datasource
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        return dataSource;
    }

    public static String getSecret() {

        String secretName = "mydb-secret-new";
        Region region = Region.of("ap-south-1"); // Mumbai region
		
		String access_key = "";
		String secret_access_key = "";

        AwsBasicCredentials awsBasicCredentials = AwsBasicCredentials.create(access_key, secret_access_key);

        // Create a Secrets Manager client from region
        SecretsManagerClient client = SecretsManagerClient.builder()
                .region(region)
                .credentialsProvider(StaticCredentialsProvider.create(awsBasicCredentials))
                .build();

        GetSecretValueRequest getSecretValueRequest = GetSecretValueRequest.builder()
                .secretId(secretName)
                .build();

        GetSecretValueResponse getSecretValueResponse;

        try {
            getSecretValueResponse = client.getSecretValue(getSecretValueRequest);
        } catch (Exception e) {
            // For a list of exceptions thrown, see
            // https://docs.aws.amazon.com/secretsmanager/latest/apireference/API_GetSecretValue.html
            throw e;
        }

        String secret = getSecretValueResponse.secretString();

        return secret;
    }
}
