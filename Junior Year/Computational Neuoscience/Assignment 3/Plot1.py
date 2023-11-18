import numpy as np
from scipy.integrate import solve_ivp
import matplotlib.pyplot as plt

# Given parameters
tau = 10e-3  # 10 milliseconds
lambda_val = 0.7
total_time = 4  # 4000 milliseconds
t_eval = np.linspace(0, total_time, 4001)  # Evaluate the solution at 1 ms intervals

def input_x(t):
    return 1 if 250e-3 <= t <= 1000e-3 else 0

def system(t, y):
    v, = y
    dxdt = (-v + lambda_val * input_x(t) + (1 - lambda_val) * v) / tau
    return [dxdt]

# Initial condition: assuming v(0) = 0
y0 = [0]

# Solve the differential equation
solution = solve_ivp(system, (0, total_time), y0, t_eval=t_eval)

# Plot the result
plt.plot(solution.t * 1e3, solution.y[0])  # Convert time to milliseconds for the plot
plt.xlabel('Time (ms)')
plt.ylabel('Response (y)')
plt.title('Time vs Response')
plt.grid(True)
plt.savefig('time_vs_response.png')  # Save the plot to an image file
plt.show()
