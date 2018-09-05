package com.hrisko.quotes.models;

public class Quote {
    public int id;
    public String authorName;
    public String topic;
    public String quote;
    public String imageUrl;
    public boolean isDeleted;

    public Quote() {

    }

    public Quote(String authorName, String topic, String quote, String imageUrl) {
        this.authorName = authorName;
        this.topic = topic;
        this.quote = quote;
        this.imageUrl = imageUrl;
        isDeleted = false;
    }


    public int getId() {
        return id;
    }


    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public boolean getIsDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
}
