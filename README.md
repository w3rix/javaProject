# 🚗 FindJourney - Transportation Management System

## 📌 Overview

FindJourney is a **Java-based transportation management system** that allows users to **choose between transportation companies** and organize their journeys. The project is built using **object-oriented programming (OOP) principles** and includes a **Graphical User Interface (GUI)**.

## 🛠️ Tech Stack

- **Java** - Main programming language.
- **Swing (GUI)** - For building the graphical user interface.
- **OOP (Inheritance, Interface, Has-A Relationships)** - Object-oriented structures.

## 📂 Project Structure

```
FindJourney/
│── bin/                 # Compiled Java class files
│── src/                 # Java source code
│── UML Diagram.pdf      # UML diagram illustrating system architecture
│── .classpath           # Eclipse configuration file
│── .project             # Eclipse project file
```

### **Source Code (src/) Structure:**
- **GUI/** → Graphical User Interface components (`driverFrame.java`, `TransportationGUI.java`, `TripFrame.java`)
- **HasA/** → "Has-A" relationship classes (`Driver.java`)
- **Inheritance/** → Classes following inheritance relationships (`Uber.java`, `Lyft.java`, `Cabify.java`, `TransportationCompany.java`)
- **Interface/** → Interfaces (`Discountable.java`)
- **MainAndSystem/** → Main system logic (`TransportationMain.java`, `TransportationSystem.java`)

## 🚀 Installation & Usage

1. **Open the Project in Eclipse or IntelliJ IDEA**  
   - **For Eclipse:** Use `File > Open Projects from File System` to import the project.
   - **For IntelliJ IDEA:** Use `File > Open` and select the `FindJourney` folder.

2. **Run the Project**  
   - Execute `TransportationMain.java` to start the system.

## 📜 Documentation

For more details, refer to the `UML Diagram.pdf` file.

---

If you need further information about the project, you can explore the source code for a deeper understanding. Happy coding! 🚀
