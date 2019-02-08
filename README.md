This is the back end of my assessment, written in Java 8 using Spring.

There are three RESTful end points:

POST https://pulcher.serveo.net/api/auth/signup
which requires the following JSON example:
{
	"name":"Test",
	"username":"Test",
	"password":"Test123",
	"email":"a@b.com"
}

POST https://pulcher.serveo.net/api/auth/signin
which requires the following JSON example:
{
	"username":"Test",
	"password":"Test123"
}

GET https://pulcher.serveo.net/api/provider?max_discharges=5&min_discharges=6&max_average_covered_charges=50000
&min_average_covered_charges=40000&min_average_medicare_payments=6000
&max_average_medicare_payments=10000&state=GA&required_fields=Provider Name
require_fields is a comma-delimited list. If it isn't present all fields will be returned. Below are the possible fields:
Provider Name
Provider Street Address
Provider City
Provider State
Provider Zip Code
Hospital Referral Region Description
Total Discharges
Average Covered Charges
Average Total Payments
Average Medicare Payments
