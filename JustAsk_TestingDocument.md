# Software Testing Document

# JustAsk

Prepared by [Ben Graham](http://github.com/graham768), [John Edward](http://github.com/), [Miles Vesper](http://github.com/), [Patrick Mancuso](http://github.com/ItalianStallion), and [Sam Dowd](http://github.com/samdowd).

Last updated: November 21st, 2016

## List of Test Cases
### 1 - [Successful Facebook Login](#test-case-1-successful-facebook-login)
### 2 - [Create a New Question](#test-case-2-create-a-new-question)

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


