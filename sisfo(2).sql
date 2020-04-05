-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 05, 2020 at 06:40 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sisfo`
--

-- --------------------------------------------------------

--
-- Table structure for table `ci_sessions`
--

CREATE TABLE `ci_sessions` (
  `session_id` varchar(40) NOT NULL DEFAULT '0',
  `ip_address` varchar(45) NOT NULL DEFAULT '0',
  `user_agent` varchar(120) NOT NULL,
  `last_activity` int(10) UNSIGNED NOT NULL DEFAULT 0,
  `user_data` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ci_sessions`
--

INSERT INTO `ci_sessions` (`session_id`, `ip_address`, `user_agent`, `last_activity`, `user_data`) VALUES
('2311afc2022d54930534bf0008b2026c', '::1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:74.0) Gecko/20100101 Firefox/74.0', 1584518944, ''),
('a4656143fc3433987e170856427a0206', '::1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:74.0) Gecko/20100101 Firefox/74.0', 1584499992, 'a:7:{s:9:\"user_data\";s:0:\"\";s:9:\"logged_in\";s:13:\"aingLoginYeuh\";s:8:\"username\";s:5:\"danan\";s:12:\"nama_lengkap\";s:5:\"asjkj\";s:4:\"foto\";s:0:\"\";s:5:\"level\";s:4:\"User\";s:6:\"gudang\";N;}'),
('ee8e4a8f846b8e59412c75002c7c2362', '::1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:74.0) Gecko/20100101 Firefox/74.0', 1584492365, 'a:7:{s:9:\"user_data\";s:0:\"\";s:9:\"logged_in\";s:13:\"aingLoginYeuh\";s:8:\"username\";s:5:\"admin\";s:12:\"nama_lengkap\";s:13:\"Administrator\";s:4:\"foto\";s:16:\"ayah_profile.jpg\";s:5:\"level\";s:11:\"Super Admin\";s:6:\"gudang\";N;}');

-- --------------------------------------------------------

--
-- Table structure for table `evaluasidosen`
--

CREATE TABLE `evaluasidosen` (
  `id` int(11) NOT NULL,
  `nama` text CHARACTER SET latin1 NOT NULL,
  `mk` text CHARACTER SET latin1 NOT NULL,
  `tahun` text CHARACTER SET latin1 NOT NULL,
  `nim` text CHARACTER SET latin1 NOT NULL,
  `a1` int(11) NOT NULL,
  `a2` int(11) NOT NULL,
  `a3` int(11) NOT NULL,
  `a4` int(11) NOT NULL,
  `a5` int(11) NOT NULL,
  `a6` int(11) NOT NULL,
  `a7` int(11) NOT NULL,
  `a8` int(11) NOT NULL,
  `a9` int(11) NOT NULL,
  `a10` int(11) NOT NULL,
  `a11` int(11) NOT NULL,
  `b1` int(11) NOT NULL,
  `b2` int(11) NOT NULL,
  `b3` int(11) NOT NULL,
  `b4` int(11) NOT NULL,
  `b5` int(11) NOT NULL,
  `b6` int(11) NOT NULL,
  `b7` int(11) NOT NULL,
  `b8` int(11) NOT NULL,
  `b9` int(11) NOT NULL,
  `c1` int(11) NOT NULL,
  `c2` int(11) NOT NULL,
  `c3` int(11) NOT NULL,
  `c4` int(11) NOT NULL,
  `d1` int(11) NOT NULL,
  `d2` int(11) NOT NULL,
  `d3` int(11) NOT NULL,
  `d4` int(11) NOT NULL,
  `d5` int(11) NOT NULL,
  `d6` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `logkondite`
--

CREATE TABLE `logkondite` (
  `id` int(11) NOT NULL,
  `nim` int(11) NOT NULL,
  `nama` text CHARACTER SET latin1 NOT NULL,
  `jenispoin` text CHARACTER SET latin1 NOT NULL,
  `keterangan` text CHARACTER SET latin1 NOT NULL,
  `tahun` int(11) NOT NULL,
  `prodi` text CHARACTER SET latin1 NOT NULL,
  `tanggal` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `mahasiswa`
--

CREATE TABLE `mahasiswa` (
  `nim` int(11) NOT NULL,
  `nama` text CHARACTER SET latin1 NOT NULL,
  `jeniskelamin` text CHARACTER SET latin1 NOT NULL,
  `programstudi` text CHARACTER SET latin1 NOT NULL,
  `tempatlahir` text CHARACTER SET latin1 NOT NULL,
  `tanggallahir` int(11) NOT NULL,
  `tahunmasuk` int(11) NOT NULL,
  `status` text NOT NULL,
  `kelas` int(11) NOT NULL,
  `password` int(11) NOT NULL,
  `pembimbing` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `mahasiswa`
--

INSERT INTO `mahasiswa` (`nim`, `nama`, `jeniskelamin`, `programstudi`, `tempatlahir`, `tanggallahir`, `tahunmasuk`, `status`, `kelas`, `password`, `pembimbing`) VALUES
(1702012, 'danan', 'lakilaki', 'elektronika', 'tangerang', 1209, 2920, 'masuk', 12, 123, 12);

-- --------------------------------------------------------

--
-- Table structure for table `nilaiakademik`
--

CREATE TABLE `nilaiakademik` (
  `id` int(11) NOT NULL,
  `nim` int(11) NOT NULL,
  `nama` text NOT NULL,
  `uts` text NOT NULL,
  `uas` text NOT NULL,
  `tugas` text NOT NULL,
  `kuis` text NOT NULL,
  `akhir` text NOT NULL,
  `huruf` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `angka` double NOT NULL,
  `kodemk` text NOT NULL,
  `namamk` text NOT NULL,
  `sks` int(11) NOT NULL,
  `tahunakademik` int(11) NOT NULL,
  `prodi` text NOT NULL,
  `dosen` text NOT NULL,
  `kelas` text NOT NULL,
  `status` text NOT NULL,
  `statusmk` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `nilaiakademik`
--

INSERT INTO `nilaiakademik` (`id`, `nim`, `nama`, `uts`, `uas`, `tugas`, `kuis`, `akhir`, `huruf`, `angka`, `kodemk`, `namamk`, `sks`, `tahunakademik`, `prodi`, `dosen`, `kelas`, `status`, `statusmk`) VALUES
(1, 1702012, 'danan dwiyaksa', '80', '80', '80', '80', '80', '2020-04-08 02:17:33', 1, 'mk', 'elektronika', 2, 2019, 'elektronika', 'Devi Handaya', 'elektronika B', 'aktif', 'aktif');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `ci_sessions`
--
ALTER TABLE `ci_sessions`
  ADD PRIMARY KEY (`session_id`),
  ADD KEY `last_activity_idx` (`last_activity`);

--
-- Indexes for table `evaluasidosen`
--
ALTER TABLE `evaluasidosen`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `logkondite`
--
ALTER TABLE `logkondite`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `mahasiswa`
--
ALTER TABLE `mahasiswa`
  ADD PRIMARY KEY (`nim`);

--
-- Indexes for table `nilaiakademik`
--
ALTER TABLE `nilaiakademik`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `evaluasidosen`
--
ALTER TABLE `evaluasidosen`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `logkondite`
--
ALTER TABLE `logkondite`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `nilaiakademik`
--
ALTER TABLE `nilaiakademik`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
