package com.example.recyclerapi;
public class Posts {
    // q refers to the quote text and a refers to the author
    //The variable name is important and it should match the keywords of the JSON obj
    private String name,email,body;
    public Posts(String name, String email, String body) {
        this.name = name;
        this.email = email;
        this.body = body;
    }

    //setters and getters
    //setters and getters are important for initializing them into the views.

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
