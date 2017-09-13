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
1. INSTALL MySQL
2. Install SQLYog for Windows or SqlWorkbench for MAC
3. Point SQLYog/Workbench to the database running on your local machine (its localhost:3306)
4. import SQL backup file located in the folder SQL_schema
5. Run application (mvn spring-boot:run)
6. Goto localhost:8080/swagger-ui.html
7. Test to make sure it works by using the user-controller POST user.
8. Click the right box to auto-fill the parameters and fill out information
9. Hit "TRY IT OUT!"
10. Verify you see response body "Success"
11. If you see response, go back to SqlYog/Workbench and in the query portion type "SELECT * FROM schedule.users"
12. Verify you can see data within the database
13. Profit
