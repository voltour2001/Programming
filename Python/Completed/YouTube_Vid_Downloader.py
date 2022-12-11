from pytube import YouTube
 
yt = YouTube("https://www.youtube.com/watch?v=lkvfAFZfsag&list=RD4_ALTzXBVJ0&index=2&ab_channel=DJariium-Topic")
stream = yt.streams.first()
stream.download()