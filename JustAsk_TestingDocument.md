# Software Testing Document

# JustAsk

Prepared by [Ben Graham](http://github.com/graham768), [John Edward](http://github.com/), [Miles Vesper](http://github.com/), [Patrick Mancuso](http://github.com/ItalianStallion), and [Sam Dowd](http://github.com/samdowd).

Last updated: November 21st, 2016

## List of Test Cases
### 1 - [Successful Facebook Login](#test-case-1-successful-facebook-login)
### 2 - [Create a New Question](#test-case-2-create-a-new-question)
### 3 - [Respond Yes to Notification](#test-case-3-respond-yes-to-notification)
### 4 - [Respond No to Notification](#test-case-4-respond-no-to-notification)
### 5 - [Respond Yes Inside Application](#test-case-5-respond-yes-inside-application)
### 6 - [Respond No Inside Application](#test-case-6-respond-no-inside-application)
### 7 - [Unsucessful Facebook Login](#test-case-7-unsuccessful-facebook-login)
### 8 - [View Question](#test-case-8-view-question)
### 9 - [Open and Close Drawer](#test-case-9-open-and-close-drawer)
### 10 - [Tap Questions tab from Drawer](#test-case-10-tap-questions-tab-from-drawer)
### 11 - [Tap Contacts tab from Drawer](#test-case-11-tap-contacts-from-drawer)

---

## Test Case 1: Successful Facebook Login
|System|Subsystem|Designed By|Design Date|Executed By|Executed Date|
|------|---------|-----------|-----------|-----------|-------------|
|JustAsk|Login|Miles Vesper|10/21/16| | |

|Preconditions|
|-------------|
|1. Successful Application Launch|

|Step|Action|Expected System Response|Pass/Fail|Comment|
|----|------|------------------------|---------|-------|
|1.  |Taps 'Login with Facebook'|Facebook is launched and user is prompted to give JustAsk access to name and friend list. If user is not logged into Facebook, the user logs in now.| | |
|2.  |User gives JustAsk permission to access name and friend list|Facebook Manager notifies JustAsk of a successful login and local database fills with user information| | |

|Post Condition|
|--------------|
|User is brought to the main activity (question list tab) of the app|

---

## Test Case 2: Create a New Question
|System|Subsystem|Designed By|Design Date|Executed By|Executed Date|
|------|---------|-----------|-----------|-----------|-------------|
|JustAsk|Question|Miles Vesper|10/21/16| | |

|Preconditions|
|-------------|
|1. The system displays the main activity (question list tab)|

|Step|Action|Expected System Response|Pass/Fail|Comment|
|----|------|------------------------|---------|-------|
|1.  |Taps the plus button in the buttom right corner|New Question activity initialized prompting user for question details| | |
|2.  |Enter a question and select recipients|Recipients receive a checkmark by their name (uncheck if Tapped again)| | |
|3.  |Taps Send|Question sends to each contact in recipient list and is added to question list tab| | |

|Post Condition|
|--------------|
|User is brought back to question list tab|

---

## Test Case 3: Respond Yes to Notification
|System|Subsystem|Designed By|Design Date|Executed By|Executed Date|
|------|---------|-----------|-----------|-----------|-------------|
|JustAsk|Notification|Sam Dowd|10/21/16| | |

|Preconditions|
|-------------|
|1. Recipient is logged in|
|2. The question has been received by the recipient's phone|
|3. The push notification has appeared|

|Step|Action|Expected System Response|Pass/Fail|Comment|
|----|------|------------------------|---------|-------|
|1.  |Tap the yes button on the notification||Notification disappears and recipient is updatedto "yes" in the database| | |

|Post Condition|
|--------------|
|The recipient's status is updated in the database as responding yes|

---

## Test Case 4: Respond No to Notification
|System|Subsystem|Designed By|Design Date|Executed By|Executed Date|
|------|---------|-----------|-----------|-----------|-------------|
|JustAsk|Notification|Sam Dowd|10/21/16| | |

|Preconditions|
|-------------|
|1. Recipient is logged in|
|2. The question has been received by the recipient's phone|
|3. The push notification has appeared|

|Step|Action|Expected System Response|Pass/Fail|Comment|
|----|------|------------------------|---------|-------|
|1.  |Tap the no button on the notification||Notification disappears and recipient is updated to "no" in the database| | |

|Post Condition|
|--------------|
|The recipient's status is updated in the database as responding no|

---

## Test Case 5: Respond Yes Inside Application
|System|Subsystem|Designed By|Design Date|Executed By|Executed Date|
|------|---------|-----------|-----------|-----------|-------------|
|JustAsk|Question|Sam Dowd|10/21/16| | |

|Preconditions|
|-------------|
|1. Recipient is logged in|
|2. The question has been received by the recipient's phone|
|3. App is launched|
|4. The recipient has navigated to the question list tab|

|Step|Action|Expected System Response|Pass/Fail|Comment|
|----|------|------------------------|---------|-------|
|1.  |Tap unanswered question in question list|Question activity appears| | |
|2.  |Tap yes in Question activity|Question activity updates to show the recipient has responded yes and database is updated| | | 

|Post Condition|
|--------------|
|The recipient's status is updated in the database as responding yes|

---

## Test Case 6: Respond No Inside Application
|System|Subsystem|Designed By|Design Date|Executed By|Executed Date|
|------|---------|-----------|-----------|-----------|-------------|
|JustAsk|Question|Sam Dowd|10/21/16| | |

|Preconditions|
|-------------|
|1. Recipient is logged in|
|2. The question has been received by the recipient's phone|
|3. App is launched|
|4. The recipient has navigated to the question list tab|

|Step|Action|Expected System Response|Pass/Fail|Comment|
|----|------|------------------------|---------|-------|
|1.  |Tap unanswered question in question list|Question activity appears| | |
|2.  |Tap no in Question activity|Question activity updates to show the recipient has responded no and database is updated| | | 

|Post Condition|
|--------------|
|The recipient's status is updated in the database as responding no|

---

## Test Case 7: Unsucessful Facebook Login
|System|Subsystem|Designed By|Design Date|Executed By|Executed Date|
|------|---------|-----------|-----------|-----------|-------------|
|JustAsk|Failed Login|Patrick Mancuso|10/21/16| | |

|Preconditions|
|-------------|
|1. Successful Application Launch|

|Step|Action|Expected System Response|Pass/Fail|Comment|
|----|------|------------------------|---------|-------|
|1.  |Click 'Login with Facebook'|Facebook manager is launched and response is sent from faceBook to app with details of the failed login. These details are displayed on the app underneath the FaceBook Login button| | |

|Post Condition|
|--------------|
|The User remains on the login page with the error message displayed. User can attempt to login again|

---

## Test Case 8: View Question
|System|Subsystem|Designed By|Design Date|Executed By|Executed Date|
|------|---------|-----------|-----------|-----------|-------------|
|JustAsk|Failed Login|Patrick Mancuso|10/21/16| | |

|Preconditions|
|-------------|
|1. Successful Application Launch|
|2. User is logged in| 
|3. User is on the Questions tab (main screen)|

|Step|Action|Expected System Response|Pass/Fail|Comment|
|----|------|------------------------|---------|-------|
|1.  |Click which message you want to view |make call to database pulling table of recipients to messages and their answers. Table is then displayed as a new activity that still contains the app drawer. | | |

|Post Condition|
|--------------|
|1. User is on the View Message activity  |
|2. Entire list of recipients and answers are displayed under the question as a scrollable list |
|3. App drawer is functional in the upper left corner |

---

## Test Case 9: Open and Close Drawer
|System|Subsystem|Designed By|Design Date|Executed By|Executed Date|
|------|---------|-----------|-----------|-----------|-------------|
|JustAsk|Drawer|Ben Graham|10/21/16| | |

|Preconditions|
|-------------|
|1. Recipient is logged in|
|2. App is launched|

|Step|Action|Expected System Response|Pass/Fail|Comment|
|----|------|------------------------|---------|-------|
|1.  |Tap drawer button|Drawer opens displaying list items: Questions, Contacts, Setttings| |
|2.  |Tap drawer button after opening drawer|Drawer closes displaying current tab| |

|Post Condition|
|--------------|
|The drawer is closed revealing the current tab|

---

## Test Case 10: Tap Questions tab from Drawer
|System|Subsystem|Designed By|Design Date|Executed By|Executed Date|
|------|---------|-----------|-----------|-----------|-------------|
|JustAsk|Drawer|Ben Graham|10/21/16| | |

|Preconditions|
|-------------|
|1. Recipient is logged in|
|2. App is launched|
|3. Drawer is open|

|Step|Action|Expected System Response|Pass/Fail|Comment|
|----|------|------------------------|---------|-------|
|1.  |Tap Questions tab|Question list activity is loaded with user information from database (. Drawer is closed.|

|Post Condition|
|--------------|
|Question tab inside drawer is highlighted; User is brought to questions list activity|

---

## Test Case 11: Tap Contacts tab from Drawer
|System|Subsystem|Designed By|Design Date|Executed By|Executed Date|
|------|---------|-----------|-----------|-----------|-------------|
|JustAsk|Drawer|Ben Graham|10/21/16| | |

|Preconditions|
|-------------|
|1. Recipient is logged in|
|2. App is launched|
|3. Drawer is open|

|Step|Action|Expected System Response|Pass/Fail|Comment|
|----|------|------------------------|---------|-------|
|1.  |Tap Contacts tab|Contact activity is loaded with user's friends from database. Drawer is closed.|

|Post Condition|
|--------------|
|Question tab inside drawer is highlighted; User is brought to questions list activity|

---

## Test Case 12: Open and Close Settings
|System|Subsystem|Designed By|Design Date|Executed By|Executed Date|
|------|---------|-----------|-----------|-----------|-------------|
|JustAsk|Settings|Sam Dowd|10/21/16| | |

|Preconditions|
|-------------|
|1. Recipient is logged in|
|2. App is launched|
|3. The drawer is open|

|Step|Action|Expected System Response|Pass/Fail|Comment|
|----|------|------------------------|---------|-------|
|1.  |Tap settings list item|Settings activity opens| | |
|2.  |Tap back button|User is directed back to the main activity| | |

|Post Condition|
|--------------|
|App is in the main activity (question list tab)|

---

## Test Case 13: Mute Notifications
|System|Subsystem|Designed By|Design Date|Executed By|Executed Date|
|------|---------|-----------|-----------|-----------|-------------|
|JustAsk|Settings|Sam Dowd|10/21/16| | |

|Preconditions|
|-------------|
|1. Recipient is logged in|
|2. App is launched|
|3. The settings activity is open|
|4. User's notifications are not muted|

|Step|Action|Expected System Response|Pass/Fail|Comment|
|----|------|------------------------|---------|-------|
|1.  |Tap checkbox next to "Mute Notifications"|Check box updates to checked and user entry in database is updated| | |
|2.  |Press home button on phone|App closes| | |
|3.  |Send user question from another phone|No push notification appears on user's phone| | |

|Post Condition|
|--------------|
|The app is closed and the user has no push notifications from JustAsk|

---

## Test Case 14: Unmute Notifications
|System|Subsystem|Designed By|Design Date|Executed By|Executed Date|
|------|---------|-----------|-----------|-----------|-------------|
|JustAsk|Settings|Sam Dowd|10/21/16| | |

|Preconditions|
|-------------|
|1. Recipient is logged in|
|2. App is launched|
|3. The settings activity is open|
|4. User's notifications are muted|

|Step|Action|Expected System Response|Pass/Fail|Comment|
|----|------|------------------------|---------|-------|
|1.  |Tap checkbox next to "Mute Notifications"|Check box updates to unchecked and user entry in database is updated| | |
|2.  |Press home button on phone|App closes| | |
|3.  |Send user question from another phone|Push notification appears on user's phone| | |

|Post Condition|
|--------------|
|The app is closed and the user has one push notification from JustAsk|

---

## Test Case 15: Logout
|System|Subsystem|Designed By|Design Date|Executed By|Executed Date|
|------|---------|-----------|-----------|-----------|-------------|
|JustAsk|Settings|Sam Dowd|10/21/16| | |

|Preconditions|
|-------------|
|1. Recipient is logged in|
|2. App is launched|
|3. The settings activity is open|

|Step|Action|Expected System Response|Pass/Fail|Comment|
|----|------|------------------------|---------|-------|
|1.  |Tap logout list item|User is redirected to login screen| | |

|Post Condition|
|--------------|
|The session is updated in the database to have no user associated with it|

---

## Test Case 16: Delete Account
|System|Subsystem|Designed By|Design Date|Executed By|Executed Date|
|------|---------|-----------|-----------|-----------|-------------|
|JustAsk|Settings|Sam Dowd|10/21/16| | |

|Preconditions|
|-------------|
|1. Recipient is logged in|
|2. App is launched|
|3. The settings activity is open|

|Step|Action|Expected System Response|Pass/Fail|Comment|
|----|------|------------------------|---------|-------|
|1.  |Tap delete account list item|User is redirected to the login page| | |

|Post Condition|
|--------------|
|User is removed from the database|
