# appiumAndroidTets
### Проект appiumAndroidTets использует Appium для автоматизации тестирования мобильного приложения [Duolingo](https://ru.duolingo.com/) для изучения языков. Вот краткое описание реализованных методов и используемых фреймворков:
---
## [TutorialAccountTest](https://github.com/markuma13/appiumAndroidTest/blob/master/src/test/java/android/project/duolingo/duolingoTest/TutorialAccountTest.java) 
Класс тестов с использованием JUnit 5 для расширения функциональности тестов и настройки тестового окружения перед каждым тестом. В начальном методе setUp() инициализируются страницы приложения, такие как TutorialAccountOneStepPage, UserAccountPage и другие.

## [BaseTest](https://github.com/markuma13/appiumAndroidTest/blob/master/src/test/java/android/project/duolingo/duolingoTest/BaseTest.java)
@BeforeEach и setUp(): Метод настройки тестового окружения, включая создание экземпляра AndroidDriver с использованием Appium и установку необходимых капабилити для взаимодействия с приложением ([APK](https://apkpure.com/ru/duolingo-language-lessons/com.duolingo)).

@AfterEach и tearDown(): Метод завершения тестового окружения после выполнения тестов. Производится ожидание в течение 3 секунд для завершения тестов и закрытия приложения.

## [AllureAttachmentsManager](https://github.com/markuma13/appiumAndroidTest/blob/master/src/test/java/android/project/duolingo/AllureAttachmentsManager.java)
@screenshot(): Метод, использующий Appium для создания скриншота мобильного приложения и прикрепления его к отчету Allure.

## MyExtension 
@afterTestExecution(): Расширение, которое при наличии исключения после выполнения теста добавляет скриншот в отчет Allure.

## [Pages](https://github.com/markuma13/appiumAndroidTest/tree/master/src/test/java/android/project/duolingo/pages)
Необходимые страницы с действующими локаторами и методами для основного класса тестов.

---
Данный проект демонстрирует использование Appium для автоматизации тестирования мобильного приложения Duolingo, интеграцию с Allure для создания информативных отчетов.
