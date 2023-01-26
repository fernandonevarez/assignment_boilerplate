#!/bin/bash
for ((i=1; i<=4; i++)) do # Loops through the 4 test cases, might need to change the number depending on how many test cases you have
    echo "Testing case $i" # prints which test case number it's currently testing 

    # Compiles the java file and runs it with the input file and outputs the result to myout$i.txt(depends on which test case it's currently testing)
    java -cp bin/ $1 < test/input$i.txt > test/myout$i.txt
    diff test/myout$i.txt test/output$i.txt
done