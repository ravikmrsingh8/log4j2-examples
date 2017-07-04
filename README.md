# log4j2-examples
<H2>Log4j2</H2>
<p>Log4J 2 is an open source logging package distributed under the Apache Software License.
Log4J 2 allows you to define different levels of importance, such as ERROR, WARN, INFO, and DEBUG for log messages.
Log4J 2 also allows you to define one or more destinations, such as console, file, database, and SMTP server to send log messages.
Additionally, Log4J 2 allows you to control logging on a class-by-class basis. 
For example, one class of an application can redirect logs to the console while another to a file.
</p>
<H3>Loggers</H3>
<p>
Loggers are the key objects in Log4J 2 that are responsible for capturing logging information. 
Loggers are stored in a namespace hierarchy and a root logger, an implementation of the Logger interface, sits at the top of the hierarchy. 
Logger names are case-sensitive and they follow the hierarchical naming rule.
You can retrieve the root logger by calling the LoggerManager.getRootLogger() method.
For all other loggers, you can instantiate and retrieve them by calling LoggerManager.getLogger(String loggerName) passing the name of the desired logger as a parameter or
LoggerManager.getLogger(java.lang.Class logger). 
Although, you can specify any name for a logger, its recommend to name the logger with the fully qualified name of the class. 

<b>Log levels</b>
<p>Loggers can be assigned levels in the following order.</p>
<img src = "https://i2.wp.com/springframework.guru/wp-content/uploads/2016/02/Log_Levels.png?w=379"/>
</p>
