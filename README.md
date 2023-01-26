# assignment_boilerplate

This is a boilerplate layout for CSE205 assignments to allow for MacOS users to use test cases in vscode for java development

Special thanks to `Ryan Woo` for setting everything up, this is a simply template for students to use based off of `HIS` code

## Directions to set up test cases in vsode for MacOS users in VsCode

### `.vscode` Folder

- If you don't already have a .vscode file, create one.
- You should have two files in the `.vsode`

  1.) `settings.json`

  ```
  {
    "version": "2.0.0",
    "tasks": [
      {
        "label": "Run Tests",
        "type": "shell",
        "command": "./test.sh ${fileBasenameNoExtension}",
        "problemMatcher": [],
        "group": {
          "kind": "build",
         "isDefault": true
        }
      }
    ]
  }
  ```

### `bin` folder

- Create a `bin` folder, this folder should hold all of your .class file. When you run the `Java: run test` it will make them automatically

### `src` folder

- Create a `src` folder and it should hold all you `.java` files

### `test` folder

- Create a `test` folder and it should hold all you input an output files
- will output all your myoutput files into this folder for you to compare with.

### `test.sh` file

- in the `test.sh` file, paste this code:

```json:
  #!/bin/bash
  for ((i=1; i<=4; i++)) do
      echo "Testing case $i"
      java -cp bin/ $1 < test/input$i.txt > test/myout$i.txt
     diff test/myout$i.txt test/output$i.txt
  done
```
