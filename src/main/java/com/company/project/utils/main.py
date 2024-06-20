import csv
import random

def generate_phone_numbers(num_rows):
    prefixes = ['13', '14', '15', '16', '17', '18', '19']
    phone_numbers = []
    for _ in range(num_rows):
        # 随机选择一个前缀
        prefix = random.choice(prefixes)
        # 生成剩下的9位数字
        suffix = ''.join(random.choice('0123456789') for _ in range(9))
        phone_numbers.append(prefix + suffix)
    return phone_numbers

def write_to_csv(filename, num_rows):
    with open(filename, 'w', newline='', encoding='utf-8') as file:
        writer = csv.writer(file)
        writer.writerow([])
        writer.writerow([])
        phone_numbers = generate_phone_numbers(num_rows)
        for number in phone_numbers:
            writer.writerow([number, '长期有效'])

write_to_csv('phone_numbers.csv', 748)