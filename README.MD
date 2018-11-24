## Reset the password
After MySQL is started again, you can log into the CLI and reset the password:
- `shell> mysql -u root`
- `mysql> FLUSH PRIVILEGES;`
- `mysql> ALTER USER 'root'@'localhost' IDENTIFIED BY 'super-secret-password';`
- ref: https://www.fromdual.com/reset-mysql-password-on-macos

## Create the database
- `mysql> create database db_example; -- Create the new database`
- `mysql> create user 'springuser'@'localhost' identified by 'ThePassword'; -- Creates the user`
- `mysql> grant all on db_example.* to 'springuser'@'localhost'; -- Gives all the privileges to the new user on the newly created database`
- ref:  https://spring.io/guides/gs/accessing-data-mysql/