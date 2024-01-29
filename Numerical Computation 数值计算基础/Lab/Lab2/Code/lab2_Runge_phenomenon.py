from lab2_methods import *
import matplotlib.pyplot as plt


def runge_function(x):
    return 1 / (1 + 25 * x ** 2)


# Generate uniform points and compute interpolating polynomial for various degrees
x_values = np.linspace(-1, 1, 1000)
y_runge = runge_function(x_values)

# Adjusting the range for degrees
degrees = [5, 10, 15, 20]

# Plotting individual graphs for each degree along with the original function
for degree in degrees:
    plt.figure(figsize=(10, 6))

    # Plot original Runge function
    plt.plot(x_values, y_runge, label="Original $f(x) = \\frac{1}{1+25x^2}$", color="black", linewidth=2)

    # Plot interpolating polynomial for the specific degree
    x_data = uniform_points(degree + 1)
    y_data = runge_function(x_data)
    polynomial = newton_divided_difference(x_data, y_data)
    y_poly = [polynomial(x) for x in x_values]
    plt.plot(x_values, y_poly, '--', label=f"Interpolation with n={degree}")

    plt.title(f"Observation of Runge Phenomenon with n={degree}")
    plt.legend()
    plt.grid(True)
    plt.show()
