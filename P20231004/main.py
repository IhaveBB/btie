# 从键盘输入系数a, b, c
a = float(input("请输入a的值: "))
b = float(input("请输入b的值: "))
c = float(input("请输入c的值: "))

# 计算判别式
discriminant = b**2 - 4*a*c

# 判断判别式的值来确定方程的根的情况
if discriminant > 0:
    # 有两个实根
    root1 = (-b + (discriminant**0.5)) / (2*a)
    root2 = (-b - (discriminant**0.5)) / (2*a)
    print(f"方程有两个实根：x1 = {root1}, x2 = {root2}")
elif discriminant == 0:
    # 有一个实根
    root = -b / (2*a)
    print(f"方程有一个实根：x = {root}")
else:
    # 无实根
    real_part = -b / (2*a)
    imaginary_part = (abs(discriminant)**0.5) / (2*a)
    print(f"方程无实根，有两个复数根：x1 = {real_part} + {imaginary_part}i, x2 = {real_part} - {imaginary_part}i")