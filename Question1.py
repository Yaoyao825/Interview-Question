Python 3.7.0b5 (v3.7.0b5:abb8802389, May 31 2018, 01:03:08) [MSC v.1913 32 bit (Intel)] on win32
Type "copyright", "credits" or "license()" for more information.
>>> import csv

def get_max_population():
    pop_list = [0]*101
    #csv defined using
        #random number between 1900 and 2000 for col. 1 (birthdate)
        #random number between 1 and 100 for col. 2 (age)
        #the difference of col. 2 and col. 1 (death date)
    csvname = input("Enter filename ('filename.csv'): ")
    with open(csvname, newline='') as f:
    #with open('datese.csv', newline='') as f:
        reader = csv.reader(f)
        for row in reader:
            birth_year = int(row[0])
            death_year = int(row[2])
            #only taking into consideration years between 1900 and 2000
            if death_year > 2000:
                death_year = 2000
            n = death_year - 1900
            i = birth_year - 1900
            while i <= n:
                pop_list[i] = pop_list[i] + 1
                i = i + 1
        #take into consideration multiple years having the same number of people alive
        j = 0
        max_population = 0
        years = []
        while j <= 100:
            if pop_list[j] > max_population:
                max_population = pop_list[j]
                #reset year list if new maximum population
                years = []
            if pop_list[j] == max_population:
                year_to_append = 1900 + j
                years.append(year_to_append)
            j = j + 1
        print(str(max_population) + ' people were alive in the years',years)

get_max_population()
