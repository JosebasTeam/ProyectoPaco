-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 16-04-2018 a las 06:45:07
-- Versión del servidor: 5.5.24-log
-- Versión de PHP: 5.4.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `proyecto`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `preguntas`
--

CREATE TABLE IF NOT EXISTS `preguntas` (
  `PreguntaID` int(11) NOT NULL,
  `AdminID` int(11) DEFAULT NULL,
  `Tema` varchar(15) NOT NULL,
  `NumPregunta` int(11) DEFAULT NULL,
  `Pregunta` varchar(80) DEFAULT NULL,
  `RespA` varchar(80) DEFAULT NULL,
  `RespB` varchar(80) DEFAULT NULL,
  `RespC` varchar(80) DEFAULT NULL,
  `RespD` varchar(80) DEFAULT NULL,
  `RespCorrecta` char(1) DEFAULT NULL,
  `Localizador` int(11) NOT NULL,
  PRIMARY KEY (`PreguntaID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `preguntas`
--

INSERT INTO `preguntas` (`PreguntaID`, `AdminID`, `Tema`, `NumPregunta`, `Pregunta`, `RespA`, `RespB`, `RespC`, `RespD`, `RespCorrecta`, `Localizador`) VALUES
(1, 1, 'Holas', 1, 'gsdg', 'dfgsdgf', 'gsdfg', 'dfgsdf', 'fgsfg', 'a', 1),
(2, 1, 'ewrfawe', 1, 'wefae', 'weafwae', 'wefaewf', 'efawefawe', 'efqawfqae', 'b', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `testrealizados`
--

CREATE TABLE IF NOT EXISTS `testrealizados` (
  `IDTest` int(11) NOT NULL,
  `Tema` varchar(15) DEFAULT NULL,
  `Nota` int(11) NOT NULL,
  `IdUsuario` int(11) NOT NULL,
  `localizador` int(11) NOT NULL,
  PRIMARY KEY (`IDTest`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE IF NOT EXISTS `usuario` (
  `UsuarioID` int(11) NOT NULL,
  `nombre` varchar(20) DEFAULT NULL,
  `rol` int(11) NOT NULL,
  `contrasena` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`UsuarioID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`UsuarioID`, `nombre`, `rol`, `contrasena`) VALUES
(1, 'Toni', 1, 'Carlos');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
