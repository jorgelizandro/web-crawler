# Web-Crawler
Java program which counts top Javascript libraries used on web pages found in google


# Chosen approach
In order to get the result links from google, I decided to parse the web page (I think it's the heaviest operation), but we can improve this by using the Google's custom search API. We will need to get an API Key with a limit rate of 100 daily requests or pay for more $$$.

We're already using threads to retrieve the scripts based on the google links and the result list is sanitized by removing the path and parameters in order to identify duplicated libs.

Regarding the tests, I added some unit tests and ITs, the code coverage isn't 100% but it's an example of what we can do.


# How to build it
You only need to use maven as follows:    

    mvn clean install

# How to run it
Use the following in the terminal:    
    
    java -jar target/webcrawler-0.0.1-SNAPSHOT.jar

## Release History
* 1.0.0
    * SC01: App creation

## Features
 * Java 1.8
 * JSoup
 * Maven
 
## Output when the search term is "scalable capital"

 __          __  _      _____                    _
     \ \        / / | |    / ____|                  | |
      \ \  /\  / /__| |__ | |     _ __ __ ___      _| | ___ _ __
       \ \/  \/ / _ \ '_ \| |    | '__/ _` \ \ /\ / / |/ _ \ '__|
        \  /\  /  __/ |_) | |____| | | (_| |\ V  V /| |  __/ |   
         \/  \/ \___|_.__/ \_____|_|  \__,_| \_/\_/ |_|\___|_|   
                                                                 
    
    Please, introduce the search term:
    scalable capital
    
    Processing search page...
        Found 13 links
    
    Retrieving scripts...
        Found 96 scripts
    
    Generating metrics...
    
    The top five is:
    ------------------------------------
    jquery.min.js=4
    adsbygoogle.js=3
    lazyLoadImage.min.js=2
    script.js=2
    OneSignalSDK.js=2
    ------------------------------------

    ***Task execution finished*** 

## Contributing

1. Fork it (<https://github.com/jorgelizandro/web-crawler.git>)
2. Create your feature branch (`git checkout -b feature/fooBar`)
3. Commit your changes (`git commit -am 'Add some fooBar'`)
4. Push to the branch (`git push origin feature/fooBar`)
5. Create a new Pull Request
