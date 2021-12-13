DROP TABLE IF EXISTS TipoCambio;

CREATE TABLE TipoCambio (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  moneda_origen VARCHAR(3) NOT NULL,
  moneda_destino VARCHAR(3) NOT NULL,
  cambio DECIMAL(6,4) NOT NULL
);

INSERT INTO TipoCambio (moneda_origen, moneda_destino, cambio) VALUES
('USD', 'PEN', 4.11),
('EUR', 'PEN', 5.05),
('CLP', 'PEN', 0.0053),
('PEN','USD', 0.24);