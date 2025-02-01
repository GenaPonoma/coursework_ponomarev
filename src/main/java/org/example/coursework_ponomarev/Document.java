package org.example.coursework_ponomarev;

import java.time.LocalDate;

public class Document {
    private String documentNumber;
    private LocalDate issueDate;
    private LocalDate expirationDate;

    public Document(String documentNumber, LocalDate issueDate, LocalDate expirationDate) {
        this.documentNumber = documentNumber;
        this.issueDate = issueDate;
        this.expirationDate = expirationDate;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }


    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

}