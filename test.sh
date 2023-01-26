#!/bin/bash
for ((i=1; i<=4; i++)) do
    echo "Testing case $i" # prints which test case number it's currently testing 

    # Compiles the java file and runs it with the input file and outputs the result to myout$i.txt(depends on which test case it's currently testing)
    java -cp bin/ $1 < test/input$i.txt > test/myout$i.txt
    diff test/myout$i.txt test/output$i.txt
done