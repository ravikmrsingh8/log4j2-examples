# Log4j2 Introduction

Log4J 2 is an open source logging package distributed under the Apache Software License.
Log4J 2 allows you to define different levels of importance, such as ERROR, WARN, INFO, and DEBUG for log messages.
Log4J 2 also allows you to define one or more destinations, such as console, file, database, and SMTP server to send log messages.
Additionally, Log4J 2 allows you to control logging on a class-by-class basis. 
For example, one class of an application can redirect logs to the console while another to a file.


There are two types of objects available with log4j framework.

- Core Objects: These are mandatory objects of the framework. They are required to use the framework.

- Support Objects: These are optional objects of the framework. They support core objects to perform additional but important tasks.


## Core Objects
Core objects include the following types of objects −

- Logger Object:  The top-level layer is the Logger which provides the Logger object. The Logger object is responsible for capturing logging information and pass that to Appenders

- Appender Object This is a lower-level layer which provides Appender objects. The Appender object is responsible for publishing logging information to various preferred destinations such as a database, file, console, UNIX Syslog, etc.</li>

- Layout Object
The layout layer provides objects which are used to format logging information in different styles. It provides support to appender objects before publishing logging information.



## Support Objects
There are other important objects in the log4j framework that play a vital role in the logging framework

- Level Object:
The Level object defines the granularity and priority of any logging information. There are seven levels of logging defined within the API: OFF, DEBUG, INFO, ERROR, WARN, FATAL, and ALL. 
- Filter Object 
The Filter object is used to analyze logging information and make further decisions on whether that information should be logged or not.
An Appender objects can have several Filter objects associated with them. If logging information is passed to a particular Appender object, all the Filter objects associated with that Appender need to approve the logging information before it can be published to the attached destination.


- ObjectRenderer: 
The ObjectRenderer object is specialized in providing a String representation of different objects passed to the logging framework. This object is used by Layout objects to prepare the final logging information.

- LogManager : 
The LogManager object manages the logging framework. It is responsible for reading the initial configuration parameters from a system-wide configuration file or a configuration class.


The following virtual diagram shows the components of a log4J framework:
<img src='http://www.tutorialspoint.com/log4j/images/log4j-arch.jpg'/>

## Log4j2 Architecture

Steps involved in Logging

- Applications will ask LogManager for a Logger with a specific name. LogManager will locate the appropriate LoggerContext and then obtain Logger from it. If the Logger isn’t created yet, it will be created and associated with LoggerConfig according to three choices below: 
    - Logger instance will be created and associated with the LoggerConfig that have the same name. For example App.class in getLogger(App.class) will be evaluated to be a String com.example.log4j.App. LoggerConfig name is identical to fully qualified class name.
    - Logger instance will be created and associated with the LoggerConfig that have the same Loggers parent package. For example com.example in getLogger("com.example.log4j.App")

    - Logger instance will be created and associated with the Root LoggerConfig. Root LoggerConfig will be used when there is no configuration file or when you’re obtaining a logger with name not defined in the logger declarations.


- LoggerConfig objects are created from Logger declaration in the configuration file. LoggerConfig is also used to handle LogEvents and delegate them for their defined Log4j2 Appenders.

- Root logger is an exceptional case, in terms of its existence. It always exists and at the top of any logger hierarchy


Every logger is associated with a LoggerConfig object, set of LoggerConfig objects made up a Hierarchy of loggers. This concept is known as Logger Hierarchy.
Logger Hierarchy is made up of set of LoggerConfig objects with a parent-child relationship. The top most element in every Logger Hierarchy is the Root logger.
If Log4j2 doesn’t find the configuration file, only Root Logger will be used for logging with logging level as ERROR


An instance of LoggerConfig is said to be an ancestor of another LoggerConfig; if its name followed by a dot is a prefix for the descendant name.

An instance of LoggerConfig is said to be parent for another LoggerConfig; if there’s no interleaving names between both of them.

Table below shows parent-child relationship in the Logger Hierarchy.

|LoggerConfig|ROOT	|com|	com.example|	com.example.App|
|------------|------|---|------------|-----------------|
|Root|X|Child|descendant|descendant|
|com |Parent|	X	|Child|	descendant|
|com.example|	Ancestor|Parent|X	|Child|
|com.example.App|Ancestor|Ancestor|	Parent|X|


To clarify Parent-Child relationship, table above would be read as follows:

- Root is a parent for com.
- Root is an ancestor for com.example.
- com is a child for Root.
- com is a parent for com.example. etc.


## Log4j2 Levels and additivity
Every time when we define a LoggerConfig, we also provide logging level. By default log4j2 logging is additive. It means that all the parent loggers will also be used when a specific logger is used.

Once you obtain the com.example.log4j.App logger and initiate a logEvent for logging, the loggerConfig (com.example) will log the message and if the additivity is not false the message will be propagated up in the hierarchy without any respect for parents logging levels. So log event will be propagated to com and Root loggers and they will also log the message respectively according to the levels defined.

You can set additive property to false to avoid log event propagation to parent loggers.

<i>"To make sure Log events have been displayed, the LoggerConfig’s Level should be grater than or equal to Log event’s level."</i>

Table below shows the log4j2 Levels and the weight for each of them:

|Level|Weight|
|-----|------|
|OFF    |0     |
|FATAL  |   100|
|ERROR	|   200|
|WARN	  |   300|
|INFO	  |   400|
|DEBUG	|   500|
|TRACE	|   600|
|ALL    |  Integer.MAX_VALUE|

Note :- 
There’s no direct method that can be used for throwing an OFF/ALL log events.
Mainly, for throwing OFF/ALL log events you may use logger.log(Level.OFF, “Msg”) or logger.log(LEVEL.ALL,”Msg”), respectively.

That's it for the basics, Lets hop into the examples, and write some code!!.
