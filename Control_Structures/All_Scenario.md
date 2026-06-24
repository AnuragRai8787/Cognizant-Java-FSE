# Exercise 1: Control Structures

## Scenario 1: Apply Interest Rate Discount

### PL/SQL Code

```sql
BEGIN
   FOR cust IN (
       SELECT CustomerID
       FROM Customers
       WHERE Age > 60
   )
   LOOP
       UPDATE Loans
       SET InterestRate = InterestRate - 1
       WHERE CustomerID = cust.CustomerID;
   END LOOP;

   COMMIT;

   DBMS_OUTPUT.PUT_LINE('Interest rates updated successfully.');
END;
/
```

### Explanation

This PL/SQL block identifies customers older than 60 years and reduces their loan interest rate by 1%. A FOR loop iterates through eligible customers and updates their loan records.

---

## Scenario 2: Promote Customers to VIP Status

### PL/SQL Code

```sql
BEGIN
   FOR cust IN (
       SELECT CustomerID
       FROM Customers
       WHERE Balance > 10000
   )
   LOOP
       UPDATE Customers
       SET IsVIP = 'TRUE'
       WHERE CustomerID = cust.CustomerID;
   END LOOP;

   COMMIT;

   DBMS_OUTPUT.PUT_LINE('VIP status updated successfully.');
END;
/
```

### Explanation

This PL/SQL block checks customer balances and marks customers with balances greater than $10,000 as VIP customers.

---

## Scenario 3: Loan Due Reminder

### PL/SQL Code

```sql
BEGIN
   FOR loan_rec IN (
       SELECT CustomerID, LoanID, DueDate
       FROM Loans
       WHERE DueDate BETWEEN SYSDATE AND SYSDATE + 30
   )
   LOOP
       DBMS_OUTPUT.PUT_LINE(
           'Reminder: Customer '
           || loan_rec.CustomerID
           || ' has Loan '
           || loan_rec.LoanID
           || ' due on '
           || TO_CHAR(loan_rec.DueDate, 'DD-MON-YYYY')
       );
   END LOOP;
END;
/
```

### Explanation

This PL/SQL block retrieves loans due within the next 30 days and prints reminder messages for customers using DBMS_OUTPUT.PUT_LINE.

---
