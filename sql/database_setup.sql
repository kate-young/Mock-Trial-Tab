create database mock_trial;

create user 'testuser'@'localhost' identified by 'password';
grant all on mock_trial.* to 'testuser';

use mock_trial;

//Schools
create table schools (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY
                     ,name VARCHAR(255) NOT NULL
                     ,mascot VARCHAR(255) NULL);
