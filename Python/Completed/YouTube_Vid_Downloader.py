from pytube import YouTube
x=input("Video url:")
yt = YouTube(x)
print(yt.title)
stream = yt.streams.first()
stream.download()