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
|1.  |Click 'Login with Facebook'|Facebook is launched and uses currently logged in account to login| | |

|Post Condition|
|--------------|
|The User is logged in under their Facebook Account|

---

## Test Case 2: Create a New Question
|System|Subsystem|Designed By|Design Date|Executed By|Executed Date|
|------|---------|-----------|-----------|-----------|-------------|
|JustAsk|Question|Miles Vesper|10/21/16| | |

|Preconditions|
|-------------|
|1. The system displays the main menu|

|Step|Action|Expected System Response|Pass/Fail|Comment|
|----|------|------------------------|---------|-------|
|1.  |Click the plus button in the buttom right corner|Pop up that displays blank for new question| | |
|2.  |Enter a question into the blank space|System asks to onfirm the question| | |
|3.  |Click Yes|System shows list of contacts| | |
|4.  |Choose who to send the question to|System asks for confirmation of question| | |
|5.  |Click Send|Question appears on the main menu| | |

|Post Condition|
|--------------|
|The question appears on the homepage and is sent to other users|


