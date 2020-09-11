import tkinter

window = tkinter.Tk()

#window's title
window.title("wait")

#window's icon
window.iconbitmap('./project2/images/YouTube_ico.ico')

#button to close the program when pressed
button_quit = tkinter.Button(window, text='exit program', command=window.quit)
button_quit.pack()

#loop to stay open
window.mainloop()