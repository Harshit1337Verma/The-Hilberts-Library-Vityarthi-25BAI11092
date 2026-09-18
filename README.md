The Infinite Library

Overview

**The Infinite Library** is a Java-based computational simulation inspired by the idea of an infinite library containing every possible sequence of characters.

A user can enter text, and the program computes its corresponding location in the library.

The project demonstrates how a simple mathematical encoding system can represent an effectively enormous information space without storing that information explicitly, Inspired by The Library Of Babel.

---

Objectives

The main objectives of the project are:

* To demonstrate numerical encoding of textual information.
* To represent an extremely large conceptual library using computation rather than physical storage.
* To calculate a deterministic location for any supported text.
* To generate a deterministic page representation associated with the calculated location.
* To demonstrate how mathematical mappings can replace brute-force storage.
* To implement the system using a modular Java architecture.

---

Features

1. Text Search
The user can enter a sequence of characters through the graphical interface.
The program validates the input and searches for its corresponding location.

2. Mathematical Text Encoding
Each supported character is assigned a numerical value.
The complete text is converted into a `BigInteger` using positional encoding.
For an alphabet of size 27:

$$
V_{n+1}=27V_n+d
$$
where \(d\) represents the numerical value of the current character.
This allows arbitrarily long supported strings to be represented as large integers.

3. Library Address Generation
The resulting integer is mapped into a hierarchical library address consisting of:
* Book
* Page
* Character position
The current configuration uses:
* 1000 characters per page
* 100 pages per book

4. Deterministic Page Generation

The project generates a deterministic page from the calculated numerical address.
The same input therefore produces the same calculated location and page representation.

5. Text Decoding

The numerical representation is converted back into text using the same alphabet and positional representation.
This provides a basic verification that the encoding process is reversible for supported input.



Technologies Used

* Java
* Java Swing
* `BigInteger`
* Object-Oriented Programming
* Modular class-based architecture
* Mathematical positional encoding



Project Structure

```
InfiniteLibrary/
│
├── src/
│   └── module-info.java
|   ├── infinitelibrary/
│       ├── InfiniteLibrary.java
│       ├── LibraryEngine.java
│       ├── TextEncoder.java
│       ├── TextDecoder.java
│       ├── LibraryAddress.java
│       ├── PageGenerator.java
│       └── SearchResult.java
│
├── README.md
├── statement.md
└── Project_Report.md
```

`module-info.java` is included only when the project is configured as a Java module.

---

Class Responsibilities

`InfiniteLibrary`

Responsible for the graphical user interface.
It accepts user input, displays results, and communicates with the `LibraryEngine`.

`LibraryEngine`

Acts as the main computational coordinator.
It connects the encoder, decoder, address generator, page generator, and search result.

`TextEncoder`
Converts supported text into a `BigInteger`.

`TextDecoder`
Converts the numerical representation back into text.

`LibraryAddress`
Converts the numerical value into a hierarchical library location.

`PageGenerator`
Produces a deterministic page representation associated with the calculated address.

`SearchResult`
Stores the results of a search operation in a single object.



Running the Project

Requirements
* Java Development Kit (JDK 17 or later recommended)
* Java Swing support
* A Java-compatible operating system

Compile
From the project source directory:

```
javac -d out src/infinitelibrary/*.java
```

If the project uses `module-info.java`, compile using the appropriate module structure.

Run
```
java -cp out infinitelibrary.InfiniteLibrary
```

The graphical interface will open after launching the program.

---

Usage
1. Launch the program.
2. Enter text into the input field.
3. Click **Find in Library**.
4. The program calculates the numerical representation.
5. The corresponding library location is displayed.
6. A deterministic page representation is generated.
7. The decoded text is displayed as a verification step.
