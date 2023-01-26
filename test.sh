#!/bin/bash
for ((i=$2; i<=$3; i++)) do
    if (test -f test/input$i.txt && test -f test/output$i.txt); then
        java -cp bin/ $1 < test/input$i.txt > test/myout$i.txt
        if diff test/myout$i.txt test/output$i.txt &>/dev/null; then
            echo -e "\e[32m[PASS] Test Case $i"
        else
            echo -e "\e[31m[FAIL] Test Case $i"
            code --diff test/myout$i.txt test/output$i.txt
        fi
    else
        echo -e "\e[33mWarning: Failed to locate files for Test Case $i, ensure both input$i.txt and output$i.txt are present in the test directory"
    fi
done