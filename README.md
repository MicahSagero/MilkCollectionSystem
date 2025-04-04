BIT 2115: OJECT ORIENTED PROGRMING II

DAIRY APP SPECIFICATION GROUP PROJECT

---

GROUP MEMBERS:

 MICAH SAGERO-SCT212- 0056/2023
 
 PHILIP SIMIYU-SCT212-0067/2023
 
---

PROJECT OVERVIEW:

This repository contains the Dairy App's Milk Collection Management Module, a digital solution designed to streamline milk collection workflows for farmers, collectors, cooperatives, and processors. The project leverages real-time tracking, route optimization, automated payments (M-Pesa), and data analytics to enhance transparency, efficiency, and profitability across the dairy supply chain. Built with React Native (frontend), Node.js (backend), and Firebase/SQL (database), this module serves as the foundation for a scalable agricultural management system.
---
 MODULES
1. Farmer Module:
-Farmer profile and registration.
-Selection of collection points.
-Collection requests.
-Notifications for collection points and tracking collector's location.
-Transaction history and delivery statements.
-Access to data on milk deliveries and profitability.

2. Collector Module:
-Collector profile and registration.
-Route optimization and collection scheduling.
-Notification to farmers and creation of collection reports.
-Access to farmer transaction records.

3. Group (Cooperative) Module:
-Group profile and registration.
-Management of collection points and collectors.
-Creation and verification of collection reports.
-Payment processing for farmers and collectors.
-Daily, weekly, monthly, and annual transaction reports.
-Advance tracking and deductions management.
-Predictive analysis for future milk collections.

5. Processor Module:
-Processor profile and registration.
-Contract management with groups.
-Creation of collection reports for received milk.
-Access to group, collector, and farmer reports.
-Predictive analysis for milk collection forecasting.
---
MODULE TO IMPLEMENT:
Milk Collection Management Module

Reasons for Choosing This Module:

1.Core Problem Resolution:
-Addresses challenges faced by farmers, collectors, and cooperatives, such as inefficient manual processes, lack of transparency in payments, and poor data management.

2.High Impact:
-By streamlining the milk collection process and ensuring transparency, this module directly benefits all stakeholders in the dairy value chain.

3.Practical Feasibility:
-As described in the workflow, milk collection forms the foundation of the app's operations, making it logical to develop and implement this module as a priority.

---

Design and Approach:
1. Objectives:
-Optimize the milk collection workflow.
-Ensure accurate tracking of milk quantity, quality, and collection timing.
-Reduce transportation inefficiencies and errors in manual payrolls.

2. Key Features:
Farmer Functionality:
-Farmer can send collection requests, track the collector's location, and view historical data of transactions.
Collector Functionality:
-Collectors can optimize their routes, notify farmers, and generate collection reports.
Group Functionality:
-Aggregates data from collectors, verifies milk volumes, and manages payments.

3. Workflow Outline:
-Farmers select their nearest collection point and submit a request.
-Collectors are notified and provided with an optimized route for milk pickup.
-Collectors record the milk collection data digitally, which syncs with the group’s system.
-The group processes payments efficiently using integrated M-Pesa payment automation.

4. Technologies & Tools:
Frontend: React Native for a user-friendly mobile interface.
Backend: Node.js for scalability and real-time notifications.
Database: Firebase/SQL for centralized data storage and access.
Integration: MPesa API for payment automation.

5. Development Approach:
Agile Methodology:
-Divide the module into sprints for iterative development.
User-Centered Design:
-Regularly involve stakeholders for testing and feedback.

