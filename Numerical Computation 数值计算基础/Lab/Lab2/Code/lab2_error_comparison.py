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

# Sampling points and computing the interpolation errors
x_sample = np.arange(-1, 1.05, 0.05)
y_sample_original = func(x_sample)

uniform_errors = {n: [uniform_polys[n](x) - func(x) for x in x_sample] for n in n_values}
chebyshev_errors = {n: [chebyshev_polys[n](x) - func(x) for x in x_sample] for n in n_values}

for n in n_values:
    plt.figure(figsize=(10, 6))

    plt.plot(x_sample, uniform_errors[n], '--', label=f"Uniform points, n={n}")
    plt.plot(x_sample, chebyshev_errors[n], ':', label=f"Chebyshev points, n={n}")
    plt.title(f"Interpolation Error with n={n}")
    plt.legend()
    plt.grid(True)
    plt.show()
