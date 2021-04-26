from matplotlib import pyplot as plt


#plt.xkcd()   If you want comic book style plot

#----------Salaries by Age-----------#

    # Median Developer 
ages_x = [25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35]
dev_y = [38496, 42000, 46752, 49320, 53200,
         56000, 62316, 64928, 67317, 68748, 73752]

    # Median Python Developer 
py_dev_y = [45372, 48876, 53850, 57287, 63016,
            65998, 70003, 70000, 71496, 75370, 83640]

    # Median JavaScript Developer 
js_dev_y = [37810, 43515, 46823, 49293, 53437,
            56373, 62375, 66674, 68745, 68746, 74583]

#----------Plots----------#

# For All Developers
plt.plot(ages_x, dev_y, color='#444444', linestyle='--', label="All Devs")      

# For Python Developers
plt.plot(ages_x, py_dev_y, label="Python")

# For JavaScript Developers                                      
plt.plot(ages_x, js_dev_y, label="JavaScript")                                  


#----------Basics----------#

# X Label
plt.xlabel("Ages")

# Y Label
plt.ylabel("Salary")

# Title
plt.title('Median Salary (USD) by Age')

# Show which line is which (top left part of the chart)
plt.legend()

# Grid
plt.grid(True)

# Tightens it (if there are margin errors)
plt.tight_layout()


# Show The Plot
plt.show()

