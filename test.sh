#!/bin/bash

if [ $# -ne 1 ]; then
    echo "Usage: $0 <main_class>"
    echo "Example: $0 MyClass"
    exit 1
fi

PASS_COLOR=$(tput setaf 2)
FAIL_COLOR=$(tput setaf 1)
WARN_COLOR=$(tput setaf 3)
INFO_COLOR=$(tput setaf 4)
RESET_COLOR=$(tput sgr0)

echo -e "${INFO_COLOR}[INFO] Compiling Java code...${RESET_COLOR}"
javac -d bin/ src/*.java
if [ $? -ne 0 ]; then
    echo -e "${FAIL_COLOR}[ERROR] Compilation failed. Aborting.${RESET_COLOR}"
    exit 1
fi

total_tests=4
passed_tests=0
failed_tests=0

for ((i=1; i<=total_tests; i++)) do
    echo -e "${INFO_COLOR}Testing case $i${RESET_COLOR}"

    if (test -f test/input$i.txt && test -f test/output$i.txt); then
        java -cp bin/ $1 < test/input$i.txt > test/myout$i.txt

        if diff -w --strip-trailing-cr test/myout$i.txt test/output$i.txt &>/dev/null; then
            echo -e "${PASS_COLOR}[PASS] Test Case $i${RESET_COLOR}"
            ((passed_tests++))
        else
            echo -e "${FAIL_COLOR}[FAIL] Test Case $i${RESET_COLOR}"
            ((failed_tests++))
            diff -w --strip-trailing-cr test/myout$i.txt test/output$i.txt
        fi
    else
        echo -e "${WARN_COLOR}Warning: Failed to locate files for Test Case $i, ensure both input$i.txt and output$i.txt are present in the test directory${RESET_COLOR}"
    fi
done

echo -e "${INFO_COLOR}[INFO] Test Summary:"
echo -e "${PASS_COLOR}Passed: $passed_tests/${total_tests}${RESET_COLOR}"
echo -e "${FAIL_COLOR}Failed: $failed_tests/${total_tests}${RESET_COLOR}"
