
CREATE TABLE `login2` (
  `username` varchar(25) NOT NULL,
  `password` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1

CREATE TABLE `ozekimessagein` (
  `id` varchar(11) NOT NULL,
  `sender` varchar(30) DEFAULT NULL,
  `receiver` varchar(30) DEFAULT NULL,
  `msg` varchar(160) DEFAULT NULL,
  `senttime` varchar(100) DEFAULT NULL,
  `operator` varchar(100) DEFAULT NULL,
  `...

CREATE TABLE `ozekimessageout` (
  `id` varchar(11) NOT NULL,
  `sender` varchar(30) DEFAULT NULL,
  `receiver` varchar(30) DEFAULT NULL,
  `msg` varchar(256) DEFAULT NULL,
  `senttime` datetime DEFAULT NULL,
  `receivetime` datetime DEFAULT NULL,
  `refe...

CREATE TABLE `product` (
  `product_id` varchar(10) NOT NULL,
  `product_name` varchar(25) NOT NULL,
  `product_type` varchar(25) NOT NULL,
  `buying_price` decimal(18,2) NOT NULL,
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1

CREATE TABLE `stock` (
  `stock_id` varchar(10) NOT NULL,
  `product_id` varchar(10) NOT NULL,
  `product_name` varchar(25) NOT NULL,
  `product_type` varchar(25) NOT NULL,
  `selling_price` decimal(18,2) NOT NULL,
  PRIMARY KEY (`stock_id`),
  UNIQUE KEY...

CREATE TABLE `supplier` (
  `supplier_id` varchar(10) NOT NULL,
  `product_id` varchar(10) NOT NULL,
  `supplier_name` varchar(10) NOT NULL,
  `supplier_contact` int(11) NOT NULL,
  PRIMARY KEY (`supplier_id`),
  KEY `product_id` (`product_id`)
) ENGINE=I...
