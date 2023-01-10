# PdfInvoiceCreator
Pdf Invoice Creator
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/io.github.bhaskarkh/PdfInvoiceCreator/badge.svg?style=plastic)](https://maven-badges.herokuapp.com/maven-central/io.github.bhaskarkh/PdfInvoiceCreator)

**Maven Dependency**

```java
<dependency>
    <groupId>io.github.bhaskarkh</groupId>
    <artifactId>PdfInvoiceCreator</artifactId>
    <version>1.0.1</version>
</dependency>
```
**Gradle**
```
implementation 'io.github.bhaskarkh:PdfInvoiceCreator:1.0.1'
```
## Youtube Tutorial on how to use this library (https://youtu.be/tSYaVq-Uzpo)
 
 [![Pdf invoice Creator Libraray](http://img.youtube.com/vi/tSYaVq-Uzpo/0.jpg)](https://www.youtube.com/watch?v=tSYaVq-Uzpo "How to use pdfinvoice creator library")
 
 
**Sample Code**

```java
import com.codingerror.model.AddressDetails;
import com.codingerror.model.HeaderDetails;
import com.codingerror.model.Product;
import com.codingerror.model.ProductTableHeader;
import com.codingerror.service.CodingErrorPdfInvoiceCreator;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
public class GeneratePdf_Modified {
    public static void main(String[] args) throws FileNotFoundException {
        LocalDate ld= LocalDate.now();
        String pdfName= ld+".pdf";
        CodingErrorPdfInvoiceCreator cepdf=new CodingErrorPdfInvoiceCreator(pdfName);
        cepdf.createDocument();

        //Create Header start
        HeaderDetails header=new HeaderDetails();
        header.setInvoiceNo("RK35623").setInvoiceDate(LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))).build();
        cepdf.createHeader(header);
        //Header End

        //Create Address start
        AddressDetails addressDetails=new AddressDetails();
        addressDetails
                .setBillingCompany("Coding Error")
                .setBillingName("Bhaskar")
                .setBillingAddress("Bangluru,karnataka,india\n djdj\ndsjdsk")
                .setBillingEmail("codingerror303@gmail.com")
                .setShippingName("Customer Name \n")
                .setShippingAddress("Banglore Name sdss\n swjs\n")
                .build();

        cepdf.createAddress(addressDetails);
        //Address end

        //Product Start
        ProductTableHeader productTableHeader=new ProductTableHeader();
        cepdf.createTableHeader(productTableHeader);
        List<Product> productList=cepdf.getDummyProductList();
        productList=cepdf.modifyProductList(productList);
        cepdf.createProduct(productList);
        //Product End

        //Term and Condition Start
        List<String> TncList=new ArrayList<>();
        TncList.add("1. The Seller shall not be liable to the Buyer directly or indirectly for any loss or damage suffered by the Buyer.");
        TncList.add("2. The Seller warrants the product for one (1) year from the date of shipment");
        String imagePath="src/main/resources/ce_logo_circle_transparent.png";
        cepdf.createTnc(TncList,false,imagePath);
        // Term and condition end
        System.out.println("pdf genrated");
    }
}
```
**Model Class**
```java
AddressDetails,HeaderDetails,Product,ProductTableHeader
```
All these Class folow builder design pattern.Follow Sample code for reference

**All Methods**
```java
void createDocument()
```
createDocument Method set Document with pdf size A4 and Pdfname
provide in Constructor of CodingErrorPdfInvoiceCreator class 

```java
void createHeader(HeaderDetails header)
```
Takes HeaderDetails in parameter and create Header.Its Two column table with which contain invoiceNumber.invoiceDate
We can change/set label and value to anything else.
If label is not set it will take default label present in ConstantUtil
```java
void createAddress(AddressDetails addressDetails)
```
Create Both shipping and Billing address in two column
```java
void createTableHeader(ProductTableHeader productTableHeader)
```
Create table header(bold text) currently having three column description,quantity,price(perpieceprice)
```java
List<Product> getDummyProductList()
```
Return Sample/dummy Product List
```java
List<Product> modifyProductList(List<Product> productList)
```
Return product list by adding quantity of same product in one.
like if in list orange is added two times with 5 and 6 as quantity then in new(modified) returned product list it will have orange with quantity as 11 
```java
void createProduct(List<Product> productList)
```
Create table of three column with productname,quantity,priceperpiece
also add total amount at last.

```java
void createTnc(List<String> TncList,Boolean lastPage,String imagePath)
```
This create term and condition at last.
 
if lastPage is true it will create normal tnc after the total amount(which may in top or middle of the page) with no background image

if lastPage is false it will create  tnc at last line(footer always at bottom) of last page it will also have background image on each page

In sample code image with name ce_logo_circle_transparent.png
must be there at resource folder or you can change path as per your convience.

TODO
1. Create Different Template of invoce to use
2. Add Logo image at Header
