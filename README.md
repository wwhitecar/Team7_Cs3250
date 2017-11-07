# Team7_Cs3250
William Whitecar - wwhitecar@msudenver.edu

Dalton Wiebold - dwiebold@msudenver.edu
	Alias - Alpoc

Alex Whitlatch - awhitlat@msudenver.edu

Dan Zapfel - dzapfel@msudenver.edu

Justin Wu - jwu@msudenver.edu

Nathanael Whitney - nwhitne3@msudenver.edu

Alex Whitlatch - Pushed initial application to GitHub Sept. 5, 2017


STEPS TO GET DATABASE UP AND RUNNING:
1. INSTALL MySQL - https://dev.mysql.com/downloads/windows/installer/5.7.html
1.1 Run through initial setup (Choose default options and ensure the server runs on localhost:3306)

2. Install SQLWorkbench - https://www.mysql.com/products/workbench/
2.1 Open SQLWorkbench and you should see a 'server' tab at the top, choose the 'data import' options'
2.3 Choose the 'import from disk' tab and select the 'import from self contained file' bubble'
2.4 Find the SQL_Schema folder in the root folder of the application and select/import the file
(You shouldn't have to tell Workbench to look at localhost:3306)

3. Run application (mvn spring-boot:run)
4. Goto localhost:8080/swagger-ui.html
5. Test to make sure it works by using the user-controller POST user.
6. Click the right box to auto-fill the parameters and fill out information
7. Hit "TRY IT OUT!"
8. Verify you see response body "Success"
9. If you see response, go back to SQLWorkbench and in the query portion type "SELECT * FROM schedule.users"
12. Verify you can see data within the database by clicking the lightning icon on the top bar to run the query
13. Profit

14. Testing




