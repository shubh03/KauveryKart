<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ page import="java.io.*"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%String number=request.getParameter("num");
String series="0";
int value=Integer.valueOf(number);
int first,last,temp;
first=1;last=0;temp=0;
int []s= new int[value];
for(int i=0;i<value;i++){
s[i]=last;
System.out.println(last);
temp=first+last;
first=last;
last=temp;	
} 
for(int a:s){
	/* System.out.println(a); */
if(a==value){
System.out.println(value +" is a part of Fibonacci Series");
break;
}
else if(a!=value){
	System.out.println(value +" is not a part of Fibonacci Series");
  break;
  } 
}
if(value%2==0){
System.out.println(value +" is an even number");
}
	else if(value%2!=0){ 
		System.out.println(value +" is an odd number");
}%>

</body>
</html>