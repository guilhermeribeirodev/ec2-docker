### Running an application using Wildfly

Now we know how to provide an AWS EC2 Ubuntu instance as well running a Docker instance
using a few commands, we may be able to run a real application into a real application sever.

In this example we'll need a web application artifact as a .war file and we'll start using a Dockerfile .

Until now we used Docker images directly from Docker hub. With the Docker file you can *extend* Docker images.
That means you can use any Docker image and keeping doing more stuff, including using more than one image.

You can take a look on this [Wildfly Dockerfile](https://github.com/jboss-dockerfiles/wildfly/blob/master/Dockerfile) to see its first clause is: FROM jboss/base-jdk:8
This will pull that image specified in the FROM command.
This pulled image is a basic setup to run Wildfly. The further steps are standard Wildfly installation on an Ubuntu server.

So let's start to setup our deployment of a sample car-service web app.

1. Create a directory for this project and add the Dockerfile describing Wildfly Docker hub image use.
   
   $`mkdir car-service`
  
   $`echo FROM jboss/wildfly >> Dockerfile`
  
2. Copy the sample [car-service.war](sample/car-service.war) **from your local machine** to EC2 Ubuntu instance via ssh (replace the dummy names).

   $`scp -i ~/path-to/the-name-you-gave.pem car-service.war ubuntu@your-ec2-ip.your-zone.amazonaws.com:/home/ubuntu/car-service/`
  
3. Add the Docker ADD command in order to copy it to Wildfly's deployment folder. You can do this using your preferred editor 
   nano, vi, vim, emacs if you want.

   $`echo ADD car-service.war /opt/jboss/wildfly/standalone/deployments/ >> Dockerfile`
  
4. Now you may be able to build the Docker image locally as you have all the needed files. Running the following you are asking to
   build an image tagging it as wildfly-app (could be any name) using the Dockerfile present in the specified path which is "."(dot).

   $`sudo docker build --tag=wildfly-app .`
  
5. Run the container specified by the tag property. The parameter -p is needed to redirect the container port to a external interface.  

   $`sudo docker run -it -p 8080:8080  wildfly-app`
  
6. Now go to the browser and you'll see the car-service running http://your-ec2-ip.your-zone.amazonaws.com:8080/car-service/

[<- Back](README.md)