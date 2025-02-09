abstract class field {
    String AccountNumber;
    String UserName;
    String DateofBirth;
    Gender gender;
    String PhineNumber;

    public field(String accountNumber, String userName, String dateofBirth, Gender gender, String phineNumber) {
        AccountNumber = accountNumber;
        UserName = userName;
        DateofBirth = dateofBirth;
        this.gender = gender;
        PhineNumber = phineNumber;
    }
}

