main: HowLong.java PieceOfString.java
	javac -cp ./ -g -Xlint *.java
	java HowLong < i00.txt
