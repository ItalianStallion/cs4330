# Software Testing Document

# JustAsk

Prepared by [Ben Graham](http://github.com/graham768), [John Edward Schwartzenburg](http://github.com/), [Miles Vesper](http://github.com/mvesper20), [Patrick Mancuso](http://github.com/ItalianStallion), and [Sam Dowd](http://github.com/samdowd).

Last updated: November 21st, 2016

## List of Test Cases
#### 1 - [Successful Facebook Login](#test-case-1-successful-facebook-login)
#### 2 - [Create a New Question](#test-case-2-create-a-new-question)
#### 3 - [Respond Yes to Notification](#test-case-3-respond-yes-to-notification)
#### 4 - [Respond No to Notification](#test-case-4-respond-no-to-notification)
#### 5 - [Respond Yes Inside Application](#test-case-5-respond-yes-inside-application)
#### 6 - [Respond No Inside Application](#test-case-6-respond-no-inside-application)
#### 7 - [Unsucessful Facebook Login](#test-case-7-unsuccessful-facebook-login)
#### 8 - [View Question](#test-case-8-view-question)
#### 9 - [Close Question Activity](#test-case-9-close-question-activity)
#### 10 - [Open and Close Drawer](#test-case-10-open-and-close-drawer)
#### 11 - [Tap Questions tab from Drawer](#test-case-11-tap-questions-tab-from-drawer)
#### 12 - [Tap Contacts tab from Drawer](#test-case-12-tap-contacts-tab-from-drawer)
#### 13 - [Open and Close Settings](#test-case-13-open-and-close-settings)
#### 14 - [Mute Notifications](#test-case-14-mute-notifications)
#### 15 - [Unmute Notifications](#test-case-15-unmute-notifications)
#### 16 - [Logout](#test-case-16-logout)
#### 17 - [Delete Account](#test-case-17-delete-account)

---

## Test Case 1: Successful Facebook Login
|System|Subsystem|Designed By|Design Date|Executed By|Executed Date|
|------|---------|-----------|-----------|-----------|-------------|
|JustAsk|Login|Miles Vesper|10/21/16| | |

|Preconditions|
|-------------|
|1. Successful Application Launch|
|2. User is not logged in to JustAsk|
|3. User has a Facebook account and is logged in on their phone|

|Step|Action|Expected System Response|Pass/Fail|Comment|
|----|------|------------------------|---------|-------|
|1.  |Tap 'Login with Facebook'|Facebook Manager is launched and user is prompted to give JustAsk access to name and friend list.| | |
|2.  |Tap within Facebook Manager to give JustAsk permission to access name and friend list|Facebook Manager notifies JustAsk of a successful login and local database fills with user information| | |

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
|1. The main activity (question list tab) is open|

|Step|Action|Expected System Response|Pass/Fail|Comment|
|----|------|------------------------|---------|-------|
|1.  |Tap the plus button in the bottom right corner|NewQuestion activity initialized prompting user for question details| | |
|2.  |Enter a question and select recipients|Recipients receive a checkmark by their name (uncheck if tapped again)| | |
|3.  |Tap Send|Question sends to each contact in recipient list and is added to question list tab| | |

|Post Condition|
|--------------|
|User is brought back to question list tab|

---

## Test Case 3: Respond Yes to Notification
|System|Subsystem|Designed By|Design Date|Executed By|Executed Date|
|------|---------|-----------|-----------|-----------|-------------|
|JustAsk|Notification|John Edward Schwartzenburg|10/21/16| | |

|Preconditions|
|-------------|
|1. Recipient is logged in|
|2. The question has been received by the recipient's phone|
|3. The push notification has appeared|

|Step|Action|Expected System Response|Pass/Fail|Comment|
|----|------|------------------------|---------|-------|
|1.  |Tap the yes button on the notification|Notification disappears and recipient is updated to "yes" in the database| | |

|Post Condition|
|--------------|
|The recipient's status is updated in the database as responding yes|

---

## Test Case 4: Respond No to Notification
|System|Subsystem|Designed By|Design Date|Executed By|Executed Date|
|------|---------|-----------|-----------|-----------|-------------|
|JustAsk|Notification|John Edward Schwartzenburg|10/21/16| | |

|Preconditions|
|-------------|
|1. Recipient is logged in|
|2. The question has been received by the recipient's phone|
|3. The push notification has appeared|

|Step|Action|Expected System Response|Pass/Fail|Comment|
|----|------|------------------------|---------|-------|
|1.  |Tap the no button on the notification|Notification disappears and recipient is updated to "no" in the database| | |

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
|1.  |Tap unanswered question in question list|Question activity is loaded and opens with question and recipient list from database| | |
|2.  |Tap no in Question activity|Question activity updates to show the recipient has responded no and database is updated| | | 

|Post Condition|
|--------------|
|The recipient's status is updated in the database as responding no|

---

## Test Case 7: Unsucessful Facebook Login
|System|Subsystem|Designed By|Design Date|Executed By|Executed Date|
|------|---------|-----------|-----------|-----------|-------------|
|JustAsk|Login|Patrick Mancuso|10/21/16| | |

|Preconditions|
|-------------|
|1. Successful Application Launch|

|Step|Action|Expected System Response|Pass/Fail|Comment|
|----|------|------------------------|---------|-------|
|1.  |Tap 'Login with Facebook'|Facebook Login is launched within the app.| | |
|2.  |Enter invalid credentials (ie. username "ZZZZZZZZ")|Facebook manager returns error| | |

|Post Condition|
|--------------|
|The User remains on the login page with the error message displayed. User can attempt to login again|

---

## Test Case 8: View Question
|System|Subsystem|Designed By|Design Date|Executed By|Executed Date|
|------|---------|-----------|-----------|-----------|-------------|
|JustAsk|Question|Patrick Mancuso|10/21/16| | |

|Preconditions|
|-------------|
|1. Successful Application Launch|
|2. User is logged in| 
|3. User is on the main activity (question list tab)|

|Step|Action|Expected System Response|Pass/Fail|Comment|
|----|------|------------------------|---------|-------|
|1.  |Tap question element from question list |Question activity is created with question and recipient list data loaded from the database| | |
|2.  |Tap back button to exit question |Question activity is destroyed and user is brought back to question list activity| | |

|Post Condition|
|--------------|
|User is on the main activity (question list activity)|

---

## Test Case 9: Close Question Activity
|System|Subsystem|Designed By|Design Date|Executed By|Executed Date|
|------|---------|-----------|-----------|-----------|-------------|
|JustAsk|Question|Patrick Mancuso|10/21/16| | |

|Preconditions|
|-------------|
|1. Successful Application Launch|
|2. User is logged in| 
|3. User viewing a question activity|

|Step|Action|Expected System Response|Pass/Fail|Comment|
|----|------|------------------------|---------|-------|
|1.  |Tap back button |Question activity is destroyed| | |

|Post Condition|
|--------------|
|User is on the main activity (question list activity)|

---

## Test Case 10: Open and Close Drawer
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

## Test Case 11: Tap Questions tab from Drawer
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

## Test Case 12: Tap Contacts tab from Drawer
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

## Test Case 13: Open and Close Settings
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

## Test Case 14: Mute Notifications
|System|Subsystem|Designed By|Design Date|Executed By|Executed Date|
|------|---------|-----------|-----------|-----------|-------------|
|JustAsk|Settings|Ben Graham|10/21/16| | |

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

## Test Case 15: Unmute Notifications
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

## Test Case 16: Logout
|System|Subsystem|Designed By|Design Date|Executed By|Executed Date|
|------|---------|-----------|-----------|-----------|-------------|
|JustAsk|Settings|Patrick Mancuso|10/21/16| | |

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

## Test Case 17: Delete Account
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
