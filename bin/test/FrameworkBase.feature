@Navigation
Feature: Navigation bar
    To see the subpages
    Without logging in
    I can click the navigation bar links

   Background: I am on the Free Range Testers web without logging in.
        Given I navigate to www.freerangetesters.com
 
   Scenario Outline: I can access the subpages through the navigation bar
        When I go to <section> using the navigation bar
        Examples:
            | section   | 
            | Cursos    |
            | Recursos  |
            | Blog      |
            | Mentorías |
            | Udemy     |
            | El Dojo   | 

   @Courses 
   Scenario: Courses are presented correctly to potencial customers
        When I go to Cursos using the navigation bar
        Then I select Introduccion al Testing de Software
    
    @Plans
    Scenario: Users can select a plan when signing up
        When I select Elegir Plan
        Then I can validate the options in the checkout page