# Web-Crawler
Java program which counts top Javascript libraries used on web pages found in google




# How to build it
You only need to use maven as follows:    

    mvn clean install

# How to run it
    
    mvn spring-boot:run

## Release History
* 1.0.0
    * SC01: App creation

## Features
 * Java 1.8
 * JSoup

## Next changes
 * Statistic calculation improvement:
    * Constant memory and time
 * Handle multiple transactions with the same timestamp
 * Streams over the list of transactions once for each metric
 * Integration tests

## Contributing

1. Fork it (<https://github.com/jorgelizandro/web-crawler.git>)
2. Create your feature branch (`git checkout -b feature/fooBar`)
3. Commit your changes (`git commit -am 'Add some fooBar'`)
4. Push to the branch (`git push origin feature/fooBar`)
5. Create a new Pull Request
