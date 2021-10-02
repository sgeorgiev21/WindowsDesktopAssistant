-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               8.0.20 - MySQL Community Server - GPL
-- Server OS:                    Win64
-- HeidiSQL Version:             11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping structure for table michaeldb.commands
CREATE TABLE IF NOT EXISTS `commands` (
  `Command` longtext,
  `Execute` longtext,
  `Label` longtext,
  `Preinstalled` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table michaeldb.commands: ~17 rows (approximately)
/*!40000 ALTER TABLE `commands` DISABLE KEYS */;
INSERT INTO `commands` (`Command`, `Execute`, `Label`, `Preinstalled`) VALUES
	('MICHAEL FACEBOOK', 'https://www.facebook.com/', 'Opens Facebook', 1),
	('MICHAEL TWITTER', 'https://twitter.com/explore', 'Opens Twitter', 1),
	('MICHAEL YOUTUBE', 'https://www.youtube.com/', 'Opens YouTube', 1),
	('MICHAEL INSTAGRAM', 'https://www.instagram.com/', 'Opens Instagram', 1),
	('MICHAEL SLEEP', 'Rundll32.exe powrprof.dll,SetSuspendState Sleep', 'Enters Sleep Mode', 1),
	('MICHAEL LOCK', 'Rundll32.exe user32.dll,LockWorkStation', 'Locks Computer', 1),
	('MICHAEL SHUT DOWN', 'Shutdown.exe -s -t 00', 'Shut downs computer', 1),
	('MICHAEL RESTART', 'Shutdown.exe -r -t 00', 'Restarts Computer', 1),
	('MICHAEL BROWSER', 'http://www.google.com', 'Opens Browser', 1),
	('MICHAEL COMPUTER', 'cmd /c start explorer', 'Opens My Computer', 1),
	('MICHAEL DOWNLOADS', 'C:\\\\Users\\\\Stoyan\\\\Downloads', 'Opens Downloads', 1),
	('MICHAEL MUSIC', 'C:\\\\Users\\\\Stoyan\\\\Music', 'Opens Music', 1),
	('MICHAEL DOCUMENTS', 'C:\\\\Users\\\\Stoyan\\\\Documents', 'Opens Documents', 1),
	('MICHAEL PICTURES', 'C:\\\\Users\\\\Stoyan\\\\Pictures', 'Opens Pictures', 1),
	('MICHAEL VIDEOS', 'C:\\\\Users\\\\Stoyan\\\\Videos', 'Opens Videos', 1),
	('MICHAEL RECYCLE BIN', 'cmd /c start shell:RecycleBinFolder', 'Opens Recycle Bin', 1),
	('MICHAEL EXIT', '', 'Closes current window', 1),
	('MICHAEL INFORMATION', 'ChangeTabInfo', 'System Information', 1),
	('MICHAEL', 'ChangeTabMichael', 'Michael', 1),
	('MICHAEL COMMANDS', 'ChangeTabCommands', 'Commands', 1),
	('MICHAEL ADD COMMANDS', 'ChangeTabAddCommands', 'Add Commands', 1),
	('MICHAEL CHANGE COMMANDS', 'ChangeTabChangeCommands', 'Change commands', 1),
	('MICHAEL GOODBYE', 'EXIT_MICHAEL', 'Exits Michael', 1),
	('MICHAEL TIME', 'MICHAEL_TIME', 'Time', 1),
	('MICHAEL DATE', 'MICHAEL_DATE', 'Date', 1);
/*!40000 ALTER TABLE `commands` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
