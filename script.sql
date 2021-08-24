CREATE DATABASE FarmaStore;

CREATE TABLE Client(
    clientId int NOT NULL AUTO_INCREMENT,
    cartId int NOT NULL,
    userId int NOT NULL,
    name varchar(50) NOT NULL,
    surname varchar(50) NOT NULL,
    billingAddress varchar(50) NOT NULL,
    deliveryAddress varchar(50) NOT NULL,
    PRIMARY KEY (clientId),
    FOREIGN KEY (cartId) REFERENCES Cart(cartId),
    FOREIGN KEY (userId) REFERENCES User(userId)
); 

CREATE TABLE Cart(
	cartId int NOT NULL AUTO_INCREMENT,
    methodID int not NULL,
    totalAmount int NOT NULL,
    PRIMARY KEY (cartId),
    FOREIGN KEY (methodId) REFERENCES PaymentMethod(methodId)
);

CREATE TABLE User(
	userId int NOT NULL AUTO_INCREMENT,
    email varchar(50) NOT NULL,
    password varchar(50) NOT NULL,
    PRIMARY KEY (userId)
);



CREATE TABLE Administrator(
	adminId int NOT NULL AUTO_INCREMENT,
    name varchar(50) NOT NULL,
    userID int not NULL,
    PRIMARY KEY (adminId),
    FOREIGN KEY (userID) REFERENCES User (userID)
);

CREATE TABLE Orden (
	orderNumber int NOT NULL AUTO_INCREMENT,
    clientID int not NULL,
    amountPayed int not NULL,
	date DATE,
    estimatedDelivery varchar(50) NOT NULL,
    cartId int not NULL,
    PRIMARY KEY (orderNumber),
    FOREIGN KEY (clientID) REFERENCES Client(clientID),
    FOREIGN KEY (cartId) REFERENCES Cart(cartId)
);

CREATE TABLE OrderDetail (
	productXOrderId int NOT NULL AUTO_INCREMENT,
    orderNumber int NOT NULL,
    productId int NOT NULL, 
    productPrice int NOT NULL,
    productAmount int NOT NULL,
    PRIMARY KEY (orderDetail),
    FOREIGN KEY (orderNumber) REFERENCES Orden(orderNumber),
    FOREIGN KEY (productId) REFERENCES Product(productId)
);    

CREATE TABLE Product(
	productId int NOT NULL AUTO_INCREMENT,
    name varchar(50) NOT NULL,
    price int not NULL,
    details varchar(100) NOT NULL,
    amountInStock int not NULL,
	minimumNeeded int not NULL,
    catNameId int not NULL,
    stateId int not NULL,
    categoryId int not NULL,
    adminId int not NULL,
    PRIMARY KEY ( productId),
    FOREIGN KEY (catNameId) REFERENCES CategoryName(catNameId),
    FOREIGN KEY (stateId) REFERENCES State(stateId),
    FOREIGN KEY (categoryId) REFERENCES Category(categoryId),
    FOREIGN KEY (adminId) REFERENCES Administrator(adminId)
);

CREATE TABLE State(
	stateId int NOT NULL AUTO_INCREMENT,
    stateName varchar(50) NOT NULL,
    PRIMARY KEY (stateId)
);

CREATE TABLE Category(
	categoryId int not NULL AUTO_INCREMENT,
    catNameId int not NULL,
    fatherCatId int not NULL,
    adminId int not NULL,
    PRIMARY KEY (categoryId),
    FOREIGN KEY (catNameId) REFERENCES CategoryName (catNameId),
    FOREIGN KEY (fatherCatId) REFERENCES Category (fatherCatId),
    FOREIGN KEY (adminId) REFERENCES Administrator (adminId)
);

CREATE TABLE CategoryName(
	catNameId int NOT NULL AUTO_INCREMENT,
    catName varchar(50) NOT NULL,
    PRIMARY KEY (catNameId)
);

CREATE TABLE ProductXCart(
	productXCartId int NOT NULL AUTO_INCREMENT,
	cartId int NOT NULL,
    productId int NOT NULL,
    amountInCart int NOT NULL,
    PRIMARY KEY (productXCartId),
	FOREIGN KEY (cartId) REFERENCES Cart (cartId),
    FOREIGN KEY (productId) REFERENCES Product (productId)
);

CREATE TABLE MethodSelected(
	methodSelectId int NOT NULL AUTO_INCREMENT,
    methodId int NOT NULL,
	PRIMARY KEY (methodSelectId),
    FOREIGN KEY (methodId) REFERENCES PaymentMethod(methodId)
);

CREATE TABLE PaymentMethod(
	methodId int NOT NULL AUTO_INCREMENT,
    method varchar(50) NOT NULL,
	PRIMARY KEY (methodId)
);



