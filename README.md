# appiumAndroidTets
### Проект appiumAndroidTets использует Appium для автоматизации тестирования мобильного приложения Duolingo для изучения языков. Вот краткое описание реализованных методов и используемых фреймворков:
---
## TutorialAccountTest 
Класс тестов с использованием JUnit 5 для расширения функциональности тестов и настройки тестового окружения перед каждым тестом. В начальном методе setUp() инициализируются страницы приложения, такие как TutorialAccountOneStepPage, UserAccountPage и другие.

## BaseTest
@BeforeEach и setUp(): Метод настройки тестового окружения, включая создание экземпляра AndroidDriver с использованием Appium и установку необходимых капабилити для взаимодействия с приложением.

@AfterEach и tearDown(): Метод завершения тестового окружения после выполнения тестов. Производится ожидание в течение 3 секунд для завершения тестов и закрытия приложения.

## AllureAttachmentsManager
@screenshot(): Метод, использующий Appium для создания скриншота мобильного приложения и прикрепления его к отчету Allure.

## MyExtension 
@afterTestExecution(): Расширение, которое при наличии исключения после выполнения теста добавляет скриншот в отчет Allure.

---
Данный проект демонстрирует использование Appium для автоматизации тестирования мобильного приложения Duolingo, интеграцию с Allure для создания информативных отчетов.