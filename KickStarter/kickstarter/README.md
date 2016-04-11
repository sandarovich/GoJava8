<h1> Installation </h1>

Ubuntu
1.Installing a CA
Copy your certificate in PEM format rds-combined-ca-bundle.pem (the format that has ----BEGIN CERTIFICATE---- in it) into /usr/local/share/ca-certificates and name it with a .crt file extension.
Then run sudo update-ca-certificates.
2. Сopy context.xml from resources into Tomcat7.
