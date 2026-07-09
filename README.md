Todo App – Selenium Test Automation Suite

Automated test suite for qacart-todo, combining Selenium WebDriver UI tests with REST Assured API calls, built in Java with TestNG, the Page Object Model, and Allure reporting.
App under test: https://qacart-todo.herokuapp.com/

🧩 What's Tested:
User login with email/password
Creating a new todo item
Completing a todo item
Deleting a todo item

🧱 How It's Built:
Page Object Model — login, todo, and newtodo page classes, each extending a shared BaseForPages that initializes elements via PageFactory.
Hybrid API + UI setup — instead of registering/adding tasks through the UI every time, tests call the app's API directly (RegisterApi, TasksApi) to create users and seed data, then inject the resulting cookies into the browser session. This makes tests faster and less dependent on unrelated UI flows.
Allure step annotations (@Step, @Feature, @Story, @Description) on page actions and test cases for readable, organized reports.
Automatic failure screenshots — BaseTest captures a screenshot after every test and attaches it to the Allure report.
Parallel execution — configured via Maven Surefire (parallel=methods, threadCount=3).

📁 Project Structure:
src/test/groovy/com/qacart/todo/
├── api/            # RegisterApi, TasksApi — REST Assured calls to seed test state
├── base/           # BaseTest (setup/teardown, screenshots), BaseForPages (PageFactory init)
├── configUtils/     # production.properties
├── factory/        # Factory — WebDriver initialization (WebDriverManager + ChromeDriver)
├── models/         # Task, User — POJOs for API request bodies
├── pages/          # login, todo, newtodo — Page Objects
├── testcases/      # loginTest, TodoTest — actual test classes
└── utils/          # CookieUtils, UserUtils

⚙️ Setup & Installation:
Prerequisites:
Java JDK 21+
Maven
Chrome browser (ChromeDriver is handled automatically by WebDriverManager)

👩‍💻 Author

Aya Abdelhadi
Software Engineer | QA Automation Enthusiast
