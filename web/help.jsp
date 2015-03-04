<%-- 
    Document   : help
    Created on : 16-Feb-2015, 11:53:31
    Author     : Delaney
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="guipackage.GUI;"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/styles.css" media="screen" type="text/css" />
        <link href='http://fonts.googleapis.com/css?family=Source+Sans+Pro:400,300italic' rel='stylesheet' type='text/css'>
        <title>Timetable Scheduler</title>
    </head>
   
    <body>
        <%
          GUI loginHeader = new GUI();  
          out.print( loginHeader.loginHeader() );
        %>
            
        <section id="help">
            <h1>Help</h1>
            <p>Welcome to the UCC Computer Science Scheduling help page. Here, we hope to answer any questions you may have. However,
               if you can’t find an answer here, feel free to contact us by using our Contact page and we will get back to you as soon as possible.
            </p>
            
            <h2>Frequently Asked Questions</h2>
            
            <h3>How do I register for the system?</h3>
            <p>	On the log in page, there is a blue link that says ‘register here’. This will bring you to a page which requires you to fill out a few details about yourself, including the stream of computer science you are studying, your student number and a password for logging into the system.
                Once the required fields are filled out, you will be registered with the system. 
                You will receive a confirmation email to your own email account. 
            </p>
            
            <h3>How do I log in to the system?</h3>
            <p>
               If you are fully registered, you will be able to log in to view your schedule.
               To do this, you need your student number and your password that you set up upon registration. 
               These are the only credentials needed for logging in. 
            </p>
            
            <h3>What if I forgot my password?</h3>
            <p>
               If you have forgotten your password, you can click on the forgotten password link underneath the log in button on the home page. 
               This will bring you to a window that will require you to enter your email address. Your new password will be sent to this email address. 
            </p>
            
            <h3>Tell me about my timetable?</h3>
            <p>
               Once you log in, you will automatically see your timetable, displaying all the events that you have during the week that you log in. 
               This will include your lectures, your own personal events that you have added yourself and any meeting that have been scheduled by 
               your lecturers. You will also see a notification bar. This tells you any events that are coming up for you and any meetings or events that 
               have been scheduled for you since you last logged in. 
            </p>
            
            <h3>Adding events</h3>
            <p>
                If you click on the tab on your Timetable page that says ‘Add Meeting’, it will bring you to a page with a form on it.
                This form asks you some relevant information to add a meeting to your timetable. 
                It allows you to add a meeting at any time that is free for you on any date. 
                <b>NOTE: You cannot override lectures or group meetings. </b>
            </p>
            
            <h3>Finding a free slot. (ADMIN)</h3>
            <p> On the lefthand corner of your homepage you will see a form to find a free slot with a group of your choice on a preferred day.
                It will return a list of free times on that day, if there are any available. From here, you can choose a time that suits you. 
                If none of these times suit you, you can change the day for the meeting and search again. 
            </p>
            
            <h3>Making a meeting with a group of users</h3>
            <p>
               If you want to create a meeting with other students in your course, fill in the form on the left hand side of the timetable page. 
               (The minimum number of users to create a meeting with is 2 and the maximum per group is 5). 
               Select a day for the meeting to be scheduled. Once you click the ‘Create Personal Group Event’, a group of radio buttons 
               will appear of options of free slots that reflect the free times of the members of your groups, based on the users’ timetable in the system.
               From here, you can choose a time that suits you and click select. This will bring you to the 
               add meeting form where you can select a location for the meeting and add a description. 
               NOTE: The time and date are already set for you and cannot be changed at this point. 
               If you change your mind, you can go back to the timetable page and search for another slot. 
            </p>
            
            <p>
                Once you click the ‘Submit’ button, the event will be added to your timetable along with the timetable of the other members of your group.
                They will be notified of the meeting once they log into their system.
            </p>
            
            <h3>How do I delete an event?</h3>
            <p>
                To delete an event from your timetable, click on the event within the timetable display. 
                This will bring you to an event page, listing the details of the event itself, including the description, room number and type.
                Here, a button labelled ‘Delete’ will allow you delete this event from your schedule.
            </p>
            
            <h3>How do I see more about my events?</h3>
            <p>
                If you click on the event itself within the timetable,
                it will bring you to an event page which lists the details of the event along with the option to delete it. 
            </p>
                

        </section>
        
        <%
          GUI footer = new GUI();  
          out.print( footer.footer() );
        %>        
    </body>
</html>

