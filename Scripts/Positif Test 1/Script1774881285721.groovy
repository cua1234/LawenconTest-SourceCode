import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')
WebUI.navigateToUrl('https://demoqa.com/automation-practice-form')
//WebUI.maximizeWindow()
WebUI.waitForPageLoad(10)

// Validasi URL
WebUI.verifyMatch(WebUI.getUrl(), '.*automation-practice-form.*', true)

// ===== INPUT FORM =====

// Firstname
if (Firstname) {
    WebUI.setText(findTestObject('Page_demosite/input_First Name'), Firstname)
}

// Lastname
if (Lastname) {
    WebUI.setText(findTestObject('Page_demosite/input_Last Name'), Lastname)
}

// Email (static saja)
WebUI.setText(findTestObject('Page_demosite/input_nameexample.com'), 'sopian@gmail.com')

// Gender
if (Gender?.equalsIgnoreCase('Male')) {
    WebUI.click(findTestObject('Page_demosite/input_Male_gender-radio-2'))
} else if (Gender?.equalsIgnoreCase('Female')) {
    WebUI.click(findTestObject('Page_demosite/input_Female_gender-radio-3'))
}

// Phone
if (Phone) {
    WebUI.setText(findTestObject('Page_demosite/input_Mobile Number'), Phone)
}

// Subject
if (Subject) {
    WebUI.setText(findTestObject('Page_demosite/input_subjectsInput'), Subject)
    WebUI.sendKeys(findTestObject('Page_demosite/input_subjectsInput'), Keys.chord(Keys.ENTER))
}

// Hobby
if (Hobby?.equalsIgnoreCase('Sports')) {
    WebUI.executeJavaScript("document.getElementById('hobbies-checkbox-1').click();", null)
}

// Address
if (Address) {
    WebUI.setText(findTestObject('Page_demosite/textarea_Current Address'), Address)
}

// State
if (State) {
    WebUI.click(findTestObject('Page_demosite/div_css-19bb58m'))
    WebUI.click(findTestObject('Page_demosite/div_react-select-3-option-1'))
}

// Submit
WebUI.scrollToElement(findTestObject('Page_demosite/button_submit'), 3)
WebUI.click(findTestObject('Page_demosite/button_submit'))

// ===== ASSERTION =====

// SUCCESS → popup muncul
if (ExpectedResult == 'SUCCESS') {
    WebUI.waitForElementVisible(findTestObject('Page_demosite/button_closeLargeModal'), 5)
    WebUI.verifyElementVisible(findTestObject('Page_demosite/button_closeLargeModal'))
    WebUI.click(findTestObject('Page_demosite/button_closeLargeModal'))
}

// ERROR → popup TIDAK muncul
else {
    WebUI.verifyElementNotPresent(findTestObject('Page_demosite/button_closeLargeModal'), 5)
}

WebUI.closeBrowser()