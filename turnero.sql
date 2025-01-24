-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 24-01-2025 a las 19:54:50
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `turnero`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ciudadano`
--

CREATE TABLE `ciudadano` (
  `ID` bigint(20) NOT NULL,
  `APELLIDO` varchar(255) DEFAULT NULL,
  `CURP` varchar(255) DEFAULT NULL,
  `NOMBRE` varchar(255) DEFAULT NULL,
  `TELEFONO` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `ciudadano`
--

INSERT INTO `ciudadano` (`ID`, `APELLIDO`, `CURP`, `NOMBRE`, `TELEFONO`) VALUES
(1, 'Juárez', 'JUMR750201HDFRNS09', 'Marisol', '5551234567'),
(2, 'Pérez', 'PEJU870101HDFRNS10', 'Juan', '5552345678'),
(3, 'Gómez', 'GOAN800201HDFRNS11', 'Ana', '5553456789'),
(4, 'Rodríguez', 'ROLU920301HDFRNS12', 'Luis', '5554567890'),
(5, 'López', 'LOMA940401HDFRNS13', 'María', '5555678901'),
(6, 'Martínez', 'MACA950501HDFRNS14', 'Carlos', '5556789012'),
(7, 'Hernández', 'HESO960601HDFRNS15', 'Sofía', '5557890123'),
(8, 'Sánchez', 'SAPE970701HDFRNS16', 'Pedro', '5558901234'),
(9, 'Ramírez', 'RAFE980801HDFRNS17', 'Fernanda', '5559012345'),
(10, 'Torres', 'TODO990901HDFRNS18', 'Diego', '5550123456');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estadoturno`
--

CREATE TABLE `estadoturno` (
  `ID` bigint(20) NOT NULL,
  `NOMBRE` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `estadoturno`
--

INSERT INTO `estadoturno` (`ID`, `NOMBRE`) VALUES
(1, 'En espera'),
(2, 'Ya atendido');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipotramite`
--

CREATE TABLE `tipotramite` (
  `ID` bigint(20) NOT NULL,
  `NOMBRE` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `tipotramite`
--

INSERT INTO `tipotramite` (`ID`, `NOMBRE`) VALUES
(5, 'Actualización de CURP'),
(4, 'Cambio de domicilio'),
(2, 'Registro de nacimiento'),
(1, 'Renovación de pasaporte'),
(3, 'Solicitud de visa');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `turno`
--

CREATE TABLE `turno` (
  `ID` bigint(20) NOT NULL,
  `FECHA` date DEFAULT NULL,
  `NUMEROTURNO` int(11) NOT NULL,
  `CIUDADANO_ID` bigint(20) DEFAULT NULL,
  `ESTADOTURNO_ID` bigint(20) DEFAULT NULL,
  `TIPOTRAMITE_ID` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `turno`
--

INSERT INTO `turno` (`ID`, `FECHA`, `NUMEROTURNO`, `CIUDADANO_ID`, `ESTADOTURNO_ID`, `TIPOTRAMITE_ID`) VALUES
(1, '2025-01-24', 1, 2, 1, 3),
(2, '2025-01-25', 2, 3, 2, 4),
(3, '2025-01-26', 3, 5, 2, 3),
(4, '2025-01-27', 4, 6, 1, 4);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `ciudadano`
--
ALTER TABLE `ciudadano`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `estadoturno`
--
ALTER TABLE `estadoturno`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `NOMBRE` (`NOMBRE`);

--
-- Indices de la tabla `tipotramite`
--
ALTER TABLE `tipotramite`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `NOMBRE` (`NOMBRE`);

--
-- Indices de la tabla `turno`
--
ALTER TABLE `turno`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FK_TURNO_CIUDADANO_ID` (`CIUDADANO_ID`),
  ADD KEY `FK_TURNO_TIPOTRAMITE_ID` (`TIPOTRAMITE_ID`),
  ADD KEY `FK_TURNO_ESTADOTURNO_ID` (`ESTADOTURNO_ID`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `ciudadano`
--
ALTER TABLE `ciudadano`
  MODIFY `ID` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `estadoturno`
--
ALTER TABLE `estadoturno`
  MODIFY `ID` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `tipotramite`
--
ALTER TABLE `tipotramite`
  MODIFY `ID` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `turno`
--
ALTER TABLE `turno`
  MODIFY `ID` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `turno`
--
ALTER TABLE `turno`
  ADD CONSTRAINT `FK_TURNO_CIUDADANO_ID` FOREIGN KEY (`CIUDADANO_ID`) REFERENCES `ciudadano` (`ID`),
  ADD CONSTRAINT `FK_TURNO_ESTADOTURNO_ID` FOREIGN KEY (`ESTADOTURNO_ID`) REFERENCES `estadoturno` (`ID`),
  ADD CONSTRAINT `FK_TURNO_TIPOTRAMITE_ID` FOREIGN KEY (`TIPOTRAMITE_ID`) REFERENCES `tipotramite` (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
