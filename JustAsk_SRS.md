# Software Requirements Specification

# JustAsk

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
  1. [Create and Send Questions](#41-create-and-send-questions)
  2. [Receive Question or Reply](#42-receive-questions-or-reply)
  3. [View All Group Messages](#43-view-all-group-messages)
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

- Users can sign in by linking their Facebook profile
- Users can send questions to a single person or group of people.
- Users can mute all notifications in a form of silent mode.
- Recipient can respond to sent questions from their device’s lock screen or in-app.
- Senders receive responses from recipients inside the app.
- In group settings, recipients can see other group members’ responses as well.


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

## 4.1 Create and Send Questions

#### 4.1.1 Description and Priority
Compose a yes or no question to send to a group. Select the recipient(s) that will receive this question from a list of your contacts. Send a notification containing the information filled in earlier to everyone listed as a Recipient. High Priority, Benefit: 9, Cost: 7.

#### 4.1.2 Stimulus/Response Sequences
User taps the new question button at the bottom of the homepage. A new screen prompting for a question and recipient(s) is created. The user can type a question and search or scroll their list of contacts to select recipients. Once the prompts have been answered, the user can send or cancel the request.

#### 4.1.3 Functional Requirements 

The sender should have the app installed and must login in order to send messages. The recipient of the messages must also have the app. If a recipient does not have the app, then they will not be added to the sender's contact list and will not be an available option. Questions must be greater than 0 characters and are limited to 140 and recipient list must be non-null and is limited to 300 users to keep backend requests manageably small. The send button cannot be pressed until these limits are respected. If the user was able to send regardless of the security feature, the message will be thrown and an error will pop up on screen regarding these limits.

## 4.2 Receive Question or Reply

#### 4.2.1 Description and Priority
The recipient receives a notification that appears on their lock screen. From the lock screen the recipient is able to answer the question by pressing yes or no and the app will update the database accordingly. High Priority, Benefit: 9, Cost: 7.

#### 4.2.2 Stimulus/Response Sequences
User taps yes or no on the lock screen notification. If the user closes the notification or has notifications muted, he or she can also tap yes or no from within the app's homepage. After tapping a response, the notification or list element is dismissed and the answer is recorded on the Firebase database.

#### 4.2.3 Functional Requirements

The recipient should have the app installed and must login in order to receive messages. After the notification is received, the recipient can click the yes or no buttons, or swipe the notification to dismiss. If the notification is dismissed, the user's answer is pending and can still be answered from within the app. If a user would like to change his or her response, it can be change at any time by tapping the question within the received tab of the homepage of the app and tapping the desired response.

## 4.3 View Messages

#### 4.3.1 Description and Priority:

User can tap a single or group question from homepage list to expand details into view including time sent, sender, recipients, responses, and actions like block or leave group.

#### 4.3.2 Stimulus/Response Sequences

Appears as the main page when the app is open. Represented as a list under the navigation bar at the top. Tapping elements of the list causes the list element to expand below revealing extra details listed above. Tapping the element again causes the elements to hide once again. Tapping block or leave group causes the question element to disappear.

#### 4.3.3 Functional Requirements

After a message is sent, a list element is appended to the sender's sent tab list and the receiver's received tab list. The element is filled with data from the database including time sent, sender, recipients, responses, and actions depending on the sender (sender has action delete question, receiver has actions block and leave group). If one of these elements is missing, the question will throw an error on the sender end and the list element will be removed.

# 5. Other Nonfunctional Requirements

## 5.1 Performance Requirements

On all devices compatible with Check In, users will be able to respond to questions within 10 seconds of receipt.

A device connected to WiFi or 4G LTE mobile data will be capable of sending a question or a response to another such device through Check In’s server backend within 30 seconds.

## 5.2 Safety Requirements

With any phone application, comes the chance of harm to the user when used in an unsafe manner. It’s important to note that while this app is a quick and easy replacement for some texting, it still requires the attention of the user and should not be used when in the threat of danger. Frequent messages should be provided on the app that alerts users to put their device away while driving a car, for example.

## 5.3 Security Requirements

The app will collect minimal data about the user. For identity authentication, if the user elects to use Facebook, all security will be handled through Facebook’s API. If the user elects to use email verification, the Firebase backend provides an authentication service with built-in security considerations.

## 5.4 Software Quality Attributes

Check In is designed to be a quick and efficient way of asking simple questions to one or many people, so speed should be the top priority when implementing. Another important attribute is the ease of use. The app should feature a minimalist home screen that lets users quickly send a message to others without the hassle of customizable settings. The simplicity and speed of Check In should be what drives users toward the product.

## 5.5 Business Rules

Each question in the database can only be viewed by its original sender and that sender’s chosen recipients. The content of questions will be hidden from everyone else, including app authors.

# 6. Other Requirements

Because our plan is to use the Facebook API for the login functionality of the application, we must follow the terms of service described by them. Using Google’s Firebase database also requires the compliance to their terms of service agreement. 

# Appendix A: Glossary

4G LTE - The fourth generation of cellular data that transfers data at high rates of speed

API - The Application Program Interface that defines how software components interact

HTTP - The set of rules for transferring data on the Internet

IDE - A development environment for software

JSON - A type of object-oriented formatting for the javascript programming language

WiFi - the means of connecting a device to the Internet wirelessly

# Appendix B: Analysis Models

Future version updates could include analysis models found here

# Appendix C: To Be Determined List

Future features which may require TBD information could be found here
