-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Sep 15, 2015 at 10:02 AM
-- Server version: 5.5.32
-- PHP Version: 5.4.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `clinic_management_system`
--
CREATE DATABASE IF NOT EXISTS `clinic_management_system` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `clinic_management_system`;

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE IF NOT EXISTS `admin` (
  `aid` int(11) NOT NULL AUTO_INCREMENT,
  `aname` varchar(100) NOT NULL,
  `aaddress` varchar(100) NOT NULL,
  `aspecification` varchar(100) NOT NULL,
  `apassword` varchar(50) NOT NULL,
  `acontact` varchar(50) NOT NULL,
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`aid`, `aname`, `aaddress`, `aspecification`, `apassword`, `acontact`) VALUES
(1, 's', 'rajsahi', 'system manager,pijion clnic management system', '0', '01755103601');

-- --------------------------------------------------------

--
-- Table structure for table `diseases`
--

CREATE TABLE IF NOT EXISTS `diseases` (
  `deid` int(11) NOT NULL AUTO_INCREMENT,
  `dename` varchar(100) NOT NULL,
  `decatagory` varchar(100) NOT NULL,
  `dedescription` varchar(300) NOT NULL,
  PRIMARY KEY (`deid`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=26 ;

--
-- Dumping data for table `diseases`
--

INSERT INTO `diseases` (`deid`, `dename`, `decatagory`, `dedescription`) VALUES
(1, 'Acanthamoeba Keratitis ', 'Eye', 'Amblyopia is a vision development problem in infants and young children that can lead to permanent vision loss. Learn the symptoms, causes and treatments.'),
(2, 'Amblyopia (Lazy Eye) ', 'Eye', 'Amblyopia is a vision development problem in infants and young children that can lead to permanent vision loss. Learn the symptoms, causes and treatments.'),
(3, 'Astigmatism ', 'Eye', 'sually caused by an irregular cornea, astigmatism causes blur at all distances'),
(6, 'Bell''s Palsy ', 'Eye', 'This condition causes sudden paralysis of one side of the face. Because it affects blinking, it can cause severe dry eye.'),
(7, 'Black Eye', 'Eye', 'How serious is a black eye? How to treat black eyes.'),
(8, 'Cataracts ', 'Eye', 'The risk of cataracts increases with age. Learn what causes them and how to protect your eyes.'),
(9, 'Blurry Vision ', 'Eye', 'Blurry vision has many causes, from fatigue and eyestrain to serious eye diseases such as glaucoma. A video helps explain blurry vision causes and treatments.'),
(10, 'Deviated Nasal Septum', 'Nose', ' The nasal septum is the part of the nose that separates the two airways and the nostrils. A deviated septum is when there is a shift from the midline or center position. The septal deviation may be severe enough to obstruct the passage of air through the nostrils. This obstruction may predispose th'),
(11, 'Epistaxis (nosebleeds)', 'Nose', 'The cause may be a trauma to the nose, but many times the nose bleeds because of nasal congestion due to a nasal allergy,sinus infection, or a cold that irritates and weakens the delicate nasal lining.'),
(14, 'Nasal Airway Obstruction', 'Nose', 'Blockage/obstruction of the flow of air through the nasal passages most commonly caused by nasal fracture, allergies, deviated nasal septum, nasal deformity and enlarged adenoid tissue.'),
(15, 'Nasal Polyps', 'Nose', 'A protruding growth from the mucous membrane most commonly caused by chronic infection and allergies.'),
(16, 'Sinusitis', 'Nose', 'Sinusitis is an infection of the sinuses near the nose. These infections usually occur after a cold or after an allergic inflammation. There are other possible conditions that can lead to sinusitis'),
(17, 'Rhinitis', 'Nose', 'An inflammation of the mucous membrane of the nose. Commonly caused by allergies . Symptoms may include sudden attacks of sneezing, swelling of the nasal mucosa, watery discharge from the nose, itching, watering of the eyes'),
(18, 'Cholesteatoma', 'Ear', 'Cholesteatoma is skin cells that grow in the wrong places in the middle ear and mastoid. Less commonly, it can invade the inner ear, brain, or any other structure of the ear area/brain. As the skin mass expands, it can destroy anything in its path. Infection often accompanies a cholesteatoma. The os'),
(19, 'Otosclerosis', 'Ear', 'Otosclerosis is a kind of ear disease in which the otic capsule, the hard and "different" bone that is present only around the inner ear, is replaced in patches by soft bone at random locations around the inner ear.  When this soft bone starts growing at the edge of the stapes footplate, the stapes '),
(20, 'Continuous Fever', 'Fever', 'The temperature remains above normal throughout the day and does not fluctuate more than 1 degree Celsius in 24 hours. This type of fever occurs in  lobar pneumonia, typhoid, urinary tract infection, infective endocarditis, brucellosis, typhus etc.'),
(21, 'Remittent Fever', 'Fever', 'The temperature remains above normal throughout the day and fluctuates more than 2 degree Celsius in 24 hours. This type of fever is usually seen patients of typhoid infection and  infective endocarditis. This type of fever is most common in practice.'),
(22, 'Intermittent Fever', 'Fever', 'The temperature is present only for some hours in a day and remains to normal for the remaining hours. When the spike occurs daily, it is quotidian, when every alternate day, it tertian and when every third day, it is quartan. Intermittent fever is seen in malaria, kala-azar, pyemia, septicemia etc.'),
(23, 'Hectic or Septic Fever', 'Fever', 'The temperature variation between peak and nadir is very large and exceeds 5 degree Celsius. This type of fever occur in  septicemia.'),
(24, 'Low Grade Fever', 'Fever', 'Temperature is present daily especially in the evening for several days but does not exceed 37.8 degree Celsius at any time. Usually it does not indicate disease, but it is commonly present with tuberculosis.'),
(25, 'Pel Ebstein Fever', 'Fever', 'In this type, there is a regular alternation of recurrent bouts of fever and afebrile periods. The temperature may take 3 days to rise, remains high for 3 days and remits in 3 days, followed by apyrexia for 9 days.');

-- --------------------------------------------------------

--
-- Table structure for table `doctor`
--

CREATE TABLE IF NOT EXISTS `doctor` (
  `did` int(11) NOT NULL AUTO_INCREMENT,
  `dname` varchar(100) NOT NULL,
  `catagory` varchar(100) NOT NULL,
  `specification` varchar(100) NOT NULL,
  `app_day` varchar(100) NOT NULL,
  `app_time` varchar(50) NOT NULL,
  `dcontact` int(11) NOT NULL,
  `status` varchar(100) NOT NULL,
  PRIMARY KEY (`did`),
  UNIQUE KEY `dname` (`dname`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Dumping data for table `doctor`
--

INSERT INTO `doctor` (`did`, `dname`, `catagory`, `specification`, `app_day`, `app_time`, `dcontact`, `status`) VALUES
(1, 'Dr.Asad Nur', 'Eye Specialist', 'Eye Specialist,DMC\r FCPS,Englad CM', 'sunday-thrusday', '5pm-9pm', 1755103601, 'available'),
(3, 'Dr.Sabrina Haque', 'Medicine specialist', 'Medicine,DMC,PCPS,India', 'Friday-Satarday', '10am-5pm', 1675412368, 'not available'),
(6, 'Dr.Sipon Roy', 'medicine specialist', 'medicine specialist,DMC,FCPS-Japan', 'sunday-wednesday', '5pm-8pm', 1784261548, 'not available'),
(7, 'Dr.Akram Khan', 'medicine specialist', 'medicine specialist,DMC,FCPS-Japan', 'sunday-wednesday', '5pm-8pm', 1784261548, 'not available');

-- --------------------------------------------------------

--
-- Table structure for table `drugs`
--

CREATE TABLE IF NOT EXISTS `drugs` (
  `drid` int(11) NOT NULL AUTO_INCREMENT,
  `drname` varchar(20) NOT NULL,
  `desname` varchar(20) NOT NULL,
  `descatagory` varchar(20) NOT NULL,
  PRIMARY KEY (`drid`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=44 ;

--
-- Dumping data for table `drugs`
--

INSERT INTO `drugs` (`drid`, `drname`, `desname`, `descatagory`) VALUES
(1, 'Atropine', 'Amblyopia (Lazy Eye)', 'Eye'),
(2, 'Eye drops', 'Amblyopia (Lazy Eye)', 'Eye'),
(4, 'Alarid® Eye Drops', 'Acanthamoeba Keratit', 'Eye'),
(5, 'Alacot® DS Eye Drops', 'Acanthamoeba Keratit', 'Eye'),
(6, 'Alacot® Eye Drops', 'Astigmatism', 'Eye'),
(7, 'Iventi® Eye Drops', 'Astigmatism', 'Eye'),
(8, 'Locular® Plus Eye Dr', 'Bell''s Palsy', 'Eye'),
(9, 'Lubtear® Eye Drops', 'Bell''s Palsy', 'Eye'),
(10, 'Mexlo® Eye Drops', 'Black Eye', 'Eye'),
(11, 'OcubromTM Eye Drops', 'Black Eye', 'Eye'),
(12, 'OculantTM Eye Drops', 'Cataracts', 'Eye'),
(13, 'Locular® Plus Eye Dr', 'Cataracts', 'Eye'),
(14, 'GENACYN', 'Blurry Vision', 'Eye'),
(15, 'GENACYN', 'Blurry Vision', 'Eye'),
(16, 'diphenhydramine oral', 'Deviated Nasal Septu', 'Nose'),
(17, 'Benadryl oral', 'Deviated Nasal Septu', 'Nose'),
(18, 'Tussionex Pennkineti', 'Epistaxis (nosebleed', 'Nose'),
(19, 'Mucinex D oral', 'Epistaxis (nosebleed', 'Nose'),
(20, 'cyproheptadine oral', 'Nasal Airway Obstruc', 'Nose'),
(21, 'Claritin-D 24 Hour o', 'Nasal Airway Obstruc', 'Nose'),
(22, 'Unisom (doxylamine) ', 'Nasal Polyps', 'Nose'),
(23, 'promethazine-codeine', 'Nasal Polyps', 'Nose'),
(24, 'Bromfed DM oral', 'Sinusitis', 'Nose'),
(25, 'Percogesic oral', 'Sinusitis', 'Nose'),
(26, 'Capmist DM oral', 'Rhinitis', 'Nose'),
(27, 'Tylenol PM Extra Str', 'Rhinitis', 'Nose'),
(28, 'Ace Plus®', 'Low Grade Fever', 'Fever'),
(29, 'Napa', 'Low Grade Fever', 'Fever'),
(30, 'Acetram®', 'Continuous Fever', 'Fever'),
(31, 'Ace XR®', 'Continuous Fever', 'Fever'),
(32, 'Ciprocin', 'Remittent Fever', 'Fever'),
(33, 'Ciprocin IV Infusion', 'Remittent Fever', 'Fever'),
(34, 'Rutix®', 'Intermittent Fever', 'Fever'),
(35, 'Iventi 400 IV®', 'Intermittent Fever', 'Fever'),
(36, ' Bactomol', 'Hectic or Septic Fev', 'Fever'),
(37, ' Crocin DS', 'Hectic or Septic Fev', 'Fever'),
(38, 'Antiplar Plus', 'Pel Ebstein Fever', 'Fever'),
(39, ' Alpyrin', 'Pel Ebstein Fever', 'Fever'),
(40, 'Murine Ear Drops', 'Cholesteatoma', 'Ear'),
(41, 'LOSARCAR', 'Cholesteatoma', 'Ear'),
(42, 'MEPRA 20', 'Otosclerosis', 'Ear'),
(43, 'OMENTA 20', 'Otosclerosis', 'Ear');

-- --------------------------------------------------------

--
-- Table structure for table `fileup`
--

CREATE TABLE IF NOT EXISTS `fileup` (
  `person_id` int(11) NOT NULL AUTO_INCREMENT,
  `doc_name` varchar(45) DEFAULT NULL,
  `file` mediumblob,
  PRIMARY KEY (`person_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Dumping data for table `fileup`
--

INSERT INTO `fileup` (`person_id`, `doc_name`, `file`) VALUES
(5, 'Dr.Asad Nur', 0x44722e41736164204e757209090950494a494f4e20434c494e4943204d414e4147454d454e542053595354454d0909444154453a0a457965205370656369616c6973740909090952414a534148492c42414a41520a464350532c4a6170616e0a0a0a0909092a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a0a0a4e616d653a2020202020202020202020200909094167653a2020202020202020202020202020202009090947656e6465723a0a0a0a446174653a2020202020202020202020200909094e65787420446174653a2020202020202020202020200909436f6e746163743a0a0a0a0909092a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a0a0a50726f626c656d3a0a0a0a0a0a0a0a0a0909092a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a0a0a0a44727567733a0a0a0a0a0a0a0a0a0a0a0a0a0a0909092a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a),
(6, 'Dr.Sabrina Haque', 0x44722e53616272696e61204861717565090950494a494f4e20434c494e4943204d414e4147454d454e542053595354454d0909444154453a0a4d65646963696e65207370656369616c69737409090952414a534148492c42414a41520a464350532c4368696e610a0a0a0909092a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a0a0a4e616d653a2020202020202020202020200909094167653a2020202020202020202020202020202009090947656e6465723a0a0a0a446174653a2020202020202020202020200909094e65787420446174653a2020202020202020202020200909436f6e746163743a0a0a0a0909092a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a0a0a50726f626c656d3a0a0a0a0a0a0a0a0a0909092a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a0a0a0a44727567733a0a0a0a0a0a0a0a0a0a0a0a0a0a0909092a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a),
(7, 'Dr.Sipon Roy', 0x44722e5369706f6e20526f79090950494a494f4e20434c494e4943204d414e4147454d454e542053595354454d0909444154453a0a4d65646963696e65205370656369616c6973740909090952414a534148492c42414a41520a444d432c464350532c4a6170616e0a0a0a0909092a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a0a0a4e616d653a2020202020202020202020200909094167653a2020202020202020202020202020202009090947656e6465723a0a0a0a446174653a2020202020202020202020200909094e65787420446174653a2020202020202020202020200909436f6e746163743a0a0a0a0909092a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a0a0a50726f626c656d3a0a0a0a0a0a0a0a0a0909092a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a0a0a0a44727567733a0a0a0a0a0a0a0a0a0a0a0a0a0a0909092a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a);

-- --------------------------------------------------------

--
-- Table structure for table `patient`
--

CREATE TABLE IF NOT EXISTS `patient` (
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `serial_no` varchar(100) NOT NULL,
  `disease` varchar(100) NOT NULL,
  `doctor` varchar(100) NOT NULL,
  `date` date NOT NULL,
  `contact_no` int(11) NOT NULL,
  `prescription` mediumblob,
  `status` varchar(100) DEFAULT NULL,
  `bill` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`pid`,`serial_no`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=1278 ;

--
-- Dumping data for table `patient`
--

INSERT INTO `patient` (`pid`, `name`, `serial_no`, `disease`, `doctor`, `date`, `contact_no`, `prescription`, `status`, `bill`) VALUES
(1, 'sawan', '01', 'eye problem', 'Dr.Sipon Roy', '2015-04-24', 1755103601, NULL, 'visited', '500'),
(1248, 'miltan', '03', 'fever', 'Dr.Asad Nur', '2015-04-26', 1725846985, NULL, NULL, NULL),
(1249, 'sumon', '02', 'headache', 'Dr.Asad Nur', '2015-07-04', 1722222222, 0x44722e41736164204e757209090950494a494f4e20434c494e4943204d414e4147454d454e542053595354454d0909444154453a0a457965205370656369616c6973740909090952414a534148492c42414a41520a464350532c4a6170616e0a0a0a0909092a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a0a0a4e616d653a2020202020202020202020200909094167653a2020202020202020202020202020202009090947656e6465723a0a0a0a446174653a2020202020202020202020200909094e65787420446174653a2020202020202020202020200909436f6e746163743a0a0a0a0909092a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a0a0a50726f626c656d3a0a0a0a0a0a0a0a0a0909092a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a0a0a0a44727567733a0a0a0a0a0a0a0a0a0a0a0a0a0a0909092a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a, 'visited', '500'),
(1250, 'saddam', '11', 'skin problem', 'Dr.Asad Nur', '2015-07-05', 1, 0x6a6a09090950494a494f4e20434c494e4943204d414e4147454d454e542053595354454d0909444154453a0a457965205370656369616c6973740909090952414a534148492c42414a41520a464350532c4a6170616e0a0a0a0909092a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a0a0a4e616d653a2020202020202020202020200909094167653a2020202020202020202020202020202009090947656e6465723a0a0a0a446174653a2020202020202020202020200909094e65787420446174653a2020202020202020202020200909436f6e746163743a0a0a0a0909092a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a0a0a50726f626c656d3a0a0a0a0a0a0a0a0a0909092a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a0a0a0a44727567733a0a0a0a0a0a0a0a0a0a0a0a0a0a0909092a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a, 'not_visited', '300tk'),
(1251, 'milton', '04', 'eye problem', 'Dr.Sabrina Haque', '2015-04-24', 54655, NULL, NULL, NULL),
(1252, 'mahmud', '06', 'fever', 'Dr.Asad Nur', '2015-05-23', 156565, NULL, 'not_visited', NULL),
(1255, 'jibon', '10', 'eye problem', 'Dr.Sabrina Haque', '2015-07-03', 1726548951, NULL, 'not_visited', NULL),
(1256, 'salma khatun', '21', 'fever', 'Dr.Sipon Roy', '2015-07-03', 1723654189, NULL, 'not_visited', '300tk'),
(1257, 'Alpona jahan', '15', 'fever', 'Dr.Sipon Roy', '2015-07-25', 1751236589, 0x44722e5369706f6e20526f79090950494a494f4e20434c494e4943204d414e4147454d454e542053595354454d0909444154453a0a4d65646963696e65205370656369616c6973740909090952414a534148492c42414a41520a444d432c464350532c4a6170616e0a0a0a0909092a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a0a0a4e616d653a2020202020202020202020200909094167653a2020202020202020202020202020202009090947656e6465723a0a0a0a446174653a2020202020202020202020200909094e65787420446174653a2020202020202020202020200909436f6e746163743a0a0a0a0909092a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a0a0a50726f626c656d3a0a0a0a0a0a0a0a0a0909092a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a0a0a0a44727567733a0a0a0a0a0a0a0a0a0a0a0a0a0a0909092a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a, 'visited', '500tk'),
(1258, 'Prabon khan', '16', 'catalist', 'Dr.Asad Nur', '2015-07-25', 1912568947, 0x44722e41736164204e757209090950494a494f4e20434c494e4943204d414e4147454d454e542053595354454d0909444154453a0a457965205370656369616c6973740909090952414a534148492c42414a41520a464350532c4a6170616e0a0a0a0909092a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a0a0a4e616d653a2020202020202020202020200909094167653a2020202020202020202020202020202009090947656e6465723a0a0a0a446174653a2020202020202020202020200909094e65787420446174653a2020202020202020202020200909436f6e746163743a0a0a0a0909092a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a0a0a50726f626c656d3a0a0a0a0a0a0a0a0a0909092a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a0a0a0a44727567733a0a0a0a0a0a0a0a0a0a0a0a0a0a0909092a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a, 'visited', '500tk'),
(1259, 'Sfiq Mondol', '17', 'Headache', 'Dr.Sabrina Haque', '2015-07-25', 1856234793, 0x44722e53616272696e61204861717565090950494a494f4e20434c494e4943204d414e4147454d454e542053595354454d0909444154453a0a4d65646963696e65207370656369616c69737409090952414a534148492c42414a41520a464350532c4368696e610a0a0a0909092a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a0a0a4e616d653a2020202020202020202020200909094167653a2020202020202020202020202020202009090947656e6465723a0a0a0a446174653a2020202020202020202020200909094e65787420446174653a2020202020202020202020200909436f6e746163743a0a0a0a0909092a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a0a0a50726f626c656d3a0a0a0a0a0a0a0a0a0909092a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a0a0a0a44727567733a0a0a0a0a0a0a0a0a0a0a0a0a0a0909092a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a, 'visited', '500tk'),
(1260, 'jaman sarkar', '18', 'mumps', 'Dr.Asad Nur', '2015-07-25', 1815489547, 0x44722e41736164204e757209090950494a494f4e20434c494e4943204d414e4147454d454e542053595354454d0909444154453a0a457965205370656369616c6973740909090952414a534148492c42414a41520a464350532c4a6170616e0a0a0a0909092a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a0a0a4e616d653a2020202020202020202020200909094167653a2020202020202020202020202020202009090947656e6465723a0a0a0a446174653a2020202020202020202020200909094e65787420446174653a2020202020202020202020200909436f6e746163743a0a0a0a0909092a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a0a0a50726f626c656d3a0a0a0a0a0a0a0a0a0909092a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a0a0a0a44727567733a0a0a0a0a0a0a0a0a0a0a0a0a0a0909092a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a, 'visited', '500tk'),
(1261, 'saiful bari', '19', 'fever', 'Dr.Sipon Roy', '2015-07-25', 1921456741, 0x44722e5369706f6e20526f79090950494a494f4e20434c494e4943204d414e4147454d454e542053595354454d0909444154453a0a4d65646963696e65205370656369616c6973740909090952414a534148492c42414a41520a444d432c464350532c4a6170616e0a0a0a0909092a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a0a0a4e616d653a2020202020202020202020200909094167653a2020202020202020202020202020202009090947656e6465723a0a0a0a446174653a2020202020202020202020200909094e65787420446174653a2020202020202020202020200909436f6e746163743a0a0a0a0909092a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a0a0a50726f626c656d3a0a0a0a0a0a0a0a0a0909092a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a0a0a0a44727567733a0a0a0a0a0a0a0a0a0a0a0a0a0a0909092a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a, 'visited', '500tk'),
(1262, 'Amina Khatun', '20', 'headache', 'Dr.Sabrina Haque', '2015-07-25', 192547862, 0x44722e53616272696e61204861717565090950494a494f4e20434c494e4943204d414e4147454d454e542053595354454d0909444154453a0a4d65646963696e65207370656369616c69737409090952414a534148492c42414a41520a464350532c4368696e610a0a0a0909092a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a0a0a4e616d653a2020202020202020202020200909094167653a2020202020202020202020202020202009090947656e6465723a0a0a0a446174653a2020202020202020202020200909094e65787420446174653a2020202020202020202020200909436f6e746163743a0a0a0a0909092a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a0a0a50726f626c656d3a0a0a0a0a0a0a0a0a0909092a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a0a0a0a44727567733a0a0a0a0a0a0a0a0a0a0a0a0a0a0909092a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a, 'visited', '500tk'),
(1263, 'Foysal Khan', '21', 'catalyst', 'Dr.Asad Nur', '2015-07-25', 1705126187, 0x44722e41736164204e757209090950494a494f4e20434c494e4943204d414e4147454d454e542053595354454d0909444154453a0a457965205370656369616c6973740909090952414a534148492c42414a41520a464350532c4a6170616e0a0a0a0909092a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a0a0a4e616d653a2020202020202020202020200909094167653a2020202020202020202020202020202009090947656e6465723a0a0a0a446174653a2020202020202020202020200909094e65787420446174653a2020202020202020202020200909436f6e746163743a0a0a0a0909092a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a0a0a50726f626c656d3a0a0a0a0a0a0a0a0a0909092a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a0a0a0a44727567733a0a0a0a0a0a0a0a0a0a0a0a0a0a0909092a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a, 'visited', '500tk'),
(1264, 'Omor Faruk', '22', 'cough', 'Dr.Sabrina Haque', '2015-07-25', 1921456741, 0x44722e53616272696e61204861717565090950494a494f4e20434c494e4943204d414e4147454d454e542053595354454d0909444154453a0a4d65646963696e65207370656369616c69737409090952414a534148492c42414a41520a464350532c4368696e610a0a0a0909092a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a0a0a4e616d653a2020202020202020202020200909094167653a2020202020202020202020202020202009090947656e6465723a0a0a0a446174653a2020202020202020202020200909094e65787420446174653a2020202020202020202020200909436f6e746163743a0a0a0a0909092a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a0a0a50726f626c656d3a0a0a0a0a0a0a0a0a0909092a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a0a0a0a44727567733a0a0a0a0a0a0a0a0a0a0a0a0a0a0909092a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a, 'visited', '500tk'),
(1265, 'Rubel Mia', '23', 'cough', 'Dr.Sipon Roy', '2015-09-14', 1922584444, NULL, 'not_visited', '500tk'),
(1266, 'Alom Sarkar', '24', 'fever', 'Dr.Sabrina Haque', '2015-09-14', 1921456741, NULL, 'not_visited', '500tk'),
(1267, 'Mahmud Mia', '25', 'cough', 'Dr.Sabrina Haque', '2015-09-16', 1741112258, NULL, 'not_visited', '500tk'),
(1268, 'Himu', '26', 'fever', 'Dr.Sipon Roy', '2015-09-17', 1921456741, NULL, 'not_visited', '500tk'),
(1269, 'Taskin Ahmed', '27', 'cogh', 'Dr.Sipon Roy', '2015-09-18', 1745621458, NULL, 'not_visited', '500tk'),
(1270, 'Olpona Jahan', '28', 'catalyst', 'Dr.Asad Nur', '2015-09-19', 1921456741, NULL, 'not_visited', '500tk'),
(1271, 'Silpa Khan', '28', 'eye', 'Dr.Asad Nur', '2015-09-20', 1624587152, NULL, 'not_visited', '500tk'),
(1272, 'Miraj', '29', 'catalyst', 'Dr.Asad Nur', '2015-09-21', 1632541288, NULL, 'not_visited', '500tk'),
(1273, 'asas', '44', 'hjhj', 'Dr.Asad Nur', '2015-09-03', 4454, 0x44722e41736164204e757209090950494a494f4e20434c494e4943204d414e4147454d454e542053595354454d0909444154453a0a457965205370656369616c6973740909090952414a534148492c42414a41520a464350532c4a6170616e0a0a0a0909092a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a0a0a4e616d653a2020202020202020202020200909094167653a2020202020202020202020202020202009090947656e6465723a0a0a0a446174653a2020202020202020202020200909094e65787420446174653a2020202020202020202020200909436f6e746163743a0a0a0a0909092a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a0a0a50726f626c656d3a0a0a0a0a0a0a0a0a0909092a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a0a0a0a44727567733a0a0a0a0a0a0a0a0a0a0a0a0a0a0909092a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a, 'visited', '500tk'),
(1274, 'asas', 'dd', 'ss', 'Dr.Asad Nur', '2015-09-04', 11, 0x44722e41736164204e757209090950494a494f4e20434c494e4943204d414e4147454d454e542053595354454d0909444154453a0a457965205370656369616c6973740909090952414a534148492c42414a41520a464350532c4a6170616e0a0a0a0909092a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a0a0a4e616d653a2020202020202020202020200909094167653a2020202020202020202020202020202009090947656e6465723a0a0a0a446174653a2020202020202020202020200909094e65787420446174653a2020202020202020202020200909436f6e746163743a0a0a0a0909092a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a0a0a50726f626c656d3a0a0a0a0a0a0a0a0a0909092a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a0a0a0a44727567733a0a0a0a0a0a0a0a0a0a0a0a0a0a0909092a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a, 'visited', '500tk'),
(1275, 'ss', 'ss', 'dd', 'Dr.Asad Nur', '2015-09-04', 22, NULL, 'not_visited', '500tk'),
(1276, 'sa', 'gg', 'rr', 'Dr.Asad Nur', '2015-09-04', 11, NULL, 'not_visited', '500tk'),
(1277, 'jaman', '35', 'eye', 'Dr.Akram Khan', '2015-09-07', 1751254689, NULL, 'not_visited', '500tk');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
