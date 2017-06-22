### Hints

* Therefore thinking about setup a Docker container into a AWS EC2 machine sounds complicated you should not
  think this way if you look into it as separated steps you need to provide.
  
* If you are not familiar with EC2 console and instances, skip the Ubuntu instance creation and install Docker
 on a local machine. The steps are the same. (Almost if you consider the security group ports configuration).
 
* You can do the opposite as well. Just forget Docker and try to create a EC2 instance and play with it.

* Don't waste time trying to execute a command which is not working. Try different alternatives or even start
 from scratch.
 
* Everything that works in a Docker container should work on a local Ubuntu installation. If something is not working
  with Docker command try testing it outside Docker.
  
* A Docker image is nothing but stored binaries from a build. When it's running it's called Docker container.
 
* Every time you build a Docker image or download from Docker hub that uses space on your disk. You can check
 this running 
 
 `$ sudo docker images`
 
 
 [<- Back](README.md)