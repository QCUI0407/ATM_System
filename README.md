# ATM_System
1.Preparation
--Each user account is an object. An account class is required.
--A container is required to store all account information of the system.
--The homepage only need login and registr

2.register
-- register method
--create an account class， Encapsulation(封装) user info
-- Scanner: username, pw, pw (make sure pw are same)
-- ******* System create a 8 digits account number. Make sure the number is unique*******
--store new account to the array

3.after login
--search (show the Current user info)
--deposit
--withdraw
--transfer
--reset pw
--logout
--close account


4.transfer money
--2 or more account available && have money in account
-- enter other side card number, check that it is correct
-- second layer confirmation(check account last name)
--All the above are correct, transfer money


5.change PW, closing account
-- use set method update new PW
--closing account, del this account obj from arraylist