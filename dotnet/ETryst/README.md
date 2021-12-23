# ETryst

## Demo web application developed thanks to .NET Software Development Kit, version 5.0

From the shell I used the following commands:

```shell
dotnet new webapp -o ETryst --no-https
cd ETryst
dotnet watch run
```
## I add what is needed to connect this demo to a database server MariaDB

```shell
$ dotnet add package MySqlConnector --version 1.3.8
```
