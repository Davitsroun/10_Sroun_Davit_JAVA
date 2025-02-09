public interface Account {
    double deposit(double amount);
    double withdraw(double amount, double yourmoney);
    void tranfer(double amount, Object object);
    void displayAcc();
}
