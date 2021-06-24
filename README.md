# Technology-For-Impaired-People

Sign languages (also known as signed languages) are languages that use the visual-manual modality to convey meaning. Sign languages are expressed through manual articulations in combination with non-manual elements. Sign languages are full-fledged natural languages with their own grammar and lexicon. Sign languages are not universal and they are not mutually intelligible with each other therefore we use certain translators to understand every gestures. This application is used for translation sign language to text and text to sign language.

# Prerequisites

Android studio

# Language

*Java 
*Python

# Technology

Support Vector Machine

# Database

Firebase

# Modules

<h3>Module 1: Text to gesture</h3>

In this module we use firebase as a database which is used to store all images. The user would type any text he want to convert in sign. This module will search that text in <a href="https://console.firebase.google.com/u/0/project/tipapplication-5e879/overview" target="_blank">database</a> and retrieve the desired output.

![WhatsApp Image 2021-06-25 at 12 21 48 AM](https://user-images.githubusercontent.com/30021204/123317706-eff4e680-d54b-11eb-94c2-8ba3acb4aaeb.jpeg)

<h3>Module 2: Gesture to text</h3>

In this module we use SVM model to get the recognized gesture and convert it into text. Here the dataset is created and converted to <a href="https://raw.githubusercontent.com/futureeinstein/Technology-For-Impaired-People/master/app/src/main/res/raw/trained.xml" target="_blank">vectors</a> which makes it more reliable and helpful to communicate easily.

![WhatsApp Image 2021-06-25 at 12 29 22 AM](https://user-images.githubusercontent.com/30021204/123318160-89bc9380-d54c-11eb-8e2f-ee47210ea24e.jpeg)



