import numpy as np
import matplotlib.pyplot as plt

# Define parameters
tau_ms = 10.0  # Time constant in ms (τ)
omega_hz = 1 / 4000.0  # Frequency in Hz (range of 4000msecs)
omega_rad_per_ms = omega_hz * 2 * np.pi  # Convert frequency to radians per ms
total_time_ms = 4000.0  # Total simulation time in ms
dt_ms = 1  # Time step in ms
num_steps = int(total_time_ms / dt_ms)  # Number of time steps

# Define weight matrix W
W = np.array([[1, -2 * np.pi * omega_rad_per_ms * tau_ms], 
              [2 * np.pi * omega_rad_per_ms * tau_ms, 1]])

# Initialize arrays to store time, input, and response values
times = np.arange(0, total_time_ms, dt_ms)
input_drive = np.zeros((2, num_steps))
response = np.zeros((2, num_steps))

# Activation from 250 ms to 1000 ms for neuron 2
input_drive[1, 250:1000] = 1

# Euler method to integrate the system of equations
lambda_val = 1  # Start with lambda_val as 1
for i in range(1, num_steps):
    if i == 1000:  # Change λ at t = 1000 ms
        lambda_val = 0
    dy_dt = (-response[:, i-1] + lambda_val * input_drive[:, i-1] + (1 - lambda_val) * W.dot(response[:, i-1])) / tau_ms
    response[:, i] = response[:, i-1] + dt_ms * dy_dt
    response[:, i] = np.clip(response[:, i], -1, 1)

# Plot the input drive and responses
plt.figure(figsize=(12, 8))

# Input drive plot
plt.subplot(2, 1, 1)
plt.plot(times, input_drive[0], 'r', label='Input to Neuron 1')
plt.plot(times, input_drive[1], 'b', label='Input to Neuron 2')
plt.xlabel('Time (ms)')
plt.ylabel('Input drive (x)')
plt.title('Time Course of Input Drive')
plt.grid(True)
plt.legend()

# Neuron response plot
plt.subplot(2, 1, 2)
plt.plot(times, response[0], 'r', label='Response from Neuron 1')
plt.plot(times, response[1], 'b', label='Response from Neuron 2')
plt.xlabel('Time (ms)')
plt.ylabel('Response (y)')
plt.ylim(-1.5, 1.5)  # Set y-axis limits to show the bounds
plt.title('Response Time Course')
plt.grid(True)
plt.legend()

plt.tight_layout()
plt.show()