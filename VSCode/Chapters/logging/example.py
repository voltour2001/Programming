import logging

#create and configure logger
LOG_FORMAT = "%(levelname)s  %(asctime)s - %(message)s"
logging.basicConfig(filename= "\\Users\\spiros\\My_files\\VSCode\\Chapters\\logging\\lumberjack.log",
                    level=logging.DEBUG,
                    format=LOG_FORMAT,
                    filemode='w')
logger = logging.getLogger()

#test the logger
logger.info("My Second message.")