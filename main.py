from typing import List, Tuple

def square_numbers(nums: List[float]) -> List[Tuple[float, float]]:
    # Calculate the square of each number in the given list
    return [(num, num**2) for num in nums]
numbers = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
result = square_numbers(numbers)
print(result)