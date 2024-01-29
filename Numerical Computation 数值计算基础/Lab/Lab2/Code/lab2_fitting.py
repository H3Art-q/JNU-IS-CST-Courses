from lab2_methods import *
import matplotlib.pyplot as plt

# Generate points for n=10, 20, 40
n_values = [10, 20, 40]
uniform_pts = {n: uniform_points(n) for n in n_values}
chebyshev_pts = {n: chebyshev_points(n) for n in n_values}

# Compute function values for the generated points
uniform_y = {n: func(uniform_pts[n]) for n in n_values}
chebyshev_y = {n: func(chebyshev_pts[n]) for n in n_values}

# Generate Newton interpolating polynomials
uniform_polys = {n: newton_divided_difference(uniform_pts[n], uniform_y[n]) for n in n_values}
chebyshev_polys = {n: newton_divided_difference(chebyshev_pts[n], chebyshev_y[n]) for n in n_values}

x_plot = np.linspace(-1, 1, 500)
y_original = func(x_plot)

for n in n_values:
    plt.figure(figsize=(10, 6))

    # Plot original function
    plt.plot(x_plot, [uniform_polys[n](x) for x in x_plot], '--', label=f"Uniform points, n={n}")
    plt.plot(x_plot, [chebyshev_polys[n](x) for x in x_plot], ':', label=f"Chebyshev points, n={n}")

    # Plot data points
    plt.scatter(uniform_pts[n], [uniform_polys[n](x) for x in uniform_pts[n]], color='red', s=10, marker='o',
                label="Uniform points")
    plt.scatter(chebyshev_pts[n], [chebyshev_polys[n](x) for x in chebyshev_pts[n]], color='blue', s=10, marker='x',
                label="Chebyshev points")

    plt.title(f"Interpolation with n={n}")
    plt.legend()
    plt.grid(True)
    plt.show()
