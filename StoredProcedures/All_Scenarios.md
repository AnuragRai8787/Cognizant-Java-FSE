# Exercise 3: Stored Procedures

## Scenario 1: Process Monthly Interest

### PL/SQL Code

```sql
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest
AS
BEGIN
   UPDATE Accounts
   SET Balance = Balance + (Balance * 0.01)
   WHERE AccountType = 'Savings';

   COMMIT;

   DBMS_OUTPUT.PUT_LINE('Monthly interest processed successfully.');
END;
/
```

### Explanation

This stored procedure applies a monthly interest rate of 1% to all savings accounts. It updates the balance of each savings account by adding 1% of its current balance and then commits the changes.

---

## Scenario 2: Update Employee Bonus

### PL/SQL Code

```sql
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
   p_department IN VARCHAR2,
   p_bonus_percent IN NUMBER
)
AS
BEGIN
   UPDATE Employees
   SET Salary = Salary + (Salary * p_bonus_percent / 100)
   WHERE Department = p_department;

   COMMIT;

   DBMS_OUTPUT.PUT_LINE('Employee bonuses updated successfully.');
END;
/
```

### Explanation

This stored procedure updates employee salaries by adding a bonus percentage. The department name and bonus percentage are passed as parameters, allowing the procedure to be reused for different departments and bonus values.

---

## Scenario 3: Transfer Funds

### PL/SQL Code

```sql
CREATE OR REPLACE PROCEDURE TransferFunds(
   p_from_account IN NUMBER,
   p_to_account IN NUMBER,
   p_amount IN NUMBER
)
AS
   v_balance NUMBER;
BEGIN
   SELECT Balance
   INTO v_balance
   FROM Accounts
   WHERE AccountID = p_from_account;

   IF v_balance >= p_amount THEN

      UPDATE Accounts
      SET Balance = Balance - p_amount
      WHERE AccountID = p_from_account;

      UPDATE Accounts
      SET Balance = Balance + p_amount
      WHERE AccountID = p_to_account;

      COMMIT;

      DBMS_OUTPUT.PUT_LINE('Funds transferred successfully.');

   ELSE
      DBMS_OUTPUT.PUT_LINE('Insufficient balance for transfer.');
   END IF;
END;
/
```

### Explanation

This stored procedure transfers funds from one account to another. It first checks whether the source account has sufficient balance. If enough funds are available, the amount is deducted from the source account and added to the destination account. Otherwise, an error message is displayed.

---


