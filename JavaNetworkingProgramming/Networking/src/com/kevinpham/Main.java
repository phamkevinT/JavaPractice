package com.kevinpham;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

public class Main {

    public static void main(String[] args) {

        try {
            URL url = new URL("http://example.org");

            BufferedReader inputStream = new BufferedReader(
                    new InputStreamReader(url.openStream()));


//            URI uri = url.toURI();

////            URI uri = new URI("http://username:password@myserver.com:5000/catalogue/phones?os=android#samsung");
//            URI baseURI = new URI("http://username:password@myserver.com:5000");
//            URI uri1 = new URI("/catalogue/phones?os=android#samsung");
//            URI uri2 = new URI("/catalogue/tv?manufacturer=samsung");
//            URI uri3 = new URI("/stores/locations?zip=12345");
//
//            URI resolvedURI1 = baseURI.resolve(uri1);
//            URI resolvedURI2 = baseURI.resolve(uri2);
//            URI resolvedURI3 = baseURI.resolve(uri3);
//
//
//            // Converting URI to URL
//            URL url1 = resolvedURI1.toURL();
//            System.out.println("URL = " + url1);
//            URL url2 = resolvedURI2.toURL();
//            System.out.println("URL = " + url2);
//            URL url3 = resolvedURI3.toURL();
//            System.out.println("URL = " + url3);
//
//            // Relativized URI
//            URI relativizedURI = baseURI.relativize(resolvedURI2);
//            System.out.println("Relative URI = " + relativizedURI);


//            // Path that is before the colon (:)
//            System.out.println("Scheme = " + uri.getScheme());
//            // Everything after the colon (:) and before the hash (#)
//            System.out.println("Scheme-specific part = " + uri.getSchemeSpecificPart());
//            // The HOST and optionally the PASSWORD, as well as USERNAME and PORT number
//            System.out.println("Authority = " + uri.getAuthority());
//            // USERNAME and PASSWORD
//            System.out.println("User info = " + uri.getUserInfo());
//            // HOSTNAME or IPv4 IPv6 address
//            System.out.println("Host = " + uri.getHost());
//            // PORT number
//            System.out.println("Port = " + uri.getPort());
//            // PATH to the resource on the host
//            System.out.println("Path = " + uri.getPath());
//            // After the question mark (?)
//            System.out.println("Query = " + uri.getQuery());
//            // After the hash (#). Secondary resource
//            System.out.println("Fragment = " + uri.getFragment());


        } catch (URISyntaxException e) {
            System.out.println("URI Bad Syntax: " + e.getMessage());
        } catch (MalformedURLException e) {
            System.out.println("URL Malformed: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO Exception: " + e.getMessage());
        }
    }
}
