package com.omercan.transaction_app.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@SequenceGenerator(name = "TRANSACTIONS_SEQUENCE" , sequenceName = "OMERCAN_TRANSACTIONS_SEQUENCE",initialValue = 1 ,allocationSize = 1)
@Table(name = "TRANSACTIONS")
@Entity
public class Transaction {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TRANSACTIONS_SEQUENCE")
    @Id
    @Column(name = "TRANSACTION_ID")
    private Integer transactionId;
    @Column(name = "USER_ID")
    private Integer userId;
    @Column(name = "PRODUCT_ID")
    private Integer productId;

    private Date transactionTime;
}
