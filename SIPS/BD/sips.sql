-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 18-03-2018 a las 20:37:01
-- Versión del servidor: 10.1.21-MariaDB
-- Versión de PHP: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `sips`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `actualizacion`
--

CREATE TABLE `actualizacion` (
  `ID` int(10) NOT NULL,
  `CLAVE` varchar(60) NOT NULL,
  `PRODUCTO` varchar(60) NOT NULL,
  `EXISTENCIA` int(10) NOT NULL,
  `UNIDADES` varchar(60) NOT NULL,
  `UBICACION` varchar(60) NOT NULL,
  `PRECIO` float(10,2) NOT NULL,
  `PRECIOT` float(10,2) NOT NULL,
  `FECHA` varchar(30) NOT NULL,
  `HORA` varchar(30) NOT NULL,
  `PROVEEDOR` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `actualizacion`
--

INSERT INTO `actualizacion` (`ID`, `CLAVE`, `PRODUCTO`, `EXISTENCIA`, `UNIDADES`, `UBICACION`, `PRECIO`, `PRECIOT`, `FECHA`, `HORA`, `PROVEEDOR`) VALUES
(3, 'A017-BR-01 ', 'BROCA PARA METAL DE 1/2\" ', 6, 'PZAS', 'A3', 120.00, 720.00, '13:15:03', '14/03/2018', 'YYY'),
(3, 'A017-BR-01 ', 'BROCA PARA METAL DE 1/2\" ', 8, 'PZAS', 'A3', 122.00, 976.00, '13:15:47', '14/03/2018', 'YYY'),
(2, 'A016-ES-T304-01 ', 'ESPARRAGOS DE 5/8\", AC.INOXIDABLE T-304 (MTS) ', 18, 'METROS', 'A1', 540.00, 9720.00, '13:18:28', '14/03/2018', 'XX'),
(3, 'A017-BR-01 ', 'BROCA PARA METAL DE 1/2\" ', 18, 'PZAS', 'A3', 122.00, 2196.00, '13:19:11', '14/03/2018', 'YYY'),
(2, 'A016-ES-T304-01 ', 'ESPARRAGOS DE 5/8\", AC.INOXIDABLE T-304 (MTS) ', 28, 'METROS', 'A1', 540.00, 15120.00, '20:56:04', '14/03/2018', 'XX');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `actualizacion2`
--

CREATE TABLE `actualizacion2` (
  `ID` int(10) NOT NULL,
  `CLAVE` varchar(60) NOT NULL,
  `PRODUCTO` varchar(60) NOT NULL,
  `EXISTENCIA` int(10) NOT NULL,
  `UNIDADES` varchar(60) NOT NULL,
  `UBICACION` varchar(60) NOT NULL,
  `PRECIO` float(10,2) NOT NULL,
  `PRECIOT` float(10,2) NOT NULL,
  `FECHA` varchar(30) NOT NULL,
  `HORA` varchar(30) NOT NULL,
  `PROVEEDOR` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `actualizacion2`
--

INSERT INTO `actualizacion2` (`ID`, `CLAVE`, `PRODUCTO`, `EXISTENCIA`, `UNIDADES`, `UBICACION`, `PRECIO`, `PRECIOT`, `FECHA`, `HORA`, `PROVEEDOR`) VALUES
(2, 'A016-ES-T304-01 ', 'ESPARRAGOS DE 5/8\", AC.INOXIDABLE T-304 (MTS) ', 8, 'METROS', 'A1', 540.00, 4320.00, '13:04:26', '14/03/2018', 'XX'),
(2, 'A016-ES-T304-01 ', 'ESPARRAGOS DE 5/8\", AC.INOXIDABLE T-304 (MTS) ', 8, 'METROS', 'A1', 540.00, 4320.00, '20:56:24', '14/03/2018', 'XX');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleados`
--

CREATE TABLE `empleados` (
  `ID` int(10) NOT NULL,
  `usuario` varchar(30) DEFAULT NULL,
  `contraseña` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `empleados`
--

INSERT INTO `empleados` (`ID`, `usuario`, `contraseña`) VALUES
(1, 'MARIO', '270895');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `inventario`
--

CREATE TABLE `inventario` (
  `ID` int(10) NOT NULL,
  `CLAVE` varchar(30) DEFAULT NULL,
  `PRODUCTO` varchar(60) NOT NULL,
  `EXISTENCIA` int(10) NOT NULL,
  `UNIDADES` varchar(30) NOT NULL,
  `UBICACION` varchar(10) NOT NULL,
  `PRECIO` float(10,2) NOT NULL,
  `PRECIOT` float(10,2) NOT NULL,
  `FECHA` varchar(30) NOT NULL,
  `HORA` varchar(30) NOT NULL,
  `PROVEEDOR` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `inventario`
--

INSERT INTO `inventario` (`ID`, `CLAVE`, `PRODUCTO`, `EXISTENCIA`, `UNIDADES`, `UBICACION`, `PRECIO`, `PRECIOT`, `FECHA`, `HORA`, `PROVEEDOR`) VALUES
(2, 'A016-ES-T304-01 ', 'ESPARRAGOS DE 5/8\", AC.INOXIDABLE T-304 (MTS) ', 8, 'METROS', 'A1', 540.00, 4320.00, '14/03/2018', '20:56:24', 'XX'),
(3, 'A017-BR-01 ', 'BROCA PARA METAL DE 1/2\" ', 18, 'PZAS', 'A3', 122.00, 2196.00, '14/03/2018', '13:19:10', 'YYY');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `empleados`
--
ALTER TABLE `empleados`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `inventario`
--
ALTER TABLE `inventario`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `ID` (`ID`),
  ADD UNIQUE KEY `CLAVE` (`CLAVE`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `empleados`
--
ALTER TABLE `empleados`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `inventario`
--
ALTER TABLE `inventario`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
