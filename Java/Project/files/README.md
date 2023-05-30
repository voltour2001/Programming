# Ad Manager

This is a program that manages ads.<br> Able to add users, new ads, show ads depending on user AFM or all, show costs of all or 1 ad.

# Format
> ## ID, AFM, "Ad Type", Description, value1, value2, value3, value4, value5

Where ID is unique identifier 
AFM & Description are self explanatory

Value variables change depending on the ad Type

## Type 1 (Printed ad)

    value1 = How many words
    value2 = Price per word
    value3 = Ad duration

## Type 2 (Website)

    value1 = Price per day
    value2 = Duration of appearance
    value3 = Automated show cost
    value4 = Extra pages
    value5 = Price per Extra page

## Type 3 (Radio)

    value1 = Ad duration
    value2 = Price per second
    value3 = Duration of appearance