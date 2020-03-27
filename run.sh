echo What division is this competition?
read d
echo What Month and Year?(MMMYYYY)
read f
echo What is the name of the program?
read n
cd $d/$f
javac $n.java
java $n
cd ..
cd ..
