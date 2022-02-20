create database if not exists books;

use books;

drop table if exists series;

create table series (
		id int(4) not null auto_increment primary key,
		author varchar(20) not null,
		name varchar(50) not null,
		series_length int(2) not null
);

		--MyQueries

--INSERT INTO series(author, name, series_length) VALUES (?, ?, ?)

--SELECT * FROM series WHERE id = ?

--UPDATE series SET series_length = ? WHERE id = ?

--DELETE FROM series WHERE id = ?

--SELECT * FROM series