CREATE TABLE IF NOT EXISTS scores.score (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    score VARCHAR(255) NOT NULL
)  ENGINE=INNODB;