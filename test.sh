#!/bin/bash
for ((i=1; i<=4; i++)) do
    echo "Testing case $i"
    java -cp bin/ $1 < test/input$i.txt > test/myout$i.txt
    diff test/myout$i.txt test/output$i.txt
done