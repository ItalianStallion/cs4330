# Software Requirements Specification

# Check In

Prepared by [Ben Graham](http://github.com/graham768), [John Edward](http://github.com/), [Miles Vesper](http://github.com/), [Patrick Mancuso](http://github.com/ItalianStallion), and [Sam Dowd](http://github.com/samdowd).

Last updated: October 21st, 2016

## Table of Contents

1. [Introduction](#1-introduction)
  1. [Purpose](#11-purpose)
  2. [Document Conventions](#12-document-conventions)
  3. [Intended Audience and Reading Suggestions](#13-intended-audience-and-reading-suggestions)
  4. [Product Scope](#14-product-scope)
  5. [References](#15-references)
2. [Overall Description](#2-overall-description)
  1. [Product Perspective](#21-product-perspective)
  2. [Product Functions](#22-product-functions)
  3. [User Classes and Characteristics](#23-user-classes-and-characteristics)
  4. [Operating Environment](#24-operating-environment)
  5. [Design and Implementation Constraints](#25-design-and-implementation-constraints)
  6. [User Documentation](#26-user-documentation)
  7. [Assumptions and Dependencies](#27-assumptions-and-dependencies)
3. [External Interface Requirements](#3-external-interface-requirements)
  1. [User Interfaces](#31-user-interfaces)
  2. [Hardware Interfaces](#32-hardware-interfaces)
  3. [Software Interfaces](#33-software-interfaces)
  4. [Communications Interfaces](#34-communications-interfaces)
4. [System Features](#4-system-features)
  1. Feature 1
  2. Feature 2
  3. Feature 3
5. [Other Nonfunctional Requirements](#5-other-nonfunctional-requirements)
  1. [Performance Requirements](#51-performance-requirements)
  2. [Safety Requirements](#52-safety-requirements)
  3. [Security Requirements](#53-security-requirements)
  4. [Software Quality Attributes](#54-software-quality-attributes)
  5. [Business Rules](#55-business-rules)
6. [Other Requirements](#6-other-requirements)

[Appendix A: Glossary](#appendix-a-glossary)

[Appendix B: Analysis Models](#appendix-b-analysis-models)

[Appendix C: To Be Determined List](#appendix-c-to-be-determined-list)

---

# 1. Introduction

## 1.1 Purpose

Release 1.0 of Check In is a notification application for Android devices that allows users to respond rapidly to simple yes or no questions. After a question is sent, a notification will arise on the receiver’s home screen prompting a response. A quick press of yes or no alerts the sender of their response.

## 1.2 Document Conventions

This document is written using GitHub's markdown language. Main points are given the first heading designation, with subpoints given the second heading designation and so on.

## 1.3 Intended Audience and Reading Suggestions

This document is intended primarily for Dr. Nash and his grading staff. It will also be used by project members to stay on the same page regarding requirements and goals.

## 1.4 Product Scope

The purpose of the application is to answer questions as efficiently as possible. Often responding to a text can be tedious and time consuming, so the benefit of Check In is the rapid response design that allows users to easily convey information without the annoyance of a formal written response. The app can be used for asking single one-off questions as well as large group questions for common events like lunch or after-class plans. Popularity of the app will grow exponentially as users adopt the functionality and get their friends and family to join. Once a large user base is formed, steady income can be attained by adding banner ads inside the app homepage or selling ads for local events which users could ask their friends to attend. 


# 2. Overall Description

## 2.1 Product Perspective

The inspiration for Check In arose from the lack of simplicity in current duo or group messaging systems today. Texting a single person simple question and responses like “did you make it home?” or “are you in class?” can be tedious to respond to, and managing group text messages can be even more arduous to keep organized. Facebook allows for group events to be formed, but the setting is far too formal with calendar events, dates, descriptions, and invite lists. GroupMe allows for simpler events to be created, but notifications for each person’s attendance response can clutter the underlying conversation. With Check In, we hope to remedy the problem of simple and rapid conversation response while keeping the avenues of day to day communication open.

## 2.2 Product Functions

- Users can create an account by linking their Facebook profile or using their email address
- Users can add contacts and send app invites from their phone contacts or Facebook friends.
- Users can send questions to a single person or group of people.
- Users can block certain individuals from sending them notifications
- Users can mute all notifications in a form of silent mode.
- Recipient can respond to sent questions from their device’s lock screen.
- Senders receive responses from recipients inside the app.
- In group settings, recipients can see other group members’ responses as well.
- Senders can delete their question at any point to remove it from the recipient’s phone(s).
- Recipients can remove themselves from group listings at will.

## 2.3 User Classes and Characteristics

User Class contains all accounts. User is a superclass for the Sender and Receiver Classes. In addition to its subclass capabilities, users can add contacts, mute all notifications. 

Sender Class includes all users who want to send a message. Users in the sender class have the capability to choose which user(s) to add to their recipient list and what they would like to type as their message. They are also able to see recipient responses to all questions they have sent.

Receiver Class includes all users who have received a message. Members of the receiver class can respond to questions, remove themselves from group question responses, and check group message responses.

## 2.4 Operating Environment

The app will work on tablets and phones running Android 5.0 or beyond. The app also includes integration with Facebook API.

## 2.5 Design and Implementation Constraints

Because the notifications for questions are sent to the lock screen by design for ease of access, people other than the designated recipient would be able to respond with physical access to the system. The service would also require internet access to send notifications through the backend. Object-Oriented Java in the Android Studio IDE will be used along with Github for project management and version control. Google’s Firebase web service will be used for our backend requirements. Continued maintenance will be provided by the Check In team.

## 2.6 User Documentation

Users will be given a one-time tutorial upon first run to explain the main functionalities of the app. At any time, the user can find more help in the settings page, quickly revisiting this tutorial.

# 3. External Interface Requirements

## 3.1 User Interfaces

The app design will be tailored to fit Google’s Material Design standards. On the home screen there will be two tabs separating lists of recent questions asked to and by the user. Each of these list elements can be tapped to reveal each recipient’s status, the time the message was sent, and the actions the sender can take (deleting the question, muting response notifications). In the top right there will be an ellipsis where a user can access app settings, a page of its own which includes the features of deleting a user account and muting all notifications. Settings will also be accessible from the drawer which includes the question list and contacts as well. To create a new question, users can click the floating action button on the main screen which prompts them for a question title and recipient list from contacts.

## 3.2 Hardware Interfaces

Devices must be internet enabled Android 5.0 or greater phones or tablets.

## 3.3 Software Interfaces

The app will be created using Google’s Android API and compiled with Gradle in Android Studio. Users will be able to create an account through Facebook login or email address and password sign up. Login verification is handled by Firebase Authentication and Facebook API. Messages are sent and received through calls to the Firebase API services. These messages are stored as JSON objects in our database to be updated upon editing or deleting by users. Messages are pulled from the Firebase backend and cached on the device until updated again.

## 3.4 Communications Interfaces

Check In requires internet access to communicate with the Firebase database for retrieving and sending messages and responses. Internet connection is also required to authenticate users’ email addresses or Facebook accounts through HTTP standard requests through Firebase encryption API which may in turn call Facebook Authentication API when necessary.

# 4. System Features

## 4.1 Create and Send Question

### 4.1.1 Description and Priority
Compose a yes or no question to send to a group. Select the Recipient(s) that will receive this question from a list of your contacts. Send a notification containing the information filled in earlier to everyone listed as a Recipient. High Importance. Main function of the app.

### 4.1.2 Stimulus/Response Sequences
A form page containing 2 sections one for Recipients one for Question will appear once the compose Question button is clicked in the lower left portion of the start screen. After the Sender presses “Send” the notifications will be sent and a new group will appear at the top of the users Groups tab. 

### 4.1.3 Functional Requirements 
Must be able to send a push notification to the phones of everyone on the recipients List. Every Recipient should have the app and be able to receive notifications if on list. Questions should be able to fit in 3 lines of text Max (IDK what that character limit is but would be better to have char limit) Must have at least one recipient and entry into the Question text box before the “Send” button is able to be pressed.

## 4.2 Receive Question or Reply

### 4.2.1 Description and Priority
The Recipient will receive a push notification that will appear on their lock screen. From the lock screen the Recipient must be able to answer the question by pressing yes or no and the app will update the database accordingly. High Importance: main function of the app

### 4.2.2 Stimulus/Response Sequences
As simple as possible. One click from the user will update the database accordingly and remove the notification from their screen.

### 4.2.3 Functional Requirements
REQ-1: The push notification must be sent by the Sender

REQ-2: The push notification must contain the name of the sender, the question and a yes/no checkbox.

REQ-3: Upon clicking yes/no the response will be recorded in the database.

REQ-4: Upon clicking the push notification will disappear

REQ-5: If recipient deletes the push notification, he/she may answer it later in-app (ambiguous) 

## 4.3 View All Group Messages

### 4.3.1 Description and Priority:
Users will have a list of all their active groups that will contain the name of the sender at the top followed by the question under it. It will also contain an options button off to the right and a number representing the number of Yes replies. High importance but not as high as 4.1-4.2

### 4.3.2 Stimulus/Response Sequences
Appears as the main page when the app is open. Represented as a list under the navBar at the top. When the message is clicked 4.4 is executed where the list of Recipients is shown as well as their responses. When the options button is clicked a drop down appears with corresponding options depending on the users relation to the group (i.e. Sender options, recipient options)

### 4.3.3 Functional Requirements
REQ-1: A group that is created will be shown as a list object to both Senders and Recipients

REQ-2: that list object will contain the correct Sender name at the top and Question below it.

REQ-3: the number on the right representing number of yes replies will update in real time(may change to update every time the app is opened)

REQ-4: the options will open a drop down that contains a list of proper actions based on if the user if a Sender or a Recipient

REQ-5: touching the list option executes 4.4


# 5. Other Nonfunctional Requirements

## 5.1 Performance Requirements

## 5.2 Safety Requirements

## 5.3 Security Requirements

## 5.4 Software Quality Attributes

### Availability

### Correctness

### Maintainability

### Reliability

### Testability

### Usability

## 5.5 Business Rules

# Appendix A: Glossary

# Appendix B: Analysis Models

# Appendix C: To Be Determined List
