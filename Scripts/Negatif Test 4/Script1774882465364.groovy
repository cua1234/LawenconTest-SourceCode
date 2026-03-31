import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import org.openqa.selenium.Keys as Keys


WebUI.openBrowser('https://demoqa.com/automation-practice-form')
WebUI.maximizeWindow()
WebUI.waitForPageLoad(10)

// 1. Verifikasi apakah URL sudah benar
WebUI.verifyMatch(WebUI.getUrl(), 'https://demoqa.com/automation-practice-form', true)

WebUI.setText(findTestObject('Page_demosite/input_First Name'), 'Sopian')
WebUI.setText(findTestObject('Page_demosite/input_Last Name'), 'Manurung')

WebUI.setText(findTestObject('Page_demosite/input_nameexample.com'), 'sopian@gmail.com')

try {
    WebUI.click(findTestObject('Page_demosite/input_Male'))
} catch (Exception e) {
    WebUI.executeJavaScript("document.getElementById('gender-radio-1').click();", null)
}

WebUI.setText(findTestObject('Page_demosite/input_Mobile Number'), '0812746732')

WebUI.click(findTestObject('Page_demosite/input_dateOfBirthInput'))
WebUI.selectOptionByValue(findTestObject('Page_demosite/select_19001901190219031904190519061907190819091'), '2000', false)

WebUI.click(findTestObject('Page_demosite/div_Choose Thursday, March 23rd, 2000'))

WebUI.setText(findTestObject('Page_demosite/input_subjectsInput'), 'Computer Science')
WebUI.sendKeys(findTestObject('Page_demosite/input_subjectsInput'), Keys.chord(Keys.ENTER))

WebUI.executeJavaScript("document.getElementById('hobbies-checkbox-1').click();", null) // Sports
WebUI.executeJavaScript("document.getElementById('hobbies-checkbox-2').click();", null) // Reading
WebUI.executeJavaScript("document.getElementById('hobbies-checkbox-3').click();", null) // Music

//WebUI.setText(findTestObject('Page_demosite/textarea_Current Address'), 'Sudirman Park, South Jakarta')

WebUI.scrollToElement(findTestObject('Page_demosite/button_submit'), 3)

WebUI.click(findTestObject('Page_demosite/div_css-19bb58m'))
WebUI.click(findTestObject('Page_demosite/div_react-select-3-option-1')) // NCR

WebUI.click(findTestObject('Page_demosite/div_css-19bb58m_1'))
WebUI.click(findTestObject('Page_demosite/div_react-select-3-option-1')) // Delhi

WebUI.click(findTestObject('Page_demosite/button_submit'))
WebUI.waitForElementVisible(findTestObject('Page_demosite/button_closeLargeModal'), 5)
WebUI.click(findTestObject('Page_demosite/button_closeLargeModal'))

// WebUI.closeBrowser()