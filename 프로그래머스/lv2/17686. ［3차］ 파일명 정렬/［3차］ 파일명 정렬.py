import re

def solution(files):
    def extract_key(file):
        match = re.match(r"([a-zA-Z\-\.\s]+)(\d+)", file)
        return match[1].lower(), int(match[2])

    return sorted(files, key=extract_key)