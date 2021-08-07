## The example-activemq-classic-ms
Simple example of Activemq Classic implementation where *producer* and *consumer* run as independend microservices.

After application `example-activemq-classic-ms-producer` start-up it will send up 2 messages on the 2 queues and then `example-activemq-classic-ms-consumer` application will pull and read those sent messaged. This will recur every 10 seconds.
You can also send direct message by executing one of the following REST API:
1. GET [http://localhost:8081/active-mq-classic/send](http://localhost:8081/active-mq-classic/send). This will send one message to each queue.
2. GET [http://localhost:8081/active-mq-classic/send/test-value](http://localhost:8081/active-mq-classic/send/test-value). This will send message to test-value-object-queue queue.
3. GET [http://localhost:8081/active-mq-classic/send/test-string-value](http://localhost:8081/active-mq-classic/send/test-string-value). This will send message to test-value-string-queue queue.

## The example-activemq-classic-ms execution order
Pre requariment: To have it work first, the apache-activemq classic must be running locally.

Run in order:
1. The `example-activemq-classic-ms-lib` .jar project and then,
2. The `example-activemq-classic-ms-producer` microservice project, and lastly
2. The `example-activemq-classic-ms-consumer` microservice project.
Also you can create .jar files all at once by executing the `example-activemq-classic-ms-parent` parent project.

You can view sent/recive messages via activemq admin panel: [http://localhost:8161/admin/queues.jsp](http://localhost:8161/admin/queues.jsp)

## Activemq Classic: version
Tested with apache-activemq-5.16.1 which is available on: [https://activemq.apache.org/activemq-5016001-release](https://activemq.apache.org/activemq-5016001-release)

## Activemq Classic: execution
On Windows OS simply execute following file: ..\apache-activemq-5.16.1-bin\apache-activemq-5.16.1\bin\win64\activemq.bat
