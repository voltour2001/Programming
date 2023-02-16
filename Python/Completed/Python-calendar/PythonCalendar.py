
#* --------------------- Ορισμός συναρτήσεων ---------------------*#

#*
#! Need to add comments !!!
def show_today():
    current_day = str(datetime.datetime.now().day)
    
    current_time = datetime.datetime.now().strftime("%H:%M")
    current_time = current_time.split(":")
    
    result = search(str(current_year), str(current_month), False)
    
    today_events = []
    
    for event in result:
        date = event[0].split("-")
        if date[2] == current_day:
            today_events.append(event)        
    
    for event in today_events:
        time = event[1].split(":")
        if (int(time[0]) - int(current_time[0])) == 1 and int(time[1]) < int(current_time[1]):
            print("\nΕιδοποίηση: σε {} λεπτά(ό) από τώρα έχει προγραμματιστεί το γεγονός {}".format( 60 + int(time[1]) - int(current_time[1]), event[3]))
        elif int(time[0]) == int(current_time[0]) and int(time[1]) > int(current_time[1]):
            print("\nΕιδοποίηση: σε {} λεπτά(ό) από τώρα έχει προγραμματιστεί το γεγονός {}".format( int(time[1]) - int(current_time[1]), event[3]))
        elif int(time[0]) > int(current_time[0]):
            print("\nΕιδοποίηση: σε {} ώρες(α) από τώρα έχει προγραμματιστεί το γεγονός {}".format( int(time[0]) - int(current_time[0]), event[3]))
        

        
#* Displays the Months + Year + Template
def calendar_display():#Εμφανίζει ημερολόγιο μήνα
    print("_________________________________________________")
    print(greek_month(current_month), current_year)
    print("_________________________________________________")
    print("  ΔΕΥ |  ΤΡΙ |  ΤΕΤ |  ΠΕΜ |  ΠΑΡ |  ΣΑΒ |  ΚΥΡ")
    print(month_days_display())    
    print("_________________________________________________")

#* Display Main Menu
def main_menu():                        #Εμφανίζει κύριως menu
    print("Πατήστε ENTER για προβολή του επόμενου μήνα, \"q\" για έξοδο ή κάποια από τις \
παρακάτω επιλογές:")
    print("    \"-\" για πλοήγηση στον προηγούμενο μήνα\n    \"+\" για διαχείριση των γεγονότων \
του ημερολογίου\n    \"*\" για εμφάνιση των γεγονότων ενός επιλεγμένου μήνα")
    option=input("  -> ")    
    while check_main(option)==False:
        print("Δεν αναγνωρίζεται η επιλογή, δοκιμάστε ξανά")
        option=input("  -> ")
    if option=="-":
        show_previous()  # shows previous month
    elif option=="":
        show_next()     # shows next month
    elif option=="+":
        manage_event()
    elif option=="*":
        show_event()
    else:               #  "q", δηλαδή έξοδος
        return
    main_menu()

#* Options
def check_main(option):        # Ελέγχει αν το input είναι ορθό για κεντρικό menu
    if option in {"-","+","*","","q"}:
        return True
    else:
        return False

#* Translate months to greek
def greek_month(month):             # Μετάφραση μηνών
    if month==1:
        return "ΙΑΝ"
    elif month==2:
        return "ΦΕΒ"
    elif month==3:
        return "ΜΑΡ"
    elif month==4:
        return "ΑΠΡ"
    elif month==5:
        return "ΜΑΙ"
    elif month==6:
        return "ΙΟΥΝ"
    elif month==7:
        return "ΙΟΥΛ"
    elif month==8:
        return "ΑΥΓ"
    elif month==9:
        return "ΣΕΠ"
    elif month==10:
        return "ΟΚΤ"
    elif month==11:
        return "ΝΟΕ"
    else:
        return "ΔΕΚ"

#* Display's the days
def month_days_display():      #Δημιουργεί τον πίνακα του μήνα
    ls=calendar.monthcalendar(current_year,current_month) #list with month's days
    table=""        # Ο συνολικός πίνακας που θα εκτυπωθεί για προβολή του ημερολογίου
    if current_month!=1:
        previous_month_length=calendar.monthrange(current_year,current_month-1)[1]
    else:
        previous_month_length=calendar.monthrange(current_year-1,12)[1]
    current_month_start_and_end_data=calendar.monthrange(current_year,current_month)
    counter_0s=0                    # Αρχικοποιήσεις για αντικατάσταση των "0"
    next_month_day=1    # Αρχικοποίηση για προβολή ημερών που ανήκουν στον επόμενο μήνα
    for i in ls:
        row=""
        for j in range(7):
            day=str(i[j])       # Νούμερο ημέρας
            box="[    "
            if day=="0":                        # Αντικαθιστά τα "0"
                if len(table)==0 and counter_0s!=current_month_start_and_end_data[0]:
                    counter_0s+=1
                    day=str((previous_month_length)-(current_month_start_and_end_data[0])+counter_0s)
                else:
                    day=str(next_month_day)
                    next_month_day+=1
                box=box.replace("[","")     # Βγάζει τα "[" από της μέρες διαφορετικών μηνών
                box+=day+" "
            else:
                if is_event(current_year,current_month,day):    # Προσθέτει ασtέρι αν υπάρχει event
                    box+="*"
                box+=day+"] "
             
            while len(box)>6:                   # διορθώνει τα κενά σε κάθε box
                box=box.replace(" ","",1)
            if j<6:
                box+="|"
            row+=box
        table+=row+"\n"
    return table.removesuffix("\n")


#* Check if event on that day
def is_event(year,month,day):            # Make it read whether there is an event on that day
           
    #*  Check for event in event_data AKA CSV (if any events are already in the CSV file)
    for event in events_data:
        date = event[0].split("-")
        if len(date) > 1: # date isn't equal to date,hour,duration,title format
            if int(date[0]) == year and int(date[1]) == month and int(date[2]) == int(day): # The format is in string and we need it in int(), day is already str (line : 90)
                return True
          
    return False    

#* --------------------- Συναρτήσεις Κυρίως Menu ---------------------*#


#* Show previous month
def show_previous():
    global current_month,current_year
    if current_month==1:
        current_year,current_month=current_year-1,12
        calendar_display()
    else:
        current_month-=1
        calendar_display()

#* Show next month
def show_next():
    global current_month,current_year
    if current_month==12:
        current_year,current_month=current_year+1,1
        calendar_display()
    else:
        current_month+=1
        calendar_display()

#* Show the Sub-Menu
def manage_event():
    print("Διαχείριση γεγονότων ημερολογίου, επιλέξτε ενέργεια:")
    print("    1 Καταγραφή νέου γεγονότος\n\
    2 Διαγραφή γεγονότος\n\
    3 Ενημέρωση γεγονότος\n\
    0 Επιστροφή στο κυρίως μενού")
    option=input("  -> ")
    while check_manage_event_option(option)==False:
        print("Δεν αναγνωρίζεται η επιλογή, δοκιμάστε ξανά")
        option=input("  -> ")
    if option=="1":                       # Create event
        add_event()
    if option=="2":                       # Delete event
        delete_event()
    if option=="3":                       # Update event
        update_event()
    calendar_display()                  # Return to menu

#* Check the user inputs
def check_manage_event_option(option):
    if option in {"0","1","2","3"}:
        return True
    else:
        return False

#* todo Adds an Event
def add_event():
    date=get_date(False,None)
    time=get_time(False,None)
    while not check_space_availability(date,time): # Checks if input time and date is not taken by another event    
        print("Δεν υπάρχει χώρος για την αποθήκευση του γεγονότος στην προγραμματισμένη ώρα, δοκιμάστε ξανά:")
        date=get_date(False,None)
        free_timezones(date)
        time=get_time(False,None)

    duration=get_duration(False,None)
    title=get_title(False,None)
    
    event = [date, time, duration, title]
    events_data.append(event)    
    

#* Date
def get_date(show_current,value):
    current_value=""
    if show_current:
        current_value="("+value+")"
    date = input("ημερομηνία γεγονότος {}: ".format(current_value))

    #? Check if valid
    while not check_date_validity(date,show_current):
        print("Δεν αναγνωρίζεται η ημερομηνία, δοκιμάστε ξανά")
        date=input("ημερομηνία γεγονότος {}: ".format(current_value))
    if date=="":
        return value #It returns the previous date
    return date    
    
#* Time 
def get_time(show_current,value):
    current_value=""
    if show_current:
        current_value="("+value+")"
    time = input("ώρα γεγονότος {}: ".format(current_value)) # hh:mm    
    #? Check if valid
    while not check_time_validity(time,show_current):
        print("Δεν αναγνωρίζεται η ώρα, δοκιμάστε ξανά")
        time=input("ώρα γεγονότος {}: ".format(current_value))
    if time=="":
        return value #It returns the previous time
    return time

#* Duration 
def get_duration(show_current,value):
    current_value=""
    if show_current:
        current_value="("+value+")"    
    duration = input("Διάρκεια (λεπτά) {}: ".format(current_value))

    #? Check if valid
    while not check_duration_validity(duration,show_current):
        print("Δεν αναγνωρίζεται η διάρκεια, δοκιμάστε ξανά")
        duration = input("Διάρκεια (λεπτά) {}: ".format(current_value))
    if duration=="":
        return value #It returns the previous duration
    return duration
    
#* Title 
def get_title(show_current,value):
    current_value=""
    if show_current:
        current_value="("+value+")"    
    title = input("Τίτλος {}: ".format(current_value))
    
    #? Check if "," in title
    while ("," in title):
        print("Μη αποδεκτός τίτλος, δοκιμάστε ξανά")
        title = input("Τίτλος {}: ".format(current_value))
    if title=="":
        return value #It returns the previous title
    return title


#* Check if Date input is valid
def check_date_validity(date,current_value):
    if current_value and date=="": # Value is coming from update_event() and it stays the same
        return True

    check=True      # Logic value for existance of only numerical values + "-"
    for character in date: 
        if character not in {"0","1","2","3","4","5","6","7","8","9","-"}:
            check=False
    if check and date.count("-")==2:   # Inputed value can be checked without errors
        date=date.split("-")
        date_year = date[0]
        date_month = date[1]
        date_day = date[2]
        if len(date_day)<=2 and len(date_month)<=2 and date_year[0]!="0": # year, month, day are at the correct format
            if (int(date_year)>=2023 ) and \
                ( int(date_month)>=1 and int(date_month)<=12 ) and \
                ( int(date_day)>=1 and int(date_day)<=calendar.monthrange(int(date_year),int(date_month))[1] ): # day is in the right range of the wanted month
                return True
 
    return False


#* Check if Time input is valid
def check_time_validity(time,current_value):
    if current_value and time=="": # Value is coming from update_event() and it stays the same
        return True

    check=True
    for character in time: 
        if character not in {"0","1","2","3","4","5","6","7","8","9",":"}:
            check=False
    if check and time.count(":")==1:   # Inputed value can be checked without errors
        time=time.split(":")  
        time_h = time[0]  #*  Take the Hours
        time_m = time[1]  #*  Take the Minutes
        if len(time_h)<=2 and len(time_m)<=2: #  There are no extra 0s (ex. 021:12) at the front of them
            if (int(time_h) >= 0 and int(time_h) < 24) and (int(time_m) >= 0 and int(time_m) < 60): #* Check values
                return True

    return False

#* Check if Duration input is valid
def check_duration_validity(duration,current_value):
    if current_value and duration=="": # Value is coming from update_event() and it stays the same
        return True

    check=True
    for character in duration: 
        if character not in {"0","1","2","3","4","5","6","7","8","9"}\
        and duration[0]!="0":  #There are no 0s at the front

            check=False
    return check   # Inputed value is/isn't a positive integer  

#* todo Checks whether inputed date/time are free to add a new event
def check_space_availability(date,time):   
    date=date.split("-") #gets list containing year, month, day
    time=time.split(":") #gets list containing hour, minutes
    for event in events_data:
        date_event=event[0].split("-")
        time_event=event[1].split(":")

        if len(date_event)>1: #Checks whether what was split isn't the date,hour,duration,title format
        # Removes 0s in front of numbers and turns them back to string
            year_event=date_event[0]
            month_event=int(date_event[1]) #Removes 0s at the front in incase they were saved with them
            day_event=int(date_event[2])   #so they can match the one we are checking them with
            hour_event=int(time_event[0])
            minute_event=time_event[1]

            if (year_event==date[0] and month_event==int(date[1]) and day_event==int(date[2]))\
                and (hour_event==int(time[0]) and minute_event==time[1]): 
                return False 
                  
    return True # Το date και time είναι ελεύθερα


#* ----- Prints the times of a day that are free to add an event ----- *#
def free_timezones(date):
    date_split=date.split("-")
    results=search(date_split[0],date_split[1],False)
    taken_timezones=[]
    for event in results:
        day=event[0].split("-")[2]
        if day == date_split[2]:
            time=event[1]
            taken_timezones.append(time)
    taken_timezones.sort()
    free="00:00"
    print("Οι παρακάτω ώρες είναι ελεύθερες (τα άκρα δε συμπεριλαμβάνονται):")
    for time in taken_timezones:
        print(free, "-", time)
        free=time
    if free!="23:59":
        print(free, "-", "23:59")

#* ----- Searchs for the event we want in the specific time range and prints them out ----- *#
def search(year,month, show):
    searched_events = []   # Create a temporary List to store all the search results
    
    for event in events_data: # search for event in database
        date=event[0].split("-")
        if len(date)>1: #   Checks whether what was split isn't the date,hour,duration,title format
            event_year=date[0]
            event_month=date[1] 
            if event_year == year and int(event_month) == int(month): # turns 01 into 1
                event[3] = event[3].replace('\n', '')
                searched_events.append(event)       

    #* ----- Print all the search results in specific format ----- *#
    if show:        
        if len(searched_events)>0:
            for i in range(len(searched_events)):   
                print('{}. [{}] -> Date: {}, Time: {}, Duration: {}'.format(i, searched_events[i][3], searched_events[i][0], searched_events[i][1], searched_events[i][2]))
        else:
            print("Δεν υπάρχουν γεγονότα τον συγκεκριμένο μήνα")
            return ""
    return searched_events

#* ----- Deletes an specified event ----- *# 
def delete_event():
    print("=== Αναζήτηση γεγονότων ====")

    year = input("Εισάγετε έτος: ")
    while not check_year_validity(year):
        print("Μη επιτρεπτεί τιμή έτους, δοκιμάστε ξανά")
        year = input("Εισάγετε έτος: ")

    month = input("Εισάγετε μήνα: ")
    while not check_month_validity(month):
        print("Μη επιτρεπτεί τιμή μήνα, δοκιμάστε ξανά")
        month = input("Εισάγετε έτος: ")

    searched_events=search(year,month, True)
    if searched_events!="": #   Events were found for specified time range
        index = int(input("Επιλέξτε γεγονός προς διαγραφή: "))
        
        # Check valid input
        while index not in range(len(searched_events)):
            print("Δεν βρέθηκε το γεγονός")
            index = int(input("Επιλέξτε ξανά γεγονός προς διαγραφή: "))
        
        #
        for i in range(len(searched_events)):
            searched_events[i][3] += "\n"      # Ξαναβάζει την αλλαγή γραμμής στο event για την μελλοντική αποθήκευση στο αρχείο
        events_data.remove(searched_events[index])
        print("Το γεγονός διαγράφτηκε: <[{}] -> Date: {}, Time: {}, Duration: {}>".format(searched_events[index][3].replace("\n",''), searched_events[index][0], searched_events[index][1], searched_events[index][2]))

def check_year_validity(year):
    check=True
    for character in year:
        if character not in {"0","1","2","3","4","5","6","7","8","9"}:
            check=False
        if int(year)<2023:
            check=False
    return check
             
def check_month_validity(month):
    check=True
    for character in month:
        if character not in {"0","1","2","3","4","5","6","7","8","9"}:
            check=False
        if int(month)<1 or int(month)>12:
            check=False
    return check      
      
#* Updates Events with new given events
def update_event():
    print("=== Αναζήτηση γεγονότων ====")
    
    #? Year of the event we want to change
    year = input("Εισάγετε έτος: ")
    while not check_year_validity(year):
        print("Μη επιτρεπτεί τιμή έτους, δοκιμάστε ξανά")
        year = input("Εισάγετε έτος: ")

    #? Month of the event we want to change
    month = input("Εισάγετε μήνα: ")
    while not check_month_validity(month):
        print("Μη επιτρεπτεί τιμή μήνα, δοκιμάστε ξανά")
        month = input("Εισάγετε έτος: ")
    
    #? Choose the event you want to change
    searched_events=search(year,month, True)
       
    if searched_events!="": #   Events were found for specified time range
        index = int(input("Επιλέξτε γεγονός προς ενημέρωση: "))
        
        #? Check the validity of user input
        while index not in range(len(searched_events)):
            print("Δεν βρέθηκε το γεγονός")
            index = int(input("Επιλέξτε ξανά γεγονός προς ενημέρωση: "))
        

        #* Input New Events Date
        new_date = get_date(True,searched_events[index][0])
        
        #* Input New Events Hour
        new_time = get_time(True,searched_events[index][1])

        if new_date!=searched_events[index][0] or new_time!=searched_events[index][1]: # either date or time was changed
        #* Checks if input time and date is not taken by another event 
            while not check_space_availability(new_date,new_time):    
                print("Δεν υπάρχει χώρος για την αποθήκευση του γεγονότος στην προγραμματισμένη ώρα, δοκιμάστε ξανά:")
                new_date = get_date(True,searched_events[index][0])
                free_timezones(new_date)
                new_time = get_time(True,searched_events[index][1])
        #* Input New Events Duration
        new_duration = get_duration(True,searched_events[index][2])
            
        #* Input New Events Title
        new_title = get_title(True,searched_events[index][3])
                
                
        new_event = [new_date, new_time, new_duration, new_title]
        
        if new_event == searched_events[index]:
            print("Δεν έγινε καμία αλλαγή")
        else:
            events_data.remove(searched_events[index])
            
            events_data.append(new_event)
            
            print("\n"+"Το γεγονός ενημερώθηκε: <[{}] -> Date: {}, Time: {}, Duration: {}> ".format(new_title, new_date, new_time, new_duration))
        
    
        input("\n"+"Πατήστε οποιοδήποτε χαρακτήρα για επιστροφή στο κυρίως μενού: ")
    

#* Displays the events of the year - month that the user entered
def show_event():
    print("=== Αναζήτηση γεγονότων ====")
    
    year = input("Εισάγετε έτος: ")
    while not check_year_validity(year):
        print("Μη επιτρεπτεί τιμή έτους, δοκιμάστε ξανά")
        year = input("Εισάγετε έτος: ")

    month = input("Εισάγετε μήνα: ")
    while not check_month_validity(month):
        print("Μη επιτρεπτεί τιμή μήνα, δοκιμάστε ξανά")
        month = input("Εισάγετε έτος: ")
    
    search(year, month, True)
    
    input("\n"+"Πατήστε οποιοδήποτε χαρακτήρα για επιστροφή στο κυρίως μενού: ")
    
    calendar_display()
    
    
#* CSV Inputs
def file_updater():

    write_file=open("events.csv","w")
    #* Check every line on the read file to see if it has been deleted or changed in the new write file 
    for line in events_data:
        text=""
        for i in range(4):
            text += line[i] + ","
        text = text.rstrip(',')
        if "\n" not in text: # Adds a new liner if it is needed to be saved correctly
            text+="\n"
        write_file.write(text)   
                        
    
    write_file.close()
    


    
#* --------------------- Main Program --------------------- *#

import calendar,datetime,os

global current_month,current_year

current_month=datetime.datetime.now().month
current_year=datetime.datetime.now().year   # Curent month in english  print(calendar.month_name[current_month])

#* Open the Old/Read Instance of the file

global events_data
events_data = []

read_file=open("events.csv","a")    # Creates the csv file in case it doesn't exists and inputs its format

if os.stat('events.csv').st_size == 0:
    
    read_file.write("Date,Hour,Duration,Title")
    
read_file.close()

read_file=open("events.csv","r")

for event in read_file:
    event=event.split(",")
    events_data.append(event) #saves all current events in a list
read_file.close()
#* --------------------- Display ---------------------*#
if __name__=="__main__":
    show_today()
    calendar_display()    # go to line 12
    main_menu()           # go to line 23



    file_updater()
    
