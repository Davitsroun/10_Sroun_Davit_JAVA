public interface Account {
    double deposit(double amount);
    double withdraw(double amount);
    double tranfer(double amount , Account target);
    void displayAcc();
    double Delete(Account targeet);
}
