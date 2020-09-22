import webbrowser

url = 'http://docs.python.org/'

chrome_path = 'C:/Program Files (x86)/Google/Chrome/Application/chrome.exe %s'

webbrowser.get(chrome_path)#.open(url)
webbrowser.open(url)