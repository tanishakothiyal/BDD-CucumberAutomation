# 🧪 BDD-Driven Automation Framework

This repository contains a BDD-based test automation framework built using **Java**, **Cucumber**, **Selenium WebDriver**, and **TestNG**. It's structured with the **Page Object Model (POM)** and is designed to test e-commerce site functionalities such as user login, product selection, and cart operations.

---

## 🚀 Tech Stack

- 🟦 Java 17
- ⚙️ Maven
- 🧪 TestNG
- 🥒 Cucumber (BDD)
- 🧭 Selenium WebDriver
- 📋 Page Object Model


---

## 📁 Project Structure

bdd‑qa‑framework/
├── pom.xml
├── src/
│   ├── main/
│   │   └── java/
│   │       └── pages/                  # POM classes
│   ├── test/
│       ├── java/
│       │   ├── steps/                 # Cucumber step defs
│       │   ├── runners/               # TestNG & Cucumber runners
│       │   └── api/                   # RestAssured tests
│       └── resources/
│           └── features/              # .feature files
└── .github/
    └── workflows/
        └── ci.yml                     # GitHub Actions pipeline
└── README.md

## 🛠 How to Run the Tests

### 💻 Using IntelliJ:
1. Open project in IntelliJ
2. Right-click on `TestRunner.java` → **Run**
3. See results in the terminal or TestNG window

📦 Setup Instructions

1.Clone the repo: git repo https://github.com/tanishakothiyal/BDD-CucumberAutomation

2.Import the project into IntelliJ as a Maven project

3.Make sure you have:

Java 17 installed,
Chrome browser,
ChromeDriver in your system path

Run the tests and enjoy automation magic 🔥


 
