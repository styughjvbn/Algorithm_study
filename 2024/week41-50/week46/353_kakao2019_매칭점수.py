from html.parser import HTMLParser
import re


def solution(word, pages):
    answer = 0
    parser = new_parser()
    matching_score = [[0, i] for i in range(len(pages))]
    page_info = []
    dict = {}
    for idx, i in enumerate(pages):
        url, score, link = parser.check(i, word)
        dict[url] = idx
        matching_score[idx][0] = -score
        page_info.append(parser.check(i, word))

    for idx, info in enumerate(page_info):
        for i in info[2]:
            index = dict.get(i)
            if index != None:
                matching_score[index][0] -= info[1] / len(info[2])

    matching_score.sort()

    return matching_score[0][1]


class new_parser(HTMLParser):
    basic_score = 0
    external_link = []
    my_link = ""
    word = ""

    def handle_starttag(self, tag, attrs):
        if tag == "meta":
            for i in attrs:
                if i[0] == "content":
                    self.my_link = i[1]
        if tag == "a":
            for i in attrs:
                if i[0] == "href":
                    self.external_link.append(i[1])

    def handle_data(self, data):
        data_arr = re.split("\d", data.lower())
        r = re.compile(r'\b' + self.word + r'\b')
        for i in data_arr:
            count = r.findall(i)
            self.basic_score += len(count)

    def check(self, html, word):
        self.basic_score = 0
        self.external_link = []
        self.word = word.lower()
        self.feed(html)
        return [self.my_link, self.basic_score, self.external_link]