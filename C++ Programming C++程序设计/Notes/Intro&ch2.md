# Object Oriented Programming with C++

*2024 Spring Semester*

$\text{21 CST H3Art}$

## Introduction

**Grade distribution**
- Homework assignments: 10%
- Attendance: 10%
- Midterm exam:20%
- Final exam: 60%

**C++: A federation of languages**
- C
  - C is the base of C++
- Object-Oriented C++
  - C with classes: **classes（类）**, **encapsulation（封装）**,**inheritance（继承）**, **polymorphism（多态）**, **virtual functions（虚函数）** et al.
- Template（模板） C++
  - **Generic programming（泛型编程）**
- STL
  - **Standard Template Library（标准模版库）**

## Chapter 2 Beginning with C++

- C++ has **two conventions** for comment:
    ```c++
    //

    /* */ C-syntax
    ```

- A line beginning with a **pound sign(#)** is called a **preprocessor directive**
    ```c++
    #include <iostream>
    ```
  - Header files contain constant, variable, data type,classes and function **declarations** needed by a program (**no definitions**)

 | Type of header file | Rule                               | Examples             |
 | ------------------- | ---------------------------------- | -------------------- |
 | C style             | With suffix .h                     | string.h, iostream.h |
 | C++ style           | Without suffix .h                  | string, iostream     |
 | Converted c style   | With affix c and without suffix .h | cstring, cmath       |

- C++ provides **namespaces** to prevent name conflicts.
  - Namespace defines a scope for the identifiers that are used in a program.
  - Namespace is the mechanism for supporting module programming paradigm (模块编程范式).
  - **std** is the namespace where identifiers in ANSI C++ **standard libraries** are declared.
    ```c++
    using namespace std;
    ```
  - An identifier declared within a namespace block **can be accessed directly** only by statements within that block.
  - To access an identifier that is **"hidden" inside a namespace**, the programmer has several options. We describe two options here. 
    - The first option is to **use a qualified name for the identifier**. A qualified name consists of the name of the namespace, then the **:: operator** (**the scope resolution operator**), and the desired identifier: 
    ```c++
    std::cout
    ```
    - The second option is use a statement called a using directive:
    ```c++
    using namespace std;
    ```

- **Output & Input**
  - For standard output, use **cout**
    - **cout** is a predefined object of the standard output stream
    ```c++
    cout << S1 << ' ' << S2 << ' ' << S3 << endl;
    ```
    - The reserved word, **endl**, ensures that the next cout command prints its stuff on a **new line**. 
    - The identifier **endl** is a special C++ feature called a **manipulator**.
    - New lines can also be added using '**\n**'. 
  - For standard input, use **cin**
    - **cin** is a predefined object of the standard input stream
    ```c++
    cin >> V1 >> V2 >> V3;
    ```
    - Split the input elements by **space** or **return**.


